package assignment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Aaron Bong & Heyang Li
 *
 */

/**
 * 
 * Food Selections is to allow players to select the food which players already bought to feed the pet.
 *
 */
public class FoodSelections {
	
	private GameConsole gameConsole;
	
	/**
	 * Initialise the frame
	 */
	private JFrame frmFoodSelections;
	
	/**
	 * A getter for Frame
	 * @return the frame of Food Selections
	 */
	public JFrame getFrmFoodSelections() {
		return frmFoodSelections;
	}
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FoodSelections window = new FoodSelections();
//					window.frmFoodSelections.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public FoodSelections(GameConsole gameConsole) {
		this.gameConsole = gameConsole;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoodSelections = new JFrame();
		frmFoodSelections.setTitle("Food Inventory");
		frmFoodSelections.setBounds(100, 100, 1138, 547);
		frmFoodSelections.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmFoodSelections.getContentPane().setLayout(null);
		
		/**
		 * Create a title
		 */
		JLabel lblPleaseSelectToy = new JLabel("Please Select Food");
		lblPleaseSelectToy.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectToy.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPleaseSelectToy.setBounds(466, 0, 188, 25);
		frmFoodSelections.getContentPane().add(lblPleaseSelectToy);
		//================================================================================================
		
		/**
		 * Imports a picture of bamboo and create a label to show all its attributes.
		 */
		JLabel lblBambooPicture = new JLabel("");
		lblBambooPicture.setBounds(38, 68, 150, 150);
		frmFoodSelections.getContentPane().add(lblBambooPicture);
		ImageIcon bambooIcon = new ImageIcon(FoodSelections.class.getResource("/food_pics/bamboo.png"));
		lblBambooPicture.setIcon(bambooIcon);
		
		JLabel lblBambooAttributes = new JLabel("<html>"
				+ "* Bamboo<br> "
				+ "* Quantity: " + gameConsole.getCurrentPlayer().getFoodQuantity(new Bamboo()) + "<br>"
				+ "</html>");
		lblBambooAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblBambooAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblBambooAttributes.setBounds(38, 253, 150, 42);
		frmFoodSelections.getContentPane().add(lblBambooAttributes);
		//================================================================================================
		
		/**
		 * create a button to select bamboo
		 */
		JButton btnSelectBamboo = new JButton("");
		
