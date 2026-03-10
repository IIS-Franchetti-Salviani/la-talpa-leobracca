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
    
    LogicaGioco(Manager manager){
        this.manager = manager;
    }
    
    void setManager(Manager manager){
        this.manager = manager;
    }
    
    synchronized void addPunti(){
        punteggio += 10;
        gui.aggiornaPunti(punteggio);
    }
    
    @Override
    public void run(){
        Timer cronometro = new Timer(1000, e -> {
            if(tempo > 0){
                tempo--;
                gui.aggiornaTimer(tempo);
            }
            
            else{
                gioco = false;
                ((Timer)e.getSource()).stop();
            }
        });
        
        cronometro.start();
        
        while(gioco == true){
            try{
                int iTalpa = r.nextInt(5);
            
                SwingUtilities.invokeLater(() -> {
                    gui.aggiornaBuca(iTalpa, true);
                });
            
                int tFuori = r.nextInt(500, 1501);
                Thread.sleep(tFuori);
            
                SwingUtilities.invokeLater(() -> {
                    gui.aggiornaBuca(iTalpa, false);
                });
            
                int nTalpa = r.nextInt(1000,3001);
                Thread.sleep(nTalpa);
                }
            
            catch(InterruptedException e){
                break;
            }
        }     
    }
}
