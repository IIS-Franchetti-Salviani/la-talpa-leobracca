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

    public Grafica(){
        //Impostazioni finestra
        setTitle("Schiaccia la talpa");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        //Cariacamento immagini
        try{
            iconaBuca = new ImageIcon(getClass().getResource("buca.png"));
            iconaTalpa = new ImageIcon(getClass().getResource("talpa.png"));
        }
        catch(Exception e){
            System.out.println("Impossibile caricare le immagini");    
        }

        //Gestione tempo
        JPanel pannelloInfo = new JPanel();
        labelTempo = new JLabel("Tempo rimanente: " + tempoRimanente);
        labelTempo.setFont(new Font("Arial", Font.BOLD, 20));
        pannelloInfo.add(labelTempo);
        add(pannelloInfo, BorderLayout.NORTH);
    }
}
