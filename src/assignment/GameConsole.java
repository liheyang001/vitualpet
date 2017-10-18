
package assignment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Aaron Bong & Heyang Li
 */

/**
 * The main game console to play with pet
 * Has Toy Shop tab to buy toys and Food Shop tab to buy foods.
 */
public class GameConsole {

	/**
	 * Initialise the frame
	 */
	private JFrame frmTamagotchiGameConsole;
	
	/**
	 * A getter for Frame
	 * @return the frame of PlayerSelections
	 */
	public JFrame getFrmTamagotchiGameConsole() {
		return frmTamagotchiGameConsole;
	}
	
	//to store game object from Player Selections
	private GameEnvi game;
	
	// initialise allnecessary variables for game console
	private int playerTurn = 0; //Start from player 1
	private int petTurn = 0; //Start from pet 1
	private int actions;
	private int currentDay = 1;
	private Player currentPlayer;
	private Pet currentPet;
	
	/**
	 *Initialise all buttons for buying different toys.
	 */
	private JButton btnNinjaTurtle;
	private JButton btnLego;
	private JButton btnPikachu;
	private JButton btnStarWars;
	private JButton btnToyCar;
	private JButton btnBarbieDoll;
	
	private ArrayList<Integer> chosenToysArray = new ArrayList<>(); //temporary stores chosen Toys from toy shop.
	private int totalToyPrice = 0;
	private Integer[] ToysDurabilityList = {100, 100, 80, 100, 85, 90}; //durability of each toy {lego, barbie doll, ninja turtle, star wars, pikachu, toy car}.
	private Integer[] ToyPrices = {65, 50, 28, 73, 39, 45}; //prices of each toy {lego, barbie doll, ninja turtle, star wars, pikachu, toy car}.
	
	/**
	 * make the following variables global for refresh() and realtimeStats()
	 */
	private JTextArea CurrentPlayerName = new JTextArea();
	private JTextArea CurrentPetName = new JTextArea();
	private JTextArea CurrentPetActionsRemain = new JTextArea();
	private JTextArea CurrentDay = new JTextArea();
	private JTextArea CurrentPetInfo = new JTextArea();
	private JTextArea CurrentPlayerInfo = new JTextArea();
	private JButton btnNextPet = new JButton("Next Pet >>");
	private JButton btnPlay = new JButton("Play");
	private JButton btnFeed = new JButton("Feed");
	private JButton btnSleep = new JButton("Sleep");
	private JButton btnToilet = new JButton("Toilet");
	private JLabel lblCurrentPet = new JLabel("");
	JButton btnNextDay = new JButton("Next Day >");
	

//	/**
//	 * Launch the application.
//	 * @param args unused.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GameConsole window = new GameConsole();
//					window.frmTamagotchiGameConsole.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * getter for current player
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @return the currentPet
	 */
	public Pet getCurrentPet() {
		return currentPet;
	}

	/**
	 * Create the application.
	 */
	public GameConsole(GameEnvi game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTamagotchiGameConsole = new JFrame();
		frmTamagotchiGameConsole.setTitle("Tamagotchi Game Console");
		frmTamagotchiGameConsole.setBounds(100, 100, 1138, 570);
		frmTamagotchiGameConsole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTamagotchiGameConsole.getContentPane().setLayout(null);
		
		//Initialise currentPlayer,actions and CurrentPet
		currentPlayer = game.getPlayer(playerTurn);
		currentPet = currentPlayer.getPet(petTurn);
	
		actions = 2;

		/**
		 * Create tabbed pane for home, toyshop and foodshop.
		 */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 1134, 518);
		frmTamagotchiGameConsole.getContentPane().add(tabbedPane);
		
		JPanel home = new JPanel();
		home.setName("Home");
		tabbedPane.addTab("Home", null, home, null);
		home.setLayout(null);
		
		JPanel foodShopGUI = new JPanel();
		foodShopGUI.setName("Food Shop");
		tabbedPane.addTab("Food Shop", null, foodShopGUI, null);
		foodShopGUI.setLayout(null);
		
		JPanel toyShopGUI = new JPanel();
		toyShopGUI.setName("Toy Shop");
		tabbedPane.addTab("Toy Shop", null, toyShopGUI, null);
		toyShopGUI.setLayout(null);
		toyShopGUI.repaint();
		//================================================================================================
		
		/**
		 * Create a text area to view current pet status and characteristics.
		 * Has a scroll pane that activates automatically if text too large to view.
		 */
		
		CurrentPetInfo.setBounds(109, 214, 124, 107);
		CurrentPetInfo.setText("\n"
				+ "Current Pet Status\n\n"
				+ "* Health: " + currentPet.getPetHealth() + " %\n"
				+ "* Weight: " + currentPet.weight + " %\n"
				+ "* Stomach Fullness: " + currentPet.getPetFeed() +  " %\n"
				+ "* Hungryness: " + currentPet.getHungry() + " %\n"
				+ "* Tiredness: " + currentPet.getTired() + " %\n"
				+ "* Mood: " + currentPet.getPetMood() +  " %\n"
				+"\n"
				+ "Current Pet Characteristics\n\n"
				+ "* Species: " + currentPet.getAnimalsSpecies() + "\n"
				+ "* Favourite Toy: " + currentPet.getFavToy().getName() + "\n"
				+ "* Favourite Food: " + currentPet.getFavFood().getName() + "\n"
				+ "* Dislike Food: " + currentPet.getDislikeFood().getName() + "\n"
				+ "* Agressiveness: " + currentPet.getAggressiveness() + " %\n"
				);
		CurrentPetInfo.setEditable(false);
		JScrollPane ScrollPanePetInfo = new JScrollPane(CurrentPetInfo);
		ScrollPanePetInfo.setBounds(49, 94, 194, 341);
		home.add(ScrollPanePetInfo);
		//================================================================================================
		
		/**
		 * Create a text area to view current Money and Inventory.
		 * Has a scroll pane that activates automatically if text too large to view.
		 */
		CurrentPlayerInfo.setBounds(883, 182, 41, 81);
		CurrentPlayerInfo.setText("\n"
				+ "Money: " + currentPlayer.getMoney() + " NZD\n\n"
				+"Food Inventory\n\n"
				+ "* Bamboo: " + "0\n"
				+ "* Salmon: " + "0\n"
				+ "* Carrot: " + "0\n"
				+ "* Laksa: " + "0\n"
				+ "* Kebab: " + "0\n"
				+ "* Choc Cake: " + "0\n"
				+"\n"
				+"Toy Inventory\n\n"
				+ "* LEGO: " + "0 %\n"
				+ "* Barbie Doll: " + "0 %\n"
				+ "* Ninja Turtle: " + "0 %\n"
				+ "* Star Wars: " + "0 %\n"
				+ "* Pikachu: " + "0 %\n"
				+ "* Toy Car: " + "0 %\n"
				);
		CurrentPlayerInfo.setEditable(false);
		JScrollPane ScrollPanePlayerInfo = new JScrollPane(CurrentPlayerInfo);
		ScrollPanePlayerInfo.setBounds(878, 94, 194, 341);
		home.add(ScrollPanePlayerInfo);
		//================================================================================================
		
