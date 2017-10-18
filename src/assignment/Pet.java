package assignment;

import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

//import java.lang.reflect.Field;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Aaron Bong & Heyang Li
 *
 */

/**
 * Pet Class contains most of the methods to interact with pets
 *Initialize all related variables and pet attributes.
 *
 */
public abstract class Pet {
	protected int petMood;
	protected int hungry; 
	protected int tired;
	protected int weight;
	protected boolean misbehaving;
	protected int petHealth;
	protected int petFeed;
	protected boolean canRevive;
	protected ImageIcon petPic;
	
	public int foodChoise;
	public int toyChoise;
	
	protected String animalSpecies;
	//protected String favFood;
	protected String favToy;
	//protected String dislikeFood;
	protected String petName;
	protected int aggressiveness;
	
	private ArrayList<FoodItem> foodShopInventory = new ArrayList<>();
	private Bamboo bamboo = new Bamboo();
	private Salmon salmon = new Salmon();
	private Carrot carrot = new Carrot();
	private Laksa laksa = new Laksa();
	private Kebab kebab = new Kebab();
	private Chocolatecake chocolcateCake = new Chocolatecake();
	
	private ArrayList<ToyItem> toyShopInventory = new ArrayList<>();
	private Lego Lego = new Lego();
	private BarbieDoll BarbieDoll= new BarbieDoll();
	private NinjaTurtle NinjaTurtle= new NinjaTurtle();
	private StarWars StarWars = new StarWars();
	private Pikachu Pikachu = new Pikachu();
	private ToyCar ToyCar = new ToyCar();
	
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
	 * get animals species
	 * @return animals species
	 */
	public String getAnimalsSpecies(){
		return animalSpecies;
	}
	
	/**
	 * make 3 abstract class for pet
	 * @return favfood, favtoy and dislikefood
	 */
	public abstract FoodItem getFavFood();
	
	public abstract ToyItem getFavToy();
	
	public abstract FoodItem getDislikeFood();
	
	/**
	 * get pet's aggressiveness
	 * @return pet's aggressiveness
	 */
	public int getAggressiveness() {
		return aggressiveness;
	}
	
	/**
	 * get pet name
	 * @return pet's name
	 */
	public String getPetName() {
		return petName;
	}
	
	/**
	 * @return the petPic
	 */
	public ImageIcon getPetPic() {
		return petPic;
	}

	
	/**
	 * 
	 *intialise all pet attributes.
	 *
	 */
	public Pet() {
	}
	
	
	/**
	 * 
	
	 *intialise all pet statuses.
	 *
	 */
	public void petStatus(){
	}
	
	/**
	 * check is if pet is hungry
	 * @return true if hungry value is below 20
	 * @return false otherwise 
	 */
	public boolean isHungry() {		
		if (hungry <= 20) {
			return true;
		}
		return false;
	}
	
	/**
	 * check is if pet is tired
	 * @return true if tired value is above 80
	 * @return false otherwise 
	 */
	public boolean isTired() {
		if (tired >= 80) {
			return true;
		}
		return false;
	}
	
