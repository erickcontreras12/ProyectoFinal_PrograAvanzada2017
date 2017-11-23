package gt.edu.url.estructuras;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;


/**
 * Implementacion de lista enlazada utilizando generics
 * @author tuxtor
 *
 * @param <E>
 */
public class LinkedList<E> implements Stack<E>, Queue<E>{

	/**
	 * Inner class
	 * @author tuxtor
	 *
	 * @param <E>
	 */
	private static class Node<E>{
		private E element; //Valor
		private Node<E> next; //Puntero en la lista
                int repeticiones=0;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
    private String getCodigoInterno() {
        String etiqueta;
        if(next==null){
            etiqueta="nodo"+element+" [ label =\""+element+"\"];\n";
        }else{
            if(repeticiones==0){
                etiqueta="nodo"+element+" [ label =\""+element+"\"];\n";
            }
            else{
                 etiqueta="nodo"+next.element+" [ label =\"<C0>|"+next.element+"|<C1>\"];\n";
            }
           
        }
        if(next!=null){
            etiqueta=etiqueta + next.getCodigoInterno() +
               "nodo"+element+"->nodo"+next.element+"\n";
            repeticiones++;
        }
        return etiqueta;
    }
    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
               "rankdir=TB;\n" +
               "node [shape = record, style=filled, fillcolor=seashell2];\n"+
                getCodigoInterno()+
                "}\n";
    }
        public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("aux_graficoSimple.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo aux_grafico.dot");
           } 
        }                        
        try{
         File file = new File("aux_graficoSimple.dot");
	FileInputStream fis = null;		
	fis = new FileInputStream(file);
	
        MutableGraph g = Parser.read(fis);
	Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File(path+"\\grafoPrueba.png"));
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }            
    }
 }

	private Node<E> head = null;
	private Node<E> tail = null;
	
	private int size = 0;
	
	public int size() {return size;}
	
	public boolean isEmpty() { return size == 0;}
	
	public E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}
	
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0) tail = head;
		size++;
	}
	
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if(isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	public E removeFirst() {
		if (isEmpty()) return null;
		E response = head.getElement();
		head = head.getNext( );
		size--;
		if(size == 0) tail = null;
		return response;
	}

	@Override
	public void push(E e) {
		this.addFirst(e);
		
	}

	@Override
	public E top() {
		
		return this.first();
	}

	@Override
	public E pop() {
		
		return this.removeFirst();
	}

	@Override
	public void enqueue(E e) {
		this.addLast(e);
		
	}

	@Override
	public E dequeue() {
		return removeFirst();
	}
	 public void graficar(String path) {
        head.graficar(path);
    }
	
}
