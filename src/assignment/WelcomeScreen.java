
package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Aaron Bong & Heyang Li
 *
 */

/**
 * 
 * Welcome Screen is to ask players for number of players and number of desired days.
 *
 */
public class WelcomeScreen {
	
	/**
	 * Creates new game using GameEnvi class.
	 */
	private GameEnvi game = new GameEnvi();
	
	/**
	 * Initialise the frame
	 */
	private JFrame frmWelcomeToTamagotchi;
	
	/**
	 * A getter for Frame
	 * @return image
	 */
	public JFrame getFrmWelcomeToTamagotchi() {
		return frmWelcomeToTamagotchi;
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.frmWelcomeToTamagotchi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Initialize the Jframe.
		 */
		frmWelcomeToTamagotchi = new JFrame();
		frmWelcomeToTamagotchi.setTitle("Welcome to Tamagotchi");
		frmWelcomeToTamagotchi.setBounds(100, 100, 857, 494);
		frmWelcomeToTamagotchi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToTamagotchi.getContentPane().setLayout(null);
		//================================================================================================
		
		/**
		 * Create a title for the application.
		 */
		JLabel lblWelcome = new JLabel("WELCOME TO THE TAMAGOTCHI!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(273, 25, 286, 16);
		frmWelcomeToTamagotchi.getContentPane().add(lblWelcome);
		//================================================================================================
		
		/**
		 * Create a day selector for players to select number of players.
		 */
		JSlider NumPlayersSelector = new JSlider();
		NumPlayersSelector.setMinimum(1);
		NumPlayersSelector.setMaximum(3);
		NumPlayersSelector.setValue(0);
		NumPlayersSelector.setBounds(273, 265, 310, 28);
		frmWelcomeToTamagotchi.getContentPane().add(NumPlayersSelector);
		
		JLabel lblNumPlayersSelector = new JLabel("Number of Players");
		lblNumPlayersSelector.setBounds(78, 265, 173, 28);
		frmWelcomeToTamagotchi.getContentPane().add(lblNumPlayersSelector);
		
		JLabel lblPlayersSelectorCount = new JLabel("1");
		lblPlayersSelectorCount.setBounds(609, 265, 20, 28);
		frmWelcomeToTamagotchi.getContentPane().add(lblPlayersSelectorCount);
		
		NumPlayersSelector.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedNum = NumPlayersSelector.getValue();
				lblPlayersSelectorCount.setText(Integer.toString(selectedNum));
			}
		});
		//================================================================================================
		
		/**
		 * Create a day selector for player to select number of desired days.
		 */
		JSlider numDaySelector = new JSlider();
		numDaySelector.setMinimum(1);
		numDaySelector.setValue(0);
		numDaySelector.setBounds(273, 316, 310, 28);
		frmWelcomeToTamagotchi.getContentPane().add(numDaySelector);
		
		JLabel lblDaysSelector = new JLabel("Number of Days");
		lblDaysSelector.setBounds(78, 316, 173, 28);
		frmWelcomeToTamagotchi.getContentPane().add(lblDaysSelector);
		
		JLabel lblDaysSelectorCount = new JLabel("1");
		lblDaysSelectorCount.setBounds(608, 316, 32, 28);
		frmWelcomeToTamagotchi.getContentPane().add(lblDaysSelectorCount);
		
		numDaySelector.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedNumDays = numDaySelector.getValue();
				lblDaysSelectorCount.setText(Integer.toString(selectedNumDays));
			}
		});
		//================================================================================================
		
		
		/**
		 * Create a help button that will pop up a text message containing insturctions and explanations.
		 */
		JButton btnHelpWelcome = new JButton("Help");
		btnHelpWelcome.setBounds(376, 409, 89, 23);
		frmWelcomeToTamagotchi.getContentPane().add(btnHelpWelcome);
		
		btnHelpWelcome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTextArea msg = new JTextArea("- Use the slider to select number of players (1-3 Players).\n\n"
						+ "- Use the slider to select number of days (1-100 Days).\n\n"
						+ "- Click Next for next steps.");
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
		 * Imports a picture of a tamagotchi
		 */
		JLabel lblTamagotchipicture = new JLabel("");
		lblTamagotchipicture.setBounds(337, 70, 150, 150);
		frmWelcomeToTamagotchi.getContentPane().add(lblTamagotchipicture);
		ImageIcon Icon1 = new ImageIcon(WelcomeScreen.class.getResource("/pics/Tamagotchi_logo.png"));
		lblTamagotchipicture.setIcon(Icon1);
		//================================================================================================

		/**
		 * Creates "Next" Button. Changes to Player 1 Selection JPanel when clicked.
		 */
		
		JButton btnNextWelcomeScrn = new JButton("Next >");
		btnNextWelcomeScrn.setBounds(527, 409, 89, 23);
		frmWelcomeToTamagotchi.getContentPane().add(btnNextWelcomeScrn);
		
		btnNextWelcomeScrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Store Number of players and number of days into game envi
				int selectedNumPlayers = NumPlayersSelector.getValue();
				game.setNumPlayer(selectedNumPlayers);
				int selectedNumDays = numDaySelector.getValue();
				game.setDayCounter(selectedNumDays);
				
				
				// Move on to Player Selections window
				frmWelcomeToTamagotchi.setVisible(false);
				new PlayerSelections(game).getFrmPlayerSelections().setVisible(true);
			}
		});

		
	}
}
