import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class CardDeck {
	
	/*Data Members Declaration*/
	private  String name = "";
	private  String image = "";
	private  int value = 0;
	
	private static int nextCardIndex;
	
	private static ArrayList<CardDeck> cardDeck;
	private static ArrayList<CardDeck> shuffledCardDeck;
	
	private static Random random = new Random();
	
	private static ImageIcon back = new ImageIcon("smallCards//back.png");
		
	public CardDeck(String name, String image, int value) {
		// ####################################################################################################
		// Method				:	Constructor
		//
		// Method parameters	:	String name, String image, int value
		//
		// Method return		:	null
		//
		// Synopsis				:   This constructor creates is used to create objects of cardDeck
		//							it sets the name, image, and value 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		this.name =  name;				//name attribute for a card object	| string data type
		this.image = image;				//image attribute for a card object	| string data type
		this.value = value;				//value attribute for a card object	| int data type
	}
	
	public static void createCards() {
		// ####################################################################################################
		// Method				:	void createCards()
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method creates a cardDeck of 52 cards
		//							it then stores the cards in an array of cardDeck
		//							
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		//Reference				:	The 52 Card Images used in this method are from Open Game Arts
		//							https://opengameart.org/content/playing-cards-0
		//							Iron Star Media
		//							Submitted by ryan.dansie
		//							Friday, February 28, 2014 - 14:33
		//
		// ######################################################################################################
		
		cardDeck = new ArrayList<>();				//Instantiates a new cardDeck | this runs at the beginning of every game
		
		/*Creates 13 card objects of the Hearts suit
		 * and adds it to the cardDeck array
		 * These card objects contain the cardName, image directory and value */
		CardDeck aceOfHearts = new CardDeck  ("aOH" , "Cards//h01.png" , 11);
		cardDeck.add(aceOfHearts);
		CardDeck twoOfHearts = new CardDeck  ("2OH" , "Cards//h02.png" , 2);
		cardDeck.add(twoOfHearts);
		CardDeck threeOfHearts = new CardDeck("3OH" , "Cards//h03.png" , 3);
		cardDeck.add(threeOfHearts);
		CardDeck fourOfHearts = new CardDeck ("4OH" , "Cards//h04.png" , 4);
		cardDeck.add(fourOfHearts);
		CardDeck fiveOfHearts = new CardDeck ("5OH" , "Cards//h05.png" , 5);
		cardDeck.add(fiveOfHearts);
		CardDeck sixOfHearts = new CardDeck  ("6OH" , "Cards//h06.png" , 6);
		cardDeck.add(sixOfHearts);
		CardDeck sevenOfHearts = new CardDeck("7OH" , "Cards//h07.png" , 7);
		cardDeck.add(sevenOfHearts);
		CardDeck eightOfHearts = new CardDeck("8OH" , "Cards//h08.png" , 8);
		cardDeck.add(eightOfHearts);
		CardDeck nineOfHearts = new CardDeck ("9OH" , "Cards//h09.png" , 9);
		cardDeck.add(nineOfHearts);
		CardDeck tenOfHearts = new CardDeck  ("1OH" , "Cards//h10.png" , 10);
		cardDeck.add(tenOfHearts);
		CardDeck jackOfHearts = new CardDeck ("jOH" , "Cards//h11.png" , 10);
		cardDeck.add(jackOfHearts);
		CardDeck queenOfHearts = new CardDeck("qOH" , "Cards//h12.png" , 10);
		cardDeck.add(queenOfHearts);
		CardDeck kingOfHearts = new CardDeck ("kOH" , "Cards//h13.png" , 10);
		cardDeck.add(kingOfHearts);
		
		
		/*Creates 13 card objects of the Diamonds suit
		 * and adds it to the cardDeck array*/
		CardDeck aceOfDiamonds = new CardDeck  ("aOD" , "Cards//d01.png" , 11);
		cardDeck.add(aceOfDiamonds);
		CardDeck twoOfDiamonds = new CardDeck  ("2OD" , "Cards//d02.png" , 2);
		cardDeck.add(twoOfDiamonds);
		CardDeck threeOfDiamonds = new CardDeck("3OD" , "Cards//d03.png" , 3);
		cardDeck.add(threeOfDiamonds);
		CardDeck fourOfDiamonds = new CardDeck ("4OD" , "Cards//d04.png" , 4);
		cardDeck.add(fourOfDiamonds);
		CardDeck fiveOfDiamonds = new CardDeck ("5OD" , "Cards//d05.png" , 5);
		cardDeck.add(fiveOfDiamonds);
		CardDeck sixOfDiamonds = new CardDeck  ("6OD" , "Cards//d06.png" , 6);
		cardDeck.add(sixOfDiamonds);
		CardDeck sevenOfDiamonds = new CardDeck("7OD" , "Cards//d07.png" , 7);
		cardDeck.add(sevenOfDiamonds);
		CardDeck eightOfDiamonds = new CardDeck("8OD" , "Cards//d08.png" , 8);
		cardDeck.add(eightOfDiamonds);
		CardDeck nineOfDiamonds = new CardDeck ("9OD" , "Cards//d09.png" , 9);
		cardDeck.add(nineOfDiamonds);
		CardDeck tenOfDiamonds = new CardDeck  ("1OD" , "Cards//d10.png" , 10);
		cardDeck.add(tenOfDiamonds);
		CardDeck jackOfDiamonds = new CardDeck ("jOD" , "Cards//d11.png" , 10);
		cardDeck.add(jackOfDiamonds);
		CardDeck queenOfDiamonds = new CardDeck("qOD" , "Cards//d12.png" , 10);
		cardDeck.add(queenOfDiamonds);
		CardDeck kingOfDiamonds = new CardDeck ("kOD" , "Cards//d13.png" , 10);
		cardDeck.add(kingOfDiamonds);

		/*Creates 13 card objects of the Spades suit
		 * and adds it to the cardDeck array*/
		CardDeck aceOfSpades = new CardDeck  ("aOS" , "Cards//s01.png" , 11);
		cardDeck.add(aceOfSpades);
		CardDeck twoOfSpades = new CardDeck  ("2OS" , "Cards//s02.png" , 2);
		cardDeck.add(twoOfSpades);
		CardDeck threeOfSpades = new CardDeck("3OS" , "Cards//s03.png" , 3);
		cardDeck.add(threeOfSpades);
		CardDeck fourOfSpades = new CardDeck ("4OS" , "Cards//s04.png" , 4);
		cardDeck.add(fourOfSpades);
		CardDeck fiveOfSpades = new CardDeck ("5OS" , "Cards//s05.png" , 5);
		cardDeck.add(fiveOfSpades);
		CardDeck sixOfSpades = new CardDeck  ("6OS" , "Cards//s06.png" , 6);
		cardDeck.add(sixOfSpades);
		CardDeck sevenOfSpades = new CardDeck("7OS" , "Cards//s07.png" , 7);
		cardDeck.add(sevenOfSpades);
		CardDeck eightOfSpades = new CardDeck("8OS" , "Cards//s08.png" , 8);
		cardDeck.add(eightOfSpades);
		CardDeck nineOfSpades = new CardDeck ("9OS" , "Cards//s09.png" , 9);
		cardDeck.add(nineOfSpades);
		CardDeck tenOfSpades = new CardDeck  ("1OS" , "Cards//s10.png" , 10);
		cardDeck.add(tenOfSpades);
		CardDeck jackOfSpades = new CardDeck ("jOS" , "Cards//s11.png" , 10);
		cardDeck.add(jackOfSpades);
		CardDeck queenOfSpades = new CardDeck("qOS" , "Cards//s12.png" , 10);
		cardDeck.add(queenOfSpades);
		CardDeck kingOfSpades = new CardDeck ("kOS" , "Cards//s13.png" , 10);
		cardDeck.add(kingOfSpades);

		/*Creates 13 card objects of the Clubs suit
		 * and adds it to the cardDeck array*/
		CardDeck aceOfClubs = new CardDeck  ("aOC" , "Cards//c01.png" , 11);
		cardDeck.add(aceOfClubs);
		CardDeck twoOfClubs = new CardDeck  ("2OC" , "Cards//c02.png" , 2);
		cardDeck.add(twoOfClubs);
		CardDeck threeOfClubs = new CardDeck("3OC" , "Cards//c03.png" , 3);
		cardDeck.add(threeOfClubs);
		CardDeck fourOfClubs = new CardDeck ("4OC" , "Cards//c04.png" , 4);
		cardDeck.add(fourOfClubs);
		CardDeck fiveOfClubs = new CardDeck ("5OC" , "Cards//c05.png" , 5);
		cardDeck.add(fiveOfClubs);
		CardDeck sixOfClubs = new CardDeck  ("6OC" , "Cards//c06.png" , 6);
		cardDeck.add(sixOfClubs);
		CardDeck sevenOfClubs = new CardDeck("7OC" , "Cards//c07.png" , 7);
		cardDeck.add(sevenOfClubs);
		CardDeck eightOfClubs = new CardDeck("8OC" , "Cards//c08.png" , 8);
		cardDeck.add(eightOfClubs);
		CardDeck nineOfClubs = new CardDeck ("9OC" , "Cards//c09.png" , 9);
		cardDeck.add(nineOfClubs);
		CardDeck tenOfClubs = new CardDeck  ("1OC" , "Cards//c10.png" , 10);
		cardDeck.add(tenOfClubs);
		CardDeck jackOfClubs = new CardDeck ("jOC" , "Cards//c11.png" , 10);
		cardDeck.add(jackOfClubs);
		CardDeck queenOfClubs = new CardDeck("qOC" , "Cards//c12.png" , 10);
		cardDeck.add(queenOfClubs);
		CardDeck kingOfClubs = new CardDeck ("kOC" , "Cards//c13.png" , 10);
		cardDeck.add(kingOfClubs);	
		
	}
	
	public static void shuffleCards() {
		// ####################################################################################################
		// Method				:	void shuffleCards()
		//
		// Method parameters	:	null
		//
		// Method return		:	void
		//
		// Synopsis				:   This method instantiates an array of shuffledcardDeck
		//							it then randomizes the cardDeck array and keeps it in a shuffled array
		//							
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		shuffledCardDeck = new ArrayList<>();							//Instantiates a new cardDeck | this runs at the beginning of every game
		
		int numberOfCards = 52;											//declaring an integer signifying the size of a card cardDeck as created  in createCards method
		int randomIndex = 0;											//declaring an integer used to store randomly generated number between 0 and 51 (The index range of the cardDeck array)
		int counter = 0;												//declaring an integer used to keep count of the while loop in this function

		while(counter < numberOfCards)
		{
			randomIndex  = random.nextInt(51);							//store a randomly generated index between (0-51) in randomIndex | This is the index range of the cardDeck array
			
			/*after a card is found the index is deleted
			 and since, we are using a dynamic array
			 the array automatically adjusts its size */
			if(randomIndex < cardDeck.size()) {							//if the index is less than the cardDeck array size, that means the index still exists 		
				
				shuffledCardDeck.add( cardDeck.get(randomIndex) );		//the card at the randomIndex location in the cardDeck is extracted and kept in a new array shuffledCardDeck
				cardDeck.remove(randomIndex);							//the index is therefore removed from the cardDeck array
				counter++;												//the counter is incremented | note: the counter only increments when this "if statement runs"
			}
			
		}//the "while loop" might run more than 52 times. however, it will only fill shuffledCardDeck up to 52 unique cards
		
		nextCardIndex = -1;												//The nextCardIndex is used to call the next card from the shuffledCardDeck array,
																		//we want to initialize it every time the card is re-shuffled
		
	}
	
	
	public static CardDeck getNextCard() {
		// ####################################################################################################
		// Method				:	CardDeck getNextCard()
		//
		// Method parameters	:	null
		//
		// Method return		:	CardDeck 
		//
		// Synopsis				:   This method returns a single Card from the shuffled card when called
		//							
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-23		O. Ogunrinde			Initial setup
		//
		// ######################################################################################################
		nextCardIndex += 1;								//the index is incremented
														//since the initial value of nextCardIndex is -1; the first card to be pulled out will be at index 0
		
		return shuffledCardDeck.get(nextCardIndex);		//the next card is pulled out from the shuffled card array
	}
	
	
	
	//Getters and Setters
	/*
	 Getters and setters are used to access and set data members from outside the class
	 Below are the list of setters and getters function for this class
	 */
	
	//CardDeckSize getter
	public static int getCardDeckSize() {
		return cardDeck.size();
	}
	
	//CardDeck getter and setter
	public static ArrayList<CardDeck> getCardDeck() {
		return cardDeck;
	}

	public static void setCardDeck(ArrayList<CardDeck> cardDeck) {
		CardDeck.cardDeck = cardDeck;
	}
	
	
	//cardName getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//cardImage String getter and setter
	public String getImage() {
		return this.image;
	}

	public  void setImage(String image) {
		this.image = image;
	}

	//cardValue getter and setter
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// NextCardIndex getter and setter
	public static int getNextCardIndex() {
		return nextCardIndex;
	}

	public static void setNextCardIndex(int nextCardIndex) {
		CardDeck.nextCardIndex = nextCardIndex;
	}

	//Image Icon for back of card getter and setter
	public ImageIcon getBack() {
		return back;
	}
	public void setBack(ImageIcon back) {
		CardDeck.back = back;
	}
	
	
}