		/**
		 * Create a text area to view current Player Name.
		 * Has a scroll pane that activates automatically if text too large to view.
		 */
		CurrentPlayerName.setBounds(109, 214, 124, 107);
		CurrentPlayerName.setText(" Hello: " + currentPlayer.getName()
		);
		CurrentPlayerName.setEditable(false);
		JScrollPane ScrollPanePlayerName = new JScrollPane(CurrentPlayerName);
		ScrollPanePlayerName.setBounds(49, 25, 254, 25);
		home.add(ScrollPanePlayerName);
		//================================================================================================
		
		/**
		 * Create a text area to view current Pet Name.
		 * Has a scroll pane that activates automatically if text too large to view.
		 */
		CurrentPetName.setBounds(109, 214, 124, 107);
		CurrentPetName.setText(" Pet Name: " + currentPet.getPetName()
				);
		CurrentPetName.setEditable(false);
		JScrollPane ScrollPanePetName = new JScrollPane(CurrentPetName);
		ScrollPanePetName.setBounds(401, 25, 254, 25);
		home.add(ScrollPanePetName);
		//================================================================================================
		
		/**
		 * Create a text area to view Current Pet actions remaining.
		 * Has a scroll pane that activates automatically if text too large to view.
		 */
		CurrentPetActionsRemain.setBounds(109, 214, 124, 107);
		CurrentPetActionsRemain.setText(" Pet Actions Left: " + actions
				);
		CurrentPetActionsRemain.setEditable(false);
		JScrollPane ScrollPanePetActionsRemain = new JScrollPane(CurrentPetActionsRemain);
		ScrollPanePetActionsRemain.setBounds(728, 25, 142, 25);
		home.add(ScrollPanePetActionsRemain);
		//================================================================================================
		
		/**
		 * Create a text area to view Current Day.
		 * Has a scroll pane that activates automatically if text too large to view.
		 */
		CurrentDay.setBounds(109, 214, 124, 107);
		CurrentDay.setText(" Day: " + currentDay
				);
		CurrentDay.setEditable(false);
		JScrollPane ScrollPaneDay= new JScrollPane(CurrentDay);
		ScrollPaneDay.setBounds(930, 25, 142, 25);
		home.add(ScrollPaneDay);
		//================================================================================================
		
		/**
		 * Creates a label that shows image of current pet or image of random events.
		 */
		lblCurrentPet.setBounds(486, 158, 150, 150);
		home.add(lblCurrentPet);
		lblCurrentPet.setIcon(currentPet.getPetPic());
		//================================================================================================
		
