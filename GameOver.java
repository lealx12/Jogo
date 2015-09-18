import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GameOver {

    private JFrame frame;
    private Tela tela;
    private Board board;
    private String nick;
    /**
     * Launch the application.
     */
    public static void iniciar() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameOver window = new GameOver();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GameOver() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 615, 440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        btnNewButton_1.setIcon(new ImageIcon("img\\botao\\menuPrincipal.png"));
        btnNewButton_1.setBounds(357, 281, 132, 23);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                board = new Board(nick);
                frame.setVisible(false);
            }
        });
        btnNewButton.setIcon(new ImageIcon("img\\botao\\continuar.png"));
        btnNewButton.setBounds(116, 281, 132, 23);
        panel.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("img\\fundo\\gameOver.png"));
        lblNewLabel.setBounds(0, 0, 600, 400);
        panel.add(lblNewLabel);
        frame.setTitle("GameOver");
    }
}
