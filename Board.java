import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Score score;
    private Principal principal;
    private int anteriorX;
    private int anteriorY;
    private String anteriorDir;

    private int delay = 50;
    private String dirVilao;
    
    private Vilao vilao;
    private ArvoreVilao arvore;
    
    private Image food;
    private int food_x;
    private int food_y;

    private int widthGame = 720;
    private int heightGame = 520;

    private boolean isPlaying = true;
    private Font font;

    int xP, yP, xP2,yP2;
    public Board() {
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("images\\gameFundo.png"));
        lblNewLabel.setBounds(0, 0, 950, 600);
        add(lblNewLabel);

        addKeyListener(new TAdapter());
        setFocusable(true);        
        setDoubleBuffered(true);
        //setBackground(Color.WHITE);
        loadFoodImage();
        principal = new Principal();
        vilao = new Vilao();
        score = new Score();
        arvore = new ArvoreVilao(principal,vilao);
        add(score);       
        showFood();

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        score.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

        paintIntro(g);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();

    }

    public void paintIntro(Graphics g) {
        if(isPlaying){
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(food,food_x,food_y,null);
            try{
                File file = new File("fonts/VT323-Regular.ttf");
                font = Font.createFont(Font.TRUETYPE_FONT, file);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
                font = font.deriveFont(Font.PLAIN,40);
                g2d.setFont(font);
            }catch (Exception e){
                System.out.println(e.toString());
            }   
            Principal aux = principal.getNext();
            g2d.drawImage(principal.getImage(),principal.getX(),principal.getY(),null);
            g2d.drawImage(vilao.getImage(), vilao.getX(), vilao.getY(), null);

        }
    }

    public void actionPerformed(ActionEvent e) {
        checkFood();
        checkCollision();
        xP = principal.getX();
        yP = principal.getY();
        principal.move();
        xP2 = principal.getX();
        yP2 = principal.getY();
        if(xP != xP2 || yP != yP2){
            moveVilao(vilao);
        }
        repaint();  
    }

    private void loadFoodImage(){
        ImageIcon iic = new ImageIcon("images/fries.png");
        food = iic.getImage();
    }

    private void checkFood(){
        if((principal.getX() == food_x) && (principal.getY() == food_y)){
            score.addScore(1);
            showFood();
        }
    }

    private void checkCollision(){
        if(principal.getX() >= widthGame){
            isPlaying = false;
        }
        if(principal.getX() < 20){
            isPlaying = false;
        }
        if(principal.getY() >= heightGame){
            isPlaying = false;
        }
        if(principal.getY() < 20){
            isPlaying = false;
        }
        if(principal.getX() == vilao.getX() && principal.getY() == vilao.getY()){
            isPlaying = false;
        }
        if(!isPlaying){
            timer.stop();
        }
    }

    private void showFood(){
        int [] xPos = new int [widthGame/50];
        xPos[0] = 50;
        for(int i = 1;i<= xPos.length-1;i++){
            xPos[i] = xPos[i-1] + 50;
        }

        int [] yPos = new int [heightGame/50];
        yPos[0] = 50;
        for(int i = 1;i<= yPos.length-1;i++){
            yPos[i] = yPos[i-1] + 50;
        }

        int randomPosition = (int) (Math.random() * 12);
        food_x = xPos[randomPosition];

        randomPosition = (int) (Math.random() * 8);
        food_y = yPos[randomPosition];

        //         int randomPosition = (int) (Math.random() * 50);
        //         food_x = randomPosition * 10;
        // 
        //         randomPosition = (int) (Math.random() * 50);
        //         food_y = randomPosition * 10;
        //         
    }

    private void moveVilao(Vilao _vilao){
        arvore.inserir(new Node());
        Node aux = arvore.getAtual();
        if(aux.getTp() == true){
            aux.setX(food_x);
            aux.setY(food_y);
            vilao.move(aux);
        }else{
            vilao.setDirection(aux.getDir());
            vilao.move();
        }
    }

    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            // Obtém o código da tecla
            int key =  e.getKeyCode();

            switch (key){
                case KeyEvent.VK_ENTER:
                break;

                case KeyEvent.VK_LEFT:
                principal.setDirection("left");
                break;

                case KeyEvent.VK_RIGHT :
                principal.setDirection("right");
                break;

                case KeyEvent.VK_UP:
                principal.setDirection("up");
                break;

                case KeyEvent.VK_DOWN:
                principal.setDirection("down");
                break;
            }

        }

        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            switch(key){

                case KeyEvent.VK_LEFT:
                principal.setDirection("null");
                break;

                case KeyEvent.VK_RIGHT :
                principal.setDirection("null");
                break;

                case KeyEvent.VK_UP:
                principal.setDirection("null");
                break;

                case KeyEvent.VK_DOWN:
                principal.setDirection("null");
                break;
            }
        }
    }
}
