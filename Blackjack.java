package blackJack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blackjack {
	
	/*random generator to pick cards from blackjack.img package

	ceil a method that comes from the java.lang.math import
	this uses the import java.lang.Math | use the console to see what happens when Math. is deleted or when ceil is
	 deleted shows which cards are randomly generated in the console in the values of integers
	*/
	
	public static int findRandomPokerIndex() {			
		double x = Math.ceil(Math.random()*52);								
		System.out.println(x); 												
		return (int)x;	
	}

   public static void main(String[] args) {
	 //THE GUI
      JFrame gui = new JFrame();
      gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit program on  GUI close 
      gui.setTitle("Blackjack");
      gui.setSize(700, 500);
      gui.setLocationRelativeTo(null); // center GUI

      // container
      Container container = gui.getContentPane();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      
      // Dealer Panel and JLabel
      JLabel dealerHeader = new JLabel("dealer");
      dealerHeader.setFont(new Font("palatino", Font.BOLD, 15));
      dealerHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

      JPanel dealer = new JPanel();
      dealer.setBorder(BorderFactory.createLineBorder(Color.black));

      // player Panel and JLabel
      JLabel playerHeader = new JLabel("player");
      playerHeader.setFont(new Font("palatino", Font.BOLD, 15));
      playerHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

      JPanel player = new JPanel();
      player.setBorder(BorderFactory.createLineBorder(Color.black));

      //score board Panel and JLabel
      JLabel scoreHeader = new JLabel("scores");
      scoreHeader.setText("dealer: ? player: ?");
      scoreHeader.setFont(new Font("palatino", Font.BOLD, 10));
      scoreHeader.setAlignmentX(Component.CENTER_ALIGNMENT); 
      
      // action buttons
      JPanel buttonsPanel = new JPanel();
      JButton deal = new JButton("Deal");
      JButton hit = new JButton("Hit");
      JButton stand = new JButton("Stand");  

      //buttons added on panel
      buttonsPanel.add(deal);
      buttonsPanel.add(hit);
      buttonsPanel.add(stand);
      
      // adding stuff to container
      container.add(dealerHeader);
      container.add(dealer);
      container.add(playerHeader);
      container.add(player);
      container.add(buttonsPanel);
      container.add(scoreHeader);

      gui.setVisible(true);
      
     // buttons default settings
      deal.setEnabled(true);
      hit.setEnabled(false);
      stand.setEnabled(false);
      
      //deal action listener
      deal.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {

        	 //image of deck of cards
        	ImageIcon img = new ImageIcon(Blackjack.class.getResource("img/0.png"));
            JLabel imgHolder = new JLabel(img);
            dealer.add(imgHolder);
            
            
            //dealer hand
            int randomPokerIndex = findRandomPokerIndex();										
            img = new ImageIcon(Blackjack.class.getResource("img/"+randomPokerIndex+".png"));
            imgHolder = new JLabel(img);
            dealer.add(imgHolder);  /*JLabel with an ImageIcon*/
            dealer.updateUI();
           
            //player hand
            randomPokerIndex = findRandomPokerIndex();
            img = new ImageIcon(Blackjack.class.getResource("img/"+randomPokerIndex+".png"));
            imgHolder = new JLabel(img);
            player.add(imgHolder);  /*JLabel with an ImageIcon*/
            player.updateUI();
            
            randomPokerIndex = findRandomPokerIndex();
            img = new ImageIcon(Blackjack.class.getResource("img/"+randomPokerIndex+".png"));
            imgHolder = new JLabel(img);
            player.add(imgHolder);  /*JLabel with an ImageIcon*/
            player.updateUI();
            
            deal.setEnabled(false);
            hit.setEnabled(true);
            stand.setEnabled(true);
         }
      });
 
      //hit action listener
      hit.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
        	 
        	 int randomPokerIndex = findRandomPokerIndex();										
        	 ImageIcon img = new ImageIcon(Blackjack.class.getResource("img/"+randomPokerIndex+".png"));
        	 JLabel imgHolder = new JLabel(img);
             player.add(imgHolder);  /*JLabel with an ImageIcon*/
             player.updateUI();

             deal.setEnabled(false);
             hit.setEnabled(true);
             stand.setEnabled(true);
         }
         
      });  
      
      //stand action listener
      stand.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {

        	 int randomPokerIndex = findRandomPokerIndex();										
        	 ImageIcon img = new ImageIcon(Blackjack.class.getResource("img/"+randomPokerIndex+".png"));
        	 JLabel imgHolder = new JLabel(img);
             dealer.add(imgHolder);  /*JLabel with an ImageIcon*/
             dealer.updateUI();
            
             deal.setEnabled(false);
             hit.setEnabled(true);
             stand.setEnabled(true);
         }
         
      });     

   }

}

