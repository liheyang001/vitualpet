package assignment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Aaron Bong and Heyang Li
 * 
 */

/** For initialisation of new players before launching the actual game.
 *  players need to enter their names and their pet's names as well as making desired selections (number of days, number of pets, pet species) 
 */
public class PlayerSelections {
	
	/**
	 * Initialise pet selection button status for pet 1, pet 2 and pet 3 to false type Boolean.
	 */
	private boolean pet1BtnStatus = false;
	private boolean pet2BtnStatus = false;
	private boolean pet3BtnStatus = false;
	
	private boolean set1BtnStatus = false;
	private boolean set2BtnStatus = false;
	private boolean set3BtnStatus = false;
	
	private boolean btnCheckNameStatus = false;
	private boolean proceed = true;
	
	//to store game object from welcome screen
	private GameEnvi game;
	
	 
	//Create a chosenSpecies array list for checking to make sure player does not select the same pet twice.
	//also used to create pets selected
	private ArrayList<Integer> chosenSpeciesArray = new ArrayList<>();
	
	//Create a chosenSpecies array list for checking to make sure player does not have the same name.
	//also used to create pets selected
	private static ArrayList<String> playersName = new ArrayList<>();
	
	//Create a petNameArray array list for checking to make sure player does not select the same pet name.
	//the name also used to pass into the pet constructor to store its name. 
	private ArrayList<String> petNameArray = new ArrayList<>();
	
	//store choosen Species
	private static int choosenSpecies;
	
	
	/**
	 * setter for ChoosenSpecies
	 * @param choosenSpecie
	 */
	public static void setChoosenSpecies(int choosenSpecie) {
		choosenSpecies = choosenSpecie;
	}
	
	//a list of pet names to be displayed at selection button when  player has selected a pet.
	private String[] petSpeciesName = {"", "Turtle", "Kiwi Bird", "Wolf", "Panda", "Hawk", "Whale"};
	
	/**
	 * A counter to count the number of Player Selections class created so far.
	 */
	private static int newPlayerSelectionsCounter = 0;
	
	/**
	 * Initialise the frame
	 */
	private JFrame frmPlayerSelections;
	
