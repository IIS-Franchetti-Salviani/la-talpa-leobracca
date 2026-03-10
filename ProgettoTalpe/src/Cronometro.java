/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.Timer;
import java.awt.event.*;
/**
 *
 * @author lbrac
 */
class Cronometro {
    int tempo;
    Timer timer;
    GraficaGioco gui;
    
    Cronometro(int secondi, GraficaGioco gui, Manager manager) {
        this.tempo = secondi;
        this.gui = gui;
        
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tempo > 0){
                    tempo--;
                    gui.aggiornaTimer(tempo);
                }

                else{
                    ((Timer)e.getSource()).stop();
                    manager.fineGioco();
                }
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
