package prisioners.day.hacker.science.hackerday;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;


/**
 * Created by agne on 17.2.11.
 */

public class End extends Activity {
    private static TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_layout);
        text = (TextView) findViewById(R.id.textView);
        StringBuilder strbuilder = new StringBuilder();
        strbuilder.append(Data.prisoner1.totalYears());
        strbuilder.append('\n');
        strbuilder.append(Data.prisoner2.totalYears());
        String str = strbuilder.toString();
        text.setText(str);
    }
    @Override
    public void onBackPressed() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(End.this, MainActivity.class);
                startActivity(intent);

            }
        });
        t1.start();
    }
}
