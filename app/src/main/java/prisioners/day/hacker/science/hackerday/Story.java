package prisioners.day.hacker.science.hackerday;

import java.util.Random;

/**
 * Created by agne on 17.2.11.
 */

public class Story {
    public String place;
    public String motive;
    public String clue;
    public String victim;

    public Story(){
        setEverything();
    }

    public void setEverything(){
        Random r = new Random();
        int index = 0;
        if ("žmogžudystė".equals(Data.nusikaltimas)){
            index = r.nextInt(Data.zmogAuka.length);
            this.victim = Data.zmogAuka[index];
            index = r.nextInt(Data.zmogPriemones.length);
            this.clue = Data.zmogPriemones[index];
            index = r.nextInt(Data.zmogVieta.length);
            this.place = Data.zmogVieta[index];
            index = r.nextInt(Data.zmogMotyvas.length);
            this.motive = Data.zmogMotyvas[index];
        } else if ("platinimas".equals(Data.nusikaltimas)) {
            index = r.nextInt(Data.platAuka.length);
            this.victim = Data.platAuka [index];
            index = r.nextInt(Data.platPriemones.length);
            this.clue = Data.platPriemones[index];
            index = r.nextInt(Data.platVieta.length);
            this.place = Data.platVieta[index];
            index = r.nextInt(Data.platMotyvas.length);
            this.motive = Data.platMotyvas[index];
        } else{
            index = r.nextInt(Data.apiAuka.length);
            this.victim = Data.apiAuka[index];
            index = r.nextInt(Data.apiPriemones.length);
            this.clue = Data.apiPriemones[index];
            index = r.nextInt(Data.apiVieta.length);
            this.place = Data.apiVieta[index];
            index = r.nextInt(Data.apipMotyvas.length);
            this.motive = Data.apipMotyvas[index];
        }
    }
}
