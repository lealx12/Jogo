
/**
 * Write a description of class ArvoreVilao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArvoreVilao
{
    private Node raiz;
    private Node atual;
    private Node anterior;
    private Vilao vilao;
    private Principal principal;
    ArvoreVilao(Principal _principal, Vilao _vilao){
        raiz = null;
        vilao = _vilao;
        principal = _principal;
    }

    public void inserir (Node _node){
        int calculaX = 0;
        int calculaY = 0;
        int sorteado = (int) (Math.random() * 100);
        calculaX = Math.abs(vilao.getX() - principal.getX());
        calculaY = Math.abs(vilao.getY() - principal.getY());
        if(calculaX <= calculaY){
            if(vilao.getX() <= principal.getX()){
                _node.setDir("right");
            }else{
                _node.setDir("left");
            }
        }else{
            if(vilao.getY() <= principal.getY()){
                _node.setDir("down");
            }else{
                _node.setDir("up");
            }
        }

        if(raiz == null){
            raiz = _node;
            atual = _node;
        }else{
            inserirR(_node,raiz,sorteado);
        }
    }

    private void inserirR(Node _node, Node raiz,int sorteado){
        Node aux = raiz;

        if(aux.getEsquerdo() == null){
            aux.setEsquerdo(new Node(true));
        }
        if(aux.getDireito() == null){
            aux.setDireito(_node); 
        }else if(vilao.getX() < principal.getX()){
            aux = aux.getEsquerdo();
            inserirR(_node, aux,sorteado);
        }else if(vilao.getX() > principal.getX()){
            aux = aux.getDireito();
            inserirR(_node, aux,sorteado);
        }

        if(sorteado < 0){
            atual = aux.getEsquerdo();
        }else{
            atual = aux.getDireito();
        }
    }

    public Node getAtual(){
        return atual;
    }

    public Node getAnterior(){
        return anterior; 
    }
}
