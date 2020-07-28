import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException;

public class ProxyReplace {
	public static void main (String[] args) throws IOException {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("input.txt");
			fw = new FileWriter("output.txt");
			//System.out.println(fr.ready());
			int state = fr.read();
			String line = "";
			// 1310 is character code for new line
			while (state != -1) {
				char letter = (char)state;
				if (state != 1310) {
					line = line.concat(Character.toString(letter));
					//System.out.println(line);
				} else {
					fw.write(line + "peepeepoopoo");
					line = "";
				}
				//System.out.print(letter);
				state = fr.read();
			}
			fw.write(line + "2peepeepoopoo");
		}
		finally {
	         if (fr != null) {
	            fr.close();
	         }
	         if (fw != null) {
	            fw.close();
	         }
		}
	}
}
