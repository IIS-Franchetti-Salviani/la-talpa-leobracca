/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
/**
 *
 * @author lbrac
 */
public class Buca extends JButton{
    boolean talpa = false;
    ImageIcon iBuca = new ImageIcon(getClass().getResource("/buca.png"));
    ImageIcon iTalpa = new ImageIcon(getClass().getResource("/talpa.png"));
    
    
    Buca(LogicaGioco logica){
        this.setIcon(iBuca);
        
        this.addActionListener(e ->{
            if(talpa == true){
                logica.addPunti();
                setStato(false);
            }
        });
    }
    
    void setStato(boolean attiva){
        this.talpa = attiva;
        this.setIcon(attiva ? iTalpa : iBuca);
    }
}
