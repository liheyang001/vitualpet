package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class EndGame {


	private JFrame frmEndGame;
	
	/**
	 * getter for frmEndGame.
	 * @return the frmEndGame
	 */
	public JFrame getFrmEndGame() {
		return frmEndGame;
	}
	
	
	//to store game object from Game Conmsole
	private GameEnvi game;
	 
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EndGame window = new EndGame();
//					window.frmEndGame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * to calculate the final score
	 */
	public int FinalScore(Player player){
		int finalScore = 0;
		for (int temp = 0; temp < player.getPets().size(); temp++)
			{
			int tempScore = player.getPet(temp).getHungry() + player.getPet(temp).getPetFeed()
					+ player.getPet(temp).getPetHealth() + player.getPet(temp).getPetMood() 
					+ player.getPet(temp).getTired() + player.getPet(temp).getWeight()
					+ player.getMoney();
			finalScore += tempScore / player.getPets().size();
			}
		return finalScore;
	}
	
	
	/**
	 * Create the application.
	 */
	public EndGame(GameEnvi game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEndGame = new JFrame();
		frmEndGame.setTitle("Players Score");
		frmEndGame.setBounds(100, 100, 634, 393);
		frmEndGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEndGame.getContentPane().setLayout(null);
		
		JLabel lblPlayersScore = new JLabel("!!!* PLAYERS SCORE *!!!");
		lblPlayersScore.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 20));
		lblPlayersScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayersScore.setBounds(138, 12, 315, 47);
		frmEndGame.getContentPane().add(lblPlayersScore);
		
		
		JLabel lblPlayer1Score = new JLabel("");
		lblPlayer1Score.setBounds(62, 120, 482, 27);
		frmEndGame.getContentPane().add(lblPlayer1Score);
		
		
		JLabel lblPlayer2Score = new JLabel("");
		lblPlayer2Score.setBounds(62, 186, 482, 27);
		frmEndGame.getContentPane().add(lblPlayer2Score);
		
		
		JLabel lblPlayer3Score = new JLabel("");
		lblPlayer3Score.setBounds(62, 243, 482, 27);
		frmEndGame.getContentPane().add(lblPlayer3Score);
		
		int numPlayers = game.getPlayers().size();
		
		if(numPlayers == 1){
			Player p1 = game.getPlayer(0);
			lblPlayer1Score.setText(p1.getName() + " : " + FinalScore(p1));
		}
		else if(numPlayers == 2){
			Player p1 = game.getPlayer(0);
			Player p2 = game.getPlayer(1);
			lblPlayer1Score.setText(p1.getName() + " : " + FinalScore(p1));
			lblPlayer2Score.setText(p2.getName() + " : " + FinalScore(p2));
		}
		else{
			Player p1 = game.getPlayer(0);
			Player p2 = game.getPlayer(1);
			Player p3 = game.getPlayer(2);
			lblPlayer1Score.setText(p1.getName() + " : " + FinalScore(p1));
			lblPlayer2Score.setText(p2.getName() + " : " + FinalScore(p2));
			lblPlayer3Score.setText(p3.getName() + " : " + FinalScore(p3));

		}
	}
}
