
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
    String[] lineas;
    String valores[];
    
    public void llenarEstructuras(String texto){
        lineas = texto.split("\r\n");
        for (int i = 0; i < lineas.length; i++) {
            valores = lineas[i+1].split(" ");
            
            if(null!=lineas[i]) switch (lineas[i]) {
                case "stack":
                    this.addStack(valores);
                    break;
                case "queue":
                    this.addQueue(valores);
                    break;
                case "linkedlist":
                    break;
                case "circularlinkedlist":
                    break;
                case "doublelinkedlist":
                    break;
                case "btree":
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
        
    }
    
    public void addDoubleLinkedList(String[] data){
        
    } 
    
    public void addBinaryTree(String[] data){
        
    }
}
