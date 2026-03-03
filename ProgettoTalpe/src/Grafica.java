import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;
public class Grafica extends JFrame{
    //Componenti grafici
    private JButton[] buche = new JButton[5];
    private JLabel labelTempo;
    private int tempoRimanente = 30;

    private ImageIcon iconaBuca;
    private ImageIcon iconaTalpa;

    private Timer gioco;
    private Timer countdown;
    private Random r = new Random();
}