	/**
	 * A getter for Frame
	 * @return the frame of PlayerSelections
	 */
	public JFrame getFrmPlayerSelections() {
		return frmPlayerSelections;
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PlayerSelections window = new PlayerSelections(null);
//					window.frmPlayerSelections.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PlayerSelections(GameEnvi game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerSelections = new JFrame();
		frmPlayerSelections.setTitle("Player Selections");
		frmPlayerSelections.setBounds(100, 100, 857, 494);
		frmPlayerSelections.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerSelections.getContentPane().setLayout(null);
		/**
		 * Create a title for the application.
		 */
		int currentPlayer = newPlayerSelectionsCounter + 1;
		JLabel lblPlayerSelection = new JLabel("PLAYER " + currentPlayer);
		lblPlayerSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerSelection.setBounds(317, 44, 202, 16);
		frmPlayerSelections.getContentPane().add(lblPlayerSelection);
		//================================================================================================
		
		/**
		 * Create a input box for player 1 to enter his/her name.
		 */
		JLabel lblPlayerName = new JLabel("Please enter your name:");
		lblPlayerName.setBounds(65, 110, 202, 28);
		frmPlayerSelections.getContentPane().add(lblPlayerName);
		
		JTextField playerNameTextField = new JTextField();
		playerNameTextField.setBounds(285, 112, 310, 26);
		frmPlayerSelections.getContentPane().add(playerNameTextField);
		playerNameTextField.setColumns(10);
		//================================================================================================

		/**
		 * Create a text field to input pet 1 name.
		 */
		JLabel lblPet1Name = new JLabel("Please enter Pet 1 Name:");
		lblPet1Name.setBounds(439, 216, 200, 28);
		frmPlayerSelections.getContentPane().add(lblPet1Name);
		
		JTextField pet1NameTextField = new JTextField();
		pet1NameTextField.setBounds(630, 217, 156, 28);
		frmPlayerSelections.getContentPane().add(pet1NameTextField);
		pet1NameTextField.setColumns(10);
		pet1NameTextField.setEnabled(false);
		//================================================================================================
		
		/**
		 * Create a text field to input pet 2 name.
		 */
		JLabel lblPet2Name = new JLabel("Please enter Pet 2 Name:");
		lblPet2Name.setBounds(439, 275, 200, 28);
		frmPlayerSelections.getContentPane().add(lblPet2Name);
		
		JTextField pet2NameTextField = new JTextField();
		pet2NameTextField.setBounds(630, 276, 156, 28);
		frmPlayerSelections.getContentPane().add(pet2NameTextField);
		pet2NameTextField.setColumns(10);
		pet2NameTextField.setEnabled(false);
		//================================================================================================
		
		/**
		 * Create a text field to input pet 3 name.
		 */
		JLabel lblPet3Name = new JLabel("Please enter Pet 3 Name:");
		lblPet3Name.setBounds(439, 342, 200, 28);
		frmPlayerSelections.getContentPane().add(lblPet3Name);
		
		JTextField pet3NameTextField = new JTextField();
		pet3NameTextField.setBounds(630, 343, 156, 28);
		frmPlayerSelections.getContentPane().add(pet3NameTextField);
		pet3NameTextField.setColumns(10);
		pet3NameTextField.setEnabled(false);
		//================================================================================================
		
		/**
		 * Create a pet 1 selector button for player 1. Activate pet 1 name text field if pet 1 is selected. Executes a pop up for selecting desired pet.
		 * Pet 1 selector button is activated by default as players need a minimum of 1 pet to play game.
		 */
		JLabel lblPet1 = new JLabel("Pet 1");
		lblPet1.setBounds(49, 220, 79, 21);
		frmPlayerSelections.getContentPane().add(lblPet1);
		
		JButton btnPet1Selection = new JButton("Pet not selected");
		btnPet1Selection.setBounds(97, 216, 187, 28);
		frmPlayerSelections.getContentPane().add(btnPet1Selection);
		btnPet1Selection.setBackground(Color.RED);
		btnPet1Selection.setEnabled(true);
		
		btnPet1Selection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pet1BtnStatus == false){
					btnPet1Selection.setBackground(Color.YELLOW);
					pet1BtnStatus = true;
					pet1NameTextField.setEnabled(true);					
					petChoise();
					btnPet1Selection.setText("Please Click Set Pet 1");
				}				
			}
		});
		//================================================================================================
		
		/**
		 * create a set button to set pet 1
		 */
		JButton btnSetPet1 = new JButton("Set Pet 1");
		btnSetPet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pet1BtnStatus == false){
					alertPetNotSelected();
				}
				else if(pet2BtnStatus == true || pet3BtnStatus == true){
				alertFollowOrder("Clear", "pet 2 &/or pet 3");
				}
				else{//set select pet button and pet1 name text field to default state
					if(set1BtnStatus == true){
						chosenSpeciesArray.remove(0);
						btnPet1Selection.setEnabled(true);
						pet1NameTextField.setEnabled(false);
						pet1NameTextField.setText("");
						btnPet1Selection.setBackground(Color.RED);
						btnPet1Selection.setText("Pet not selected");
						btnSetPet1.setText("Set Pet 1");
						set1BtnStatus = false;
						pet1BtnStatus = false;
					}
					else{
						//checks if same pets has been selected
						if (chosenSpeciesArray.contains(choosenSpecies)){
							alertPetSelected();
						}
						else{
							chosenSpeciesArray.add(choosenSpecies);
							btnPet1Selection.setBackground(Color.GREEN);
							btnPet1Selection.setText(petSpeciesName[chosenSpeciesArray.get(0)] + " Selected!!");
							btnPet1Selection.setEnabled(false);
							btnSetPet1.setText("clear");
							set1BtnStatus = true;
						}
					}
				}
			}
		});
		btnSetPet1.setBounds(307, 215, 104, 28);
		frmPlayerSelections.getContentPane().add(btnSetPet1);
		//================================================================================================
		
		/**
		 * Create a pet 2 selector button for player 1. Activate pet 2 name text field if pet 3 is selected. Executes a pop up for selecting desired pet. Executes a pop up alert if pet 1 not selected or deselected.
		 */
		JLabel lblPet2 = new JLabel("Pet 2");
		lblPet2.setBounds(49, 279, 79, 21);
		frmPlayerSelections.getContentPane().add(lblPet2);
		
		JButton btnPet2Selection = new JButton("Pet not selected");
		btnPet2Selection.setBounds(97, 275, 187, 28);
		frmPlayerSelections.getContentPane().add(btnPet2Selection);
		btnPet2Selection.setBackground(Color.RED);
		btnPet2Selection.setEnabled(true);

		btnPet2Selection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pet1BtnStatus == false){
					alertFollowOrder("select", "pet 1");
				}
				else if(pet1BtnStatus == true){
					if (pet2BtnStatus == false){
						btnPet2Selection.setBackground(Color.YELLOW);
						pet2BtnStatus = true;
						pet2NameTextField.setEnabled(true);
						petChoise();
						btnPet2Selection.setText("Please Click Set Pet 2");	
					}
				}
			}
		});
		//================================================================================================
		
		/**
		 * create a set button to set pet 2
		 */
		JButton btnSetPet2 = new JButton("Set Pet 2");
		btnSetPet2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pet2BtnStatus == false){
					alertPetNotSelected();
				}
				else if(pet3BtnStatus == true){
				alertFollowOrder("Clear", "pet 3");
				}
				else{//set select pet button and pet1 name text field to default state
					if(set2BtnStatus == true){
						chosenSpeciesArray.remove(1);
						btnPet2Selection.setEnabled(true);
						pet2NameTextField.setEnabled(false);
						pet2NameTextField.setText("");
						btnPet2Selection.setBackground(Color.RED);
						btnPet2Selection.setText("Pet not selected");
						btnSetPet2.setText("Set Pet 2");
						set2BtnStatus = false;
						pet2BtnStatus = false;
					}
					else{
						//checks if same pets has been selected
						if (chosenSpeciesArray.contains(choosenSpecies)){
							alertPetSelected();
							pet2NameTextField.setEnabled(false);
							pet2NameTextField.setText("");
							btnPet2Selection.setBackground(Color.RED);
							btnPet2Selection.setText("Pet not selected");
							pet2BtnStatus = false;
							
						}
						else{
							chosenSpeciesArray.add(choosenSpecies);
							btnPet2Selection.setBackground(Color.GREEN);
							btnPet2Selection.setText(petSpeciesName[chosenSpeciesArray.get(1)] + " Selected!!");
							btnPet2Selection.setEnabled(false);
							btnSetPet2.setText("clear");
							set2BtnStatus = true;
						}
					}
				}
			}
		});
		btnSetPet2.setBounds(307, 275, 104, 27);
		frmPlayerSelections.getContentPane().add(btnSetPet2);
		//================================================================================================
		
		/**
		 * Create a pet 3 selector button for player. Activate pet 3 name text field if pet 3 is selected. Executes a pop up for selecting desired pet. Executes a pop up alert if pet 1 & pet 2 not selected or deselected.
		 */
		JLabel lblPet3 = new JLabel("Pet 3");
		lblPet3.setBounds(49, 346, 79, 21);
		frmPlayerSelections.getContentPane().add(lblPet3);
		
		JButton btnPet3Selection = new JButton("Pet not selected");
		btnPet3Selection.setBounds(97, 342, 187, 28);
		frmPlayerSelections.getContentPane().add(btnPet3Selection);
		btnPet3Selection.setBackground(Color.RED);
		btnPet3Selection.setEnabled(true);
		
		btnPet3Selection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pet1BtnStatus == false || pet2BtnStatus == false ){
					alertFollowOrder("select", "pet 1 & pet 2");
				}
				else if(pet1BtnStatus == true && pet2BtnStatus == true ){
					if (pet3BtnStatus == false){
						btnPet3Selection.setBackground(Color.YELLOW);
						pet3BtnStatus = true;
						pet3NameTextField.setEnabled(true);
						petChoise();
						btnPet3Selection.setText("Please Click Set Pet 3");
					
					}
				}				
			}
		});
		//================================================================================================
		
		/**
		 * create a set button to set pet 3
		 */
		JButton btnSetPet3 = new JButton("Set Pet 3");
		btnSetPet3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pet3BtnStatus == false){
					alertPetNotSelected();
				}
				else{//set select pet button and pet1 name text field to default state
					if(set3BtnStatus == true){
						chosenSpeciesArray.remove(2);
						btnPet3Selection.setEnabled(true);
						pet3NameTextField.setEnabled(false);
						pet3NameTextField.setText("");
						btnPet3Selection.setBackground(Color.RED);
						btnPet3Selection.setText("Pet not selected");
						btnSetPet3.setText("Set Pet 3");
						set3BtnStatus = false;
						pet3BtnStatus = false;
					}
					else{
						//checks if same pets has been selected
						if (chosenSpeciesArray.contains(choosenSpecies)){
							alertPetSelected();
							pet3NameTextField.setEnabled(false);
							pet3NameTextField.setText("");
							btnPet3Selection.setBackground(Color.RED);
							btnPet3Selection.setText("Pet not selected");
							pet3BtnStatus = false;
							
						}
						else{
							chosenSpeciesArray.add(choosenSpecies);
							btnPet3Selection.setBackground(Color.GREEN);
							btnPet3Selection.setText(petSpeciesName[chosenSpeciesArray.get(2)] + " Selected!!");
							btnPet3Selection.setEnabled(false);
							btnSetPet3.setText("clear");
							set3BtnStatus = true;
						}
					}
				}
			}
		});
		btnSetPet3.setBounds(307, 342, 104, 27);
		frmPlayerSelections.getContentPane().add(btnSetPet3);
		//================================================================================================
		
		/**
		 *  Create a seperator to seperate pet selection and pet input name
		 */
		JSeparator player1Separator = new JSeparator();
		player1Separator.setBackground(Color.BLACK);
		player1Separator.setForeground(Color.BLACK);
		player1Separator.setOrientation(SwingConstants.VERTICAL);
		player1Separator.setBounds(424, 217, 10, 153);
		frmPlayerSelections.getContentPane().add(player1Separator);
		//================================================================================================
		
		/**
		 * Create a help button that will pop up a text message containing instructions and explanations.
		 */
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(383, 409, 89, 23);
		frmPlayerSelections.getContentPane().add(btnHelp);
		
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTextArea msg = new JTextArea(
						"\n"
						+ "- You can only enter pet name when the corresponding pet is selected.\n"
						+ "\n"
						+ "- Activation of the pet selection button for Pet 2 and Pet 3 depends on number of pets selected, Pet 1 selection button is activated by default. \n"
						+ "\n"
						+ "- Every Players and Pets must have different names \n"
						+ "\n"
						+ "- Player must enter player name and corresponding pet name\n"
						+ "\n"
						+ "- When the pet selection button is activated, player must click Set Button\n"
						+ "\n"
						+ "- Click Next for next steps.");
				msg.setLineWrap(true);
				msg.setWrapStyleWord(true);
				msg.setSize(120, 45);
				msg.setEditable(false);

				JScrollPane scrollPane = new JScrollPane(msg);
				JOptionPane.showMessageDialog(null, scrollPane);
			}
		});
		
		//================================================================================================	
		
		/**
		 * Creates "Next" Button. Changes to next player Selection JPanel when clicked.
		 */
		JButton btnNext = new JButton("Next >");
		btnNext.setBounds(506, 409, 89, 23);
		frmPlayerSelections.getContentPane().add(btnNext);
		
		JButton btnCheckName = new JButton("Check Name");
		btnCheckName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playersName.contains(playerNameTextField.getText()) || playerNameTextField.getText().length() == 0){
					alertPlayerName();
				}
				else{
					playersName.add(playerNameTextField.getText());
					btnCheckName.setText("ok!");
					btnCheckName.setBackground(Color.GREEN);
					btnCheckNameStatus = true;
					playerNameTextField.setEnabled(false);
					btnCheckName.setEnabled(false);
				}
			}
		});
		btnCheckName.setBounds(630, 112, 133, 25);
		frmPlayerSelections.getContentPane().add(btnCheckName);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/////////////////////////////////input validation////////////////////////////
				if (playerNameTextField.getText().length() == 0){
					alertMissingField();
				}
				else if(pet1NameTextField.isEnabled() == true && pet1NameTextField.getText().length() == 0){
					//if player did not enter pet 1 name even though pet 1 has been selected
					alertMissingField();
				}
				else if(pet2NameTextField.isEnabled() == true && pet2NameTextField.getText().length() == 0){
					//if player did not enter pet 2 name even though pet 2 has been selected
					alertMissingField();
				}
				else if(pet3NameTextField.isEnabled() == true && pet3NameTextField.getText().length() == 0){
					//if player did not enter pet 3 name even though pet 3 has been selected
					alertMissingField();
				}
				else if (btnCheckNameStatus == false || set1BtnStatus == false){
					alertButton();
				}
				/////////////////////////////////end of validation////////////////////////////
				else{
					if (newPlayerSelectionsCounter == game.getNumPlayer() - 1){ //if this is the last player
						//stores pet name
						petNameArray.add(pet1NameTextField.getText());
						if (pet2NameTextField.isEnabled()){
							petNameArray.add(pet2NameTextField.getText());
						}
						if (pet3NameTextField.isEnabled()){
							petNameArray.add(pet3NameTextField.getText());
						}
//						for (String petName: petNameArray){
//							if (petNameArray.contains(petName)){ //checks if there are same pet names
//								proceed = false;
//								}
//							}
//						if(proceed == false){
//							alertPetName();
//						}
//						if(proceed){
							//create player object and store player names. pets selected and pet names.
							Player player = new Player();
							player.setName(playerNameTextField.getText());
							
							//create pet object and store in player's pet array.
							for(int loop = 0; loop < chosenSpeciesArray.size(); loop ++){
								int tempPetChoise = chosenSpeciesArray.get(loop);
								String tempPetName = petNameArray.get(loop);
								
								if (tempPetChoise == 1){
									player.addPet(new Turtle(tempPetName));
								}
								else if (tempPetChoise == 2){
									player.addPet(new KiwiBird(tempPetName));
								} 
								else if (tempPetChoise == 3){
									player.addPet(new Wolf(tempPetName));
								}
								else if (tempPetChoise == 4){
									player.addPet(new Panda(tempPetName));
									//System.out.println("panda made");
								}
								else if (tempPetChoise == 5){
									player.addPet(new Hawk(tempPetName));
								}
								else if (tempPetChoise == 6){
									player.addPet(new Whale(tempPetName));
								}
						}
						//store player in player arrays
						game.addPlayer(player);

						//Starts game!
						gameStartNotify();
						frmPlayerSelections.setVisible(false);
						new GameConsole(game).getFrmTamagotchiGameConsole().setVisible(true);
//						}
						}
						
						else { // if there is still next player
							//stores pet name
							petNameArray.add(pet1NameTextField.getText());
							if (pet2NameTextField.isEnabled()){
								petNameArray.add(pet2NameTextField.getText());
							}
							if (pet3NameTextField.isEnabled()){
								petNameArray.add(pet3NameTextField.getText());
							}
//							for (String petName: petNameArray){
//								if (petNameArray.contains(petName)){ //checks if there are same pet names
//									proceed = false;
//									alertPetName();
//									}
//								}
//							if(proceed == false){
//								alertPetName();
//							}
//							if(proceed){
								//create player object and store player names. pets selected and pet names.
								Player player = new Player();
								player.setName(playerNameTextField.getText());
								
								//create pet object and store in player's pet array.
								for(int loop = 0; loop < chosenSpeciesArray.size(); loop ++){
									int tempPetChoise = chosenSpeciesArray.get(loop);
									String tempPetName = petNameArray.get(loop);
									
									if (tempPetChoise == 1){
										player.addPet(new Turtle(tempPetName));
									}
									else if (tempPetChoise == 2){
										player.addPet(new KiwiBird(tempPetName));
									} 
									else if (tempPetChoise == 3){
										player.addPet(new Wolf(tempPetName));
									}
									else if (tempPetChoise == 4){
										player.addPet(new Panda(tempPetName));
									}
									else if (tempPetChoise == 5){
										player.addPet(new Hawk(tempPetName));
									}
									else if (tempPetChoise == 6){
										player.addPet(new Whale(tempPetName));
									}
								}
								//store player in player arrays
								game.addPlayer(player);
								
								//Move on to next player selections
								newPlayerSelectionsCounter += 1;
								frmPlayerSelections.setVisible(false);
								pet1BtnStatus = false;
								pet2BtnStatus = false;
								pet3BtnStatus = false;
								chosenSpeciesArray.clear();
								new PlayerSelections(game).getFrmPlayerSelections().setVisible(true);
							//}
						}
				}
			}

		});
		//================================================================================================

	}
	
	/**
	 * Creates a new window for selecting pets.
	 */
	private void petChoise(){
		PetSelections petSelections = new PetSelections();
		petSelections.getFrmPetSelections().setVisible(true);
	}
	
	/**
	 * Creates a pop up to alert user to follow order when choosing pets (choose pet 1 first, followed by pet 2, then pet 3).
	 */
	private void alertFollowOrder(String message, String petNum){
		JOptionPane.showMessageDialog(frmPlayerSelections,
		    "Please " + message + " " + petNum + " first!",
		    "Alert!",
		    JOptionPane.ERROR_MESSAGE);
	}
	
	private void alertPlayerName(){
		JOptionPane.showMessageDialog(frmPlayerSelections,
		    "Please re-enter a different player name",
		    "Alert!",
		    JOptionPane.ERROR_MESSAGE);
	}
	
	private void alertPetName(){
		JOptionPane.showMessageDialog(frmPlayerSelections,
		    "Please re-enter a different pet name",
		    "Alert!",
		    JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * Notify players the game is starting.
	 */
	private void gameStartNotify(){
		JOptionPane.showMessageDialog(frmPlayerSelections,
		    "Game Starting!",
		    null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Alert player if player did not enter his/her name or did not name the selected pet
	 */
	private void alertMissingField() {
		JOptionPane.showMessageDialog(frmPlayerSelections,
			    "Missing player name and/or pet name!",
			    "Alert!",
			    JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * Alert player if player did not enter name or did not choose pet
	 */
	private void alertPetNotSelected() {
		JOptionPane.showMessageDialog(frmPlayerSelections,
			    "Pet not selected!",
			    "Alert!",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Alert player if player did not enter name or did not choose pet
	 */
	private void alertPetSelected() {
		JOptionPane.showMessageDialog(frmPlayerSelections,
			    "Pet already selected!",
			    "Alert!",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Alert player if player did not enter name or did not choose pet
	 */
	private void alertButton(){
		JOptionPane.showMessageDialog(frmPlayerSelections,
			    "Please make sure you have click check name and set any corresponding pets.",
			    "Alert!",
			    JOptionPane.ERROR_MESSAGE);
	}
	
}
