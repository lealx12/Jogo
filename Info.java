import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;


public class Info
{
    private JFrame frame;

  
    public static void iniciar() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Info window = new Info();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Info() {
        initialize();
    } 
    
   private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 514, 434);
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
			ControlarTelas cont = new ControlarTelas();
			cont.setInicio();
			}
		});
		button.setIcon(new ImageIcon("img/botao/voltar.png"));
		button.setBounds(10, 355, 132, 27);
		panel.add(button);
		
	
		frame.setTitle("Sudden Attack");
	}
}
