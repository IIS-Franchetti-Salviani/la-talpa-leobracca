import java.util.*;

public class Gestore {
    ArrayList <Giocatore> giocatori = new ArrayList<>();

    void setGioco(){
        AddGiocatore();
    }

    void AddGiocatore(){
        Giocatore g = new Giocatore();
        giocatori.add(g);
    }


    
}
