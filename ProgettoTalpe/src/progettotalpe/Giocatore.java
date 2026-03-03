package progettotalpe;
import java.util.*;
public class Giocatore {
    ArrayList <Buca> buche = new ArrayList<>();

    int Punteggio = 0;
    
    void GestioneGioco(){
        addBuca();
    }

    void addBuca(){
        for(int i = 0; i < 6; i++){
            Buca b = new Buca();
            buche.add(b);
        }
    }
}