
package gt.edu.url.estructuras;

/**
 *
 * @author Erick Contreras
 */
/**
 * C:\\Users\\Erick Contreras\\Desktop\\URL\\Segundo Ciclo\\Progra\\ProyectoFinal_PrograAvanzada2017\\src\\main\\java\\gt\\edu\\url\\archivo\\textPrueba.txt
 */

public class ListClass {
    public Stack<String> pila = new LinkedList<String>();
    public Queue<String> cola = new LinkedList<String>();
    public LinkedList<String> listaEnlazada = new LinkedList<String>();
    public CircularLinkedList<String> listaCircular = new CircularLinkedList<String>();
    public DoubleLinkedList<String> listaDobleEnlazada = new DoubleLinkedList<String>();
    public LinkedBinaryTree<String> arbol = new LinkedBinaryTree<String>();
    Position<String> p;
    String[] lineas;
    String valores[];
    
    public void llenarEstructuras(String texto){
        lineas = texto.split("\r\n");
        for (int i = 0; i < lineas.length; i++) {
            if (i != lineas.length - 1) {
                valores = lineas[i+1].split(" ");
            }
            
            
            if(null!=lineas[i]) switch (lineas[i]) {
                case "stack":
                    this.addStack(valores);
                    break;
                case "queue":
                    this.addQueue(valores);
                    break;
                case "linkedlist":
                    this.addLinkedList(valores);
                    break;
                case "circularlinkedlist":
                    this.addCircularLinkedList(valores);
                    break;
                case "doublelinkedlist":
                    this.addDoubleLinkedList(valores);
                    break;
                case "btree":
                    this.addBinaryTree(valores);
                    break;
            }
        }
    }
    
    public void addQueue(String[] data){
        for (int i = 0; i < data.length; i++) {
            cola.enqueue(data[i]);
        }
    }
    
    public void addStack(String[] data){
        for (int i = 0; i < data.length; i++) {
            pila.push(data[i]);
        }
    }
    
    public void addLinkedList(String[] data){
        for (int i = 0; i < data.length; i++) {
            listaEnlazada.addLast(data[i]);
        }
    }
    
    public void addCircularLinkedList(String[] data){
        for (int i = 0; i < data.length; i++) {
            listaCircular.addLast(data[i]);
        }
    }
    
    public void addDoubleLinkedList(String[] data){
        for (int i = 0; i < data.length; i++) {
            listaDobleEnlazada.addLast(data[i]);
        }
    } 
    
    public void addBinaryTree(String[] data){
        int cont = 1;
        p = arbol.addRoot(data[0]);
        while(cont<data.length){
            arbol.addLeft(p,data[cont]);
            if(cont==data.length-1){
                break;
            }
            else{
                         cont++;
            }
            p = arbol.addRight(p,data[cont]);
            if(cont==data.length-1){
                break;
            }
            else{
                 cont++;  
            }
         
        }
    }
}
