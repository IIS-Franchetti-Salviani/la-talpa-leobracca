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
    
    Manager(GraficaGioco gui, Buca[] buche){
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
    
}