		if (gameConsole.getCurrentPlayer().hasFood(new Bamboo())){
			btnSelectBamboo.setEnabled(true);
			btnSelectBamboo.setText("Select");
			btnSelectBamboo.setBackground(Color.GREEN);
		}
		else{
			btnSelectBamboo.setEnabled(false);
			btnSelectBamboo.setText("Unavailable");
			btnSelectBamboo.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectBamboo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = gameConsole.getCurrentPlayer();
				Pet pet = gameConsole.getCurrentPet();
				Bamboo b = new Bamboo();
				pet.feed(b);
				player.useFood(b);
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmFoodSelections.setVisible(false);
			}
		});
		btnSelectBamboo.setBounds(38, 338, 150, 25);
		frmFoodSelections.getContentPane().add(btnSelectBamboo);
		//================================================================================================

		/**
		 * Imports a picture of salmon and create a label to show all its attributes.
		 */
		JLabel lblSalmonPicture = new JLabel("");
		lblSalmonPicture.setBounds(401, 68, 150, 150);
		frmFoodSelections.getContentPane().add(lblSalmonPicture);
		ImageIcon salmonIcon = new ImageIcon(FoodSelections.class.getResource("/food_pics/salmon.png"));
		lblSalmonPicture.setIcon(salmonIcon);
		
		JLabel lblSalmonAttributes = new JLabel("<html>"
				+ "* Salmon<br> "
				+ "* Quantity: " + gameConsole.getCurrentPlayer().getFoodQuantity(new Salmon()) + "<br>"
				+ "</html>");
		lblSalmonAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblSalmonAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblSalmonAttributes.setBounds(401, 253, 150, 42);
		frmFoodSelections.getContentPane().add(lblSalmonAttributes);
		//================================================================================================
		
		/**
		 * create a button to select salmon
		 */
		JButton btnSelectSalmon = new JButton("");
		
		if (gameConsole.getCurrentPlayer().hasFood(new Salmon())){
			btnSelectSalmon.setEnabled(true);
			btnSelectSalmon.setText("Select");
			btnSelectSalmon.setBackground(Color.GREEN);
		}
		else{
			btnSelectSalmon.setEnabled(false);
			btnSelectSalmon.setText("Unavailable");
			btnSelectSalmon.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectSalmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = gameConsole.getCurrentPlayer();
				Pet pet = gameConsole.getCurrentPet();
				Salmon s = new Salmon();
				pet.feed(s);
				player.useFood(s);
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmFoodSelections.setVisible(false);
			}
		});
		btnSelectSalmon.setBounds(401, 338, 150, 25);
		frmFoodSelections.getContentPane().add(btnSelectSalmon);
		//================================================================================================
		
		/**
		 * Imports a picture of carrot and create a label to show all its attributes.
		 */
		JLabel lblCarrotPicture = new JLabel("");
		lblCarrotPicture.setBounds(763, 68, 150, 150);
		frmFoodSelections.getContentPane().add(lblCarrotPicture);
		ImageIcon carrotIcon = new ImageIcon(FoodSelections.class.getResource("/food_pics/carrot.png"));
		lblCarrotPicture.setIcon(carrotIcon);
		
		JLabel lblCarrotAttributes = new JLabel("<html>"
				+ "* Carrot<br> "
				+ "* Quantity: " + gameConsole.getCurrentPlayer().getFoodQuantity(new Carrot()) + "<br>"
				+ "</html>");
		lblCarrotAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblCarrotAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblCarrotAttributes.setBounds(763, 253, 150, 42);
		frmFoodSelections.getContentPane().add(lblCarrotAttributes);
		//================================================================================================
		
		/**
		 * create a button to select carrot
		 */
		JButton btnSelectCarrot = new JButton();
		
		if (gameConsole.getCurrentPlayer().hasFood(new Carrot())){
			btnSelectCarrot.setEnabled(true);
			btnSelectCarrot.setText("Select");
			btnSelectCarrot.setBackground(Color.GREEN);
		}
		else{
			btnSelectCarrot.setEnabled(false);
			btnSelectCarrot.setText("Unavailable");
			btnSelectCarrot.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectCarrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = gameConsole.getCurrentPlayer();
				Pet pet = gameConsole.getCurrentPet();
				Carrot c = new Carrot();
				pet.feed(c);
				player.useFood(c);
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmFoodSelections.setVisible(false);
			}
		});
		btnSelectCarrot.setBounds(763, 338, 150, 25);
		frmFoodSelections.getContentPane().add(btnSelectCarrot);
		//================================================================================================
		
		/**
		 * Imports a picture of laksa and create a label to show all its attributes.
		 */
		JLabel lblLaksaPicture = new JLabel("");
		lblLaksaPicture.setBounds(223, 68, 150, 150);
		frmFoodSelections.getContentPane().add(lblLaksaPicture);
		ImageIcon laksaIcon = new ImageIcon(FoodSelections.class.getResource("/food_pics/laksa.png"));
		lblLaksaPicture.setIcon(laksaIcon);
		
		JLabel lblLaksaAttributes = new JLabel("<html>"
				+ "* Laksa<br> "
				+ "* Quantity: " + gameConsole.getCurrentPlayer().getFoodQuantity(new Laksa()) + "<br>"
				+ "</html>");
		lblLaksaAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblLaksaAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblLaksaAttributes.setBounds(223, 253, 150, 42);
		frmFoodSelections.getContentPane().add(lblLaksaAttributes);
		//================================================================================================
		
		/**
		 * create a button to select laksa
		 */
		JButton btnSelectLaksa = new JButton();
		
		if (gameConsole.getCurrentPlayer().hasFood(new Laksa())){
			btnSelectLaksa.setEnabled(true);
			btnSelectLaksa.setText("Select");
			btnSelectLaksa.setBackground(Color.GREEN);
		}
		else{
			btnSelectLaksa.setEnabled(false);
			btnSelectLaksa.setText("Unavailable");
			btnSelectLaksa.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectLaksa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = gameConsole.getCurrentPlayer();
				Pet pet = gameConsole.getCurrentPet();
				Laksa l = new Laksa();
				pet.feed(l);
				player.useFood(l);
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmFoodSelections.setVisible(false);
			}
		});
		btnSelectLaksa.setBounds(223, 338, 150, 25);
		frmFoodSelections.getContentPane().add(btnSelectLaksa);
		//================================================================================================
		
		/**
		 * Imports a picture of kebab and create a label to show all its attributes.
		 */
		JLabel lblKebabPicture = new JLabel("");
		lblKebabPicture.setBounds(588, 68, 150, 150);
		frmFoodSelections.getContentPane().add(lblKebabPicture);
		ImageIcon kebabIcon = new ImageIcon(FoodSelections.class.getResource("/food_pics/Kebab.png"));
		lblKebabPicture.setIcon(kebabIcon);
		
		JLabel lblKebabAttributes = new JLabel("<html>"
				+ "* Kebab<br> "
				+ "* Quantity: " + gameConsole.getCurrentPlayer().getFoodQuantity(new Kebab()) + "<br>"
				+ "</html>");
		lblKebabAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblKebabAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblKebabAttributes.setBounds(588, 253, 150, 42);
		frmFoodSelections.getContentPane().add(lblKebabAttributes);
		//================================================================================================
		
		/**
		 * create a button to select kebab
		 */
		JButton btnSelectKebab = new JButton();
		
		if (gameConsole.getCurrentPlayer().hasFood(new Kebab())){
			btnSelectKebab.setEnabled(true);
			btnSelectKebab.setText("Select");
			btnSelectKebab.setBackground(Color.GREEN);
		}
		else{
			btnSelectKebab.setEnabled(false);
			btnSelectKebab.setText("Unavailable");
			btnSelectKebab.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectKebab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = gameConsole.getCurrentPlayer();
				Pet pet = gameConsole.getCurrentPet();
				Kebab k = new Kebab();
				pet.feed(k);
				player.useFood(k);
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmFoodSelections.setVisible(false);
			}
		});
		btnSelectKebab.setBounds(588, 338, 150, 25);
		frmFoodSelections.getContentPane().add(btnSelectKebab);
		//================================================================================================
		/**
		 * Imports a picture of chocolate cake and create a label to show all its attributes.
		 */
		JLabel lblChocCakePicture = new JLabel("");
		lblChocCakePicture.setBounds(941, 68, 150, 150);
		frmFoodSelections.getContentPane().add(lblChocCakePicture);
		ImageIcon chocCakeIcon = new ImageIcon(FoodSelections.class.getResource("/food_pics/chocolate_cake.png"));
		lblChocCakePicture.setIcon(chocCakeIcon);
		
		JLabel lblChocCakeAttributes = new JLabel("<html>"
				+ "* Chocolate Cake<br> "
				+ "* Quantity: " + gameConsole.getCurrentPlayer().getFoodQuantity(new Chocolatecake()) + "<br>"
				+ "</html>");
		lblChocCakeAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblChocCakeAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblChocCakeAttributes.setBounds(941, 253, 150, 42);
		frmFoodSelections.getContentPane().add(lblChocCakeAttributes);
		//================================================================================================
		
		/**
		 * create a button to select Chocolate cake
		 */
		JButton btnSelectChocolatecake= new JButton();
		
		if (gameConsole.getCurrentPlayer().hasFood(new Chocolatecake())){
			btnSelectChocolatecake.setEnabled(true);
			btnSelectChocolatecake.setText("Select");
			btnSelectChocolatecake.setBackground(Color.GREEN);
		}
		else{
			btnSelectChocolatecake.setEnabled(false);
			btnSelectChocolatecake.setText("Unavailable");
			btnSelectChocolatecake.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectChocolatecake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = gameConsole.getCurrentPlayer();
				Pet pet = gameConsole.getCurrentPet();
				Chocolatecake cc = new Chocolatecake();
				pet.feed(cc);
				player.useFood(cc);
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmFoodSelections.setVisible(false);
			}
		});
		btnSelectChocolatecake.setBounds(941, 338, 150, 25);
		frmFoodSelections.getContentPane().add(btnSelectChocolatecake);
		//================================================================================================


	}
}
