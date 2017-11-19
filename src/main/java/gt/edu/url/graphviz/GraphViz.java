
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
    public void createDemoGraph() throws IOException{
	//Graph g = graph("example1").with(node("a").link(node("b")));
        String[] valores = new String[4];
        for (int i = 0; i < valores.length; i++) {
            valores[i]= "" + i+1;
        }
        Node nodo0 = node("node0").with(Records.of(rec("f0", valores[0]), rec("f1", "2"), rec("f2", ""), rec("f3", ""), rec("f4", "")));
        Graph g = graph("eje1").with(nodo0);
        Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new File("C:\\Users\\Erick Contreras\\Desktop\\LabFinal_ErickContreras1009017\\grafo1.png"));
    }
	
    public void createDemoFromDot() throws IOException {
	File file = new File("");
	FileInputStream fis = null;		
	fis = new FileInputStream(file);
	
        MutableGraph g = Parser.read(fis);
	Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("C:\\Users\\Erick Contreras\\Desktop\\LabFinal_ErickContreras1009017\\grafoPrueba.png"));
    }

}
