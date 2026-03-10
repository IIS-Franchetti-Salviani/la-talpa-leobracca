/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lbrac
 */
public class Manager {
    Buca[] elencoBuche;
    GraficaGioco gui;
    Punteggio punteggio;
    Cronometro cronometro;
    LogicaGioco logica;
    
    Manager(GraficaGioco gui, Buca[] buche, LogicaGioco logica){
        this.logica = logica;
        this.elencoBuche = buche;
        this.gui = gui;
        this.punteggio = new Punteggio(gui);
        this.cronometro = new Cronometro(30, gui, this);
    }
    
    void avviaCronometro(){
        cronometro.start();
    }
    
    int getTempo(){
        return cronometro.getTempo();
    }
    
    public void incrementaPunteggio() { 
        punteggio.aggiungiPunto(); 
    }
    
    public int getPunteggioFinale() { 
        return punteggio.getPunti(); 
    }
    
    void aggiornaBuca(int indice, boolean stato){
        System.out.println("1");
        if(elencoBuche != null && indice >= 0 && indice < elencoBuche.length){
            if(elencoBuche[indice] != null){
                elencoBuche[indice].setStato(stato);
                System.out.println("2");
            }          
        }
        
        else{
            System.out.println("Errore indice buca");
        }
    }
    
    void fineGioco(){
        int punti = getPunteggioFinale();
        
        javax.swing.JOptionPane.showMessageDialog(
                gui,
                "Tempo finito! \n Punteggio finale: " + punti,
                "Fine partita",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
        ); 
    }
}
