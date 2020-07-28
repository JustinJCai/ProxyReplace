//import java.io.FileReader;
//import java.io.FileWriter; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class ProxyReplace {
	public static void main (String[] args) throws IOException {
		/*FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("input.txt");
			fw = new FileWriter("output.txt");
			//System.out.println(fr.ready());
			String user = "ndwjdis";
			String pass = "2139ikv09sd";
			int state = fr.read();
			String line = "";
			// 1310 is character code for new line
			while (state != -1) {
				char letter = (char)state;
				if (state != (1310)) {
					line = line.concat(Character.toString(letter));
					//System.out.println(line);
				} else {
					System.out.println("new line");
					fw.write(line + "test");
					line = "";
				}
				System.out.print(state);
				state = fr.read();
			}
			fw.write(line + "test");
		}
		finally {
	         if (fr != null) {
	            fr.close();
	         }
	         if (fw != null) {
	            fw.close();
	         }
		}*/
		// Oxy
		try {
		    List<String> proxyInput = Files.readAllLines(Paths.get("input.txt"));
		    List<String> proxyOutput = new ArrayList<String>();
		    String newUser = "ndwjdis";
		    String newPass = "2139ikv09sd";
		    for (String proxy : proxyInput) {
		    	String[] pieces = proxy.split(":");
		    	proxyOutput.add(pieces[0] + ":" + pieces[1] + ":" + newUser + ":" + newPass);
		    }
		    Path outputPath = Paths.get("output.txt");
		    Files.write(outputPath, proxyOutput);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
}
