package prisioners.day.hacker.science.hackerday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

/**
 * Created by agne on 17.2.11.
 */

public class Find extends Activity implements View.OnClickListener{
    private static String usersMax;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_activity);
        getCode();
        Button find = (Button) findViewById(R.id.buttonFind);
        find.setOnClickListener(this);
    }

    private void getCode (){

          /*  myRef.child("maxuser").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    usersMax = dataSnapshot.getValue(String.class);
                    //  Log.d(TAG, "Value is: " + value);

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    // Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
           // myRef.child("maxuser").setValue(Integer.parseInt(usersMax) + 1);*/
        Random r = new Random();
        usersMax = Integer.toString(r.nextInt(10000));
            DatabaseReference firebase = myRef.child("online").push();
            firebase.setValue(usersMax);

        }

    @Override
    public void onClick(View v) {
        myRef.child("online").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                TextView text = (TextView) findViewById(R.id.textViewGeneratedCode) ;
                String user = text.getText().toString();
                boolean connected = dataSnapshot.hasChild(user);
                if (connected == true) {
                    Thread t1 = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Find.this, Game.class);
                            startActivity(intent);

                        }
                    });
                    t1.start();
                } else {
                    Toast.makeText(getBaseContext(), "Friend not found", Toast.LENGTH_LONG);
                }
                //  Log.d(TAG, "Value is: " + value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}

