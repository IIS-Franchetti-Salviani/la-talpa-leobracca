/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lbrac
 */
class Punteggio {
    int punti = 0;
    GraficaGioco gui;
    
    Punteggio(GraficaGioco gui) {
        this.gui = gui;
    }

    void aggiungiPunto() {
        punti = punti +10;
        gui.aggiornaPunti(punti);
    }

    int getPunti() {
        return punti;
    }
    
}
