/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.Timer;
/**
 *
 * @author lbrac
 */
class Cronometro {
    int tempo;
    Timer timer;
    
    Cronometro(int secondi, GraficaGioco gui, Manager manager) {
        this.tempo = secondi;
        this.timer = new Timer(1000, e ->{
            if(tempo > 0){
                tempo--;
                gui.aggiornaTimer(secondi);
            }
            
            else{
                ((Timer)e.getSource()).stop();
            }
        });
    }

    void start() {
        timer.start();
    }

    int getTempo() {
        return tempo;
    }
    
}
