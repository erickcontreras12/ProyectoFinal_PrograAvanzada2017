
package gt.edu.url.graphviz;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableGraph;
import static guru.nidi.graphviz.model.Factory.*;
import static guru.nidi.graphviz.model.Compass.*;
import guru.nidi.graphviz.attribute.Records;
import static guru.nidi.graphviz.attribute.Records.*;
import guru.nidi.graphviz.model.Node;
import guru.nidi.graphviz.parse.Parser;

//COLAAAA y si agrego turn( despues de "Records.of(" se hace pilaa
public class GraphViz {
     Graph g =null;
    public void createDemoGraph(String[] Datos,String tipo) throws IOException{
	//Graph g = graph("example1").with(node("a").link(node("b")));
       if("Stack".equals(tipo)){
           Node Lista=node("Stack").with(Records.of(turn(Datos)));
           g = graph("eje1").directed().with(Lista);
       }
       else if("Queue".equals(tipo)){
            Node Lista=node("Queue").with(Records.mOf((Datos))) ;
           g = graph("eje1").directed().with(Lista);
       }
        
        
    }
    
    public void GuardarGrafo(String path) throws IOException{
        Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new File(path+"\\eje1.PNG"));
    }
	
    public void createDemoFromDot() throws IOException {
	File file = new File("");
	FileInputStream fis = null;		
	fis = new FileInputStream(file);
	
        MutableGraph g = Parser.read(fis);
	Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("C:\\Users\\Erick Contreras\\Desktop\\LabFinal_ErickContreras1009017\\grafoPrueba.png"));
    }

}
