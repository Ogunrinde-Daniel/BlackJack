
public class Main {

	/*Data members declaration*/
	private static boolean newHandClicked = false;					//data member that determines if the new hand clicked is true
	
	public static void main(String[] args) {
	// ####################################################################################################
	// Method				:	void main(String[] args)
	//
	// Method parameters	:	args - the method permits String command line parameters to be entered
	//
	// Method return		:	void
	//
	// Synopsis				:   This method reads the win loss tally displays the graphical 
	//							user interface and runs the game loop
	//							which has the game functionality
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-23		O. Ogunrinde			Initial setup
	//
	// ######################################################################################################
		Game.dataReader();											//reads in the win loss tally from the previous run
		
		GUI.main(args);												//displays the graphical user interface 		
		
		gameLoop();													//runs the gameLoop function
		
	}

	public static void gameLoop() {
	// ####################################################################################################
	// Method				:	void gameLoop()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method calls the game functionality, it is been called twice.
	//							It is been called when the main runs but does not activate yet
	//							it is activates once new hand is pressed. the newHandClicked
	//							data member is set to true in the GUI button function btnNewHand 
	//	
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-23		O. Ogunrinde			Initial setup
	//
	// ######################################################################################################
	
		if (newHandClicked == true)								//checks if the newHand button is clicked
																//the boolean is set in class GUI->btnNewHand
			
			Game.main(null);									//runs the main function in class->Game if 
																//new hand is clicked
		
		/*Below is the pseudo code version of the above code
		 *The below version works well but is not as efficient 
		 */
		
//		do {
//			if(newHandClicked == true) {
//				newHandClicked = false;
//				while (newHandClicked == false) {
//									
//					//run the game
//					Game.main(null);	
//					
//				}
//			}
//		}while(newHandClicked == true);
	}
	
	
	
	
	//getter and setters
	public static boolean isNewHandClicked() {
		return newHandClicked;									//getter for new hand clicked
	}
	
	public static void setNewHandClicked(boolean newHandClickedValue) {
		newHandClicked = newHandClickedValue;					//setter for new hand clicked
	}

}