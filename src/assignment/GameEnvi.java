

package assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Aaron Bong and Heyang Li
 * Game Environment for starting the game and initialize all players attributes.
 * After initialization, player can play with pets in this class.
 * Initialize variables for the GameEnvi Class.
 */
public class GameEnvi {

	private List<Player> playersArray = new ArrayList<>();
	private FoodShop foodShop = new FoodShop();
	private ToyShop toyShop = new ToyShop();

	private int dayCounter = -1;
	private int numPlayers;
	private int rndEventChoose;
	
	/**
	 * get FoodShop class
	 * @return a foodShop class
	 */
	public FoodShop getFoodShop() {
		return foodShop;
	}
	
	/**
	 * get ToyShop class
	 * @return a toyshop class
	 */
	public ToyShop getToyShop() {
		return toyShop;
	}
	
	/**
	 * construct a list to contain all the player
	 * @return a list of players array
	 */
	public List<Player> getPlayers() {
		return Collections.unmodifiableList(playersArray);
	}
	
	/**
	 * get current player
	 * @param i is indicate index
	 * @return current player
	 */
	public Player getPlayer(int i) {
		return playersArray.get(i);
	}

	/**
	 * add a player into players array
	 * @param player
	 */
	public void addPlayer(Player player) {
		playersArray.add(player);
	}
	
	/**
	 * get the number of players
	 * @return number of players
	 */
	public int getNumPlayer() {
		return numPlayers;
	}

	/**
	 * setter for the number of players
	 * @param numPlayers
	 */
	public void setNumPlayer(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	/**
	 * setter for variable dayCounter
	 * @param value = playerLoop
	 */
	public void setDayCounter(int value) {
		dayCounter = value;
	}
	
	/**
	 * setter for the random event choose value
	 * @param value
	 */
	public void setRndEventChoose(int value) {
		rndEventChoose = value;
	}
	
	/**
	 * getter for variable dayCounter
	 * @return
	 */
	public int getDayCounter() {
		return dayCounter;
	}
}