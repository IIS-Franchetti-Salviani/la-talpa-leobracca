/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.util.Random;
/**
 *
 * @author braccalenti.leonardo
 */
public class LogicaGioco implements Runnable{
    Manager manager;
    volatile boolean gioco = true;
    Random r = new Random();
    
    void setManager(Manager manager){
        this.manager = manager;
    }
    
    void stopGioco(){
        this.gioco = false;
    }
    
    @Override
    public void run(){
        if (manager == null) {
            return;
        }
        manager.avviaCronometro();

        while (gioco) {
            try {
                int iTalpa = r.nextInt(5);

                manager.aggiornaBuca(iTalpa, true);
                Thread.sleep(r.nextInt(500, 1501));

                manager.aggiornaBuca(iTalpa, false);

                if (!gioco || manager.getTempo() <= 0) break;
                
                Thread.sleep(r.nextInt(1000, 3001));

            } catch (InterruptedException e) {
                break; 
            }
        }
    }
}
