package assignment;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author Aaron Bong and Heyang Li
 * This class allows player to purchase toys.
 * Initialize all related variables.
 *
 */
public class FoodShop {
	//uncomment it later
	//Player player = new Player();
	private ArrayList<FoodItem> foodShopInventory = new ArrayList<>();
	private Bamboo bamboo = new Bamboo();
	private Salmon salmon = new Salmon();
	private Carrot carrot = new Carrot();
	private Laksa laksa = new Laksa();
	private Kebab kebab = new Kebab();
	private Chocolatecake chocolcateCake = new Chocolatecake();
	public int chosenFood;
	public int purchaseNum;

	/**
	 * add all food into a empty food shop
	 */
	public void foodShopInit(){	
		foodShopInventory.add(bamboo);
		foodShopInventory.add(salmon);
		foodShopInventory.add(carrot);
		foodShopInventory.add(laksa);
		foodShopInventory.add(kebab);
		foodShopInventory.add(chocolcateCake);
		}

	/**
	 * check if the input is valid
	 * @return a valid input
	 */
	public int buyFoodInput(){
		Scanner sc = new Scanner(System.in);
		while(true){
			try {
				return chosenFood =sc.nextInt();
				}
			catch(Exception e){
				sc.next();
				System.out.println("Please re-enter a valid number");
				System.out.println("Please enter 1-6 to select item you would like to purchase");
			}
		}
	}
	
	/**
	 * check if the input is valid
	 * @return a valid input
	 */
	public int buyFoodQuantity(){
		Scanner sc = new Scanner(System.in);
		while(true){
			try {
				return purchaseNum =sc.nextInt();
				}
			catch(Exception e){
				sc.next();
				System.out.println("Please re-enter a valid number");
			}
		}
	}
	
	/**
	 * let the current player to buy the food and will dedicate money from the current player
	 * will add food into the current player's food inventory
	 * @param player is indicate current player
	 */
	public void buyFood(Player player){
		foodShopInit();
		System.out.println(" === Welcome to the food store === ");
		for (int i = 0; i < 6; i++){
		System.out.println((i+1) + ". purchase " + foodShopInventory.get(i).getName() + ", they are " + foodShopInventory.get(i).getPrice()+ " each");
		}
		System.out.println("Please enter 1-6 to select item you would like to purchase");
		Scanner sc = new Scanner(System.in);
		buyFoodInput();
			while (chosenFood < 1 | chosenFood > 6){
				System.out.println("Please re-enter a valid number");
				buyFoodInput();
			}
		System.out.println("How many would you like to purchase?");
	
		for (int j = 0; j < 99999; j++){
			buyFoodQuantity();
			while (purchaseNum < 0){
				System.out.println("Please re-enter a valid number");
				buyFoodQuantity();
			}
			FoodItem fi = foodShopInventory.get(chosenFood-1);
			int totalPrice = purchaseNum * fi.getPrice();
			if (player.getMoney() >= totalPrice){
				System.out.println("You have purchased " + purchaseNum + " " + fi.getName() + ".");
				System.out.println("You have spent $" + totalPrice + ".");
				player.addFood(fi, purchaseNum);
				player.spendMoney(totalPrice);
				System.out.println("You have $" + player.getMoney() + " left.");
				System.out.println("You now have " + player.getFoodQuantity(fi) + " of " + fi.getName());
				break;
			}
			else{
				System.out.println("You don't have enough money, please re-enter a number.");
			}
		}
	}


}