	/**
	 * check is if pet is sick
	 * @return true if health value is below or equal to 20 and above 9 or equal to 0
	 * @return false otherwise 
	 */
	public boolean isSick() {
		if (petHealth <= 20 && petHealth >= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * check is if pet is dead
	 * @return true if health value is below 0
	 * @return false otherwise 
	 */
	public boolean isDead() {
		if (petHealth < 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * check is if pet is misbehaving
	 * @return true or false
	 */
	public boolean isMisbehaving() {
		return misbehaving;
	}

	/**
	 * set pet's misbehaving statue
	 * @param misbehaving
	 */
	public void setMisbehaving(boolean misbehaving) {
		this.misbehaving = misbehaving;
	}
	
	/**
	 * get pet's mood
	 * @return pet mood
	 */
	public int getPetMood() {
		return petMood;
	}

	/**
	 * set pet's mood
	 * @param petMood
	 */
	public void setPetMood(int petMood) {
		this.petMood = petMood;
	}

	/**
	 * get pet's hungry value
	 * @return hungry value
	 */
	public int getHungry() {
		return hungry;
	}

	/**
	 * set pet's hungry value
	 * @param hungry
	 */
	public void setHungry(int hungry) {
		this.hungry = hungry;
	}

	/**
	 * get pet's tired value
	 * @return tired value
	 */
	public int getTired() {
		return tired;
	}

	/**
	 * set pet's tired value
	 * @param tired
	 */
	public void setTired(int tired) {
		this.tired = tired;
	}

	/**
	 * get pet's weight
	 * @return pet's weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * set pet's weight
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * get pet's health
	 * @return
	 */
	public int getPetHealth() {
		return petHealth;
	}

	/**
	 * set pet's health
	 * @param petHealth
	 */
	public void setPetHealth(int petHealth) {
		this.petHealth = petHealth;
	}

	/**
	 * get pet's feed value
	 * @return petfeed value
	 */
	public int getPetFeed() {
		return petFeed;
	}

	/**
	 * set pet's feed value
	 * @param petFeed
	 */
	public void setPetFeed(int petFeed) {
		this.petFeed = petFeed;
	}
	
	/**
	 * Check status of pets.
	 * 
	 */
	public void checker(){
		// check whether your pet is hungry
		if (isHungry() && !isDead()){
			//System.out.println("Your pet need to get something to eat.");
			JOptionPane.showMessageDialog(null,
					   "Your pet need to get something to eat.",
					    "Alert!",
					    JOptionPane.ERROR_MESSAGE);
			
			petHealth -= 20;
			petMood -= 10;
		}
		
		// check whether your pet is misbehaviour
		if (isMisbehaving()){
		}
		// check whether your pet is tired
		if (isTired() && !isDead()){
			//System.out.println("Your pet need to go to sleep.");
			JOptionPane.showMessageDialog(null,
					   "Your pet need to go to sleep.",
					    "Alert!",
					    JOptionPane.ERROR_MESSAGE);
			petHealth -= 10;
			petMood -= 10;
		}
		// check your pet if it is too full
		if (petFeed >= 80){
			JOptionPane.showMessageDialog(null,
					   "Your pet is too full, please go to toilet.",
					    "Alert!",
					    JOptionPane.ERROR_MESSAGE);
			//System.out.println("Your pet is too full, please go to toilet.");
			petHealth -= 10;
		}
		
		// check whether your pet is private unhealthy
		// isSick == true, petHealth -= 5, petMoodValue -= 10
		if (isSick()){
			JOptionPane.showMessageDialog(null,
					   "Your pet is sick.",
					    "Alert!",
					    JOptionPane.ERROR_MESSAGE);
			//System.out.println("Your pet is sick.");
			petHealth -= 5;
			petMood -= 10;
		}
		
		/*
		 * to set up the up limit and low limit
		 */
		if (petFeed > 100){
			petFeed = 100;
		}
		
		if (petFeed < 0){
			petFeed = 0;
		}
		
		if (petHealth > 100){
			petHealth = 100;
		}
		
		if (petMood > 100)
		{
			petMood = 100;
		}
		
		if (petMood < 0){
			petMood = 0;
		}
		
		if (weight > 100){
			weight = 100;
		}
		
		if (weight < 0)
		{
			weight = 0;
		}
		
		if (tired > 100){
			tired = 100;
		}
		
		if (tired  < 0){
			tired = 0;
		}
		
		// check whether is dead
		if (isDead()) {
			if (!canRevive) {
				//System.out.println("Your pet is dead, and cannot be revived.");// to revive or not
				JOptionPane.showMessageDialog(null,
						   "Your pet is dead, and cannot be revived.",
						    "Alert!",
						    JOptionPane.ERROR_MESSAGE);
				petDead();
			}
			else {
				while (canRevive) {
					JOptionPane.showMessageDialog(null,
							   "Your pet is dead.",
							    "Alert!",
							    JOptionPane.ERROR_MESSAGE);
					//System.out.println("Your pet is dead.");// to revive or not
					//System.out.println("Would you like to revive your pet?");
					//System.out.println("1. Yes");
					//System.out.println("2. No");
					Scanner sc = new Scanner(System.in);
					String isRevive;
					isRevive = sc.next();
		
					if (isRevive.equals("1")){
						//reset all revived pet's attributes to default value
							petMood = 50;
							hungry = 50; 
							tired = 50;
							weight = 50;
							misbehaving = false;
							petHealth = 50;
							petFeed = 50;
							canRevive = true;
						//System.out.println("Your pet is revived!");
						canRevive = false;
					}
					else if(isRevive.equals("2")){
						//Pet cannot revive anymore.
						canRevive = false;
						petDead();
					}
					else {
						//System.out.println("Please re-enter a valid number");
					}
				}
			}
		}
	}
	
	/**
	 * set all pet attributes to -1 when pet is dead.	
	 */
	private void petDead() {
		petMood = -1;
		hungry = -1; 
		tired = -1;
		weight = -1;
		misbehaving = false;
		petHealth = -1;
		petFeed = -1;
		canRevive = false;
	}

	/**
	 * ask what food the player wants to feed the pet with
	 * @return foodChoise
	 */
	public int feedInput(){
		Scanner sc = new Scanner(System.in);
		while(true){
			try {
				return foodChoise = sc.nextInt();
				}
			catch(Exception e){
				sc.next();
				System.out.println("Please re-enter a valid number");
			}
		}
	}	
	
	/**
	 * to show what food in the food inventory for current player
	 * @param player is current player
	 */
	public void foodQuantityShow(Player player){
		System.out.println(("1: " + foodShopInventory.get(0).getName() + " Quantity: " + player.getFoodQuantity(new Bamboo())));
		System.out.println(("2: " + foodShopInventory.get(1).getName() + " Quantity: " + player.getFoodQuantity(new Salmon())));
		System.out.println(("3: " + foodShopInventory.get(2).getName() + " Quantity: " + player.getFoodQuantity(new Carrot())));
		System.out.println(("4: " + foodShopInventory.get(3).getName() + " Quantity: " + player.getFoodQuantity(new Laksa())));
		System.out.println(("5: " + foodShopInventory.get(4).getName() + " Quantity: " + player.getFoodQuantity(new Kebab())));
		System.out.println(("6: " + foodShopInventory.get(5).getName() + " Quantity: " + player.getFoodQuantity(new Chocolatecake())));
	}
	/**
	 * to show what toy are in the toy inventory for current player
	 * @param player is current player
	 */
	
	public void toyShow(Player player){
		System.out.println("==============Toy Inventory================");
		System.out.println("You have");
		List<ToyItem> toys = player.getToys();
		int a = 0;
		if (toys.isEmpty()) {
			System.out.println("No toys!");
		}
		else {
			for (ToyItem toy : toys) {
				System.out.print(new Integer(a+1).toString()  +  ". " + toy.getName());
				System.out.println(" Durability is " + toy.getDurability());
				a++;
			}
		}
	}
	
	/**
	 * current will choose food to feed the pet
	 * @param player is current player
	 * @param pet is current pet
	 */
	public void feed(Player player, Pet pet){
		GameEnvi game = new GameEnvi();
		Scanner in = new Scanner(System.in);
		System.out.println("Please select food from your food inventory below:"); 
		foodShopInit();
		// prints out current Player's food inventory
		foodQuantityShow(player);
	
		feedInput();
		
		while (foodChoise < 1 | foodChoise > 6){
			System.out.println("Please re-enter a valid number");
			foodQuantityShow(player);
			feedInput();
		}
		FoodItem feedFood = null;
		if (foodChoise == 1){
			feedFood = new Bamboo();
		}
		else if (foodChoise == 2){
			feedFood = new Salmon();
		}
		else if (foodChoise == 3){
			feedFood = new Carrot();
		} 
		else if (foodChoise == 4){
			feedFood = new Laksa();
		} 
		else if (foodChoise == 5){
			feedFood = new Kebab();
		} 
		else if (foodChoise == 6){
			feedFood = new Chocolatecake();
		} 
		
		while (player.getFoodQuantity(feedFood) == 0){
			System.out.println("You don't have enough food, please select another one or enter food store");
			foodQuantityShow(player);
			System.out.println( "7. Visit Food Store");
			feedInput();
			
			feedFood = null;
			if (foodChoise == 1){
				feedFood = new Bamboo();
			}
			else if (foodChoise == 2){
				feedFood = new Salmon();
			}
			else if (foodChoise == 3){
				feedFood = new Carrot();
			} 
			else if (foodChoise == 4){
				feedFood = new Laksa();
			} 
			else if (foodChoise == 5){
				feedFood = new Kebab();
			} 
			else if (foodChoise == 6){
				feedFood = new Chocolatecake();
			} 
			while (foodChoise < 1 | foodChoise > 7){
				System.out.println("Please re-enter a valid number");
				foodQuantityShow(player);
				System.out.println( "7. Visit Food Store");
				feedInput();
			}
			
			if (foodChoise == 7){
				game.getFoodShop().buyFood(player);
				System.out.println("==============================================");
				System.out.println("Please select food from your food inventory below:"); 
				foodQuantityShow(player);
				feedInput();
				feedFood = null;
				if (foodChoise == 1){
					feedFood = new Bamboo();
				}
				else if (foodChoise == 2){
					feedFood = new Salmon();
				}
				else if (foodChoise == 3){
					feedFood = new Carrot();
				} 
				else if (foodChoise == 4){
					feedFood = new Laksa();
				} 
				else if (foodChoise == 5){
					feedFood = new Kebab();
				} 
				else if (foodChoise == 6){
					feedFood = new Chocolatecake();
				} 
				}
			}
		feed(feedFood);
		player.useFood(feedFood);
		checker();
	}

	/**
	 * check if the food is pet fav food, dislike food or just normal food
	 * @param food is the food has been choose from the player
	 */
	public void feed(FoodItem food){
		if (food.equals(getFavFood()))
		{
			weight += food.getNutrition() * 2;
			hungry -= 15;
			petMood += 10;
			petHealth += 10;	
			petFeed += 20;
		}
		else if (food.equals(getDislikeFood()))
		{
			weight += 1;
			hungry -= 5;
			petMood -= 5;
			petHealth -= 5;	
			petFeed += 2;
		}
		else {
			weight += food.getNutrition();
			hungry -= 5;
			petMood += 5;
			petHealth += 5;	
			petFeed +=10;
		}
	}
	/**
	 * ask what toy the player wants for the pet to play
	 * @return toyChoise
	 */
	public int playInput(){
		Scanner sc = new Scanner(System.in);
		while(true){
			try {
				return toyChoise =sc.nextInt();
				}
			catch(Exception e){
				sc.next();
				System.out.println("Please re-enter a valid number");
			}
		}
	}
	
	/**
	 * Pet Play with a choosen toy.
	 * @param player is current player
	 * @param pet is current pet
	 */
	public void play(Player player, Pet pet){
		GameEnvi game = new GameEnvi();
		Scanner in = new Scanner(System.in);
		System.out.println("Please select toy from your toy inventory below:");
		toyShopInit();
		
		if (player.getNumToys() == 0){
			System.out.println("Your have no toy!");
			System.out.println("Press any key to visit Toy Store");
			in.nextLine();
			game.getToyShop().buyToy(player);
			System.out.println("Please select toy from your toy inventory below:");
			toyShow(player);
			playInput();
		}
		else{
			toyShow(player);
			playInput();
		}
	
		List<ToyItem> toys = player.getToys();
		ToyItem playToy = null;

		while (toyChoise < 1 | toyChoise > player.getNumToys()){
			System.out.println("Please re-enter a valid number");
			toyShow(player);
			playInput();
		}
		
		if (toyChoise == 1){
			playToy = toys.get(0);
			}
		else if (toyChoise == 2){
			playToy = toys.get(1);
			}
		else if (toyChoise == 3){
			playToy = toys.get(2);
			}
		else if (toyChoise == 4){
			playToy = toys.get(3);
			}
		else if (toyChoise == 5){
			playToy = toys.get(4);
			}
		else if (toyChoise == 6){
			playToy = toys.get(5);
			}
		
		while (player.getToyDurability(playToy) < pet.aggressiveness){
			System.out.println("Your toy's durability is too low, please select another one or enter toy store");
			toyShow(player);
			System.out.println((player.getNumToys() + 1) + ". Visit Food Store");
			playInput();
			
			if (toyChoise == player.getNumToys() + 1){
				game.getToyShop().buyToy(player);
				System.out.println("==============================================");
				System.out.println("Please select toy from your toy inventory below:"); 
				toyShow(player);
				playInput();
				while (toyChoise < 1 | toyChoise > player.getNumToys()){
					System.out.println("Please re-enter a valid number");
					toyShow(player);
					playInput();
				}
				
				if (toyChoise == 1){
					playToy = toys.get(0);
					}
				else if (toyChoise == 2){
					playToy = toys.get(1);
					}
				else if (toyChoise == 3){
					playToy = toys.get(2);
					}
				else if (toyChoise == 4){
					playToy = toys.get(3);
					}
				else if (toyChoise == 5){
					playToy = toys.get(4);
					}
				else if (toyChoise == 6){
					playToy = toys.get(5);
					}
			}
			}
		play(playToy);
		player.useToy(playToy, pet);
		checker();
	}
	
	/**
	 * check if toy is fav toy or normal toy for the current pet
	 * @param toy, player choose toy for the pet
	 */
	public void play(ToyItem toy){
		if (toy.equals(getFavToy()))
		{
			petMood += toy.getHappypoint() * 2;
			petHealth += 10;	
			petFeed -= 20;
			hungry += 20;
			tired += 20;			
		}
		else {
			petMood += toy.getHappypoint();
			petHealth += 5;	
			petFeed -= 10;
			hungry += 10;
			tired += 20;
		}
	}
	
	public void sleep(){
		petHealth += 20;
		tired -= 20;
		hungry += 5;
		checker();
	}
	
	public void toilet(){
		petFeed -= 20;
		checker();
	}	
}

/**
 * 
 * extend all the pet's attribute for the pet class
 * override fav food, dislike food and fav toy
 *
 */
 //extends turtle to animals and construct turtle
class Turtle extends Pet { 	
	public Turtle(String inputPetName) {
		super();
		animalSpecies = "Turtle";
		aggressiveness = 12;
		petName = inputPetName;
		petMood = 40;
		hungry = 30; 
		tired = 40;
		weight = 50;
		misbehaving = false;
		petHealth = 70;
		petFeed = 50;
		canRevive = true;
		petPic = new ImageIcon(Pet.class.getResource("/pet_pics/turtle.png"));
	}

	@Override
	public FoodItem getFavFood() {
		return new Salmon();
	}

	@Override
	public FoodItem getDislikeFood() {
		return new Chocolatecake();
	}
	
	@Override
	public ToyItem getFavToy() {
		return new NinjaTurtle();
	}
}


//extends kiwiBird to animals and construct kiwiBird
class KiwiBird extends Pet{
	public KiwiBird(String inputPetName) {
		super();
		animalSpecies = "Kiwi Bird";
		aggressiveness = 20;
		petName = inputPetName;
		petMood = 30;
		hungry = 45; 
		tired = 60;
		weight = 70;
		misbehaving = false;
		petHealth = 70;
		petFeed = 55;
		canRevive = true;
		petPic = new ImageIcon(Pet.class.getResource("/pet_pics/kiwi_bird.png"));
	}
	@Override
	public FoodItem getFavFood() {
		return new Kebab();
	}

	@Override
	public FoodItem getDislikeFood() {
		return new Salmon();
	}
	
	@Override
	public ToyItem getFavToy() {
		return new Lego();
	}
}

//extends wolf to animals and construct wolf
class Wolf extends Pet{
	public Wolf(String inputPetName){
		super();
		animalSpecies = "Wolf";
		aggressiveness = 28;
		petName = inputPetName;
		petMood = 55;
		hungry = 45; 
		tired = 45;
		weight = 50;
		misbehaving = false;
		petHealth = 60;
		petFeed = 50;
		canRevive = true;
		petPic = new ImageIcon(Pet.class.getResource("/pet_pics/wolf.png"));
	}
	@Override
	public FoodItem getFavFood() {
		return new Carrot();
	}

	@Override
	public FoodItem getDislikeFood() {
		return new Laksa();
	}
	
	@Override
	public ToyItem getFavToy() {
		return new Pikachu();
	}
}

//extends panda to animals and construct panda
class Panda extends Pet{
	public Panda(String inputPetName) {
		super();
		animalSpecies = "Panda";
		aggressiveness = 6;
		petName = inputPetName;
		petMood = 40;
		hungry = 60; 
		tired = 40;
		weight = 55;
		misbehaving = false;
		petHealth = 60;
		petFeed = 55;
		canRevive = true;
		petPic = new ImageIcon(Pet.class.getResource("/pet_pics/panda.png"));
	}
	
	@Override
	public FoodItem getFavFood() {
		return new Bamboo();
	}
	
	@Override
	public FoodItem getDislikeFood() {
		return new Kebab();
	}
	@Override
	public ToyItem getFavToy() {
		return new ToyCar();
	}
}

//extends hawk to animals and construct hawk
class Hawk extends Pet{
	public Hawk(String inputPetName) {
		super();
		animalSpecies = "Hawk";
		aggressiveness = 21;
		petName = inputPetName;
		petMood = 40;
		hungry = 45; 
		tired = 40;
		weight = 50;
		misbehaving = false;
		petHealth = 60;
		petFeed = 50;
		canRevive = true;
		petPic = new ImageIcon(Pet.class.getResource("/pet_pics/hawk.png"));
	}
	
	@Override
	public FoodItem getFavFood() {
		return new Kebab();
	}
	
	@Override
	public FoodItem getDislikeFood() {
		return new Laksa();
	}
	@Override
	public ToyItem getFavToy() {
		return new StarWars();
	}
}

class Whale extends Pet {
	public Whale(String inputPetName) {
		super();
		animalSpecies = "Whale";
		aggressiveness = 28;
		petName = inputPetName;
		petMood = 55;
		hungry = 60; 
		tired = 55;
		weight = 55;
		misbehaving = false;
		petHealth = 70;
		petFeed = 55;
		canRevive = true;
		petPic = new ImageIcon(Pet.class.getResource("/pet_pics/whale.png"));
	}
	@Override
	public FoodItem getFavFood() {
		return new Chocolatecake();
	}
	
	@Override
	public FoodItem getDislikeFood() {
		return new Bamboo();
	}
	@Override
	public ToyItem getFavToy() {
		return new BarbieDoll();
	}
}