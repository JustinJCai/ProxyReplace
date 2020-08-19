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
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProxyReplace extends JFrame implements ActionListener {
	//Instantiating Status
		String status = "Enter the proxy list and the User:Pass and then hit Run";
	
	// Instantiating all Components
	JPanel topLeft = new JPanel();
	JLabel ogLabel = new JLabel("Original Proxy List");
	JTextArea ogTextArea = new JTextArea(10,35);
	
	JPanel topRight = new JPanel();
	JLabel newLabel = new JLabel("Updated Proxy List");
	JTextArea newTextArea = new JTextArea(10,35);
	
	JPanel bottomLeft = new JPanel();
	JLabel userPassLabel = new JLabel("User:Pass");
	JTextField userPassTextField = new JTextField(20);
	JButton saveButton = new JButton("Save");
	
	JPanel bottomRight = new JPanel();
	JLabel statusLabel = new JLabel("Status: " + status);
	JButton copyButton = new JButton("Copy");
	JButton runButton = new JButton("Run");
	
	JPanel bottom = new JPanel();
	
	public ProxyReplace() {
		// Instantiating window
		super("Proxy Replace");
		setSize(900,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(0,10));
		
		// Customizing Components
		topLeft.setLayout(new BorderLayout(0,5));
		ogTextArea.setLineWrap(true);
		
		topRight.setLayout(new BorderLayout(0,5));
		newTextArea.setLineWrap(true);
		
		bottomLeft.setLayout(new BorderLayout(15,10));
		saveButton.setActionCommand("save");
		saveButton.addActionListener(this);
		
		bottomRight.setLayout(new BorderLayout(35,5));
		copyButton.setActionCommand("copy");
		copyButton.addActionListener(this);
		runButton.setActionCommand("run");
		runButton.addActionListener(this);
		
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
		bottomRight.add(statusLabel, BorderLayout.SOUTH);
		
		bottom.add(bottomLeft);
		bottom.add(bottomRight);

		// Adding Panels to Frame
		add(topLeft, BorderLayout.WEST);
		add(topRight, BorderLayout.EAST);
		add(bottom, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		ProxyReplace p = new ProxyReplace();
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
	
	public void run() {
		if (userPassTextField.getSelectionEnd() == 0) { // Checks if TextField is empty
			status = "Enter user:pass and try again";
			return;
		}
		if (ogTextArea.getSelectionEnd() == 0) {
			status = "Enter proxy input and try again";
			return;
		}
		if (isNetnut()) {
			newTextArea.setText(convertNetnut());
		} else {
			newTextArea.setText(convertOxy());
		}
		status = "Proxies replaced";
	}
	
	public void copy() {
		String outputList = newTextArea.getText();
		StringSelection stringSelection = new StringSelection(outputList);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		status = "Copied to clipboard";
	}
	
	public void save() { // INCOMPLETE
		status = "User:Pass saved to file";
	}
	
	public boolean isNetnut() { // INCOMPLETE
		return false;
	}
	
	public String convertOxy() { // NEEDS ERROR HANDLING
		String[] proxyInput = ogTextArea.getText().split("\\R");
		String proxyOutput = "";
		String[] userPassInput = userPassTextField.getText().split(":");
	    String newUser = userPassInput[0];
	    String newPass = userPassInput[1];
	    for (String proxy : proxyInput) {
	    	String[] pieces = proxy.split(":");
	    	proxyOutput += pieces[0] + ":" + pieces[1] + ":" + newUser + ":" + newPass + "\n";
	    }
	    return proxyOutput;
	}
	
	public String convertNetnut() { // INCOMPLETE
		return "";
	}
	
	public void updateStatus() {
		statusLabel.setText("Status: " + status);
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("run".equals(e.getActionCommand())) {
			run();
			updateStatus();
			repaint();
			return;
		}
		if ("copy".equals(e.getActionCommand())) {
			copy();
			updateStatus();
			repaint();
			return;
		}
		if ("save".equals(e.getActionCommand())) {
			save();
			updateStatus();
			repaint();
			return;
		}
	}
	
}