		/**
		 * Create a play button
		 * execute play function and execute Toy Inventory window when pressed.
		 */
		btnPlay.setBounds(289, 158, 117, 25);
		home.add(btnPlay);
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentPlayer.getToys().size()<= 0){
					alertNoItem("toy");
				}
				else{
					actions -= 1;
					int actionsDisplay = actions;
					if (actions <= 0){
						new ToySelections(GameConsole.this).getFrmToySelections().setVisible(true);
						frmTamagotchiGameConsole.setVisible(false);
						actionsDisplay = 0;
						CurrentPetActionsRemain.setText(" Pet Actions Left: " + actionsDisplay);
						notifyNextPet();
						btnNextPet.setEnabled(true);
						random_event(currentPlayer, currentPet);
						disable();
					}
					else{
						new ToySelections(GameConsole.this).getFrmToySelections().setVisible(true);
						frmTamagotchiGameConsole.setVisible(false);
						CurrentPetActionsRemain.setText(" Pet Actions Left: " + actionsDisplay);
					}
				}
			}
		});
		//================================================================================================
		
		/**
		 * Create a feed button
		 * execute feed function and execute Food Inventory window when pressed.
		 */
		btnFeed.setBounds(289, 246, 117, 25);
		home.add(btnFeed);
		
		btnFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bamboo b = new Bamboo();
				Salmon s = new Salmon();
				Carrot c = new Carrot();
				Laksa l = new Laksa();
				Kebab k = new Kebab();
				Chocolatecake cc = new Chocolatecake();
				
				if(currentPlayer.hasFood(b) || currentPlayer.hasFood(s) || currentPlayer.hasFood(c) || currentPlayer.hasFood(l) || currentPlayer.hasFood(k) || currentPlayer.hasFood(cc)){
					actions -= 1;
					int actionsDisplay = actions;
					if (actions <= 0){
						new FoodSelections(GameConsole.this).getFrmFoodSelections().setVisible(true);
						frmTamagotchiGameConsole.setVisible(false);
						actionsDisplay = 0;
						CurrentPetActionsRemain.setText(" Pet Actions Left: " + actionsDisplay);
						notifyNextPet();
						btnNextPet.setEnabled(true);
						random_event(currentPlayer, currentPet);
						disable();
					}
					else{
						new FoodSelections(GameConsole.this).getFrmFoodSelections().setVisible(true);
						frmTamagotchiGameConsole.setVisible(false);
						CurrentPetActionsRemain.setText(" Pet Actions Left: " + actionsDisplay);
					}
				}
				else{
					alertNoItem("food");
				}
			}
		});
		//================================================================================================
		
		/**
		 * Create a sleep button
		 * execute sleep function when pressed.
		 */
		btnSleep.setBounds(716, 158, 117, 25);
		home.add(btnSleep);
		
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPet.sleep(); //execute sleep
				realtimePetStats();
				
				actions -= 1;
				int actionsDisplay = actions;
				if (actions <= 0){
					actionsDisplay = 0;
					CurrentPetActionsRemain.setText(" Pet Actions Left: " + actionsDisplay);
					notifyNextPet();
					btnNextPet.setEnabled(true);
					random_event(currentPlayer, currentPet);
					disable();
				}
				else{
					CurrentPetActionsRemain.setText(" Pet Actions Left: " + actionsDisplay);
				}
			}
		});
		//================================================================================================
		
		/**
		 * Create a toilet button
		 * execute toilet function when pressed.
		 */
		btnToilet.setBounds(716, 246, 117, 25);
		home.add(btnToilet);
		
		btnToilet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPet.toilet(); //execute go to toilet
				realtimePetStats();
				
				actions -= 1;
				int actionsDisplay = actions;
				if (actions <= 0){
					actionsDisplay = 0;
					CurrentPetActionsRemain.setText(" Pet Actions Left: " + actionsDisplay);
					notifyNextPet();
					btnNextPet.setEnabled(true);
					random_event(currentPlayer, currentPet);
					disable();
				}
				else{
					CurrentPetActionsRemain.setText(" Pet Actions Left: " + actionsDisplay);
				}
			}
		});
		//================================================================================================
		
		/**
		 * Create a Help button.
		 * execute help message when pressed.
		 */
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(414, 354, 117, 25);
		home.add(btnHelp);
		
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea msg = new JTextArea(
						  "How it works:\n"
						+ "The game starts with the first player's first pet. Then, if its the last pet, it moves to the second player\n"
						+ "Then, if its the last player, it moves to the next day. Then, if its the last day, the game ends and each player's score is displayed.\n"
						+ "There will be some random events so be careful!\n"
						+ "The score is calculated by averaging the all the indivudual player's pets Stats and player's money.\n\n"
						+ "- Click Next Pet to jump to next pet. Please note you will not be able to go to previous pet.\n\n"
						+ "- Click Next Day to jump to next day. Please note you will not be able to go to previous day.\n\n"
						+ "- Click Play to play with pet. pops up a window to select bought toys\n\n"
						+ "- Click feed to feed pet. pops up a window to select bought foods\n\n"
						+ "- Click Sleep to let the pet go to sleep\n\n"
						+ "- Click Toilet to let the pet go to Toilet"
						+ "- Click Food Shop to buy Foods\n\n"
						+ "- Click Toy Shop to buy Toys"
						);
				msg.setLineWrap(true);
				msg.setWrapStyleWord(true);
				msg.setSize(90, 45);
				msg.setEditable(false);

				JScrollPane scrollPane = new JScrollPane(msg);
				JOptionPane.showMessageDialog(null, scrollPane);
			}
		});
		//================================================================================================
		
		/**
		 * Create a Next Day button.
		 * jump to next day when pressed.
		 */
		btnNextDay.setBounds(598, 354, 117, 25);
		home.add(btnNextDay);
		if (game.getDayCounter() == 1){
			btnNextDay.setEnabled(false);
		}
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPet.checker();
				nextDay();
			}
		});
		//================================================================================================
		
		/**
		 * Create a Next pet button.
		 * jump to next pet when pressed.
		 */

		btnNextPet.setEnabled(true);
		btnNextPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refresh();
				//reset buttons to default status
				currentPet.checker();
				if (currentPet.petHealth != -1){
				btnPlay.setEnabled(true);
				btnFeed.setEnabled(true);
				btnSleep.setEnabled(true);
				btnToilet.setEnabled(true);
				btnNextPet.setEnabled(true);
				btnNextDay.setEnabled(true);
				}
				if (currentPet.petHealth == -1){
					disable(); // disable all action buttons
					CurrentPetActionsRemain.setText(" Pet Actions Left: 0");
					//ImageIcon deadIcon = new ImageIcon(GameConsole.class.getResource("/random_pics/dead.png"));
					//lblCurrentPet.setIcon(deadIcon);
					
					//display next pet's stats
					petStatusPrint();
				}
			}
		});
		btnNextPet.setBounds(486, 90, 150, 25);
		home.add(btnNextPet);
		//================================================================================================

		/**
		 * Imports a picture of bamboo and create a label to show all its attributes.
		 */
		JLabel lblBambooPicture = new JLabel("");
		lblBambooPicture.setBounds(38, 11, 150, 150);
		foodShopGUI.add(lblBambooPicture);
		ImageIcon bambooIcon = new ImageIcon(GameConsole.class.getResource("/food_pics/bamboo.png"));
		lblBambooPicture.setIcon(bambooIcon);
		
		JLabel lblBambooAttributes = new JLabel("<html>"
				+ "* Bamboo<br> "
				+ "* Price: 10 NZD<br>"
				+ "* Nutrition: 20 %</html>");
		lblBambooAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblBambooAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblBambooAttributes.setBounds(38, 164, 150, 60);
		foodShopGUI.add(lblBambooAttributes);
		//================================================================================================
		
		/**
		 * Create slider player to select bamboo quantity to buy.
		 */
		JSlider bambooQuantity = new JSlider();
		bambooQuantity.setMinimum(0);
		bambooQuantity.setMaximum(20);
		bambooQuantity.setValue(0);
		bambooQuantity.setBounds(198, 71, 125, 28);
		foodShopGUI.add(bambooQuantity);
		
		JLabel bambooQuantityCounter = new JLabel("0");
		bambooQuantityCounter.setBounds(333, 71, 20, 28);
		foodShopGUI.add(bambooQuantityCounter);
		
		bambooQuantity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedNum = bambooQuantity.getValue();
				//numPlayers = selectedNum;
				bambooQuantityCounter.setText(Integer.toString(selectedNum));
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of salmon and create a label to show all its attributes.
		 */
		JLabel lblSalmonPicture = new JLabel("");
		lblSalmonPicture.setBounds(401, 11, 150, 150);
		foodShopGUI.add(lblSalmonPicture);
		ImageIcon salmonIcon = new ImageIcon(GameConsole.class.getResource("/food_pics/salmon.png"));
		lblSalmonPicture.setIcon(salmonIcon);
		
		JLabel lblSalmonAttributes = new JLabel("<html>"
				+ "* Salmon<br> "
				+ "* Price: 15 NZD<br>"
				+ "* Nutrition: 25 %</html>");
		lblSalmonAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblSalmonAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblSalmonAttributes.setBounds(401, 164, 150, 60);
		foodShopGUI.add(lblSalmonAttributes);
		//================================================================================================
		
		/**
		 * Create slider player to select salmon quantity to buy.
		 */
		JSlider salmonQuantity = new JSlider();
		salmonQuantity.setMinimum(0);
		salmonQuantity.setMaximum(20);
		salmonQuantity.setValue(0);
		salmonQuantity.setBounds(561, 71, 125, 28);
		foodShopGUI.add(salmonQuantity);
		
		JLabel salmonQuantityCounter = new JLabel("0");
		salmonQuantityCounter.setBounds(698, 71, 20, 28);
		foodShopGUI.add(salmonQuantityCounter);
		
		salmonQuantity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedNum = salmonQuantity.getValue();
				//numPlayers = selectedNum;
				salmonQuantityCounter.setText(Integer.toString(selectedNum));
			}
		});
		//================================================================================================
		/**
		 * Imports a picture of carrot and create a label to show all its attributes.
		 */
		JLabel lblCarrotPicture = new JLabel("");
		lblCarrotPicture.setBounds(753, 11, 150, 150);
		foodShopGUI.add(lblCarrotPicture);
		
		ImageIcon carrotIcon = new ImageIcon(GameConsole.class.getResource("/food_pics/carrot.png"));
		lblCarrotPicture.setIcon(carrotIcon);
		
		JLabel lblCarrotAttributes = new JLabel("<html>"
				+ "* Carrot<br> "
				+ "* Price: 8 NZD<br>"
				+ "* Nutrition: 10 %</html>");
		lblCarrotAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblCarrotAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblCarrotAttributes.setBounds(753, 164, 150, 60);
		foodShopGUI.add(lblCarrotAttributes);
		//================================================================================================
		
		/**
		 * Create slider player to select carrot quantity to buy.
		 */
		JSlider carrotQuantity = new JSlider();
		carrotQuantity.setMinimum(0);
		carrotQuantity.setMaximum(20);
		carrotQuantity.setValue(0);
		carrotQuantity.setBounds(919, 71, 125, 28);
		foodShopGUI.add(carrotQuantity);
		
		JLabel carrotQuantityCounter = new JLabel("0");
		carrotQuantityCounter.setBounds(1054, 71, 20, 28);
		foodShopGUI.add(carrotQuantityCounter);
		
		carrotQuantity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedNum = carrotQuantity.getValue();
				//numPlayers = selectedNum;
				carrotQuantityCounter.setText(Integer.toString(selectedNum));
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of laksa and create a label to show all its attributes.
		 */
		JLabel lblLaksaPicture = new JLabel("");
		lblLaksaPicture.setBounds(38, 242, 150, 150);
		foodShopGUI.add(lblLaksaPicture);
		
		ImageIcon laksaIcon = new ImageIcon(GameConsole.class.getResource("/food_pics/laksa.png"));
		lblLaksaPicture.setIcon(laksaIcon);
		
		JLabel lblLaksaAttributes = new JLabel("<html>"
				+ "* Laksa<br> "
				+ "* Price: 11 NZD<br>"
				+ "* Nutrition: 12 %</html>");
		lblLaksaAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblLaksaAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblLaksaAttributes.setBounds(38, 396, 150, 60);
		foodShopGUI.add(lblLaksaAttributes);
		//================================================================================================
		
		/**
		 * Create slider player to select laksa quantity to buy.
		 */
		JSlider laksaQuantity = new JSlider();
		laksaQuantity.setMinimum(0);
		laksaQuantity.setMaximum(20);
		laksaQuantity.setValue(0);
		laksaQuantity.setBounds(198, 308, 125, 28);
		foodShopGUI.add(laksaQuantity);
		
		JLabel laksaQuantityCounter = new JLabel("0");
		laksaQuantityCounter.setBounds(333, 308, 20, 28);
		foodShopGUI.add(laksaQuantityCounter);
		
		laksaQuantity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedNum = laksaQuantity.getValue();
				//numPlayers = selectedNum;
				laksaQuantityCounter.setText(Integer.toString(selectedNum));
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of kebab and create a label to show all its attributes.
		 */
		JLabel lblKebabPicture = new JLabel("");
		lblKebabPicture.setBounds(401, 242, 150, 150);
		foodShopGUI.add(lblKebabPicture);
		
		ImageIcon kebabIcon = new ImageIcon(GameConsole.class.getResource("/food_pics/Kebab.png"));
		lblKebabPicture.setIcon(kebabIcon);
		
		JLabel lblKebabAttributes = new JLabel("<html>"
				+ "* Kebab<br> "
				+ "* Price: 13 NZD<br>"
				+ "* Nutrition: 8 %</html>");
		lblKebabAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblKebabAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblKebabAttributes.setBounds(401, 396, 150, 60);
		foodShopGUI.add(lblKebabAttributes);
		//================================================================================================
		
		/**
		 * Create slider player to select kebab quantity to buy.
		 */
		JSlider kebabQuantity = new JSlider();
		kebabQuantity.setMinimum(0);
		kebabQuantity.setMaximum(20);
		kebabQuantity.setValue(0);
		kebabQuantity.setBounds(561, 308, 125, 28);
		foodShopGUI.add(kebabQuantity);
		
		JLabel kebabQuantityCounter = new JLabel("0");
		kebabQuantityCounter.setBounds(698, 308, 20, 28);
		foodShopGUI.add(kebabQuantityCounter);
		
		kebabQuantity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedNum = kebabQuantity.getValue();
				//numPlayers = selectedNum;
				kebabQuantityCounter.setText(Integer.toString(selectedNum));
			}
		});
		//================================================================================================
		/**
		 * Imports a picture of chocolate cake and create a label to show all its attributes.
		 */
		JLabel lblChocCakePicture = new JLabel("");
		lblChocCakePicture.setBounds(753, 242, 150, 150);
		foodShopGUI.add(lblChocCakePicture);
		
		ImageIcon chocCakeIcon = new ImageIcon(GameConsole.class.getResource("/food_pics/chocolate_cake.png"));
		lblChocCakePicture.setIcon(chocCakeIcon);
		
		JLabel lblChocCakeAttributes = new JLabel("<html>"
				+ "* Chocolate Cake<br> "
				+ "* Price: 17 NZD<br>"
				+ "* Nutrition: 9 %</html>");
		lblChocCakeAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblChocCakeAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblChocCakeAttributes.setBounds(753, 396, 150, 60);
		foodShopGUI.add(lblChocCakeAttributes);
		//================================================================================================
		
		/**
		 * Create slider player to select chocolate cake quantity to buy.
		 */
		JSlider chocCakeQuantity = new JSlider();
		chocCakeQuantity.setMinimum(0);
		chocCakeQuantity.setMaximum(20);
		chocCakeQuantity.setValue(0);
		chocCakeQuantity.setBounds(919, 308, 125, 28);
		foodShopGUI.add(chocCakeQuantity);
		
		JLabel chocCakeQuantityCounter = new JLabel("0");
		chocCakeQuantityCounter.setBounds(1054, 308, 20, 28);
		foodShopGUI.add(chocCakeQuantityCounter);
		
		chocCakeQuantity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedNum = chocCakeQuantity.getValue();
				//numPlayers = selectedNum;
				chocCakeQuantityCounter.setText(Integer.toString(selectedNum));
			}
		});
		//================================================================================================
		
		/**
		 * Create a OK button at the FoodShop tab to store data once player has completed purchase.
		 */
		JButton btnOkFoodShop = new JButton("OK");
		btnOkFoodShop.setBounds(955, 224, 89, 23);
		foodShopGUI.add(btnOkFoodShop);
		
		btnOkFoodShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bamboo b = new Bamboo();
				Salmon s = new Salmon();
				Carrot c = new Carrot();
				Laksa l = new Laksa();
				Kebab k = new Kebab();
				Chocolatecake cc = new Chocolatecake();
				
				int totalFoodPrice = bambooQuantity.getValue() * b.getPrice();
				totalFoodPrice += salmonQuantity.getValue() * s.getPrice();
				totalFoodPrice += carrotQuantity.getValue() * c.getPrice();
				totalFoodPrice += laksaQuantity.getValue() * l.getPrice();
				totalFoodPrice += kebabQuantity.getValue() * k.getPrice();
				totalFoodPrice += chocCakeQuantity.getValue() * cc.getPrice();
				
				if (currentPlayer.getMoney() < totalFoodPrice) {
					alertInsufficientMoney();
					totalFoodPrice = 0;
				}
				else {
					currentPlayer.spendMoney(totalFoodPrice);
					currentPlayer.addFood(b, bambooQuantity.getValue());
					currentPlayer.addFood(s, salmonQuantity.getValue());
					currentPlayer.addFood(c, carrotQuantity.getValue());
					currentPlayer.addFood(l, laksaQuantity.getValue());
					currentPlayer.addFood(k, kebabQuantity.getValue());
					currentPlayer.addFood(cc, chocCakeQuantity.getValue());
					realtimePlayerStats();
					purchaseSuccessfulNotify();
					totalFoodPrice = 0;
				}
				
				//Reset all elements ro default values
				bambooQuantity.setValue(0);
				bambooQuantityCounter.setText("0");
				salmonQuantity.setValue(0);
				salmonQuantityCounter.setText("0");
				carrotQuantity.setValue(0);
				carrotQuantityCounter.setText("0");
				laksaQuantity.setValue(0);
				laksaQuantityCounter.setText("0");
				kebabQuantity.setValue(0);
				kebabQuantityCounter.setText("0");
				chocCakeQuantity.setValue(0);
				chocCakeQuantityCounter.setText("0");
				
			}
		});
		//================================================================================================

		/**
		 * Imports a picture of Lego and creates a label to show all its attributes.
		 */
		JLabel lblLegoPicture = new JLabel("");
		lblLegoPicture.setBounds(24, 66, 150, 150);
		toyShopGUI.add(lblLegoPicture);
		ImageIcon toyIcon1 = new ImageIcon(GameConsole.class.getResource("/toy_pics/lego.png"));
		lblLegoPicture.setIcon(toyIcon1);
		
		JLabel lblLegoAttributes = new JLabel("<html>"
				+ "* LEGO<br> "
				+ "* Price: 65 NZD<br>"
				+ "* Durability: 100 %<br>"
				+ "* Happy Points: 10<br>"
				+ "</html>");
		lblLegoAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblLegoAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblLegoAttributes.setBounds(24, 227, 150, 70);
		toyShopGUI.add(lblLegoAttributes);
		//================================================================================================
		
		/**
		 * Create a checkbox for player to select lego.
		 */
		JCheckBox checkBoxLego = new JCheckBox("Buy");
		checkBoxLego.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxLego.setBounds(55, 306, 97, 23);
		toyShopGUI.add(checkBoxLego);
		
		checkBoxLego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxLego.isSelected()){
					chosenToysArray.add(1);
				}
				else if (checkBoxLego.isSelected() == false){
					int remove = chosenToysArray.indexOf(1);
					chosenToysArray.remove(remove);
				}
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Barbie Doll and create a label to show all its attributes.
		 */
		JLabel lblBarbieDollPicture = new JLabel("");
		lblBarbieDollPicture.setBounds(206, 66, 150, 150);
		toyShopGUI.add(lblBarbieDollPicture);
		ImageIcon toyIcon2 = new ImageIcon(GameConsole.class.getResource("/toy_pics/barbie_doll.png"));
		lblBarbieDollPicture.setIcon(toyIcon2);
		
		JLabel lblBarbieDollAttributes = new JLabel("<html>"
				+ "* Barbie Doll<br> "
				+ "* Price: 50 NZD<br>"
				+ "* Durability: 100 %<br>"
				+ "* Happy Points: 12<br>"
				+ "</html>");
		lblBarbieDollAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblBarbieDollAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblBarbieDollAttributes.setBounds(206, 227, 150, 70);
		toyShopGUI.add(lblBarbieDollAttributes);
		//================================================================================================
		
		/**
		 * Create a checkbox for player to select barbie doll.
		 */
		JCheckBox checkBoxBarbieDoll = new JCheckBox("Buy");
		checkBoxBarbieDoll.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxBarbieDoll.setBounds(235, 306, 97, 23);
		toyShopGUI.add(checkBoxBarbieDoll);
		
		checkBoxBarbieDoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxBarbieDoll.isSelected()){
					chosenToysArray.add(2);
				}
				else if (checkBoxBarbieDoll.isSelected() == false){
					int remove = chosenToysArray.indexOf(2);
					chosenToysArray.remove(remove);
				}
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Ninja Turtle and create a label to show all its attributes.
		 */
		JLabel lblNinjaTurtlePicture = new JLabel("");
		lblNinjaTurtlePicture.setBounds(398, 66, 150, 150);
		toyShopGUI.add(lblNinjaTurtlePicture);		
		ImageIcon toyIcon3 = new ImageIcon(GameConsole.class.getResource("/toy_pics/ninja_turtle.png"));
		lblNinjaTurtlePicture.setIcon(toyIcon3);
		
		JLabel lblNinjaTurtleAttributes = new JLabel("<html>"
				+ "* Ninja Turtle<br> "
				+ "* Price: 28 NZD<br>"
				+ "* Durability: 80 %<br>"
				+ "* Happy Points: 15<br>"
				+ "</html>");
		lblNinjaTurtleAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblNinjaTurtleAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNinjaTurtleAttributes.setBounds(398, 227, 150, 70);
		toyShopGUI.add(lblNinjaTurtleAttributes);
		//================================================================================================
		
		/**
		 * Create a checkbox for player to select ninja turtle.
		 */
		JCheckBox checkBoxNinjaTurtle = new JCheckBox("Buy");
		checkBoxNinjaTurtle.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxNinjaTurtle.setBounds(427, 306, 97, 23);
		toyShopGUI.add(checkBoxNinjaTurtle);
		
		checkBoxNinjaTurtle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxNinjaTurtle.isSelected()){
					chosenToysArray.add(3);
				}
				else if (checkBoxNinjaTurtle.isSelected() == false){
					int remove = chosenToysArray.indexOf(3);
					chosenToysArray.remove(remove);
				}
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Star Wars and create a label to show all its attributes.
		 */
		JLabel lblStarWarsPicture = new JLabel("");
		lblStarWarsPicture.setBounds(582, 66, 150, 150);
		toyShopGUI.add(lblStarWarsPicture);
		ImageIcon toyIcon4 = new ImageIcon(GameConsole.class.getResource("/toy_pics/star_wars.png"));
		lblStarWarsPicture.setIcon(toyIcon4);
		
		JLabel lblStarWarsAttributes = new JLabel("<html>"
				+ "* Star Wars<br> "
				+ "* Price: 73 NZD<br>"
				+ "* Durability: 100 %<br>"
				+ "* Happy Points: 20<br>"
				+ "</html>");
		lblStarWarsAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblStarWarsAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblStarWarsAttributes.setBounds(582, 227, 150, 70);
		toyShopGUI.add(lblStarWarsAttributes);
		//================================================================================================
		
		/**
		 * Create a checkbox for player to select star wars.
		 */
		JCheckBox checkBoxStarWars = new JCheckBox("Buy");
		checkBoxStarWars.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxStarWars.setBounds(611, 306, 97, 23);
		toyShopGUI.add(checkBoxStarWars);
		
		checkBoxStarWars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxStarWars.isSelected()){
					chosenToysArray.add(4);
				}
				else if (checkBoxStarWars.isSelected() == false){
					int remove = chosenToysArray.indexOf(4);
					chosenToysArray.remove(remove);
				}
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Pikachu  and create a label to show all its attributes.
		 */
		JLabel lblPikachuPicture = new JLabel("");
		lblPikachuPicture.setBounds(768, 66, 150, 150);
		toyShopGUI.add(lblPikachuPicture);
		ImageIcon toyIcon5 = new ImageIcon(GameConsole.class.getResource("/toy_pics/pikachu.png"));
		lblPikachuPicture.setIcon(toyIcon5);
		
		JLabel lblPikachuAttributes = new JLabel("<html>"
				+ "* Pikachu<br> "
				+ "* Price: 39 NZD<br>"
				+ "* Durability: 85 %<br>"
				+ "* Happy Points: 7<br>"
				+ "</html>");
		lblPikachuAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblPikachuAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblPikachuAttributes.setBounds(768, 227, 150, 70);
		toyShopGUI.add(lblPikachuAttributes);
		//================================================================================================
		
		/**
		 * Create a checkbox for player to select pikachu.
		 */
		JCheckBox checkBoxPikachu = new JCheckBox("Buy");
		checkBoxPikachu.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxPikachu.setBounds(802, 306, 97, 23);
		toyShopGUI.add(checkBoxPikachu);
		
		checkBoxPikachu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxPikachu.isSelected()){
					chosenToysArray.add(5);
				}
				else if (checkBoxPikachu.isSelected() == false){
					int remove = chosenToysArray.indexOf(5);
					chosenToysArray.remove(remove);
				}
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Toy Car and create a label to show all its attributes.
		 */
		JLabel lblToyCarPicture = new JLabel("");
		lblToyCarPicture.setBounds(942, 66, 150, 150);
		toyShopGUI.add(lblToyCarPicture);
		ImageIcon toyIcon6 = new ImageIcon(GameConsole.class.getResource("/toy_pics/toy_car.png"));

		lblToyCarPicture.setIcon(toyIcon6);
		
		JLabel lblToyCarAttributes = new JLabel("<html>"
				+ "* Toy Car<br> "
				+ "* Price: 45 NZD<br>"
				+ "* Durability: 90 %<br>"
				+ "* Happy Points: 11<br>"
				+ "</html>");
		lblToyCarAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblToyCarAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblToyCarAttributes.setBounds(942, 227, 150, 70);
		toyShopGUI.add(lblToyCarAttributes);
		//================================================================================================
		
		/**
		 * Create a checkbox for player to select toy car.
		 */
		JCheckBox checkBoxToyCar = new JCheckBox("Buy");
		checkBoxToyCar.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxToyCar.setBounds(975, 306, 97, 23);
		toyShopGUI.add(checkBoxToyCar);
		
		checkBoxToyCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxToyCar.isSelected()){
					chosenToysArray.add(6);
				}
				else if (checkBoxToyCar.isSelected() == false){
					int remove = chosenToysArray.indexOf(6);
					chosenToysArray.remove(remove);
				}
			}
		});
		//================================================================================================
		
		/**
		 * Create a OK button at the ToyShop tab to store data once player has completed purchase.
		 */
		JButton btnOkToyShop = new JButton("OK");
		btnOkToyShop.setBounds(521, 368, 89, 23);
		toyShopGUI.add(btnOkToyShop);
		
		btnOkToyShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for (int choosenToy: chosenToysArray){
					totalToyPrice += ToyPrices[choosenToy-1];
				}
				
				if (currentPlayer.getMoney() >= totalToyPrice){ //if enough money
					currentPlayer.spendMoney(totalToyPrice);
					for (int choosenToy: chosenToysArray){
						currentPlayer.addToy(ToyShop.makeNewToy(choosenToy - 1));
					}
					
					purchaseSuccessfulNotify();
					realtimePlayerStats();
					totalToyPrice = 0;
					chosenToysArray.clear();
					//Set all checkBox to default state
					checkBoxLego.setSelected(false);
					checkBoxBarbieDoll.setSelected(false);
					checkBoxNinjaTurtle.setSelected(false);
					checkBoxStarWars.setSelected(false);
					checkBoxPikachu.setSelected(false);
					checkBoxToyCar.setSelected(false);
				}
				else{
					alertInsufficientMoney();
					totalToyPrice = 0;
					chosenToysArray.clear();
					//Set all checkBox to default state
					checkBoxLego.setSelected(false);
					checkBoxBarbieDoll.setSelected(false);
					checkBoxNinjaTurtle.setSelected(false);
					checkBoxStarWars.setSelected(false);
					checkBoxPikachu.setSelected(false);
					checkBoxToyCar.setSelected(false);
				}
			}
		});
		//================================================================================================
	}
	
	/**
	 * alert player insufficient money
	 */
	private void alertInsufficientMoney(){
			JOptionPane.showMessageDialog(frmTamagotchiGameConsole,
				    "Not enough money!",
				    "Alert!",
				    JOptionPane.ERROR_MESSAGE);
		
	}
	
	/**
	 * Notify players they have succesfully made the purchase.
	 * shows remaining money
	 */
	private void purchaseSuccessfulNotify(){
		JOptionPane.showMessageDialog(getFrmTamagotchiGameConsole(),
		    "Purchase Successful! you have " + currentPlayer.getMoney()  +" NZD left.",
		    null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Notify players when their pet is sick (random event).
	 * @return decision (0 if yes, 1 if no)
	 */
	private int alertRandomPetSick(){
		Object[] options = {"Yes, please",
                "No, thanks"};
		int decision = JOptionPane.showOptionDialog(getFrmTamagotchiGameConsole(),
				"Your Pet is Sick! \n"
				+ "Would you like to heal it?\n"
				+ "* Cost: 80 NZD to increase pet health to 50%.",
				"WARNING",
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[1]);
		return decision;
	}
	
	/**
	 * Notify players when their pet is dead (random event).
	 * @return decision (0 if yes, 1 if no)
	 */
	private int alertRandomPetDied(){
		Object[] options = {"Yes, please",
                "No, thanks"};
		int decision = -5;
		if (currentPet.canRevive == true){
			decision = JOptionPane.showOptionDialog(getFrmTamagotchiGameConsole(),
					"Your Pet is Dead! \n"
					+ "Would you like to revive it?\n"
					+ "1 *  revive chance",
					"WARNING",
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE,
					null,
					options,
					options[1]);
			}
		else{
			JOptionPane.showMessageDialog(getFrmTamagotchiGameConsole(),
				    "Your Pet is Dead Forever",
				    "Alert!",
				    JOptionPane.ERROR_MESSAGE);
		}
		
		return decision;
	}
	
	/**
	 * Notify players when their pet is misbehaving (random event).
	 * @return decision (0 if yes, 1 if no)
	 */
	private int alertRandomPetMisbehaving(){
		Object[] options = {"Yes, please",
                "No, thanks"};
		int decision = JOptionPane.showOptionDialog(getFrmTamagotchiGameConsole(),
				"Your Pet is Misbehaving! \n"
				+ "Would you like to punish it?\n"
				+ "* Decreases mood",
				"WARNING",
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[1]);
		return decision;
	}
	
	/**
	 * Refresh current session to show next pet's picture and info.
	 */
	private void refresh(){
		petTurn += 1;
		actions = 2;

		
		if (petTurn == currentPlayer.getNumPets() && playerTurn == game.getPlayers().size()-1 && currentDay >= game.getDayCounter()){ //if its the last pet & last player & last day, end game and display score.
			new EndGame(game).getFrmEndGame().setVisible(true);
			frmTamagotchiGameConsole.setVisible(false);
			
		}
		
		else if(playerTurn == game.getPlayers().size()-1 && petTurn == currentPlayer.getNumPets()){ //if its the last pet and last player, go to next day
			notifyNextDay();
			currentDay += 1;
			petTurn = 0;
			playerTurn = 0;
			currentPlayer = game.getPlayer(playerTurn);
			currentPet = currentPlayer.getPet(petTurn);
			
			CurrentDay.setText(" Day: " + currentDay);
			
			
			lblCurrentPet.setIcon(currentPet.getPetPic()); //set next pet's image
			
			//display next player's stats.
			CurrentPlayerName.setText(" Hello: " + currentPlayer.getName());
			CurrentPlayerInfo.setText("\n"
					+ "Money: " + currentPlayer.getMoney() + " NZD\n\n"
					+"Food Inventory\n\n"
					+ "* Bamboo: " + currentPlayer.getFoodQuantity(new Bamboo()) + "\n"
					+ "* Salmon: " + currentPlayer.getFoodQuantity(new Salmon()) +  "\n"
					+ "* Carrot: " + currentPlayer.getFoodQuantity(new Carrot()) +  "\n"
					+ "* Laksa: " + currentPlayer.getFoodQuantity(new Laksa()) +  "\n"
					+ "* Kebab: " + currentPlayer.getFoodQuantity(new Kebab()) +  "\n"
					+ "* Choc Cake: " + currentPlayer.getFoodQuantity(new Chocolatecake()) +  "\n"
					+"\n"
					+"Toy Inventory\n\n"
					+ "* LEGO: "  + currentPlayer.getToyDurability(new Lego()) + " %\n"
					+ "* Barbie Doll: " + currentPlayer.getToyDurability(new BarbieDoll()) + " %\n"
					+ "* Ninja Turtle: " +  currentPlayer.getToyDurability(new NinjaTurtle()) + " %\n"
					+ "* Star Wars: " +  currentPlayer.getToyDurability(new StarWars()) + " %\n"
					+ "* Pikachu: " +  currentPlayer.getToyDurability(new Pikachu()) + " %\n"
					+ "* Toy Car: " +  currentPlayer.getToyDurability(new ToyCar()) + " %\n"
					);
			
			if(currentPet.petHealth == -1){
				disable(); // disable all action buttons
				CurrentPetActionsRemain.setText(" Pet Actions Left: 0");
				//ImageIcon deadIcon = new ImageIcon(GameConsole.class.getResource("/random_pics/dead.png"));
				//lblCurrentPet.setIcon(deadIcon);
				
				//display next pet's stats
				petStatusPrint();
				
			}
			else {
			//display next player's 1st pet's stats
				petStatusPrint();
			}
		}
		
		else if(petTurn == currentPlayer.getNumPets()){ //if its the last pet, go to next player
			if (currentDay >= game.getDayCounter() - 1){
				btnNextDay.setEnabled(false);
			}
			notifyNextPlayer();
			petTurn = 0; //next player's 1st pet
			playerTurn += 1;
			currentPlayer = game.getPlayer(playerTurn);
			currentPet = currentPlayer.getPet(petTurn);
			
			lblCurrentPet.setIcon(currentPet.getPetPic()); //set next pet's image
			
			//display next player's stats.
			CurrentPlayerName.setText(" Hello: " + currentPlayer.getName());
			CurrentPlayerInfo.setText("\n"
					+ "Money: " + currentPlayer.getMoney() + " NZD\n\n"
					+"Food Inventory\n\n"
					+ "* Bamboo: " + currentPlayer.getFoodQuantity(new Bamboo()) + "\n"
					+ "* Salmon: " + currentPlayer.getFoodQuantity(new Salmon()) +  "\n"
					+ "* Carrot: " + currentPlayer.getFoodQuantity(new Carrot()) +  "\n"
					+ "* Laksa: " + currentPlayer.getFoodQuantity(new Laksa()) +  "\n"
					+ "* Kebab: " + currentPlayer.getFoodQuantity(new Kebab()) +  "\n"
					+ "* Choc Cake: " + currentPlayer.getFoodQuantity(new Chocolatecake()) +  "\n"
					+"\n"
					+"Toy Inventory\n\n"
					+ "* LEGO: "  + currentPlayer.getToyDurability(new Lego()) + " %\n"
					+ "* Barbie Doll: " + currentPlayer.getToyDurability(new BarbieDoll()) + " %\n"
					+ "* Ninja Turtle: " +  currentPlayer.getToyDurability(new NinjaTurtle()) + " %\n"
					+ "* Star Wars: " +  currentPlayer.getToyDurability(new StarWars()) + " %\n"
					+ "* Pikachu: " +  currentPlayer.getToyDurability(new Pikachu()) + " %\n"
					+ "* Toy Car: " +  currentPlayer.getToyDurability(new ToyCar()) + " %\n"
					);
			
			if(currentPet.petHealth == -1){
				disable(); // disable all action buttons
				CurrentPetActionsRemain.setText(" Pet Actions Left: 0");
				//ImageIcon deadIcon = new ImageIcon(GameConsole.class.getResource("/random_pics/dead.png"));
			    //lblCurrentPet.setIcon(deadIcon);
				
				//display next pet's stats
				petStatusPrint();
				
			}
			else {
			
				//display next player's 1st pet's stats
				petStatusPrint();			
				}
		}
		

		
		else{
			if(currentPet.isDead()){
				disable(); // disable all action buttons
				CurrentPetActionsRemain.setText(" Pet Actions Left: 0");
				//ImageIcon deadIcon = new ImageIcon(GameConsole.class.getResource("/random_pics/dead.png"));
				//lblCurrentPet.setIcon(deadIcon);
				
				//display next pet's stats
				petStatusPrint();
				
			}
			else {
					currentPet = currentPlayer.getPet(petTurn); //next pet
					lblCurrentPet.setIcon(currentPet.getPetPic()); //set next pet's image
					
					//display next pet's stats
					petStatusPrint();
				}
		}
	}
	/**
	 * display updated pet stats after an action is performed
	 */
	public void realtimePetStats(){
		petStatusPrint();
	}
	
	/**
	 * display updated player stats.
	 */
	public void realtimePlayerStats(){
		//currentPlayer.hasToy(new Lego());
		
		CurrentPlayerInfo.setText("\n"
				+ "Money: " + currentPlayer.getMoney() + " NZD\n\n"
				+"Food Inventory\n\n"
				+ "* Bamboo: " + currentPlayer.getFoodQuantity(new Bamboo()) + "\n"
				+ "* Salmon: " + currentPlayer.getFoodQuantity(new Salmon()) +  "\n"
				+ "* Carrot: " + currentPlayer.getFoodQuantity(new Carrot()) +  "\n"
				+ "* Laksa: " + currentPlayer.getFoodQuantity(new Laksa()) +  "\n"
				+ "* Kebab: " + currentPlayer.getFoodQuantity(new Kebab()) +  "\n"
				+ "* Choc Cake: " + currentPlayer.getFoodQuantity(new Chocolatecake()) +  "\n"
				+"\n"
				+"Toy Inventory\n\n"
				+ "* LEGO: "  + currentPlayer.getToyDurability(new Lego()) + " %\n"
				+ "* Barbie Doll: " + currentPlayer.getToyDurability(new BarbieDoll()) + " %\n"
				+ "* Ninja Turtle: " +  currentPlayer.getToyDurability(new NinjaTurtle()) + " %\n"
				+ "* Star Wars: " +  currentPlayer.getToyDurability(new StarWars()) + " %\n"
				+ "* Pikachu: " +  currentPlayer.getToyDurability(new Pikachu()) + " %\n"
				+ "* Toy Car: " +  currentPlayer.getToyDurability(new ToyCar()) + " %\n"
				);
	}
	
	/**
	 * jumps to next day.
	 */
	private void nextDay() {
		if (currentDay >= game.getDayCounter() - 1){
			btnNextDay.setEnabled(false);
		}
		if(playerTurn == game.getPlayers().size()-1){ //if last player, reset player turn to 0
			notifyBtnNextDay();
			currentDay += 1;
			playerTurn = 0;
		}
		else{
			notifyBtnNextDay();
			playerTurn += 1;
		}
		if(game.getPlayers().size() != 1){
		notifyNextPlayer();
		}
		actions = 2;
		petTurn = 0; //next player's 1st pet
		currentPlayer = game.getPlayer(playerTurn);
		currentPet = currentPlayer.getPet(petTurn);
		
		//reset buttons to default status
		if (currentPet.petHealth != -1){
		btnPlay.setEnabled(true);
		btnFeed.setEnabled(true);
		btnSleep.setEnabled(true);
		btnToilet.setEnabled(true);
		//btnNextPet.setEnabled(true);
		}
		if (currentPet.petHealth == -1){
			disable(); // disable all action buttons
			CurrentPetActionsRemain.setText(" Pet Actions Left: 0");
			//ImageIcon deadIcon = new ImageIcon(GameConsole.class.getResource("/random_pics/dead.png"));
			//lblCurrentPet.setIcon(deadIcon);
			
			//display next pet's stats
			petStatusPrint();
		}
		
		CurrentDay.setText(" Day: " + currentDay);
		
		lblCurrentPet.setIcon(currentPet.getPetPic()); //set next pet's image
		
		//display next player's stats.
		CurrentPlayerName.setText(" Hello: " + currentPlayer.getName());
		CurrentPlayerInfo.setText("\n"
				+ "Money: " + currentPlayer.getMoney() + " NZD\n\n"
				+"Food Inventory\n\n"
				+ "* Bamboo: " + currentPlayer.getFoodQuantity(new Bamboo()) + "\n"
				+ "* Salmon: " + currentPlayer.getFoodQuantity(new Salmon()) +  "\n"
				+ "* Carrot: " + currentPlayer.getFoodQuantity(new Carrot()) +  "\n"
				+ "* Laksa: " + currentPlayer.getFoodQuantity(new Laksa()) +  "\n"
				+ "* Kebab: " + currentPlayer.getFoodQuantity(new Kebab()) +  "\n"
				+ "* Choc Cake: " + currentPlayer.getFoodQuantity(new Chocolatecake()) +  "\n"
				+"\n"
				+"Toy Inventory\n\n"
				+ "* LEGO: "  + currentPlayer.getToyDurability(new Lego()) + " %\n"
				+ "* Barbie Doll: " + currentPlayer.getToyDurability(new BarbieDoll()) + " %\n"
				+ "* Ninja Turtle: " +  currentPlayer.getToyDurability(new NinjaTurtle()) + " %\n"
				+ "* Star Wars: " +  currentPlayer.getToyDurability(new StarWars()) + " %\n"
				+ "* Pikachu: " +  currentPlayer.getToyDurability(new Pikachu()) + " %\n"
				+ "* Toy Car: " +  currentPlayer.getToyDurability(new ToyCar()) + " %\n"
				);
		
		//display next player's 1st pet's stats
		petStatusPrint();			
	}
	private void notifyNextPet(){
		JOptionPane.showMessageDialog(frmTamagotchiGameConsole,
			    "Actioned finished! Please review ur stats and press next pet",
			    "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void notifyNextPlayer(){
		JOptionPane.showMessageDialog(frmTamagotchiGameConsole,
			    "Next player!",
			    "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void notifyNextDay(){
		JOptionPane.showMessageDialog(frmTamagotchiGameConsole,
			    "Next day!",
			    "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void notifyBtnNextDay(){
		int nextDayy = currentDay + 1;
		JOptionPane.showMessageDialog(frmTamagotchiGameConsole,
				currentPlayer.getName() + " is now in Day " + nextDayy,
			    "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void alertNoItem(String msg){
		JOptionPane.showMessageDialog(frmTamagotchiGameConsole,
			    "No " + msg + " in inventory! Please buy some.",
			    "Alert!",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	
	
	public void random_event(Player player, Pet pet){
		int rnd = (int)(Math.random()*100+1); // random value is 1-100
		int rndLotty = (int)(Math.random()*200+1);
		if (rnd == 1 || rnd == 2){ //pet randomly dies
			int decisionDead = alertRandomPetDied();
			pet.petHealth = -1;
			pet.hungry = -1;
			pet.weight = -1;
			pet.tired = -1;
			pet.petMood = -1;
			pet.petFeed = -1;
			actions = 0;
					
			if (decisionDead == 0){
				pet.canRevive = false;
				pet.petHealth = 50;
				pet.hungry = 50;
				pet.weight = 50;
				pet.tired = 50;
				pet.petMood = 50;
				pet.petFeed = 50;
			}				
		}
		else if (rnd >= 3 & rnd <= 10){ //pet randomly gets sick
			pet.petHealth = 19;
			int decisionSick = alertRandomPetSick();
			if(decisionSick == 0){
				player.spendMoney(80);
				pet.petHealth = 50;
				realtimePetStats();
				realtimePlayerStats();
			}
			realtimePetStats();
		}
		else if (rnd >= 11 & rnd <= 20){ // pet randomly misbehave
			pet.setMisbehaving(true);
			int decisionMisbehave = alertRandomPetMisbehaving();
			if (decisionMisbehave == 0){
				pet.petMood -= 10;
				pet.setMisbehaving(false);
			}
			else{
				ImageIcon misbehaveIcon = new ImageIcon(GameConsole.class.getResource("/random_pics/misbehave.png"));
				lblCurrentPet.setIcon(misbehaveIcon);
			}
		}
		else if (rnd >= 95){
			player.spendMoney(-rndLotty);
			realtimePlayerStats();
			JOptionPane.showMessageDialog(frmTamagotchiGameConsole,
				    "Your pet has won a lotty!!!", 
				    "Info", JOptionPane.INFORMATION_MESSAGE);
		}

		
	}
	private void petStatusPrint(){
		CurrentPetName.setText(" Pet Name: " + currentPet.getPetName());
		CurrentPetActionsRemain.setText(" Pet Actions Left: " + actions);
		CurrentPetInfo.setText("\n"
				+ "Current Pet Status\n\n"
				+ "* Health: " + currentPet.getPetHealth() + " %\n"
				+ "* Weight: " + currentPet.weight + " %\n"
				+ "* Stomach Fullness: " + currentPet.getPetFeed() +  " %\n"
				+ "* Hungryness: " + currentPet.getHungry() + " %\n"
				+ "* Tiredness: " + currentPet.getTired() + " %\n"
				+ "* Mood: " + currentPet.getPetMood() +  " %\n"
				+"\n"
				+ "Current Pet Characteristics\n\n"
				+ "* Species: " + currentPet.getAnimalsSpecies() + "\n"
				+ "* Favourite Toy: " + currentPet.getFavToy().getName() + "\n"
				+ "* Favourite Food: " + currentPet.getFavFood().getName() + "\n"
				+ "* Dislike Food: " + currentPet.getDislikeFood().getName() + "\n"
				+ "* Agressiveness: " + currentPet.getAggressiveness() + " %\n"
				);	
	}
	/**
	 * disable uneccesary buttons.
	 */
	private void disable(){
		btnPlay.setEnabled(false);
		btnFeed.setEnabled(false);
		btnSleep.setEnabled(false);
		btnToilet.setEnabled(false);
		btnNextDay.setEnabled(false);
	}
	
	
}
