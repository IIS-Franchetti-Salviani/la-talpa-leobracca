import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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
            ImageIcon originalBuca = new ImageIcon(getClass().getResource("buca.png"));
            ImageIcon originalTalpa = new ImageIcon(getClass().getResource("talpa.png"));

            iconaBuca = ridimensiona(originalBuca, 80,50);
            iconaTalpa = sovrapponi(originalTalpa, iconaBuca);
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

        //Buche
        JPanel pannelloBuca = new JPanel();
        pannelloBuca.setLayout(new GridLayout(1,5));
        for(int i = 0; i < buche.length; i++){
            buche[i] = new JButton();
            buche[i].setIcon(iconaBuca);
            buche[i].setBorderPainted(false);
            buche[i].setFocusPainted(false);
            buche[i].setRolloverIcon(iconaTalpa);
            buche[i].setContentAreaFilled(false);
            buche[i].setRolloverSelectedIcon(iconaTalpa);
            pannelloBuca.add(buche[i]);
        }
        add(pannelloBuca, BorderLayout.CENTER);

        //Logica del gioco
        setVisible(true);
        avviaTempo();
        avviaTalpe();
    }

    ImageIcon ridimensiona(ImageIcon original, int larghezza, int altezza){
        Image immagine = original.getImage();
        Image nuovaImmagine = immagine.getScaledInstance(larghezza, altezza, Image.SCALE_SMOOTH);
        return new ImageIcon(nuovaImmagine);
    }

    ImageIcon sovrapponi(ImageIcon talpa, ImageIcon buca){
        int larghezza = 110;
        int altezza = 110;

        BufferedImage combinata = new BufferedImage(altezza, larghezza, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = combinata.createGraphics();

        int x = (larghezza - buca.getIconWidth()) / 2;
        int y = (altezza - talpa.getIconHeight()) -5;
        g.drawImage(buca.getImage(), x, y, null);

        int dimTalpa = 70;
        x = (larghezza - dimTalpa) / 2;
        y = (altezza - dimTalpa) / 45;
        g.drawImage(talpa.getImage(), x, y, null);

        g.dispose();
        return new ImageIcon(combinata);
    }

    void avviaTempo(){
        countdown = new Timer(1000, e->{
            tempoRimanente--;
            labelTempo.setText("Tempo rimanente: " + tempoRimanente);
            if(tempoRimanente <= 0){
                fermaGioco();
                JOptionPane.showMessageDialog(this, "Fine tempo!");
            }
        });
        countdown.start();
    }

    void avviaTalpe(){
        gioco = new Timer(1500, e->{
            int random = r.nextInt(5);
            buche[random].setIcon(iconaTalpa);
            Timer timerNascondi = new Timer(1000, f->{
                buche[random].setIcon(iconaBuca);
            });

            timerNascondi.setRepeats(false);
            timerNascondi.start();
        });

        gioco.start();
    }

    void fermaGioco(){
        gioco.stop();
        countdown.stop();
    }
}
