import java.util.*;

public class Buca {
    Random r = new Random();
    int n = 0;
    int punti;

    int TalpaRandom(){
        n = r.nextInt(0,11);

        if(n <= 5){
            //TalpaNormale t = new TalpaNormale();
            
        }
        //prov

        else if(n <= 8){
            //TalpaOro t = new TalpaOro();
            
        }

        else{
            //TalpaBomba t = new TalpaBomba();

        }

        return punti;

    }
}
