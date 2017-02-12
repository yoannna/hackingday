package prisioners.day.hacker.science.hackerday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by agne on 17.2.11.
 */

public class Game extends Activity  implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        Button start = (Button) findViewById(R.id.buttonStart);
        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Random r = new Random();
        int index = r.nextInt(3);
        Data.nusikaltimas = Data.nusikaltimai [index];
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Game.this, Question1.class);
                startActivity(intent);

            }
        });
        t1.start();
    }
}
