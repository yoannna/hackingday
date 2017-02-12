package prisioners.day.hacker.science.hackerday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = (Button) findViewById(R.id.startButton);
        Button find = (Button) findViewById(R.id.buttonFind);
        start.setOnClickListener(this);
        find.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startButton:
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(MainActivity.this, Game.class);
                        startActivity(intent);

                    }
                });
                t1.start();
                break;
            default:
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(MainActivity.this, Find.class);
                        startActivity(intent);

                    }
                });
                t.start();
                break;
        }
    }
}
