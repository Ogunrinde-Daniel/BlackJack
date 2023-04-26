import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Game {

	/*Data Members Declaration*/
	/*Every data member is extremely crucially to the game run*/
	
	private static ArrayList<CardDeck> playerCardStorage;	//ArrayList to store 5 playerCards
	private static ArrayList<CardDeck> dealerCardStorage;	//ArrayList to store 5 dealerCards

	private static Integer playerTotalMoneyleft = 100;		//storage for playerMoney, It remains 
															//the same throughout a game play
	
	private static Integer dealerTotalMoneyleft = 100;		//storage for dealerMoney, It remains 
															//the same throughout a game play
	
	private static int playerNextcardIndex;					//stores the next card index for the player
	private static int dealerNextcardIndex;					//stores the next card index for the dealer
		
	private static Integer playerHandCount;					//stores the player total handCount
	private static Integer dealerHandCount;					//stores the player total handCount
	
	private static Integer winCount = 0;					//stores the win count, this stores in a file
	private static Integer lossCount= 0;					//stores the loss count, this stores in a file
	
	private static Integer BetAmount;						//stores the bet amount made by the player
	
	private static CardDeck currentCard;					//Stores the current card passed in
	
	/*WinLoss Testers*/
	private static boolean blackJack;						//is true when the player has a blackJack
	private static boolean playerBusted;					//is true when the player is Busted
	private static boolean dealerBusted;					//is true when the dealer is busted
	private static boolean monty;							//is true when the player has a monty
	
	private static int playerMoves;							//stores the player total moves after the
															//first two cards have been displayed
	
	
	public static void main(String[] args) {
	// ####################################################################################################
	// Method				:	void main(String[] args)
	//
	// Method parameters	:	args - the method permits String command line parameters to be entered
	//
	// Method return		:	void
	//
	// Synopsis				:   This method creates and shuffles a cardDeck from the cardDeck class, 
	//							it then initializes the data members, it triggers the bet function
	//							and goes through the game play
	//							This function runs every time new hand is clicked on
	//							GUI.btnNewHand >> Main.gameLoop >> Game.main
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-23		O. Ogunrinde			Initial setup
	//
	// ######################################################################################################
		
		
		CardDeck.createCards();								//creates a deck of 52 cards from the class of cardDeck
		CardDeck.shuffleCards();							//shuffles the deck of cards created from the class of cardDeck					
		initializeDataMembers();							//initializes the data members of this class
		bet();												//creates a deck of 52 cards 
		play(); 											//creates a deck of 52 cards 
		

	}
	
	public static void dataReader() {
		// ####################################################################################################
		// Method				:	void dataReader()
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method reads in the win Loss tally from the text file
		//							in the code, in other words, the win loss tally of the player
		//							is continuous
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		
		
		try {
		
			FileReader inputFile = new FileReader("Data//WinLossTally.txt");	//declares and instantiates a inputFile object of FileReader	
			BufferedReader bufferedReader = new BufferedReader(inputFile);		//declares and instantiates a bufferedReader object of BufferedReader
		
			String winCountString;												//declares a string of winCountString
			String lossCountString;												//declares a string of lossCountString
			
			/*since the fileReader can't read integer data types well. a string is created to temporarily store the file readings*/
			winCountString  = bufferedReader.readLine();						//stores the firstLine of the file in winCountString
			lossCountString = bufferedReader.readLine();						//stores the secondLine of the file in lossCountString
			
			winCount  = Integer.parseInt(winCountString);						//stores the Strings in the winCount Integer data members
			lossCount = Integer.parseInt(lossCountString);						//stores the Strings in the lossCount Integer data members
			
			bufferedReader.close();												//closes the buffer reader
			inputFile.close();													//closes the file reader
			
		} catch (IOException e) {
			e.printStackTrace();												//checks for problems while reading file
		}
			
	}
	
	public static void dataSaver() {
		// ####################################################################################################
		// Method				:	void dataReader()
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method write in the win Loss tally text file
		//							in the code, in other words, it modifies the win loss count
		//							
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		
		try {
			
			FileWriter	   outputFile	  = new FileWriter("Data//WinLossTally.txt");	//declares and instantiates a outputFile object of FileWriter	
			BufferedWriter bufferedWriter = new BufferedWriter(outputFile);				//declares and instantiates a bufferedWriter object of BufferedWriter	
			
			bufferedWriter.write(getWinCount());										//modifies the winCount by accessing it from the getter function
			bufferedWriter.newLine();													//moves the cursor to the nextLine
			
			bufferedWriter.write(getLossCount());										//modifies the lossCount by accessing it from the getter function
			bufferedWriter.newLine();													//moves the cursor to the nextLine
			
			bufferedWriter.flush();														//flushes the bufferedWriter object
			bufferedWriter.close();														//closes the bufferedWriter object
			outputFile.close();															//closes the outputFile object
			
		} catch (IOException e) {
			e.printStackTrace();														//checks for problems while reading file
		}
		
	}
	
	public static void initializeDataMembers() {
		// ####################################################################################################
		// Method				:	void initializeDataMembers
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method initializes all the data members created in this class with the exceptions of
		//							playerTotalMonyLeft and dealerTotalMoneyLeft
		//							The data members are initialized in a function so, the parameters can reset after each successful game;
		//							The function then instantiates an array by receiving 10 cards from cardDeck class
		//							The function always calls a function to update all the cardHolders to a card back 
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		/*This initializes the data members for every new game*/
		
		 playerCardStorage = new ArrayList<>();						//instantiates the storage for player cards
		 dealerCardStorage = new ArrayList<>(); 					//instantiates the storage for dealer cards
		 currentCard = new CardDeck(null, null , 0);				//instantiates the a temporary card Storage
				
		 playerNextcardIndex = 0;									//initializing the player next card index to 0
		 dealerNextcardIndex = 0;									//initializing the dealer next card index to 0
		 
		 BetAmount = 0;												//initializing the bet Amount to 0
		 
		 playerHandCount = 0;										//initializing the playerHandCount to 0
		 dealerHandCount = 0;										//initializing the dealerHandCount to 0
		 
		 blackJack = false;											//initializes blackjack to false
		 playerBusted = false;										//initializes playerBusted to false
		 dealerBusted = false;										//initializes dealerBusted to false
		 monty = false;												//initializes monty to false
			
		 playerMoves = 0;											//initializes playerMoves to 0
		 
		 
		 /*loops 5 times and fills the player cardStorage and dealer cardStorage with 5 cards each*/
		 /*NOTE: this loop only fill the array, It doesn't display it yet*/
		 
		 for(int counter = 0; counter < 5; counter++) {				
				playerCardStorage.add( CardDeck.getNextCard() );	//fills in the array with 5 cards from the deck
				dealerCardStorage.add( CardDeck.getNextCard() );	//fills in the array with 5 cards from the deck
		}
		
		 GUI.initializeCardHolders();								//turns the cards placeholder to display the back of card
		 GUI.updateInterface();										//since the variables have been initialized, the interface has to be updated
		 															//for the user, this method updates the interface.
	
	}
	
	public static void bet() {
	// ####################################################################################################
	// Method				:	void bet()
	//
	// Method parameters	:	null
	//
	// Method return		:	void
	//
	// Synopsis				:   This prompts the user to input a bet amount
	//							It subtracts the bet amount from both the player and the dealer
	//							Finally, the function updates the user Interface
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-23		O. Ogunrinde			Initial setup
	//
	// ######################################################################################################
		
		
		String BetAmountString = "";																												//Variable to temporarily store the bet input from user
		boolean userError;																															//a boolean to test when the user enters a wrong input
		
		do {
			userError = false;																														//userError initialized to false every time the loop runs
			BetAmountString = JOptionPane.showInputDialog("You have to place your bet first \n How much do you want to bet");						//informing the user to place their bet
			
			try {
				BetAmount = Integer.parseInt(BetAmountString);																						//converting the string input to an Integer data type
				if (playerTotalMoneyleft < BetAmount) JOptionPane.showMessageDialog(null, "You do not have up to that amount to bet");				//warning the user of a wrong input if the user does not have enough money (The loop will run again)
				if (BetAmount <= 0) JOptionPane.showMessageDialog(null, "Sorry, The minimum bet amount is $1");										//warns the user that the bet amount must be more than 0 (The loop will run again)
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "pls input a valid amount");																	//displays error if a valid integer was not inserted
				userError = true;																													//triggers the userError; makes the loop run
			}
		}while(userError || (playerTotalMoneyleft < BetAmount) || (BetAmount <= 0) );																//if the conditions are not met, the loop runs again
			
		
		playerTotalMoneyleft -= BetAmount;																											//Subtracts the betAmount from the player's remaining money
		dealerTotalMoneyleft -= BetAmount;																											//Subtracts the same bet Amount from the dealer's money
		BetAmount *= 2;																																//The bet Amount is multiplied by 2 to signify the 2 bets coming together
		
		/*If the dealer money is less than zero, it means the dealer does not have enough money for the bet
		 * in this case, the whole of the dealer's remaining money will be bet, but the dealer's remaining money will be 0*/
		if(dealerTotalMoneyleft < 0) { 																												//checks if the dealer doesn't have enough money for the bet
			BetAmount += dealerTotalMoneyleft;																										//removes the dealer's deficit from the combined bet amount
			dealerTotalMoneyleft = 0;																												//sets the dealer remaining money to 0
		
		}
		GUI.updateInterface();																														//updates the interface | betAmount in this case																																																		

		
	}
		
	public static void play() {
		
	// ####################################################################################################
	// Method				:	void play()
	//
	// Method parameters	:	null
	//
	// Method return		:	void
	//
	// Synopsis				:   This method starts the real game, it comes starts after the new Hand has been pressed
	//							the play function updates the cards to the screen for the player and dealer
	//							after displaying the card images, it accesses the card values and updates the HandCount
	//							Lastly, it checks for if the player has blackJack and sets an automatic win
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-23		O. Ogunrinde			Initial setup
	//
	// ######################################################################################################
		
		
		/*deals 2 cards out to the player*/
		while( playerNextcardIndex < 2) {
			currentCard = playerCardStorage.get(playerNextcardIndex);			//sets the current card to the first card element in the playerCardStorage array of 5
			
			switch (playerNextcardIndex) {										//switches on the player card index
			
			case 0:																//for the first index | first loop run
				GUI.setlblPlayerCardHolder1( currentCard.getImage()  );			//the player's first card is set to the current image
				updatePlayerCount(currentCard.getValue());						//adds the card value to the player count
				break;
			
			case 1:																//for the second index | second loop run
				GUI.setlblPlayerCardHolder2( currentCard.getImage()  );			//the player's second card is set to the current image
				updatePlayerCount(currentCard.getValue());						//adds the card value to the player count
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Error in Game.play");		//signifies an error
				break;
			}
			playerNextcardIndex++;												//increments the player index
			
		}
		
		/*deals 2 cards out to the dealer*/
		while(dealerNextcardIndex < 2) {
			currentCard = dealerCardStorage.get(dealerNextcardIndex);			//sets the current card to the first card element in the playerCardStorage array of 5
			
			switch (dealerNextcardIndex) {										//switches on the dealer card index
			
			case 0:																//for the first index | first loop run
				GUI.setlbldealerCardHolder1( currentCard.getImage()  );			//the dealer's first card is set to the current image
				updateDealerCount(currentCard.getValue());						//adds the card value to the player count
				break;
				
			case 1:																//for the second index | first loop run
				GUI.setlbldealerCardHolder2( currentCard.getImage()  );			//the dealer's second card is set to the current image
				updateDealerCount(currentCard.getValue());						//adds the card value to the player count
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Error in Game.play");		//signifies an error
				break;
			}
			dealerNextcardIndex++;												//increments the dealer index
			
		}
		
		if(playerHandCount == 21) {												//checks if the player has a blackjack
			
			blackJack = true;													//sets the blackjack state to true
			displayResult();													//displays the result
		}
		
	}
	
	public static void updatePlayerCount(int cardValue) {
		// ####################################################################################################
		// Method				:	void updatePlayerCount(int cardValue)
		//
		// Method parameters	:	int cardValue
		//
		// Method return		:	void
		//
		// Synopsis				:   This method starts updates the playerHandCount
		//							It does this by adding the value of the card passed in as parameter
		//							finally, It calls the function to update interface
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		if ((cardValue == 11) &&  (playerHandCount > 10) )			//checks if the card is an ace. if the value is an ace and the 
																	//total hand count is greater than 10, then the ace will be turned 
																	//to 1. because 11 + anything greater than 10 will be over 21
			
			cardValue = 1;											//sets the value of the ace to one | NOTE: Ace's value is 11 by default
		
		playerHandCount += cardValue;								//playerCount is updated by adding the current card value to the playerHandCount
		
		GUI.updateInterface();										//The GUI is updated to reflect the changes in hand count
	}
	
	public static void updateDealerCount(int cardValue) {
		// ####################################################################################################
		// Method				:	void updateDealerCount(int cardValue)
		//
		// Method parameters	:	int cardValue
		//
		// Method return		:	void
		//
		// Synopsis				:   This method starts updates the dealerHandCount
		//							It does this by adding the value of the card passed in as parameter
		//							finally, It calls the function to update interface
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		if ((cardValue == 11) &&  (dealerHandCount > 10) ) 			//checks if the card is an ace. if the value is an ace and the 
																	//total hand count is greater than 10, then the ace will be turned 
																	//to 1. because 11 + anything greater than 10 will be over 21
			
			cardValue = 1;											//sets the value of the ace to one | NOTE: Ace's value is 11 by default
		
		dealerHandCount += cardValue;								//deerCount is updated by adding the current card value to the dealerHandCount
		
		GUI.updateInterface();										//The GUI is updated to reflect the changes in the hand count
	}
	
	public static void hit() {
		// ####################################################################################################
		// Method				:	void hit()
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method is called when the user clicks on the button btnNewHand
		//							the method runs once, and gives the player his next card. 
		//							the function keeps count of the number of times hit has been pressed
		//							and stops running once the player runs out of moves
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		
		int numberOfHitsLeft = 3;												//numberOfHitsLeft initialization
																				//since the player gets two card by default of start, 
																				//the maximum no of cards he can get is 3
		
		if( (playerMoves < numberOfHitsLeft)  && (blackJack == false) && (playerBusted == false) && (dealerBusted == false)  ) {	//checks if the player can still go for another round of card	
			
				currentCard = playerCardStorage.get(playerNextcardIndex);		//the current card is set the next card from the player's array of 5
				
				switch (playerNextcardIndex) {
				
				case 2:															//player's 3rd card
					GUI.setlblPlayerCardHolder3( currentCard.getImage()  );		//the image is displayed
					updatePlayerCount(currentCard.getValue());					//the value is added to the playerHandCount
					playerNextcardIndex++;										//the playerNextcardIndex is incremented
					break;
					
				case 3:															//player's 4th card
					GUI.setlblPlayerCardHolder4( currentCard.getImage()  );		//the image is displayed
					updatePlayerCount(currentCard.getValue());					//the value is added to the playerHandCount
					playerNextcardIndex++;										//the playerNextcardIndex is incremented
					break;
					
				case 4:															//player's 5th card
					GUI.setlblPlayerCardHolder5( currentCard.getImage()  );		//the image is displayed
					updatePlayerCount(currentCard.getValue());					//the value is added to the playerHandCount
					playerNextcardIndex++;										//the playerNextcardIndex is incremented
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Error from hitOrStand"); //displays an error message
					break;
					
				}
				playerMoves++;														//increments playerMoves
				
				/*checks for the condition in which the player either wins or losses*/
				if(playerHandCount > 21) {											//checks if the player count is less than 21
					
					playerBusted = true;											//sets the variable, playerBusted to true
					displayResult();												//displays the result
				}
				
				if(playerHandCount == 21) {											//checks if the player hand Count is equal to 21
					
					blackJack = true;												//sets the variable blackjack to true
					displayResult();												//displays the result
				}
				
				if( (playerMoves == 3) && (playerHandCount < 21) ) { 				//checks if there is a monty 
					
					monty = true;													//sets monty to true
					displayResult();												//displays result
				}
			
		}//end of if
		else 
			displayResult();														//if the hit conditions are not met, the result is displayed
		
		
	}//end of function hit
	
	public static void stand() {
		// ####################################################################################################
		// Method				:	void stand()
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method is called when the user clicks on the button btnStand
		//							the method runs until (dealerHandCount <= playerHandCount) and (dealerMoves < 3)
		//							each time the while loop runs, the dealer is given a new card and the interface
		//							is updated
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		
			int dealerMoves = 0;															//declaration of dealerMoves variable
			
			if(!playerBusted && !blackJack	&& !monty)	{									//checks if the player has either won or lost, 
																							//if so, the stand does not work
				
				while ( (dealerHandCount <= playerHandCount) && (dealerMoves < 3) ) {		//checks if the dealer should still add more cards
					
					currentCard = dealerCardStorage.get(dealerNextcardIndex);				//sets the currentCard to the next card from the dealer array of size 5
					
					switch (dealerNextcardIndex) {											
					case 2:																	//dealer's 3rd card
						GUI.setlbldealerCardHolder3( currentCard.getImage()  );				//the image is displayed
						updateDealerCount(currentCard.getValue());							//the value is added to the dealerHandCount
						dealerNextcardIndex++;												//the dealerNextcardIndex is incremented
						break;
						
					case 3:																	//dealer's 4th card
						GUI.setlbldealerCardHolder4( currentCard.getImage()  );				//the image is displayed
						updateDealerCount(currentCard.getValue());							//the value is added to the dealerHandCount
						dealerNextcardIndex++;												//the dealerNextcardIndex is incremented
						break;
						
					case 4:																	//dealer's 5th card
						GUI.setlbldealerCardHolder5( currentCard.getImage()  );				//the image is displayed
						updateDealerCount(currentCard.getValue());							//the value is added to the dealerHandCount
						dealerNextcardIndex++;												//the dealerNextcardIndex is incremented
						break;
					default:
						JOptionPane.showMessageDialog(null, "Error from stand");			//displays an error
						break;
						
					}
					dealerMoves++;															//increments the dealerMoves
				}//end of while loop
			
				if (dealerHandCount > 21) dealerBusted = true;								//checks if the dealer is busted
				displayResult();															//displays the result if the dealer is busted
			
			}//end of if condition
	}
	
	public static void displayResult() {
		// ####################################################################################################
		// Method				:	void displayResult()
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method is called randomly when the user has either lost or won
		//							the method sets the new Hand to be enabled and sets the hit and stand button 
		//							to be true. It then displays the result by going through a series of if else
		//							statements
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		
		
		GUI.setNewHandsetEnabled(true);								//the newHand button is enabled
		
		GUI.setHitSetEnabled(false);								//hit   button is disabled
		GUI.setStandSetEnabled(false);								//stand button is disabled
		
		
		String resultString ="";									//declaration of resultString
		
		if (monty == true) {										//monty case
			
			resultString = "You have a Monty | You win";			//displays result
			resultString += "\nYou won $" + BetAmount;
			
			playerTotalMoneyleft += BetAmount;						//pays the winner
			BetAmount = 0;											//reset the betAmount
			
			winCount += 1;											//updates winlossTally
			GUI.updateInterface();									//updates interface to reflect changes
		}
		
		else if (blackJack == true) {								//blackjack case
			
			resultString = "You have a blackjack | You win";		//displays result
			resultString += "\nYou won $" + BetAmount;	
			
			playerTotalMoneyleft += BetAmount;						//pays the winner				
			BetAmount = 0;											//reset the betAmount
			
			winCount += 1;											//updates winlossTally
			GUI.updateInterface();									//updates interface to reflect changes
		}
			
		else if (playerBusted == true) {							//busted case
			
			resultString = "You have been busted | You lose";		//stores result
			resultString += "\nThe dealer won $" + BetAmount;
			
			dealerTotalMoneyleft += BetAmount;						//pays the winner	
			BetAmount = 0;											//reset the betAmount
			
			lossCount += 1;											//updates winlossTally
			GUI.updateInterface();									//updates interface to reflect changes

		}
			
		else if (dealerBusted == true) {							//dealerBusted case
			
			resultString = "The dealer has been busted | You win";	//stores result
			resultString += "\nYou won $" + BetAmount;				
			
			playerTotalMoneyleft += BetAmount;						//pays the winner	
			BetAmount = 0;											//reset the betAmount
			
			winCount += 1;											//updates winlossTally
			GUI.updateInterface();									//updates interface to reflect changes

		}
					
		else if (playerHandCount > dealerHandCount ) {				//playerCount higher case
			
			resultString = "you have more count than the dealer | You Win.";//stores result
			resultString += "\nYou won $" + BetAmount;
			
			playerTotalMoneyleft += BetAmount;						//pays the winner	
			BetAmount = 0;											//reset the betAmount
			
			winCount += 1;											//updates winlossTally
			GUI.updateInterface();									//updates interface to reflect changes

		}
			
		else if (dealerHandCount > playerHandCount) {				//dealerCount higher case
			
			resultString = "the dealer has more count than you | You lose.";//stores result
			resultString += "\nThe dealer won $" + BetAmount;
			
			dealerTotalMoneyleft += BetAmount;						//pays the winner	
			BetAmount = 0;											//reset the betAmount
			
			lossCount += 1;											//updates winlossTally
			GUI.updateInterface();									//updates interface to reflect changes
		}
		
		else if (dealerHandCount == playerHandCount) {				//dealerCount equal playerCount case
			
			resultString = "you have the same count as the dealer | You Win.";//stores result
			resultString += "\nYou won $" + BetAmount;
			
			playerTotalMoneyleft += BetAmount;						//pays the winner	
			BetAmount = 0;											//reset the betAmount
			
			winCount += 1;											//updates winlossTally
			GUI.updateInterface();									//updates interface to reflect changes
		}

					 
		JOptionPane.showMessageDialog(null, resultString);			//displays stored result
		
		
		/*This conditional statement determines if the Game is over or not*/
		if(playerTotalMoneyleft <= 0) {													//checks if the player has no money left	
			
			JOptionPane.showMessageDialog(null, "You have no Money Left\n"  			//displays Game over screen
											   	+" 		 GAME OVER		 ");
			GUI.setHitSetEnabled(false);												//disables hit button
			GUI.setStandSetEnabled(false);												//disables the stand button
			GUI.setNewHandsetEnabled(false);											//disables newHand button
		}
		
		else if (dealerTotalMoneyleft <= 0) {											//checks if the dealer has no money left	
			
			JOptionPane.showMessageDialog(null, "The dealer has no Money Left\n " 		//displays Game over screen
											   +" 		 GAME OVER			    ");
			GUI.setHitSetEnabled(false);												//disables hit button
			GUI.setStandSetEnabled(false);												//disables the stand button
			GUI.setNewHandsetEnabled(false);											//disables newHand button
		}
		
		dataSaver();																	//saves the winLoss count
	}
	
	
	
	
	//getters and setters
	
	/*
	 Getters and setters are used to access and set data members from outside the class
	 Below are the list of setters and getters function for this class
	 */
	
	//playerCardStorage getter and setter
	public static ArrayList<CardDeck> getPlayerCardStorage() {
		return playerCardStorage;
	}
	public static void setPlayerCardStorage(ArrayList<CardDeck> playerCardStorage) {
		Game.playerCardStorage = playerCardStorage;
	}
	
	//dealerCardStorage getter and setter
	public static ArrayList<CardDeck> getDealerCardStorage() {
		return dealerCardStorage;
	}
	public static void setDealerCardStorage(ArrayList<CardDeck> dealerCardStorage) {
		Game.dealerCardStorage = dealerCardStorage;
	}
	
	//PlayerNextcardIndex getter and setter
	public static int getPlayerNextcardIndex() {
		return playerNextcardIndex;
	}
	public static void setPlayerNextcardIndex(int playerNextcardIndex) {
		Game.playerNextcardIndex = playerNextcardIndex;
	}
	
	//dealerNextcardIndex getter and setter
	public static int getDealerNextcardIndex() {
		return dealerNextcardIndex;
	}
	public static void setDealerNextcardIndex(int dealerNextcardIndex) {
		Game.dealerNextcardIndex = dealerNextcardIndex;
	}
	
	//PlayerTotalMoneyleft getter and setter
	public static String getPlayerTotalMoneyleft() {
		String playerTotalMoneyleftString = playerTotalMoneyleft.toString();
		return playerTotalMoneyleftString;
	}
	public static void setPlayerTotalMoneyleft(int playerTotalMoneyleft) {
		Game.playerTotalMoneyleft = playerTotalMoneyleft;
	}
	
	//DealerTotalMoneyleft getter and setter
	public static String getDealerTotalMoneyleft() {
		String dealerTotalMoneyleftString = dealerTotalMoneyleft.toString();
		return dealerTotalMoneyleftString;
	}
	public static void setDealerTotalMoneyleft(int dealerTotalMoneyleft) {
		Game.dealerTotalMoneyleft = dealerTotalMoneyleft;
	}

	//PlayerHandCount getter and setter
	public static String getPlayerHandCount() {
		String playerHandCountString = playerHandCount.toString();
		return playerHandCountString;
	}
	public static void setPlayerHandCount(Integer playerHandCount) {
		Game.playerHandCount = playerHandCount;
	}
	
	//DealerHandCount getter and setter
	public static String getDealerHandCount() {
		String dealerHandCountString = dealerHandCount.toString();
		return dealerHandCountString;
	}
	public static void setDealerHandCount(Integer dealerHandCount) {
		Game.dealerHandCount = dealerHandCount;
	}
	
	//BetAmount getter and setter
	public static String getBetAmount() {
		String BetAmountString = BetAmount.toString();
		return BetAmountString;
	}
	public static void setBetAmount(Integer BetAmount) {
		Game.BetAmount = BetAmount;
	}
	
	//Win Count getter and setter
	public static String getWinCount() {
		String winCountString = winCount.toString();
		return winCountString;
	}

	public static void setWinCount(Integer winCount) {
		Game.winCount = winCount;
	}
	
	//Loss Count getter and setter
	public static String getLossCount() {

		String lossCountString = lossCount.toString();
		return lossCountString;
	}

	public static void setLossCount(Integer lossCount) {
		Game.lossCount = lossCount;
	}

	
}
