import java.awt.Graphics; 
import java.awt.EventQueue;
import javax.swing.ImageIcon;  
import java.awt.Image;  
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class Tela  {
    public JFrame frame;
    private JTextField textField;
    public String nick;
    /**
     * Launch the application.
     */
    public void iniciar(){
         EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Tela window = new Tela();
                        window.frame.setVisible(true);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Tela window = new Tela();
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
    public Tela() {
        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 510, 370);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 12));
        textField.setBounds(297, 271, 176, 33);
        panel.add(textField);
        textField.setColumns(10);
        
        
        JButton button = new JButton("");
        button.setIcon(new ImageIcon("img/botao/sair.png"));
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    System.exit(1);
                }
            });
        button.setBounds(141, 187, 249, 23);
        panel.add(button);

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setIcon(new ImageIcon("img/botao/info.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    Info info = new Info();
                    info.iniciar();
                    frame.setVisible(false);
                }
            });
        btnNewButton_1.setBounds(141, 136, 249, 23);
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setIcon(new ImageIcon("img/botao/inicio.png"));
        btnNewButton_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                  
                    nick = textField.getText();
                    if(nick.equals("") || nick.equals(" ")){
                        JOptionPane.showMessageDialog(null,
                        "Ops, É preciso informar seu nome :c", "Campo obrigatorio", JOptionPane.ERROR_MESSAGE);  
                    }else{
                        Apoio game = new Apoio(nick);
                        frame.setVisible(false);
                      
                    }
                }
            });
        btnNewButton_2.setBounds(141, 83, 249, 23);
        panel.add(btnNewButton_2);

        JLabel label = new JLabel("");
        label.setBounds(103, 83, 351, 24);
        panel.add(label);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(new Color(255, 255, 255));
        lblNome.setFont(new Font("Cooper Black", Font.PLAIN, 16));
        lblNome.setBounds(244, 274, 58, 24);
        panel.add(lblNome);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("img/fundo/menuFundo.png"));
        lblNewLabel.setBounds(0, 0, 494, 332);
        panel.add(lblNewLabel);
        frame.setTitle("Sudden Attack");
    }

}
