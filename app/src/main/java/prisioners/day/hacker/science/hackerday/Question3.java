package prisioners.day.hacker.science.hackerday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static prisioners.day.hacker.science.hackerday.Data.prisoner1;
import static prisioners.day.hacker.science.hackerday.Data.prisoner2;

/**
 * Created by agne on 17.2.11.
 */

public class Question3 extends Activity implements View.OnClickListener{
private static TextView text;
    private static int playerNo  = 1;
    private static int ind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question3);
       text = (TextView) findViewById(R.id.textViewMotyvas);
        setText();
        Button yes = (Button) findViewById(R.id.buttonYes);
        Button no = (Button) findViewById(R.id.buttonNo);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }
    private static void setText (){
        if (playerNo == 1) {
            if ("žmogžudystė".equals(Data.nusikaltimas)) {
                Random r = new Random();
                int index = r.nextInt(4);
                ind  = index;
                text.setText(Data.zmogMotyvas[index]);
            } else if ("platinimas".equals(Data.nusikaltimas)) {
                Random r1 = new Random();
                int index1 = r1.nextInt(1);
                ind  = index1;
                text.setText(Data.platMotyvas[index1]);
            } else {
                Random r2 = new Random();
                int index2 = r2.nextInt(2);
                ind  = index2;
                text.setText(Data.apipMotyvas[index2]);
            }
        } else {
            if ("žmogžudystė".equals(Data.nusikaltimas)) {
                text.setText(Data.zmogMotyvas[ind]);
            } else if ("platinimas".equals(Data.nusikaltimas)) {
                text.setText(Data.platMotyvas[ind]);
            } else {
                text.setText(Data.apipMotyvas[ind]);
            }
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonYes:
                if (playerNo == 1){
                    Data.prisoner1.defect();
                } else {
                    Data.prisoner2.defect();
                    Prisoner.outcome(prisoner1, prisoner2);
                }
                break;
            default:
                if (playerNo == 1){
                    Data.prisoner1.co_operate();
                } else {
                    Data.prisoner2.co_operate();
                    Prisoner.outcome(prisoner1, prisoner2);
                }
                break;
        }
        if (playerNo == 1) {
            playerNo = 2;
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(Question3.this, Question3.class);
                    startActivity(intent);

                }
            });
            t1.start();
        } else {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(Question3.this, Question4.class);
                    startActivity(intent);

                }
            });
            t1.start();
        }
    }
}
