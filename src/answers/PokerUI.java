package answers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class PokerUI {
	
	private List<String> userInput = new ArrayList<>();
	private String numPlayersText = "";
   
	public void createFormFrame() {
	   
	   JFrame frame1 = new JFrame("Poker Form");
	   
	   //Create radio buttons and group them
	   JRadioButton two = new JRadioButton("2");
	   JRadioButton three = new JRadioButton("3");
	   JRadioButton four = new JRadioButton("4");
	   JRadioButton five = new JRadioButton("5");
	   ButtonGroup playersRadio = new ButtonGroup();
	   playersRadio.add(two);
	   playersRadio.add(three);
	   playersRadio.add(four);
	   playersRadio.add(five);
	   two.setSelected(true);
	   
	   //Create input text areas
	   JTextField nameText = new JTextField("Player1");
       nameText.setPreferredSize(new Dimension(120, 20));
       JTextField anteText = new JTextField("5.00");
       anteText.setPreferredSize(new Dimension(55, 20));
       JTextField walletText = new JTextField("15.00");
       walletText.setPreferredSize(new Dimension(70, 20));
	      
       //Create main panel and add sub-panels inside
       JPanel mainPanel = new JPanel();
       mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	   JPanel panel1 = new JPanel();
	   JPanel panel2 = new JPanel();
	   JPanel panel3 = new JPanel();
	   JPanel panel4 = new JPanel();
	   JPanel panel5 = new JPanel();
	   mainPanel.add(panel1);
	   mainPanel.add(panel2);
	   mainPanel.add(panel3);
	   mainPanel.add(panel4);
	   mainPanel.add(panel5);
	   
	   
	   //Define what the sub-panels will do
	   panel1.add(new JLabel("What is your name?"));
	   panel1.add(nameText);
	   
	   panel2.add(new JLabel("How many players?"));
	   panel2.add(two);
	   panel2.add(three);
	   panel2.add(four);
	   panel2.add(five);
	   
	   panel3.add(new JLabel("Ante size: $"));
	   panel3.add(anteText);
	   
	   panel4.add(new JLabel("Wallet size: $"));
	   panel4.add(walletText);
	   
	   //Define Exit and Play button actions
	   JButton quitButton = new JButton("Exit");
	   quitButton.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent event) {
	           System.exit(0);
	       }
	   });
	   JButton playButton = new JButton("Play");
	   playButton.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent event) {
			   //Set ante and wallet as doubles to check for errors
			   double ante = Double.parseDouble(anteText.getText());
			   double wallet = Double.parseDouble(walletText.getText());
			   if(ante <= 0.0) {
				   JOptionPane.showMessageDialog(mainPanel, "Ante must be greater than $0.00","Error", JOptionPane.ERROR_MESSAGE);
			   }
			   if(wallet < ante*3.0)
				   JOptionPane.showMessageDialog(mainPanel, "Wallet must be at least $" + ante*3.00,"Error", JOptionPane.ERROR_MESSAGE);
			   //Store number of players in string
			   if(two.isSelected())
				   numPlayersText = two.getText();
			   else if(three.isSelected())
				   numPlayersText = three.getText();
			   else if(four.isSelected())
				   numPlayersText = four.getText();
			   else if(five.isSelected())
				   numPlayersText = five.getText();
			   //Add user input to ArrayList
			   userInput.add(nameText.getText());
			   userInput.add(numPlayersText);
			   userInput.add(anteText.getText());
			   userInput.add(walletText.getText());
			   //Send ArrayList to method that prints it
			   sendInput(userInput);
			   //Close the current window and open the game window
			   frame1.dispatchEvent(new WindowEvent(frame1, WindowEvent.WINDOW_CLOSING));
			   createGameFrame();
			   }
	   });
	   
	   panel5.add(playButton);
	   panel5.add(quitButton);
	   
	   
	   //Add panel to frame and set size and visibility
	   frame1.add(mainPanel);
	   frame1.setVisible(true);
	   frame1.pack();
	   //setBounds(x,y,length,width)
	   frame1.setBounds(400,150,400,300);
	   
   }
   
   public void createGameFrame() {
	   
	   JFrame frame2 = new JFrame("Poker Game");
	   frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   JPanel mainPanel = new JPanel();
       mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	   
	   frame2.add(mainPanel);
	   frame2.setVisible(true);
	   frame2.pack();
	   frame2.setBounds(300,150,600,400);
   }
   
   public void sendInput(List<String> userInput) {
	   System.out.println(userInput);
   }

}
