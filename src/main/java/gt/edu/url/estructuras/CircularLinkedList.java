package gt.edu.url.estructuras;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;


public class CircularLinkedList<E> {
	private static class Node<E>{
		private E element;
		private Node<E> next;
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
         Node save;
        String etiqueta;
        if(next.getNext()==next){
            etiqueta="nodo"+element+" [ label =\""+element+"\"];\n";
        }else{
             etiqueta="nodo"+next.element+" [ label =\"<C0>|"+next.element+"|<C1>\"];\n";
        }
        if(next!=null){
            etiqueta=etiqueta + next.getCodigoInterno() +
               "nodo"+element+"->nodo"+next.element+"\n";
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
            fichero = new FileWriter("aux_grafico1.dot");
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
         File file = new File("aux_grafico1.dot");
	FileInputStream fis = null;		
	fis = new FileInputStream(file);
	
        MutableGraph g = Parser.read(fis);
	Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("C:\\Users\\garya\\Desktop\\grafoPrueba.png"));
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }            
    }
	}

	private Node<E> tail = null;
	private Node<E> header=null;
	private int size = 0;
	
	public int size() {return size;}
	
	public boolean isEmpty() { return size == 0;}
	
	public E first() {
		if (isEmpty()) return null;
		return tail.getNext().getElement();//Primer cambio
	}
	
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	public void rotate() {
		if (tail != null)
			tail = tail.getNext();
	}
	
	public void addFirst(E e) {
		
		if(size == 0) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		}else {
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
                header=tail.getNext();
		size++;
	}
	
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		Node<E> head = tail.getNext();
		if(head == tail) tail = null;
		else tail.setNext(head.getNext());
		size--;
		return head.getElement();
	}
          public void graficar(String path) {
        tail.graficar(path);
    }
}
