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

public class Question1 extends Activity implements View.OnClickListener{
    private static TextView text;
    private static int playerNo = 1;
    private static int ind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1);
        text = (TextView) findViewById(R.id.textViewName);

        setText();
        Button yes = (Button) findViewById(R.id.buttonYes);
        Button no = (Button) findViewById(R.id.buttonNo);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }
private static void setText (){
    text.setText(Data.gameStory.victim);
    /*if (playerNo  == 1) {
        if ("žmogžudystė".equals(Data.nusikaltimas)) {
            Random r = new Random();
            int index = r.nextInt(4);
            ind  = index;
            text.setText(Data.gameStory.victim);
            //text.setText(Data.zmogAuka[index]);
        } else if ("platinimas".equals(Data.nusikaltimas)) {
            Random r1 = new Random();
            int index1 = r1.nextInt(1);
            ind  = index1;
            text.setText(Data.gameStory.victim);
            //text.setText(Data.platAuka[index1]);
        } else {
            Random r2 = new Random();
            int index2 = r2.nextInt(2);
            ind  = index2;
            text.setText(Data.gameStory.victim);
            //text.setText(Data.apiAuka[index2]);
        }
    } else {
        if ("žmogžudystė".equals(Data.nusikaltimas)) {
            text.setText(Data.gameStory.victim);
            //text.setText(Data.zmogAuka[ind]);
        } else if ("platinimas".equals(Data.nusikaltimas)) {
            text.setText(Data.gameStory.victim);
            //text.setText(Data.platAuka[ind]);
        } else {
            Random r2 = new Random();
            int index2 = r2.nextInt(2);
            text.setText(Data.gameStory.victim);
            //text.setText(Data.apiAuka[ind]);

        }
    }*/
}
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonYes:
                if (playerNo == 1){
                    Data.prisoner1.defect();
                } else {
                    prisoner2.defect();
                    Prisoner.outcome(prisoner1, prisoner2);
                }
                break;
            default:
                if (playerNo == 1){
                    Data.prisoner1.co_operate();
                } else {
                    prisoner2.co_operate();
                    Prisoner.outcome(prisoner1, prisoner2);
                }
                break;

        }



        //int index = Data.prisoner1._actions.size() - 1;
        /*
        if (prisoner1.lastAction == Action.Co_operate && prisoner2.lastAction == Action.Co_operate)
        {
            prisoner1.reward();
            prisoner2.reward();
        }
        if (Data.prisoner1.lastAction == Action.Co_operate && prisoner2.lastAction == Action.Defect)
        {
            Data.prisoner1.payoff();
            prisoner2.temptation();
        }
        if (Data.prisoner1.lastAction == Action.Defect && prisoner2.lastAction == Action.Co_operate)
        {
            Data.prisoner1.temptation();
            prisoner2.payoff();
        }
        if (Data.prisoner1.lastAction == Action.Defect && prisoner2.lastAction == Action.Defect)
        {
            Data.prisoner1.punishment();
            prisoner2.punishment();
        }
        */



        if (playerNo  == 1) {
            playerNo = 2;
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(Question1.this, Question1.class);
                    startActivity(intent);

                }
            });
            t1.start();
        }
        else {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(Question1.this, Question2.class);
                    startActivity(intent);

                }
            });
            t1.start();

        }
    }
    public static void outcome(Prisoner prisoner1, Prisoner prisoner2)
    {
        int index = prisoner1._actions.size() - 1;
        if (prisoner1._actions.get(index) == Action.Co_operate && prisoner2._actions.get(index) == Action.Co_operate)
        {
            prisoner1.reward();
            prisoner2.reward();
        }
        if (prisoner1._actions.get(index) == Action.Co_operate && prisoner2._actions.get(index) == Action.Defect)
        {
            prisoner1.payoff();
            prisoner2.temptation();
        }
        if (prisoner1._actions.get(index) == Action.Defect && prisoner2._actions.get(index) == Action.Co_operate)
        {
            prisoner1.temptation();
            prisoner2.payoff();
        }
        if (prisoner1._actions.get(index) == Action.Defect && prisoner2._actions.get(index) == Action.Defect)
        {
            prisoner1.punishment();
            prisoner2.punishment();
        }
    }
}
