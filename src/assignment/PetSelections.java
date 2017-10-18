package assignment;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * @author Aaron Bong & Heyang Li
 */

/**
 * A seperate window for selecting desired pet.
 */
public class PetSelections {
	/**
	 * Initialise the frame
	 */
	private JFrame frmPetSelections;
	
	/**
	 * A getter for Frame
	 * @return the frame of PetSelections
	 */
	public JFrame getFrmPetSelections() {
		return frmPetSelections;
	}

	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PetSelections window = new PetSelections();
//					window.frmPetSelections.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}



	/**
	 * Create the application.
	 */
	public PetSelections() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPetSelections = new JFrame();
		frmPetSelections.setTitle("Pet Selections");
		frmPetSelections.setBounds(100, 100, 1138, 547);
		frmPetSelections.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPetSelections.getContentPane().setLayout(null);
		
		/**
		 * Create a title
		 */
		JLabel lblPleaseSelectPet = new JLabel("Please Select Pet");
		lblPleaseSelectPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectPet.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPleaseSelectPet.setBounds(470, 11, 179, 25);
		frmPetSelections.getContentPane().add(lblPleaseSelectPet);
		//================================================================================================

		/**
		 * Create a button to select Turtle and a label to show all its attributes.
		 */
		JButton btnTurtle = new JButton("");
		btnTurtle.setBounds(31, 48, 150, 150);
		btnTurtle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerSelections.setChoosenSpecies(1);
				frmPetSelections.setVisible(false);
			}
		});
		frmPetSelections.getContentPane().add(btnTurtle);
		ImageIcon petIcon1 = new ImageIcon(PetSelections.class.getResource("/pet_pics/turtle.png"));
		btnTurtle.setIcon(petIcon1);
		
		

		
		JLabel lblTurtleAttributes = new JLabel(
				"<html>Characteristics<br>"
				+ "* Species: Turtle<br>"
				+ "* Fav Toy: NinjaTurtle<br>"
				+ "* Fav Food: Salmon<br>"
				+ "* Dislike Food: ChocCake<br><br>"
				+ "Initial Stats<br>"
				+ "* Agressiveness: 12%<br>"
				+ "* Health:  70%<br>"
				+ "* Weight: 50kg<br>"
				+ "* Stomach Fullness: 50%<br>"
				+ "* Hungryness: 30%<br>"
				+ "* Tiredness: 40%<br>"
				+ "* Mood: 40%<br></html>"
				);
		lblTurtleAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblTurtleAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblTurtleAttributes.setBounds(31, 210, 161, 299);
		frmPetSelections.getContentPane().add(lblTurtleAttributes);
		//================================================================================================
		
		/**
		 * Create a button to select Kiwi Bird and a label to show all its attributes.
		 */
		JButton btnKiwiBird = new JButton("");
		btnKiwiBird.setBounds(215, 48, 150, 150);
		frmPetSelections.getContentPane().add(btnKiwiBird);
		ImageIcon petIcon2 = new ImageIcon(PetSelections.class.getResource("/pet_pics/kiwi_bird.png"));
		btnKiwiBird.setIcon(petIcon2);
		
		btnKiwiBird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerSelections.setChoosenSpecies(2);
				frmPetSelections.setVisible(false);
			}
		});
		
		JLabel lblKiwiBirdAttributes = new JLabel(				
				"<html>Characteristics<br>"
				+ "* Species: kiwi Bird<br>"
				+ "* Fav Toy: Lego<br>"
				+ "* Fav Food: Kebab<br>"
				+ "* Dislike Food: Salmon<br><br>"
				+ "Initial Stats<br>"
				+ "* Agressiveness: 20%<br>"
				+ "* Health:  70%<br>"
				+ "* Weight: 70kg<br>"
				+ "* Stomach Fullness: 55%<br>"
				+ "* Hungryness: 45%<br>"
				+ "* Tiredness: 60%<br>"
				+ "* Mood: 30%<br></html>"
				);
		lblKiwiBirdAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblKiwiBirdAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblKiwiBirdAttributes.setBounds(215, 210, 161, 299);
		frmPetSelections.getContentPane().add(lblKiwiBirdAttributes);
		//================================================================================================
		
		/**
		 * Create a button to select Wolf and a label to show all its attributes.
		 */
		JButton btnWolf = new JButton("");
		btnWolf.setBounds(397, 48, 150, 150);
		frmPetSelections.getContentPane().add(btnWolf);
		ImageIcon petIcon3 = new ImageIcon(PetSelections.class.getResource("/pet_pics/wolf.png"));
		btnWolf.setIcon(petIcon3);
		
		btnWolf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerSelections.setChoosenSpecies(3);
				frmPetSelections.setVisible(false);
			}
		});
		
		JLabel lblWolfAttributes = new JLabel(				
				"<html>Characteristics<br>"
				+ "* Species: Wolf<br>"
				+ "* Fav Toy: Pikachu<br>"
				+ "* Fav Food: Carrot<br>"
				+ "* Dislike Food: Laksa<br><br>"
				+ "Initial Stats<br>"
				+ "* Agressiveness: 28%<br>"
				+ "* Health:  60%<br>"
				+ "* Weight: 50kg<br>"
				+ "* Stomach Fullness: 50%<br>"
				+ "* Hungryness: 45%<br>"
				+ "* Tiredness: 45%<br>"
				+ "* Mood: 55%<br></html>"
				);
		lblWolfAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblWolfAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblWolfAttributes.setBounds(397, 210, 161, 299);
		frmPetSelections.getContentPane().add(lblWolfAttributes);
		//================================================================================================
		
		/**
		 * Create a button to select Panda and a label to show all its attributes.
		 */
		JButton btnPanda = new JButton("");
		btnPanda.setBounds(582, 48, 150, 150);
		frmPetSelections.getContentPane().add(btnPanda);
		ImageIcon petIcon4 = new ImageIcon(PetSelections.class.getResource("/pet_pics/panda.png"));
		btnPanda.setIcon(petIcon4);
		
		btnPanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerSelections.setChoosenSpecies(4);
				frmPetSelections.setVisible(false);
			}
		});
		
		JLabel lblPandaAttributes = new JLabel(				
				"<html>Characteristics<br>"
				+ "* Species: Panda<br>"
				+ "* Fav Toy: ToyCar<br>"
				+ "* Fav Food: Bamboo<br>"
				+ "* Dislike Food: Kebab<br><br>"
				+ "Initial Stats<br>"
				+ "* Agressiveness: 6%<br>"
				+ "* Health:  60%<br>"
				+ "* Weight: 55kg<br>"
				+ "* Stomach Fullness: 55%<br>"
				+ "* Hungryness: 60%<br>"
				+ "* Tiredness: 40%<br>"
				+ "* Mood: 40%<br></html>"
				);
		lblPandaAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblPandaAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblPandaAttributes.setBounds(582, 210, 161, 299);
		frmPetSelections.getContentPane().add(lblPandaAttributes);
		//================================================================================================
		
		/**
		 * Create a button to select Hawk and a label to show all its attributes.
		 */
		JButton btnHawk = new JButton("");
		btnHawk.setBounds(762, 48, 150, 150);
		frmPetSelections.getContentPane().add(btnHawk);
		ImageIcon petIcon5 = new ImageIcon(PetSelections.class.getResource("/pet_pics/hawk.png"));
		btnHawk.setIcon(petIcon5);
		
		btnHawk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerSelections.setChoosenSpecies(5);
				frmPetSelections.setVisible(false);
			}
		});
		
		JLabel lblHawkAttributes = new JLabel(				
				"<html>Characteristics<br>"
				+ "* Species: Hawk<br>"
				+ "* Fav Toy: StarWars<br>"
				+ "* Fav Food: Kebab<br>"
				+ "* Dislike Food: Laksa<br><br>"
				+ "Initial Stats<br>"
				+ "* Agressiveness: 21%<br>"
				+ "* Health:  60%<br>"
				+ "* Weight: 50kg<br>"
				+ "* Stomach Fullness: 50%<br>"
				+ "* Hungryness: 45%<br>"
				+ "* Tiredness: 40%<br>"
				+ "* Mood: 40%<br></html>"
				);
		lblHawkAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblHawkAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblHawkAttributes.setBounds(762, 210, 161, 299);
		frmPetSelections.getContentPane().add(lblHawkAttributes);
		//================================================================================================
		
		/**
		 * Create a button to select Whale and a label to show all its attributes.
		 */
		JButton btnWhale = new JButton("");
		btnWhale.setBounds(942, 48, 150, 150);
		frmPetSelections.getContentPane().add(btnWhale);
		ImageIcon petIcon6 = new ImageIcon(PetSelections.class.getResource("/pet_pics/whale.png"));
		btnWhale.setIcon(petIcon6);
		
		btnWhale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerSelections.setChoosenSpecies(6);
				frmPetSelections.setVisible(false);
			}
		});
		
		JLabel lblWhaleAttributes = new JLabel(				
				"<html>Characteristics<br>"
				+ "* Species: Whale<br>"
				+ "* Fav Toy: BarbieDoll<br>"
				+ "* Fav Food: ChocCake<br>"
				+ "* Dislike Food: Bamboo<br><br>"
				+ "Initial Stats<br>"
				+ "* Agressiveness: 28%<br>"
				+ "* Health:  70%<br>"
				+ "* Weight: 55kg<br>"
				+ "* Stomach Fullness: 55%<br>"
				+ "* Hungryness: 60%<br>"
				+ "* Tiredness: 55%<br>"
				+ "* Mood: 55%<br></html>"
				);
		lblWhaleAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblWhaleAttributes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblWhaleAttributes.setBounds(942, 210, 166, 299);
		frmPetSelections.getContentPane().add(lblWhaleAttributes);
		//================================================================================================
		
	}
}
