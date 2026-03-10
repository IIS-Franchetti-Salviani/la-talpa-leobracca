/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.SwingUtilities;
import java.util.Random;
/**
 *
 * @author braccalenti.leonardo
 */
public class LogicaGioco implements Runnable{
    GraficaGioco gui;
    boolean gioco = true;
    Random r = new Random();
    
    LogicaGioco(GraficaGioco gui){
        this.gui = gui;
    }
    
    @Override
    public void run(){
        while(gioco == true){
            int iTalpa = r.nextInt(5);
            
            SwingUtilities.invokeLater(() -> {
                gui.aggiornaBuca(iTalpa, true);
            });
        }
    }
}
