
/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
{
    private int x;
    private int y;
    String dir;
    boolean tp = false;
    private Node esquerdo;
    private Node direito;
    
    public Node(){
    }
    
    public Node(boolean tp){
        this.tp = tp;
    }
    
    public Node getEsquerdo(){
        return esquerdo;
    }
    
    public void setEsquerdo(Node esquerdo){
        this.esquerdo = esquerdo;
    }
    
    public Node getDireito(){
        return direito;
    }
    
    public void setDireito(Node direito){
        this.direito = direito;
    }
    
    public int getX(){
        return x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public String getDir(){
        return dir;
    }
    
    public void setDir(String dir){
        this.dir = dir;
    }
    
    public void setTp(boolean tp){
        this.tp = tp;
    }
    
    public boolean getTp(){
        return tp;
    }
    
}
