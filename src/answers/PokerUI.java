package answers;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class PokerUI {
	
	private List<String> userInput = new ArrayList<>();
	private String numPlayersText = "";
	public static RunRound rr = new RunRound();
	private double walletSizeP1 = 0;
	private double walletSizeCPU1 = 0;
	private double walletSizeCPU2 = 0;
	private double walletSizeCPU3 = 0;
	private double walletSizeCPU4 = 0;
	private double anteSize = 0;
	private double potSize = 0;
	
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
			   if(ante > 0.0 && wallet >= ante*3.0) {
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
				   userInput.add(walletText.getText());;
				   //Close the current window and open the game window
				   frame1.dispatchEvent(new WindowEvent(frame1, WindowEvent.WINDOW_CLOSING));
				   createGameFrame(userInput);
			   }
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
	
   
   public void createGameFrame(List<String> initialValues) {
	   
	   anteSize = Double.parseDouble(initialValues.get(2));
	   walletSizeP1 = Double.parseDouble(initialValues.get(3));
	   walletSizeCPU1 = Double.parseDouble(initialValues.get(3));
	   walletSizeCPU2 = Double.parseDouble(initialValues.get(3));
	   walletSizeCPU3 = Double.parseDouble(initialValues.get(3));
	   walletSizeCPU4 = Double.parseDouble(initialValues.get(3));
	   int numOfPlayers = Integer.parseInt(initialValues.get(1));
	   
	   JFrame frame2 = new JFrame("Poker Game");
	   frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   JPanel mainPanel = new JPanel();
       mainPanel.setLayout(new GridLayout(0,3));
       
       JPanel panel1 = new JPanel();
       JPanel panel2 = new JPanel();
       JPanel panel3 = new JPanel();
       JPanel panel4 = new JPanel();
       JPanel panel5 = new JPanel();
       JPanel panel6 = new JPanel();
       JPanel panel7 = new JPanel();
       JPanel panel8 = new JPanel();
       JPanel panel9 = new JPanel();
       mainPanel.add(panel1);
       mainPanel.add(panel2);
       mainPanel.add(panel3);
       mainPanel.add(panel4);
       mainPanel.add(panel5);
       mainPanel.add(panel6);
       mainPanel.add(panel7);
       mainPanel.add(panel8);
       mainPanel.add(panel9);
	   
	   panel1.setLayout(new GridLayout(3,0));
	   panel3.setLayout(new GridLayout(3,0));
	   panel4.setLayout(new GridLayout(3,0));
	   panel6.setLayout(new GridLayout(3,0));
	   panel8.setLayout(new GridLayout(3,0));
	   
	   CardIcons ci = new CardIcons();
	   JLabel winner = new JLabel();
	   JLabel p1Cards = new JLabel();
	   JLabel cpu1Cards = new JLabel();
	   JLabel cpu2Cards = new JLabel();
	   JLabel cpu3Cards = new JLabel();
	   JLabel cpu4Cards = new JLabel();
	   JLabel p1Wallet = new JLabel("Wallet: $" + walletSizeP1, SwingConstants.CENTER);
	   JLabel cpu1Wallet = new JLabel("Wallet: $" + walletSizeCPU1, SwingConstants.CENTER);
	   JLabel cpu2Wallet = new JLabel("Wallet: $" + walletSizeCPU2, SwingConstants.CENTER);
	   JLabel cpu3Wallet = new JLabel("Wallet: $" + walletSizeCPU3, SwingConstants.RIGHT);
	   JLabel cpu4Wallet = new JLabel("Wallet: $" + walletSizeCPU4, SwingConstants.LEFT);
	   JLabel pot = new JLabel();
       
	   JButton quitButton = new JButton("Quit");
	   quitButton.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent event) {
	           System.exit(0);
	       }
	   });
	   JButton dealButton = new JButton("Deal");
	   dealButton.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent event) {
	    	   Shuffler s = new Shuffler();
	           s.shuffle(numOfPlayers);
	           rr.round();
	           winner.setText("");
	           p1Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getP1Cards()));
	           cpu1Cards.setText(blankCards());
	           p1Wallet.setText("Wallet: $" + (walletSizeP1 -= anteSize));
	    	   p1Wallet.setHorizontalAlignment(SwingConstants.CENTER);
	    	   cpu1Wallet.setText("Wallet: $" + (walletSizeCPU1 -= anteSize));
	    	   cpu1Wallet.setHorizontalAlignment(SwingConstants.CENTER);
	    	   if(numOfPlayers == 2) {
	    		   potSize += anteSize*2;
	    		   pot.setText("Pot: $" + potSize);
	    	   }
	           if(numOfPlayers == 3) {
	        	   cpu2Cards.setText(blankCards());
		    	   cpu2Wallet.setText("Wallet: $" + (walletSizeCPU2 -= anteSize));
		    	   cpu2Wallet.setHorizontalAlignment(SwingConstants.CENTER);
		    	   potSize += anteSize*3;
		    	   pot.setText("Pot: $" + potSize);
	           }
	           if(numOfPlayers == 4) {
	           	   cpu2Cards.setText(blankCards());
	        	   cpu3Cards.setText(blankCards());
		    	   cpu2Wallet.setText("Wallet: $" + (walletSizeCPU2 -= anteSize));
		    	   cpu2Wallet.setHorizontalAlignment(SwingConstants.CENTER);
		    	   cpu3Wallet.setText("Wallet: $" + (walletSizeCPU3 -= anteSize));
		    	   cpu3Wallet.setHorizontalAlignment(SwingConstants.RIGHT);
		    	   potSize = anteSize*4;
		           pot.setText("Pot: $" + potSize);
	           }
	           if(numOfPlayers == 5) {
	           	   cpu2Cards.setText(blankCards());
	        	   cpu3Cards.setText(blankCards());
	        	   cpu4Cards.setText(blankCards());
		    	   cpu2Wallet.setText("Wallet: $" + (walletSizeCPU2 -= anteSize));
		    	   cpu2Wallet.setHorizontalAlignment(SwingConstants.CENTER);
		    	   cpu3Wallet.setText("Wallet: $" + (walletSizeCPU3 -= anteSize));
		    	   cpu3Wallet.setHorizontalAlignment(SwingConstants.RIGHT);
		    	   cpu4Wallet.setText("Wallet: $" + (walletSizeCPU4 -= anteSize));
		    	   cpu4Wallet.setHorizontalAlignment(SwingConstants.LEFT);
		    	   potSize = anteSize*5;
		           pot.setText("Pot: $" + potSize);
	           }
	       }
	   });
	   
       panel1.add(new JLabel("CPU1 ", SwingConstants.CENTER));
       panel1.add(cpu1Wallet);
       panel1.add(cpu1Cards);
       panel2.add(winner);
       if(numOfPlayers == 3) {
    	   panel3.add(new JLabel("CPU2 ", SwingConstants.CENTER));
    	   panel3.add(cpu2Wallet);
    	   panel3.add(cpu2Cards);
       }
       else if(numOfPlayers == 4) {
    	   panel3.add(new JLabel("CPU2 ", SwingConstants.CENTER));
    	   panel3.add(cpu2Wallet);
    	   panel3.add(cpu2Cards);
    	   panel4.add(new JLabel("CPU3 ", SwingConstants.RIGHT));
    	   panel4.add(cpu3Wallet);
    	   panel4.add(cpu3Cards);
       }
       else if(numOfPlayers == 5) {
    	   panel3.add(new JLabel("CPU2 ", SwingConstants.CENTER));
    	   panel3.add(cpu2Wallet);
    	   panel3.add(cpu2Cards);
    	   panel4.add(new JLabel("CPU3 ", SwingConstants.RIGHT));
    	   panel4.add(cpu3Wallet);
    	   panel4.add(cpu3Cards);
    	   panel6.add(new JLabel("CPU4 ", SwingConstants.LEFT));
    	   panel6.add(cpu4Wallet);
    	   panel6.add(cpu4Cards);
       }
       panel5.add(pot);
       
       JButton playHandButton = new JButton("Play Hand");
	   playHandButton.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent event) {
	    	   if(numOfPlayers == 2) {
	    		   cpu1Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU1Cards()));
	    	   }
	    	   if(numOfPlayers == 3) {
	    		   cpu1Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU1Cards()));
	    		   cpu2Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU2Cards()));
	    	   }
	    	   if(numOfPlayers == 4) {
	    		   cpu1Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU1Cards()));
	    		   cpu2Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU2Cards()));
	    		   cpu3Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU3Cards()));
	    	   }
	    	   if(numOfPlayers == 5) {
	    		   cpu1Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU1Cards()));
	    		   cpu2Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU2Cards()));
	    		   cpu3Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU3Cards()));
	    		   cpu4Cards.setText("<html><span style='font-size:28'>" + ci.icons(rr.getCPU4Cards()));
	    	   }
	    	   winner.setText(rr.whoWins());
	    	   if(rr.whoWins() == "You Win This Round!") {
	    		   p1Wallet.setText("Wallet: $" + (walletSizeP1 += potSize));
	    	   }
	    	   if(rr.whoWins() == "You Lose! CPU1 Wins Round") {
	    		   cpu1Wallet.setText("Wallet: $" + (walletSizeCPU1 += potSize));
	    	   }
	    	   potSize = 0;
	    	   pot.setText("Pot: $" + potSize);
	    	   if(walletSizeP1 <= 0.00) {
	    		   JOptionPane.showMessageDialog(mainPanel, "You Lost All Your Money, You Suck!","Haha", JOptionPane.ERROR_MESSAGE);
	    		   System.exit(0);
	    	   }
	       }
	   });
	   JButton foldButton = new JButton("Fold");
	   foldButton.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent event) {
	    	   winner.setText("You Lose! CPU1 Wins Round");
	    	   cpu1Wallet.setText("Wallet: $" + (walletSizeCPU1 += potSize));
	    	   potSize = 0;
	    	   pot.setText("Pot: $" + potSize);
	    	   if(walletSizeP1 <= 0.00) {
	    		   JOptionPane.showMessageDialog(mainPanel, "You Lost All Your Money, You Suck!","Haha", JOptionPane.ERROR_MESSAGE);
	    		   System.exit(0);
	    	   }
	       }
	   });
       panel7.add(foldButton);
       panel7.add(playHandButton);
       panel7.add(new JLabel("Ante : $" + anteSize));
       panel8.add(new JLabel(initialValues.get(0) + " ", SwingConstants.CENTER));
       panel8.add(p1Wallet);
       panel8.add(p1Cards);
       
       panel9.add(dealButton);
       panel9.add(quitButton);

	   frame2.add(mainPanel);
	   frame2.setVisible(true);
	   frame2.pack();
	   frame2.setBounds(300,150,600,400);
   }

   public String blankCards() {
	   String backs = "<html><span style='font-size:28'> \uD83C\uDCA0 \uD83C\uDCA0 \uD83C\uDCA0 \uD83C\uDCA0 \uD83C\uDCA0";
	   return backs;
   }

}
