package assignment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Aaron Bong and Heyang Li
 * This class allows player to purchase toys.
 * Initialize all related variables
 *
 */
public class ToyShop {
	private ArrayList<ToyItem> toyShopInventory = new ArrayList<>();
	private Lego Lego = new Lego();
	private BarbieDoll BarbieDoll= new BarbieDoll();
	private NinjaTurtle NinjaTurtle= new NinjaTurtle();
	private StarWars StarWars = new StarWars();
	private Pikachu Pikachu = new Pikachu();
	private ToyCar ToyCar = new ToyCar();
	
	public int chosenToy;

	/**
	 * add all toy into a empty toy shop
	 */
	public void toyShopInit(){
		toyShopInventory.add(Lego);
		toyShopInventory.add(BarbieDoll);
		toyShopInventory.add(NinjaTurtle);
		toyShopInventory.add(StarWars);
		toyShopInventory.add(Pikachu);
		toyShopInventory.add(ToyCar);
	}
	
	/**
	 * choose a toy you want to buy
	 * @param i, pass in the value i which is indicate the toy you are going to choose
	 * @return toy class
	 */
	public static ToyItem makeNewToy(int i) {
		switch (i) {
		case 0:
			return new Lego();
		case 1:
			return new BarbieDoll();
		case 2:
			return new NinjaTurtle();
		case 3:
			return new StarWars();
		case 4:
			return new Pikachu();
		case 5:
			return new ToyCar();
		default:
			return null;
		}
	}
	
	/**
	 * check if the input is valid
	 * @return a valid input
	 */
	public int buyToyInput(){
		Scanner sc = new Scanner(System.in);
		while(true){
			try {
				return chosenToy =sc.nextInt();
				}
			catch(Exception e){
				sc.next();
				System.out.println("Please re-enter a valid number");
				System.out.println("Please enter 1-6 to select item you would like to purchase");
			}
		}
	}
		
	/**
	 * let the current player to buy the toy and will dedicate money from the current player
	 * will add toy into the current player's toy inventory
	 * @param player is indicate current player
	 */
	public void buyToy(Player player){		
		toyShopInit();
		System.out.println(" === Welcome to the toy store === ");
		for (int i = 0; i < 6; i++){
		System.out.println((i+1) + ". purchase " + toyShopInventory.get(i).getName() + ", they are " + toyShopInventory.get(i).getPrice() + " each");
		}
		System.out.println("Please enter 1-6 to select item you would like to purchase");
		Scanner sc = new Scanner(System.in);

		buyToyInput();
		while (chosenToy < 1 | chosenToy > 6){
			System.out.println("Please re-enter a valid number");
			buyToyInput();
		}
		ToyItem ti = toyShopInventory.get(chosenToy-1);
		
		if (player.getMoney() >= ti.getPrice()){
			System.out.println("You have purchased " + ti.getName() + ".");
			System.out.println("You have spent $" + ti.getPrice() + ".");
			player.addToy(makeNewToy(chosenToy-1));
			player.spendMoney(ti.getPrice());
			System.out.println("You have $" + player.getMoney()  + " left.");
			}
			else{
				System.out.println("You don't have enough money to buy this, please choose another one.");
				}
			}
	
}
	
	