
package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Aaron Bong and Heyang Li
 * player class, which has all player's method
 * Initialize all player's attribute
 */
public class Player {

	Scanner sc = new Scanner(System.in);
	private String name;
	private int money = 1000;
	
	private List<Pet> pets = new ArrayList<>();
	private Map<FoodItem, Integer> foodInventory = new HashMap<>();
	private List<ToyItem> toyInventory = new ArrayList<>();

	protected int currentPlayer;
	protected int currentPet;
	
	/**
	 * get all the pets for the player
	 * @return the list of pet that player has
	 */
	public List<Pet> getPets() {
		return pets;
	}

	
	public Player() {
	}
	
	/**
	 * get player's name
	 * @return player's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setter for player's name
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * get player's current financial statement
	 * @return money that current player has
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * when player buying toy or food
	 * @param purchase
	 * @return how much money left
	 */
	public int spendMoney(int purchase) {
		money -= purchase;
		return money;
	}
	
	/**
	 * add new pet into the player's pet list
	 * @param newPet
	 */
	public void addPet(Pet newPet) {
		pets.add(newPet);
	}
	
	/**
	 * get the i's pet that in the player pet list
	 * @param i
	 * @return pet[i]
	 */
	public Pet getPet(int i) {
		return pets.get(i);
	}
	
	/**
	 * get player's list size
	 * @return how many pet that player has
	 */
	public int getNumPets() {
		return pets.size();
	}
	
	/**
	 * add toy into player's toy list, if the player already has
	 * Destroy the current toy and add a new one
	 * @param toy
	 */
	public void addToy(ToyItem toy) {
		if (hasToy(toy)) {
			removeToy(toy);			
		}
		toyInventory.add(toy);
	}
	
	
	/**
	 * remove a toy, help function for add toy method
	 * @param toy
	 * @return remove a toy
	 */
	public boolean removeToy(ToyItem toy) {
		return toyInventory.remove(toy);
	}
	
	/**
	 * check if the toy is the player's toy list
	 * help function for add toy method
	 * @param toy
	 * @return true or false
	 */
	public boolean hasToy(ToyItem toy) {
		return toyInventory.contains(toy);
	}
	
	/**
	 * get i's item from the toy inventory list
	 * @param toy
	 * @return toy[i]
	 */
	public ToyItem getToy(ToyItem toy) {
		return toyInventory.get(toyInventory.indexOf(toy));
	}
	
	/**
	 * get toy list's size
	 * @return number of toys
	 */
	public int getNumToys() {
		return toyInventory.size();
	}
	
	/**
	 * get all toy's from the toy list
	 * @return a list of toys
	 */
	public List<ToyItem> getToys() {
		return Collections.unmodifiableList(toyInventory);
	}
	
	/**
	 * check if the food is already in the food inventory list
	 * a help function for add food method
	 * @param food
	 * @return true or false
	 */
	public boolean hasFood(FoodItem food){
		return getFoodQuantity(food) != 0;
	}
	
	/**
	 * get current player's chosen food quantity
	 * @param food
	 * @return 0 for no food or a number for if food exist in the list
	 */
	public int getFoodQuantity(FoodItem food) {
		return foodInventory.getOrDefault(food, 0);
	}

	/**
	 * add food quantity into the food inventory list
	 * if food already in the food inventory, will use food's quantity add on the new quantity
	 * else, will put the new quantity into the list
	 * @param food
	 * @param quantity
	 */
	public void addFood(FoodItem food, int quantity) {
		if (foodInventory.containsKey(food)) {
			foodInventory.replace(food, foodInventory.get(food).intValue() + quantity);
		}
		else {
			foodInventory.put(food, quantity);
		}
	}
	
	/**
	 * if toy in the toy list, get durability, otherwise, get 0
	 * @param toy
	 * @return toy's durability or 0
	 */
	public int getToyDurability(ToyItem toy) {
		if (hasToy(toy)){
			return getToy(toy).getDurability();
		}
		else{
			return 0;
			}
		}
	
	/**
	 * for pet play with toy, will destroy the entire toy if pet's aggressiveness
	 * is higher than current toy's durability, else will dedicate.
	 * @param toy
	 * @param pet
	 */
	public void useToy(ToyItem toy, Pet pet){
		ToyItem myToy = getToy(toy);
		if (myToy.decreaseDurability(pet.getAggressiveness())){
			removeToy(myToy);
		}
		
		//add code to make pet happier & more tired
		//pet.setPetMood(pet.getPetMood() + toy.getHappypoint());
	}
	
	/**
	 * use a single FoodItem from inventory
	 * @param food the FoodItem to use
	 * @return false if not enough, true otherwise
	 */
	public boolean useFood(FoodItem food) {
		if (getFoodQuantity(food) > 0) {
			foodInventory.replace(food,  foodInventory.get(food).intValue() - 1);
			return true;
		}
		return false;
	}
}
		
		
	

