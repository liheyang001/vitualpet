package assignment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * 
 * @author Aaron Bong & Heyang Li
 *
 */

/**
 * 
 * Toy Selections is to allow players to select the toy which players already bought to play with the pet.
 *
 */
public class ToySelections {
	private GameConsole gameConsole;
		
	/**
	 * Initialise the frame
	 */
	private JFrame frmToySelections;
	
	/**
	 * A getter for Frame
	 * @return the frame of Toy Selections
	 */
	public JFrame getFrmToySelections() {
		return frmToySelections;
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ToySelections window = new ToySelections();
//					window.frmToySelections.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param gameConsole
	 */
	public ToySelections(GameConsole gameConsole) {
		this.gameConsole = gameConsole;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmToySelections = new JFrame();
		frmToySelections.setTitle("Toy Inventory");
		frmToySelections.setBounds(100, 100, 1138, 547);
		frmToySelections.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmToySelections.getContentPane().setLayout(null);
		
		/**
		 * Create a title
		 */
		JLabel lblPleaseSelectToy = new JLabel("Please Select Toy");
		lblPleaseSelectToy.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectToy.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPleaseSelectToy.setBounds(476, 12, 173, 25);
		frmToySelections.getContentPane().add(lblPleaseSelectToy);
		//================================================================================================
		
		/**
		 * Imports a picture of Lego and creates a label to show all its attributes.
		 */
		JLabel lblLegoPicture = new JLabel("");
		lblLegoPicture.setBounds(24, 66, 150, 150);
		frmToySelections.getContentPane().add(lblLegoPicture);
		ImageIcon toyIcon1 = new ImageIcon(ToySelections.class.getResource("/toy_pics/lego.png"));
		lblLegoPicture.setIcon(toyIcon1);
		
		JLabel lblLegoAttributes = new JLabel("<html>"
				+ "* LEGO<br> "
				+ "* Durability: " + gameConsole.getCurrentPlayer().getToyDurability(new Lego()) + "%<br>"
				+ "</html>");
		lblLegoAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblLegoAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblLegoAttributes.setBounds(24, 227, 150, 42);
		frmToySelections.getContentPane().add(lblLegoAttributes);
		//================================================================================================
		
		/**
		 * Create a button for player to select lego to play with pet.
		 */
		JButton btnSelectLego = new JButton();
		btnSelectLego.setHorizontalAlignment(SwingConstants.CENTER);
		btnSelectLego.setBounds(24, 306, 150, 23);
		frmToySelections.getContentPane().add(btnSelectLego);
		
		if (gameConsole.getCurrentPlayer().hasToy(new Lego())){
			btnSelectLego.setEnabled(true);
			btnSelectLego.setText("Select");
			btnSelectLego.setBackground(Color.GREEN);
		}
		else{
			btnSelectLego.setEnabled(false);
			btnSelectLego.setText("Unavailable");
			btnSelectLego.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectLego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameConsole.getCurrentPlayer().useToy(gameConsole.getCurrentPlayer().getToy(new Lego()), gameConsole.getCurrentPet());
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmToySelections.setVisible(false);
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Barbie Doll and create a label to show all its attributes.
		 */
		JLabel lblBarbieDollPicture = new JLabel("");
		lblBarbieDollPicture.setBounds(206, 66, 150, 150);
		frmToySelections.getContentPane().add(lblBarbieDollPicture);
		ImageIcon toyIcon2 = new ImageIcon(ToySelections.class.getResource("/toy_pics/barbie_doll.png"));
		lblBarbieDollPicture.setIcon(toyIcon2);
		
		JLabel lblBarbieDollAttributes = new JLabel("<html>"
				+ "* Barbie Doll<br> "
				+ "* Durability: " + gameConsole.getCurrentPlayer().getToyDurability(new BarbieDoll()) + "%<br>"
				+ "</html>");
		lblBarbieDollAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblBarbieDollAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblBarbieDollAttributes.setBounds(206, 227, 150, 42);
		frmToySelections.getContentPane().add(lblBarbieDollAttributes);
		//================================================================================================
		
		/**
		 * Create a button for player to select barbie doll to play with pet.
		 */
		JButton btnSelectBarbieDoll = new JButton();
		btnSelectBarbieDoll.setHorizontalAlignment(SwingConstants.CENTER);
		btnSelectBarbieDoll.setBounds(206, 306, 150, 23);
		frmToySelections.getContentPane().add(btnSelectBarbieDoll);
		if (gameConsole.getCurrentPlayer().hasToy(new BarbieDoll())){
			btnSelectBarbieDoll.setEnabled(true);
			btnSelectBarbieDoll.setText("Select");
			btnSelectBarbieDoll.setBackground(Color.GREEN);
		}
		else{
			btnSelectBarbieDoll.setEnabled(false);
			btnSelectBarbieDoll.setText("Unavailable");
			btnSelectBarbieDoll.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectBarbieDoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameConsole.getCurrentPlayer().useToy(gameConsole.getCurrentPlayer().getToy(new BarbieDoll()), gameConsole.getCurrentPet());
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmToySelections.setVisible(false);
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Ninja Turtle and create a label to show all its attributes.
		 */
		JLabel lblNinjaTurtlePicture = new JLabel("");
		lblNinjaTurtlePicture.setBounds(398, 66, 150, 150);
		frmToySelections.getContentPane().add(lblNinjaTurtlePicture);
		ImageIcon toyIcon3 = new ImageIcon(ToySelections.class.getResource("/toy_pics/ninja_turtle.png"));
		lblNinjaTurtlePicture.setIcon(toyIcon3);
		
		JLabel lblNinjaTurtleAttributes = new JLabel("<html>"
				+ "* Ninja Turtle<br> "
				+ "* Durability: " + gameConsole.getCurrentPlayer().getToyDurability(new NinjaTurtle()) + "%<br>"
				+ "</html>");
		lblNinjaTurtleAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblNinjaTurtleAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNinjaTurtleAttributes.setBounds(398, 227, 150, 42);
		frmToySelections.getContentPane().add(lblNinjaTurtleAttributes);
		//================================================================================================
		
		/**
		 * Create a button for player to select Ninja Turtle to play with pet.
		 */
		JButton btnSelectNinjaTurtle = new JButton();
		btnSelectNinjaTurtle.setHorizontalAlignment(SwingConstants.CENTER);
		btnSelectNinjaTurtle.setBounds(398, 306, 150, 23);
		frmToySelections.getContentPane().add(btnSelectNinjaTurtle);
		if (gameConsole.getCurrentPlayer().hasToy(new NinjaTurtle())){
			btnSelectNinjaTurtle.setEnabled(true);
			btnSelectNinjaTurtle.setText("Select");
			btnSelectNinjaTurtle.setBackground(Color.GREEN);
		}
		else{
			btnSelectNinjaTurtle.setEnabled(false);
			btnSelectNinjaTurtle.setText("Unavailable");
			btnSelectNinjaTurtle.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectNinjaTurtle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameConsole.getCurrentPlayer().useToy(gameConsole.getCurrentPlayer().getToy(new NinjaTurtle()), gameConsole.getCurrentPet());
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmToySelections.setVisible(false);
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Star Wars and create a label to show all its attributes.
		 */
		JLabel lblStarWarsPicture = new JLabel("");
		lblStarWarsPicture.setBounds(582, 66, 150, 150);
		frmToySelections.getContentPane().add(lblStarWarsPicture);
		ImageIcon toyIcon4 = new ImageIcon(ToySelections.class.getResource("/toy_pics/star_wars.png"));
		lblStarWarsPicture.setIcon(toyIcon4);
		
		JLabel lblStarWarsAttributes = new JLabel("<html>"
				+ "* Star Wars<br> "
				+ "* Durability: " + gameConsole.getCurrentPlayer().getToyDurability(new StarWars()) + "%<br>"
				+ "</html>");
		lblStarWarsAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblStarWarsAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblStarWarsAttributes.setBounds(582, 227, 150, 42);
		frmToySelections.getContentPane().add(lblStarWarsAttributes);
		//================================================================================================
		
		/**
		 * Create a button for player to select Star Wars to play with pet.
		 */
		JButton btnSelectStarWars = new JButton();
		btnSelectStarWars.setHorizontalAlignment(SwingConstants.CENTER);
		btnSelectStarWars.setBounds(582, 306, 150, 23);
		frmToySelections.getContentPane().add(btnSelectStarWars);
		if (gameConsole.getCurrentPlayer().hasToy(new StarWars())){
			btnSelectStarWars.setEnabled(true);
			btnSelectStarWars.setText("Select");
			btnSelectStarWars.setBackground(Color.GREEN);
		}
		else{
			btnSelectStarWars.setEnabled(false);
			btnSelectStarWars.setText("Unavailable");
			btnSelectStarWars.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectStarWars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameConsole.getCurrentPlayer().useToy(gameConsole.getCurrentPlayer().getToy(new StarWars()), gameConsole.getCurrentPet());
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmToySelections.setVisible(false);
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Pikachu  and create a label to show all its attributes.
		 */
		JLabel lblPikachuPicture = new JLabel("");
		lblPikachuPicture.setBounds(768, 66, 150, 150);
		frmToySelections.getContentPane().add(lblPikachuPicture);
		ImageIcon toyIcon5 = new ImageIcon(ToySelections.class.getResource("/toy_pics/pikachu.png"));
		lblPikachuPicture.setIcon(toyIcon5);
		
		JLabel lblPikachuAttributes = new JLabel("<html>"
				+ "* Pikachu<br> "
				+ "* Durability: " + gameConsole.getCurrentPlayer().getToyDurability(new Pikachu()) + "%<br>"
				+ "</html>");
		lblPikachuAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblPikachuAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblPikachuAttributes.setBounds(768, 227, 150, 42);
		frmToySelections.getContentPane().add(lblPikachuAttributes);
		//================================================================================================
		
		/**
		 * Create a button for player to select Pikachu to play with pet.
		 */
		JButton btnSelectPikachu = new JButton();
		btnSelectPikachu.setHorizontalAlignment(SwingConstants.CENTER);
		btnSelectPikachu.setBounds(768, 306, 150, 23);
		frmToySelections.getContentPane().add(btnSelectPikachu);
		if (gameConsole.getCurrentPlayer().hasToy(new Pikachu())){
			btnSelectPikachu.setEnabled(true);
			btnSelectPikachu.setText("Select");
			btnSelectPikachu.setBackground(Color.GREEN);
		}
		else{
			btnSelectPikachu.setEnabled(false);
			btnSelectPikachu.setText("Unavailable");
			btnSelectPikachu.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectPikachu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameConsole.getCurrentPlayer().useToy(gameConsole.getCurrentPlayer().getToy(new Pikachu()), gameConsole.getCurrentPet());
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmToySelections.setVisible(false);
			}
		});
		//================================================================================================
		
		/**
		 * Imports a picture of Toy Car and create a label to show all its attributes.
		 */
		JLabel lblToyCarPicture = new JLabel("");
		lblToyCarPicture.setBounds(942, 66, 150, 150);
		frmToySelections.getContentPane().add(lblToyCarPicture);
		ImageIcon toyIcon6 = new ImageIcon(ToySelections.class.getResource("/toy_pics/toy_car.png"));
		lblToyCarPicture.setIcon(toyIcon6);
		
		JLabel lblToyCarAttributes = new JLabel("<html>"
				+ "* Toy Car<br> "
				+ "* Durability: " + gameConsole.getCurrentPlayer().getToyDurability(new ToyCar()) + "%<br>"
				+ "</html>");
		lblToyCarAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblToyCarAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblToyCarAttributes.setBounds(942, 227, 150, 42);
		frmToySelections.getContentPane().add(lblToyCarAttributes);
		//================================================================================================
		
		/**
		 * Create a button for player to select Toy Car to play with pet.
		 */
		JButton btnSelectToyCar = new JButton();
		btnSelectToyCar.setHorizontalAlignment(SwingConstants.CENTER);
		btnSelectToyCar.setBounds(942, 306, 150, 23);
		frmToySelections.getContentPane().add(btnSelectToyCar);
		
		if (gameConsole.getCurrentPlayer().hasToy(new ToyCar())){
			btnSelectToyCar.setEnabled(true);
			btnSelectToyCar.setText("Select");
			btnSelectToyCar.setBackground(Color.GREEN);
		}
		else{
			btnSelectToyCar.setEnabled(false);
			btnSelectToyCar.setText("Unavailable");
			btnSelectToyCar.setBackground(Color.LIGHT_GRAY);
		}
		
		btnSelectToyCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameConsole.getCurrentPlayer().useToy(gameConsole.getCurrentPlayer().getToy(new ToyCar()), gameConsole.getCurrentPet());
				gameConsole.realtimePlayerStats();
				gameConsole.realtimePetStats();
				gameConsole.getFrmTamagotchiGameConsole().setVisible(true);
				frmToySelections.setVisible(false);
			}
		});
		//================================================================================================
		
	}
}
