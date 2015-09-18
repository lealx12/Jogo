import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Apoio extends JFrame
{

    private static int WIDTH = 1000;
    private static int HEIGHT = 630;
    private JFrame frame;
 
    public Apoio(String nick){
        iniciar(nick);
      
    }

    public void iniciar(String nick){
        // Adiciona o JPanel do jogo
        
        frame = new JFrame(); 
        frame.add(new Board(nick));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WIDTH,HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setTitle("Sudden Attack");
        frame.setVisible(true);
       
    }


  
}
