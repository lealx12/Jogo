import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Vilao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vilao extends JPanel
{
    private String snake = "Vilao.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int delay = 50;
    private Image image;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean leftDirection = false;
    private boolean rightDirection = false;
    private Vilao linha;
    private Vilao coluna;

    public Vilao() {
        ImageIcon ii = new ImageIcon("images/leftVilao.png");
        image = ii.getImage();
        x = 500;
        y = 300;
    }

    public void setDirection(String direction){
        if(direction == "null"){
            leftDirection = false;
            rightDirection = false;
            upDirection = false;
            downDirection = false;
        }
        if(direction == "left" && rightDirection == false ){
            ImageIcon ii = new ImageIcon("images/leftVilao.png");
            image = ii.getImage();
            leftDirection = true; 
            upDirection = false;
            downDirection = false;
        }
        if(direction == "right" && leftDirection == false ){
            ImageIcon ii = new ImageIcon("images/rightVilao.png");
            image = ii.getImage();
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }
        if(direction == "up" && downDirection == false ){
            ImageIcon ii = new ImageIcon("images/upVilao.png");
            image = ii.getImage();
            upDirection = true;
            leftDirection = false;
            rightDirection = false;  
        }
        if(direction == "down" && upDirection == false){
            ImageIcon ii = new ImageIcon("images/downVilao.png");
            image = ii.getImage();
            downDirection = true;
            leftDirection = false;
            rightDirection = false;
        }
    }

    public String getDirection(){
        if(leftDirection == true){
            return "left";
        }
        if(rightDirection == true){
            return "right";
        }
        if(upDirection == true){
            return "up";
        }
        if(downDirection == true){
            return "down";
        }
        return "";
    }

    public void move() {
        if(leftDirection == true){
            x = x - delay;
        }
        if(rightDirection == true){
            x = x + delay;
        }
        if(upDirection == true){
            y = y - delay;
        }
        if(downDirection == true){
            y = y + delay;
        }
    }
    public void move(Node pos) {
        x = pos.getX();
        y = pos.getY();
    }

    public void moveX(int _x) {
        x += _x;
    }

    public void moveY(int _y){
        y += _y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int _x){
        x = _x;
    }

    public void setY(int _y){
        y = _y;
    }

    public Vilao getLinha(){
        return linha;
    }

    public void setLinha(Vilao _Vilao){
        linha = _Vilao;
    }

    public Vilao getColuna(){
        return coluna;
    }

    public void setColuna(Vilao _Vilao){
        coluna = _Vilao;
    }

    public Image getImage() {
        return image;
    }
}