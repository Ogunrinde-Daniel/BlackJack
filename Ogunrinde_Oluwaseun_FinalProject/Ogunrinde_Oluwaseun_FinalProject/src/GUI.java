import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class GUI extends JFrame {

	/*Data Members Declaration*/
	private JPanel contentPane;							//boiler code template
	
	private static JButton btnNewHand;					//data member declaration for the newHand button 
	private static JButton btnHit;						//data member declaration for the hit button 
	private static JButton btnStand;					//data member declaration for the stand button 
		
	private static JLabel lblPlayerTotalMoneyLeft;		//data member declaration for the player money left
	private static JLabel lblDealerTotalMoneyLeft;		//data member declaration for the dealer money left
	
	private static JLabel lblPlayerHandCount;			//data member declaration for the player hand count display
	private static JLabel lblDealerHandCount;			//data member declaration for the dealer hand count display
	
	private static JLabel lblBet;						//data member declaration for the bet amount display
	
	private static JLabel lblWinCount;					//data member declaration for the win count display	
	private static JLabel lblLossCount;					//data member declaration for the loss count display

	private static JLabel lbldealerCardHolder1;			//Card holder for the first  dealer card
	private static JLabel lbldealerCardHolder2;			//Card holder for the second dealer card
	private static JLabel lbldealerCardHolder3;			//Card holder for the third  dealer card
	private static JLabel lbldealerCardHolder4;			//Card holder for the fourth dealer card
	private static JLabel lbldealerCardHolder5;			//Card holder for the fifth  dealer card
	
	private static JLabel lblPlayerCardHolder1;			//Card holder for the first  player card
	private static JLabel lblPlayerCardHolder2;			//Card holder for the second player card
	private static JLabel lblPlayerCardHolder3;			//Card holder for the third  player card
	private static JLabel lblPlayerCardHolder4;			//Card holder for the fourth player card
	private static JLabel lblPlayerCardHolder5;			//Card holder for the fifth  player card
	
	private static JLabel lblbackground;				//holder for the background image
	
	private static ImageIcon cardBack = new ImageIcon("Cards//backOfCard.png");			//declaration and instantiation of cardBack to store the back of card image
																						//Image by Clker-Free-Vector-Image from 
																						//https://pixabay.com/vectors/card-game-deck-of-cards-card-game-48983/
																					
	private static ImageIcon cardImageIcon = new ImageIcon("");							//declaration and instantiation of an empty image icon to store card images temporarily											
	
	private static ImageIcon backgroundIcon = new ImageIcon("Cards//background2.png"); 	//declaration and instantiation of backgroundIcon to store the background of the game
																						//Background image created by me in PhotoShop,
																						//The 2 coin images used are from 
																						//https://www.pngitem.com/download/hiwRoh_poker-chips-png-image-stacked-poker-chips-clip/
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// ####################################################################################################
		// Method				:	void main()
		//
		// Method parameters	:	String[] args
		//
		// Method return		:	void
		//
		// Synopsis				:   This method is a boiler code template created by windows builder for 
		//							the graphical user interface
		//	
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public static void initializeCardHolders() {
		// ####################################################################################################
		// Method				:	void initializeCardHolders()
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method initializes the card holders on the GUI
		//							by the turning displaying the back of the image
		//	
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		
		/*sets all 5 of dealer's card holders to display the cardBack*/
		lbldealerCardHolder1.setIcon(cardBack);				
		lbldealerCardHolder2.setIcon(cardBack);
		lbldealerCardHolder3.setIcon(cardBack);
		lbldealerCardHolder4.setIcon(cardBack);
		lbldealerCardHolder5.setIcon(cardBack);
		
		/*sets all 5 of player's card holders to display the cardBack*/
		lblPlayerCardHolder1.setIcon(cardBack);
		lblPlayerCardHolder2.setIcon(cardBack);
		lblPlayerCardHolder3.setIcon(cardBack);
		lblPlayerCardHolder4.setIcon(cardBack);
		lblPlayerCardHolder5.setIcon(cardBack);

		
	}
	
	public static void updateInterface() {
		// ####################################################################################################
		// Method				:	void updateInterface()
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method updates the elements on the GUI to the current parameter 
		//							it does this by using the getters method from the class "Game"
		//	
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		
		lblPlayerTotalMoneyLeft.setText(Game.getPlayerTotalMoneyleft());			//updates the player total money left by getting the current value from the Game class
		lblDealerTotalMoneyLeft.setText(Game.getDealerTotalMoneyleft());			//updates the dealer total money left by getting the current value from the Game class
		
		lblPlayerHandCount.setText	   (Game.getPlayerHandCount());					//updates the player hand count by getting the current value from the Game class
		lblDealerHandCount.setText	   (Game.getDealerHandCount());					//updates the dealer hand count by getting the current value from the Game class
		
		lblWinCount.setText			   (Game.getWinCount());						//updates the player win count by getting the current value from the Game class
		lblLossCount.setText		   (Game.getLossCount());						//updates the player loss count by getting the current value from the Game class
		
		lblBet.setText				   (Game.getBetAmount());						//updates the player bet amount by getting the current value from the Game class
		
		
		
		
	}
		
	
	//Display Graphical User Interface
	public GUI() {
		// ####################################################################################################
		// Method				:	Constructor
		//
		// Method parameters	:	null
		//
		// Method return		:	null
		//
		// Synopsis				:   This constructor is a boiler code template created by windows builder for 
		//							the graphical user interface
		//	
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				/*Overrides the exit function to display a message for the user*/
				JOptionPane.showMessageDialog(null, "BYE FOR NOW"
												  +"\nYour Win & Loss Tally"
												  + "\nwill be saved for next time");
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1520, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//New Hand Button
		btnNewHand = new JButton("New Hand");
		btnNewHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setNewHandClicked(true);		//sets a boolean "newHandClicked" to true, to asset the current state of the game
				
				btnNewHand.setEnabled(false);		//disables the new Hand button, so the player can't access the button temporarily
				
				btnHit.setEnabled(true);			//enables the hit button that has been disabled by default
				
				btnStand.setEnabled(true);			//enables the stand button that has been disabled by default
				
				Main.gameLoop();					//runs the main game loop which activates the game play

			}
		});
		btnNewHand.setBounds(1272, 536, 141, 60);
		contentPane.add(btnNewHand);
		
		//Hit Button
		btnHit = new JButton("Hit");
		btnHit.setEnabled(false);
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.hit();							//a function from Game class is called to process one more card to the game
			}
		});
		btnHit.setBounds(1272, 608, 141, 60);
		contentPane.add(btnHit);
		
		//Stand
		btnStand = new JButton("Stand");
		btnStand.setEnabled(false);
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.stand();						//a function from Game class is called to process the dealers move
			}
		});
		btnStand.setBounds(1272, 680, 141, 60);
		contentPane.add(btnStand);
		
		//Player's hand count
		lblPlayerTotalMoneyLeft = new JLabel("100");
		lblPlayerTotalMoneyLeft.setForeground(Color.WHITE);
		lblPlayerTotalMoneyLeft.setFont(new Font("Century", Font.PLAIN, 30));
		lblPlayerTotalMoneyLeft.setBounds(1377, 109, 71, 48);
		contentPane.add(lblPlayerTotalMoneyLeft);
		
		//Dealer's total money left
		lblDealerTotalMoneyLeft = new JLabel("100");
		lblDealerTotalMoneyLeft.setForeground(Color.WHITE);
		lblDealerTotalMoneyLeft.setFont(new Font("Century", Font.PLAIN, 30));
		lblDealerTotalMoneyLeft.setBounds(1375, 48, 85, 60);
		contentPane.add(lblDealerTotalMoneyLeft);
		
		//Player's hand count
		lblPlayerHandCount = new JLabel("");
		lblPlayerHandCount.setFont(new Font("Century", Font.PLAIN, 24));
		lblPlayerHandCount.setForeground(Color.WHITE);
		lblPlayerHandCount.setBounds(155, 593, 53, 48);
		contentPane.add(lblPlayerHandCount);
		
		//Dealer's hand count
		lblDealerHandCount = new JLabel("");
		lblDealerHandCount.setForeground(Color.WHITE);
		lblDealerHandCount.setFont(new Font("Century", Font.PLAIN, 24));
		lblDealerHandCount.setBounds(155, 157, 71, 48);
		contentPane.add(lblDealerHandCount);
		
		//bet amount
		lblBet = new JLabel("");
		lblBet.setFont(new Font("Century", Font.PLAIN, 26));
		lblBet.setForeground(Color.WHITE);
		lblBet.setBounds(799, 376, 62, 44);
		contentPane.add(lblBet);
		
		//Card Holders | dealer
		lbldealerCardHolder1 = new JLabel(cardBack);
		lbldealerCardHolder1.setBounds(209, 137, 158, 207);
		contentPane.add(lbldealerCardHolder1);
	
		lbldealerCardHolder2 = new JLabel(cardBack);
		lbldealerCardHolder2.setBounds(416, 102, 158, 204);
		contentPane.add(lbldealerCardHolder2);	
		
		lbldealerCardHolder3 = new JLabel(cardBack);
		lbldealerCardHolder3.setBounds(622, 83, 167, 207);
		contentPane.add(lbldealerCardHolder3);
		
		lbldealerCardHolder4 = new JLabel(cardBack);
		lbldealerCardHolder4.setBounds(838, 95, 158, 197);
		contentPane.add(lbldealerCardHolder4);
		
		lbldealerCardHolder5 = new JLabel(cardBack);
		lbldealerCardHolder5.setBounds(1048, 142, 158, 207);
		contentPane.add(lbldealerCardHolder5);
		
		//Card Holders | Player
		lblPlayerCardHolder1 = new JLabel(cardBack);
		lblPlayerCardHolder1.setBounds(209, 440, 158, 216);
		contentPane.add(lblPlayerCardHolder1);
		
		lblPlayerCardHolder2 = new JLabel(cardBack);
		lblPlayerCardHolder2.setBounds(416, 481, 158, 214);
		contentPane.add(lblPlayerCardHolder2);
		
		lblPlayerCardHolder3 = new JLabel(cardBack);
		lblPlayerCardHolder3.setBounds(622, 498, 167, 207);
		contentPane.add(lblPlayerCardHolder3);
		
		lblPlayerCardHolder4 = new JLabel(cardBack);
		lblPlayerCardHolder4.setBounds(839, 471, 157, 207);
		contentPane.add(lblPlayerCardHolder4);
		
		lblPlayerCardHolder5 = new JLabel(cardBack);
		lblPlayerCardHolder5.setBounds(1050, 449, 156, 204);
		contentPane.add(lblPlayerCardHolder5);
		
		/*Win Count*/
		lblWinCount = new JLabel("");
		lblWinCount.setFont(new Font("Century", Font.BOLD, 30));
		lblWinCount.setForeground(Color.WHITE);
		lblWinCount.setBounds(1258, 389, 53, 53);
		contentPane.add(lblWinCount);
		
		/*Loss Count*/
		lblLossCount = new JLabel("");
		lblLossCount.setForeground(Color.WHITE);
		lblLossCount.setFont(new Font("Century", Font.BOLD, 30));
		lblLossCount.setBounds(1382, 367, 92, 97);
		contentPane.add(lblLossCount);
		
		/*background image*/
		lblbackground = new JLabel("");
		lblbackground.setBounds(5, 0, 1500, 800);
		contentPane.add(lblbackground);
		lblbackground.setIcon(backgroundIcon);
		
	}
	
	
	
	
	
	//getters and setters 
	
	/*
	 Getters and setters are used to access and set data members from outside the class
	 Below are the list of setters and getters function for this class
	 since, the GUI class handles all the display. There are no getters functions here
	 */
	
	//lbldealerCardHolder1 setters  
	public static void setlbldealerCardHolder1(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lbldealerCardHolder1.setIcon(cardImageIcon);
	}
	//lbldealerCardHolder2 setters 
	public static void setlbldealerCardHolder2(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lbldealerCardHolder2.setIcon(cardImageIcon);
	}	
	//lbldealerCardHolder3 setters 
	public static void setlbldealerCardHolder3(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lbldealerCardHolder3.setIcon(cardImageIcon);
	}	
	//lbldealerCardHolder4 setters 
	public static void setlbldealerCardHolder4(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lbldealerCardHolder4.setIcon(cardImageIcon);
	}	
	//lbldealerCardHolder5 setters 
	public static void setlbldealerCardHolder5(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lbldealerCardHolder5.setIcon(cardImageIcon);
	}	
	//lblPlayerCardHolder1 setters 
	public static void setlblPlayerCardHolder1(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lblPlayerCardHolder1.setIcon(cardImageIcon);
	}	
	//PlayerCardHolder2 setters 
	public static void setlblPlayerCardHolder2(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lblPlayerCardHolder2.setIcon(cardImageIcon);
	}	
	//lblPlayerCardHolder3 setters 
	public static void setlblPlayerCardHolder3(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lblPlayerCardHolder3.setIcon(cardImageIcon);
	}	
	//lblPlayerCardHolder4 setters 
	public static void setlblPlayerCardHolder4(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lblPlayerCardHolder4.setIcon(cardImageIcon);
	}	
	//lblPlayerCardHolder5 setters 
	public static void setlblPlayerCardHolder5(String imageLocationString) {
		cardImageIcon = new ImageIcon(imageLocationString);
		lblPlayerCardHolder5.setIcon(cardImageIcon);
	}	
	//NewHandsetEnabled setters 
	public static void setNewHandsetEnabled(boolean state) {
		btnNewHand.setEnabled(state);
	}

	//Hit setter
	public static void setHitSetEnabled (boolean state) {
		btnHit.setEnabled(state);
	}
	
	//stand setter
	public static void setStandSetEnabled (boolean state) {
		btnStand.setEnabled(state);
	}
}
