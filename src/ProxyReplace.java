//import java.io.FileReader;
//import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

public class ProxyReplace extends JFrame {
	// Instantiating all Components
	JPanel topLeft = new JPanel();
	JLabel ogLabel = new JLabel("Original Proxy List");
	JTextArea ogTextArea = new JTextArea(10,30);
	
	JPanel topRight = new JPanel();
	JLabel newLabel = new JLabel("Updated Proxy List");
	JTextArea newTextArea = new JTextArea(10,30);
	
	JPanel bottomLeft = new JPanel();
	JLabel userPassLabel = new JLabel("User:Pass");
	JTextField userPassTextField = new JTextField(20);
	JButton saveButton = new JButton("Save");
	
	JPanel bottomRight = new JPanel();
	JLabel status = new JLabel("Status:");
	JButton copyButton = new JButton("Copy");
	JButton runButton = new JButton("Run");
	
	JPanel bottom = new JPanel();
	
	public ProxyReplace() {
		// Instantiating window
		super("Proxy Replace");
		setSize(800,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(0,10));
		
		// Customizing Components
		topLeft.setLayout(new BorderLayout(0,5));
		ogTextArea.setLineWrap(true);
		
		topRight.setLayout(new BorderLayout(0,5));
		newTextArea.setLineWrap(true);
		
		bottomLeft.setLayout(new BorderLayout(15,10));
		
		bottomRight.setLayout(new BorderLayout(35,5));
		
		bottom.setLayout(new GridLayout(1,2,110,0));
		
		// Adding Components onto Panels
		topLeft.add(ogLabel, BorderLayout.NORTH);
		topLeft.add(ogTextArea, BorderLayout.CENTER);
		
		topRight.add(newLabel, BorderLayout.NORTH);
		topRight.add(newTextArea, BorderLayout.CENTER);
		
		bottomLeft.add(userPassLabel, BorderLayout.NORTH);
		bottomLeft.add(userPassTextField, BorderLayout.WEST);
		bottomLeft.add(saveButton, BorderLayout.CENTER);
		
		bottomRight.add(copyButton, BorderLayout.NORTH);
		bottomRight.add(runButton, BorderLayout.CENTER);
		bottomRight.add(status, BorderLayout.SOUTH);
		
		bottom.add(bottomLeft);
		bottom.add(bottomRight);

		// Adding Panels to Frame
		add(topLeft, BorderLayout.WEST);
		add(topRight, BorderLayout.EAST);
		add(bottom, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main (String[] args) throws IOException {
		new ProxyReplace();
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
		/*
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
		*/
		/*
		// Netnut
		try {
		    List<String> proxyInput = Files.readAllLines(Paths.get("input.txt"));
		    List<String> proxyOutput = new ArrayList<String>();
		    String newUser = "ndwjdis";
		    String newPass = "2139ikv09sd";
		    for (String proxy : proxyInput) {
		    	String[] pieces = proxy.split(":");
		    	String session = pieces[2].split("!")[1];
		    	proxyOutput.add(pieces[0] + ":" + pieces[1] + ":" + newUser + "!" + session + ":" + newPass);
		    }
		    Path outputPath = Paths.get("output.txt");
		    Files.write(outputPath, proxyOutput);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		*/
	}
}
