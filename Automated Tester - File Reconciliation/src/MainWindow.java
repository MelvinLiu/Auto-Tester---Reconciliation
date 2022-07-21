
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class MainWindow implements ActionListener{
	
	//all private variables to build elements on the main window
	private JFrame calWindowFrame;
	private JPanel calWindowPanel;
	private JPanel headerPanel;
	private JTextPane headerText;
	private JPanel footerPanel;
	private JTextPane inputText;
	private JTextPane inputText2;
	private JTextField input;
	private JTextField input2;
	private JButton calButton;
	private JTextPane resultText;		
	private JTextArea resultDisplayArea;
	private JTextArea resultDisplayArea2;
	
	//constructor
	public MainWindow(){
		buildMainWindow();
		calWindowFrame.setVisible(true);
	}
	
	private void buildMainWindow() {
		//Build main window frame
		calWindowFrame = new JFrame();
		calWindowFrame.setTitle("CSV Reconciliation");
		calWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calWindowFrame.setBounds(100, 100, 800, 700);
		calWindowFrame.setResizable(false);

		calWindowPanel = new JPanel();
		calWindowPanel.setBackground(Color.WHITE);
		calWindowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		calWindowPanel.setLayout(null);
		calWindowFrame.setContentPane(calWindowPanel);

		headerPanel = new JPanel();
		headerPanel.setBackground(Color.LIGHT_GRAY);
		headerPanel.setBounds(0, 80, 800, 5);
		headerPanel.setLayout(null);
		calWindowPanel.add(headerPanel);
        
		footerPanel = new JPanel();
		footerPanel.setBackground(Color.LIGHT_GRAY);
		footerPanel.setBounds(0, 300, 800, 5);
		footerPanel.setLayout(null);
		calWindowPanel.add(footerPanel);

		headerText = new JTextPane();
		headerText.setName("Title");
		headerText.setEditable(false);
		headerText.setFont(new Font("Arial", Font.ITALIC, 40));
		headerText.setText("Report Reconciliation");
		headerText.setBounds(220, 20, 800, 50);
		calWindowPanel.add(headerText);
		
		input = new JTextField();
		input.setName("User String");
		input.setBackground(Color.WHITE);
		input.setLocation(240, 105);
		input.setFont(new Font("Arial", Font.BOLD, 18));
		input.setSize(501, 40);	
		input.setVisible(true);
		input.setEditable(true);
		calWindowPanel.add(input);
		calWindowFrame.add(input);
		
		input2 = new JTextField();
		input2.setName("User String2");
		input2.setBackground(Color.WHITE);
		input2.setLocation(240, 150);
		input2.setFont(new Font("Arial", Font.BOLD, 18));
		input2.setSize(501, 40);	
		input2.setVisible(true);
		input2.setEditable(true);
		calWindowPanel.add(input2);
		calWindowFrame.add(input2);
		
		inputText2 = new JTextPane();
		inputText2.setName("File #2 Path");
		inputText2.setEditable(false);
		inputText2.setFont(new Font("Arial", Font.BOLD, 20));
		inputText2.setText("File #2 Path:");
		inputText2.setBounds(80, 150, 130, 90);
		calWindowPanel.add(inputText2);
		
		inputText = new JTextPane();
		inputText.setName("File #1 Path");
		inputText.setEditable(false);
		inputText.setFont(new Font("Arial", Font.BOLD, 20));
		inputText.setText("File #1 Path:");
		inputText.setBounds(80, 110, 130, 90);
		calWindowPanel.add(inputText);

		calButton = new JButton("Run");
		calButton.setBounds(270, 200, 250, 80);;
		calButton.setBackground(Color.ORANGE);
		calButton.setFont(new Font("Run", Font.BOLD, 30));
		calButton.setVisible(true);;
		calButton.addActionListener(this);
		calWindowPanel.add(calButton);
		calWindowFrame.add(calButton);
		
		resultText = new JTextPane();
		resultText.setName("Result Label");
		resultText.setEditable(false);
		resultText.setFont(new Font("Arial", Font.BOLD, 20));
		resultText.setText("RESULT");
		resultText.setBounds(350, 320, 100, 100);
		calWindowPanel.add(resultText);
		calWindowFrame.add(resultText);
		
		resultDisplayArea = new JTextArea();
		resultDisplayArea.setName("Final Result");
		resultDisplayArea.setEditable(false);
		resultDisplayArea.setFont(new Font("Arial", Font.BOLD, 30));
		resultDisplayArea.setBounds(225, 375, 600, 50);
		calWindowPanel.add(resultDisplayArea);
		calWindowFrame.add(resultDisplayArea);
		
		resultDisplayArea2 = new JTextArea();
		resultDisplayArea2.setName("Return Mesage");
		resultDisplayArea2.setEditable(false);
		resultDisplayArea2.setFont(new Font("Arial", Font.BOLD, 18));
		resultDisplayArea2.setBounds(200, 425, 900, 800);
		calWindowPanel.add(resultDisplayArea2);
		calWindowFrame.add(resultDisplayArea2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//action listner for the calculate button
		if(input.getText() != null && input2.getText() != null && e.getSource() == calButton) {
			
			MainRunner filePaths = new MainRunner(input.getText(), input2.getText());
			String res = filePaths.runner();
			String returnMessage1 = filePaths.getFileOneReturnMessage();
			String returnMessage2 = filePaths.getFileTwoReturnMessage();
			
			resultDisplayArea.setText(null);
	    	resultDisplayArea.append(res);
	    	resultDisplayArea2.append(returnMessage1 + "\n" 
	    							  + returnMessage2 + "\n" 
	    							  + "****************************************************" 
	    							  + "\n");
	    	calWindowPanel.revalidate();
		}
		//action listner for the resetButton to clear the input field
		else {
			
			resultDisplayArea.setText(null);
	    	resultDisplayArea.append("Please upload your files(s)");
			//resultDisplayArea.setText("");
		}
	}
}