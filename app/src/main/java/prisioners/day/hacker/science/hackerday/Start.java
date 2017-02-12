package prisioners.day.hacker.science.hackerday;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

/**
 * Created by agne on 17.2.11.
 */

public class Start extends Activity implements View.OnClickListener{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    public static int usersMax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        getValue();
        TextView generatedCode = (TextView) findViewById(R.id.textViewGeneratedCode);
        generatedCode.setOnClickListener(this);
        generatedCode.setText(Integer.toString(usersMax));
       //
        startService(new Intent(getBaseContext(), WaitForFriend.class));
        checkConnection();

    }

    public void getValue () {
       /* myRef.child("hacking-day").child("max user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                 usersMax = Long.parseLong(dataSnapshot.getValue(String.class));
              //  Log.d(TAG, "Value is: " + value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef.child("hacking-day").child("max user").setValue(usersMax + 1);
        DatabaseReference firebase = myRef.child("online").push();
        firebase.setValue(usersMax);*/
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Random r = new Random();
        usersMax = r.nextInt(10000);
        DatabaseReference firebase = myRef.child("online").push();
        firebase.setValue(usersMax);

    }
    private void checkConnection (){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (WaitForFriend.connected){
            stopService(new Intent(getBaseContext(), WaitForFriend.class));
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(Start.this, Game.class);
                    startActivity(intent);

                }
            });
            t1.start();
        }
    }


    @Override
    public void onClick(View v) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        TextView generatedCode = (TextView) findViewById(R.id.textViewGeneratedCode);
        clipboard.setText(generatedCode.getText());
    }
}
