
package gt.edu.url.archivo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLoader {
        String totalText;
	public String leerArchivo(String ruta) {
		File file = new File(ruta);

		try (FileInputStream fis = new FileInputStream(file)) {

			System.out.println("Total file size to read (in bytes) : " + fis.available());

			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
                                
                                totalText += (char) content;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
                return totalText;
	}
        
       

	public void escribirArchivo(String data, String ruta) {
		File file = new File(ruta);

		try (FileWriter fw = new FileWriter(file)) {
			fw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    

}
