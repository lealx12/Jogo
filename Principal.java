import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Principal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Principal extends JPanel
{

    private int px;
    private int py;
    private int x;
    private int y;
    private Image image;
    private int delay = 50;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean leftDirection = false;
    private boolean rightDirection = false;
    private boolean body = false;
    private Principal next;
    private Principal previous;

    public Principal() {
        //ImageIcon ii = new ImageIcon("images/"+this.getClass().getResource("head.png"));
        //ImageIcon ii = new ImageIcon(Image.class.getClassLoader().getResource("head.png"));
        ImageIcon ii = new ImageIcon("images/rightPrincipal.png");
        image = ii.getImage();
        x = 50;
        y = 50;
    }


    public void setDirection(String direction){
        if(direction == "null"){
            leftDirection = false;
            rightDirection = false;
            upDirection = false;
            downDirection = false;
        }
        if(direction == "left" && rightDirection == false && body == false ){
            ImageIcon ii = new ImageIcon("images/leftPrincipal.png");
            image = ii.getImage();
            leftDirection = true; 
            upDirection = false;
            downDirection = false;
        }
        if(direction == "right" && leftDirection == false && body == false ){
            ImageIcon ii = new ImageIcon("images/rightPrincipal.png");
            image = ii.getImage();
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }
        if(direction == "up" && downDirection == false && body == false ){
            ImageIcon ii = new ImageIcon("images/upPrincipal.png");
            image = ii.getImage();
            upDirection = true;
            leftDirection = false;
            rightDirection = false;  
        }
        if(direction == "down" && upDirection == false && body == false ){
            ImageIcon ii = new ImageIcon("images/downPrincipal.png");
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int _y){
        y =_y;
    }

    public void setX(int _x){
        x = _x;
    }

    public void setPreviousY(int _y){
        py = _y;
    }

    public void setPreviousX(int _x){
        px = _x;
    }

    public int getPreviousY(){
        return py;
    }

    public int getPreviousX(){
        return px;
    }

    public Principal getNext(){
        return next;
    }

    public void setNext(Principal _body){
        next = _body;
    }

    public Principal getPrevious(){
        return previous;
    }

    public void setPrevious(Principal _body){
        previous = _body;
    }

    public Image getImage() {
        return image;
    }
}
