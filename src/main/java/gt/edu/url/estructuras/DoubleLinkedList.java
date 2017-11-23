package gt.edu.url.estructuras;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DoubleLinkedList<E> {

	private static class Node<E> {
		private E element;
		private Node<E> prev;//Anterior
		private Node<E> next;//Siguiente
                int repeticiones=0;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
       private String getCodigoInterno() {
        String etiqueta="";
        if(next==null){
            etiqueta="nodo"+element+" [ label =\""+element+"\"];\n";
        }else{
            if(repeticiones==0){
                etiqueta="nodo"+element+" [ label =\""+element+"\"];\n";
            }else{
                 etiqueta="nodo"+next.element+" [ label =\"<C0>|"+next.element+"|<C1>\"];\n";
            }
           
        }
        if(next!=null){
            repeticiones++;
            etiqueta=etiqueta + next.getCodigoInterno() +
               "nodo"+element+"->nodo"+next.element+"\n"+"nodo"+next.element+"->nodo"+element+"\n";
            
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

	private Node<E> header = null;//Referencia
	private Node<E> trailer = null;
	private int size = 0;

	public DoubleLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;
		return header.getNext().getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getElement();
	}

	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

	public E removeFirst() {
		if (isEmpty())
			return null;
		return remove(header.getNext());
	}
	public E removeLast() {
		if (isEmpty())
			return null;
		return remove(trailer.getPrev());
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
           
                Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
		
	}
	
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev( );
		Node<E> successor = node.getNext( );
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement( );
	}
          public void graficar(String path) {
        header.getNext().graficar(path);
    }

}
