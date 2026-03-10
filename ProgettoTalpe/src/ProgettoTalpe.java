/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author braccalenti.leonardo
 */
public class ProgettoTalpe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraficaGioco g = new GraficaGioco();
        
        LogicaGioco logica = new LogicaGioco(g);
        g.setup(logica);
        
        g.setVisible(true);
        
        Thread t = new Thread(logica);
        t.start();
    }
    
}
