package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.PERSIST_STORE;

/**
 * 
 * @author Aaron Bong and Heyang Li
 * Initialize all related variables
 */

public class ConsoleGUI {
	private GameEnvi game = new GameEnvi();
	
	/*
	 * initialise all variables required for Console Gui
	 */
	private ArrayList<String> playersName = new ArrayList<>();
	private ArrayList<String> petName = new ArrayList<>();
	private ArrayList<Integer> chosenSpeciesArray = new ArrayList<>();
	
	private static Scanner sc = new Scanner(System.in);
	private int choosenValue;
	private int actionInput;
	private int numPet;
	
	/**
	 * create new Console GUI and player
	 * add first player inside of the game
	 * run gameInstruction for the player
	 * @param args unused
	 */
	public static void main(String[] args) {
		ConsoleGUI cg = new ConsoleGUI();
		int dayCounter;
		Player player1 = new Player(); // minimum one player
		cg.game.addPlayer(player1);
		cg.gameInstruction();	
		int tempScore = 0;
		/*
		 * ask for the player how many 
		 */
		while(true){
			System.out.println("How many days would you like to play?");
			String inputDayCounter = "";
			inputDayCounter = sc.nextLine();
			dayCounter = Integer.parseInt(inputDayCounter);
			if (isInt(inputDayCounter) == false){
				System.out.println("It is not a valid input, please enter a number.");
				continue;
			}
			else if (Integer.parseInt(inputDayCounter) <= 0 || Integer.parseInt(inputDayCounter) > 100){
				System.out.println("It is not a valid input, please enter a valid number.");
				continue;
			}
			else{
				cg.game.setDayCounter(Integer.parseInt(inputDayCounter));
				break;
			}
		}
		
		
		while(true){
			System.out.println("Please enter how many Player(1-3)");
			String numPlayers = "";
			numPlayers = sc.nextLine();
			if (isInt(numPlayers) == false){
				System.out.println("It is not a valid input, please enter a number.");
			}
			else if (Integer.parseInt(numPlayers) <= 0 || Integer.parseInt(numPlayers) > 3){
				System.out.println("It is not a valid input, please enter a valid number.");
			}
			else{
				cg.game.setNumPlayer(Integer.parseInt(numPlayers));
				break;
			}
		}
		
		if (cg.game.getNumPlayer() == 2){
			Player player2 = new Player();
			cg.game.addPlayer(player2);
		}
		
		else if(cg.game.getNumPlayer() == 3){
			Player player2 = new Player();
			Player player3 = new Player();
			cg.game.addPlayer(player2);
			cg.game.addPlayer(player3);
		}
		// Player class should have all the detail about the Player
		// there could have 1-3 players
		
		int playerCounter = 1;
		for (Player currentPlayer : cg.game.getPlayers()){
			System.out.println("Please enter Player " + (playerCounter) + " name:");
			String playerName = sc.nextLine();
			while (cg.playersName.contains(playerName)){
				System.out.println("Please re-enter a different name:");
				playerName = sc.nextLine();
				}
			cg.playersName.add(playerName);
			currentPlayer.setName(playerName);
			playerCounter += 1;
			}
		
		//=====================choose pet================================//
		
		//time to choose your pet
		for (Player currentPlayer : cg.game.getPlayers()){
			cg.chosenSpeciesArray.clear();
			int chosenPetSpecies;
			while(true){
				System.out.println(currentPlayer.getName() + ": how many pet(s) would you like to choose?");
				System.out.println("Please choose between 1 and 3.");
				String numPet = sc.nextLine();
				if (isInt(numPet) == false){
					System.out.println("It is not a valid input, please enter a number.");
				}
				else if (Integer.parseInt(numPet) <= 0 || Integer.parseInt(numPet) > 3){
					System.out.println("It is not a valid input, please enter a valid number.");
				}
				else{
					cg.numPet = (Integer.parseInt(numPet));
					break;
				}
			}
			
			for (int petNameLoop = 1; petNameLoop <= cg.numPet; petNameLoop++){
				
				while(true){
					System.out.println(currentPlayer.getName() + ": Please choose your number " + petNameLoop +" pet:");
					System.out.println("1.Turtle");
					System.out.println("2.Kiwi Bird");
					System.out.println("3.Wolf");
					System.out.println("4.Panda");
					System.out.println("5.Hawk");
					System.out.println("6.Whale");
					String strChosenPetSpecies = sc.nextLine();
					if (isInt(strChosenPetSpecies) == false){
						System.out.println("It is not a valid input, please enter a number.");
					}
					else if (Integer.parseInt(strChosenPetSpecies) <= 0 || Integer.parseInt(strChosenPetSpecies) > 6){
						System.out.println("It is not a valid input, please enter a valid number.");
					}
					else{
						chosenPetSpecies = Integer.parseInt(strChosenPetSpecies);
						while (cg.chosenSpeciesArray.contains(chosenPetSpecies)){
							System.out.println("Please re-enter a different number");
							strChosenPetSpecies = sc.nextLine();
							if (isInt(strChosenPetSpecies) == false){
								System.out.println("It is not a valid input, please enter a number.");
							}
							else if (Integer.parseInt(strChosenPetSpecies) <= 0 || Integer.parseInt(strChosenPetSpecies) > 6){
								System.out.println("It is not a valid input, please enter a valid number.");
							}
							else{
								chosenPetSpecies = Integer.parseInt(strChosenPetSpecies);
							}
						}
						cg.chosenSpeciesArray.add(chosenPetSpecies);
						break;
					}
				}
				
				System.out.println("Please enter pet " + petNameLoop + " name:");
				String petName = sc.nextLine();
				while (cg.petName.contains(petName)){
					System.out.println("Please re-enter a different name:");
					petName = sc.nextLine();
					}
				cg.petName.add(petName);
				
				if (chosenPetSpecies == 1){
					currentPlayer.addPet(new Turtle(petName));
				}
				else if (chosenPetSpecies == 2){
					currentPlayer.addPet(new KiwiBird(petName));
				} 
				else if (chosenPetSpecies == 3){
					currentPlayer.addPet(new Wolf(petName));
				}
				else if (chosenPetSpecies == 4){
					currentPlayer.addPet(new Panda(petName));
				}
				else if (chosenPetSpecies == 5){
					currentPlayer.addPet(new Hawk(petName));
				}
				else if (chosenPetSpecies == 6){
					currentPlayer.addPet(new Whale(petName));
				}
			}
		}
		
		for (int numDay = 0; numDay < cg.game.getDayCounter(); numDay++){//how many days we gonna loop
			for (int playerTurn = 0; playerTurn < cg.game.getNumPlayer(); playerTurn++){//how many players its gonna loop
				outerloop:
				for (int petTurn = 0; petTurn < cg.game.getPlayer(playerTurn).getNumPets(); petTurn++){//how many pet its gonna loop
					for (int actions = 2; actions > 0; actions--){//reset actions
					// check if the pet is still alive
						if (cg.game.getPlayer(playerTurn).getPet(petTurn).isDead()){
							break;
						}
					
					// check if the action == 0, move to next pet or next player
				
						System.out.println("Welcome to day " + (numDay + 1) + ".");
						System.out.println("Player: " + cg.game.getPlayer(playerTurn).getName());
						System.out.println("Pet: " + cg.game.getPlayer(playerTurn).getPet(petTurn).petName);	
						
						while(true){
							cg.printActions();
							String actionInput = sc.nextLine();
							if (isInt(actionInput) == false){
								System.out.println("It is not a valid input, please enter a number.");
							}
							else if (Integer.parseInt(actionInput) <= -1 || Integer.parseInt(actionInput) > 11){
								System.out.println("It is not a valid input, please enter a valid number.");
							}
							else{
								cg.actionInput = Integer.parseInt(actionInput);
								break;
							}
						}
						
						if (cg.actionInput == 0){			
							actions = actions + 1; //this is not counted as an action
							System.out.println("==============Financial Statement================");
							System.out.println("You have " + cg.game.getPlayer(playerTurn).getMoney() + ".");	
							System.out.println("Press any key to continue");
							sc.nextLine();
						}
				
						else if (cg.actionInput == 1){
							actions = actions + 1; //this is not counted as an action
							System.out.println("==============Your Current Pet Stats is================");
							System.out.println("Your pet's mood value is " + cg.game.getPlayer(playerTurn).getPet(petTurn).getPetMood() + ".");
							System.out.println("Your pet's hungry value is " + cg.game.getPlayer(playerTurn).getPet(petTurn).getHungry() + ".");
							System.out.println("Your pet's tired value is " + cg.game.getPlayer(playerTurn).getPet(petTurn).getTired() + ".");
							System.out.println("Your pet's weight is " + cg.game.getPlayer(playerTurn).getPet(petTurn).getWeight() + ".");
							System.out.println("Your pet's health is " + cg.game.getPlayer(playerTurn).getPet(petTurn).getPetHealth() + ".");
							System.out.println("Your pet's feed value is " + cg.game.getPlayer(playerTurn).getPet(petTurn).getPetFeed() + ".");

							System.out.println("Press any key to continue");
							sc.nextLine();
						}
							
					
				
						else if (cg.actionInput == 2){
							actions = actions + 1; //this is not counted as an action
							System.out.println("==============Food Inventory================");
							System.out.println("You have");
							System.out.println(cg.game.getPlayer(playerTurn).getFoodQuantity(new Bamboo())+ " Bamboo");
							System.out.println(cg.game.getPlayer(playerTurn).getFoodQuantity(new Salmon()) + " Salmon");
							System.out.println(cg.game.getPlayer(playerTurn).getFoodQuantity(new Carrot()) + " Carrot");
							System.out.println(cg.game.getPlayer(playerTurn).getFoodQuantity(new Laksa()) + " Laksa");
							System.out.println(cg.game.getPlayer(playerTurn).getFoodQuantity(new Kebab()) + " Kebab");
							System.out.println(cg.game.getPlayer(playerTurn).getFoodQuantity(new Chocolatecake()) + " Chocolate Cake");
							System.out.println("=============================================");
							System.out.println("Press any key to continue");
							sc.nextLine();
							}
					
				
						else if (cg.actionInput == 3){
							actions = actions + 1; //this is not counted as an action
							System.out.println("==============Toy Inventory================");
							System.out.println("You have");
							List<ToyItem> toys = cg.game.getPlayer(playerTurn).getToys();
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
							System.out.println("===========================================");
							System.out.println("Press any key to continue");
							sc.nextLine();
						}
			
						else if (cg.actionInput == 4){
							System.out.println("==============Visit Food Store================");
							actions += 1;
							cg.game.getFoodShop().buyFood(cg.game.getPlayer(playerTurn));
							System.out.println("==============================================");
							System.out.println("Press any key to continue");
							sc.nextLine();
							}
						
						
						else if (cg.actionInput == 5){
							System.out.println("==============Visit Toy Store================");
							actions += 1;
							cg.game.getToyShop().buyToy(cg.game.getPlayer(playerTurn));
							System.out.println("=============================================");
							System.out.println("Press any key to continue");
							sc.nextLine();
							}

		
						else if (cg.actionInput == 6){
							System.out.println("==============Feed Pet=========================");	
							cg.game.getPlayer(playerTurn).getPet(petTurn).feed(cg.game.getPlayer(playerTurn), cg.game.getPlayer(playerTurn).getPet(petTurn));
							System.out.println("===============================================");
							actions -= 1;
							System.out.println("You have " + (actions) + " action left.");
							actions +=1;
							System.out.println("Press any key to continue");
							sc.nextLine();
							}
						
						else if (cg.actionInput == 7){
							System.out.println("==============Play With Pet========================");	
							cg.game.getPlayer(playerTurn).getPet(petTurn).play(cg.game.getPlayer(playerTurn), cg.game.getPlayer(playerTurn).getPet(petTurn));
							System.out.println("===================================================");
							actions -= 1;
							System.out.println("You have " + (actions) + " action left.");
							actions +=1;
							System.out.println("Press any key to continue");
							sc.nextLine();
							}
						
						else if(cg.actionInput == 8){
							System.out.println("==============Pet is going to sleep...ZZZzzz========================");
							cg.game.getPlayer(playerTurn).getPet(petTurn).sleep();
							actions -= 1;
							System.out.println("You have " + (actions) + " action left.");
							actions +=1;
							System.out.println("Press any key to continue");
							sc.nextLine();
							}
						
						else if(cg.actionInput == 9){
							System.out.println("==============Pet is going to go to toilet...Please don't look========================");
							cg.game.getPlayer(playerTurn).getPet(petTurn).toilet();
							actions -= 1;
							System.out.println("You have " + (actions) + " action left.");
							actions +=1;
							System.out.println("Press any key to continue");
							sc.nextLine();
							}
						
					    else if(cg.actionInput == 10){
					    	System.out.println("================Move to the next player===========================");
					    	break;
					    }
						
					    else if (cg.actionInput == 11){
					    	
					    	System.out.println("================Today is End===========================");
					    	if (cg.game.getPlayer(playerTurn).getPet(petTurn).isDead() == false){
								cg.game.getPlayer(playerTurn).getPet(petTurn).checker();
								System.out.println("Random Event!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!DANGDANGDANG");
								cg.random_event(cg.game.getPlayer(playerTurn), cg.game.getPlayer(playerTurn).getPet(petTurn));
								System.out.println("Press any key to continue");
								sc.nextLine();
							}
					    	break outerloop;
					    }
					}
				
				//=========================Random Event Time===========================================
				if (cg.game.getPlayer(playerTurn).getPet(petTurn).isDead() == false){
					cg.game.getPlayer(playerTurn).getPet(petTurn).checker();
					System.out.println("Random Event!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!DANGDANGDANG");
					cg.random_event(cg.game.getPlayer(playerTurn), cg.game.getPlayer(playerTurn).getPet(petTurn));
					System.out.println("Press any key to continue");
					sc.nextLine();
				}

			}
			for (int temp = 0; temp < cg.game.getPlayer(playerTurn).getNumPets(); temp++){
				tempScore = cg.game.getPlayer(playerTurn).getPet(temp).petMood + 
						cg.game.getPlayer(playerTurn).getPet(temp).hungry +
						cg.game.getPlayer(playerTurn).getPet(temp).tired +
						cg.game.getPlayer(playerTurn).getPet(temp).weight +
						cg.game.getPlayer(playerTurn).getPet(temp).petHealth +
						cg.game.getPlayer(playerTurn).getPet(temp).petFeed +
						cg.game.getPlayer(playerTurn).getMoney();
			}
			if (numDay == dayCounter - 1){
				System.out.println("Your Final Score is:");
				System.out.println(tempScore);
			}
			}
	}
}
	
	public void random_event(Player player, Pet pet){
		int rnd = (int)(Math.random()*100+1); // random value is 1-100
		int rndLotty = (int)(Math.random()*200+1);
		String rndEventChoose;
		if (rnd == 1 | rnd == 2){
			System.out.println("Your pet is died in the random disease!");
			pet.petHealth = -1;
			pet.checker();
		}
		else if (rnd >= 3 & rnd <= 10){
			System.out.println("Your pet feel sick by an strange alian power!");
			pet.petHealth = 19;
			pet.checker();
		}
		else if (rnd >= 11 & rnd <= 20){
			System.out.println("Your pet act strange and misbehaving, perhaps it trying to hack into this programme!");
			System.out.println("Time to do something, master!");
			pet.petHealth -= 10;//petHealth decrease by 10
			pet.petMood -= 10; //petMoodValue decrease by 10 
			
			while(true){
				System.out.println("Would you like spend $50 to go to vet for heal your pet into a normal status?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				rndEventChoose = sc.nextLine();
				if (isInt(rndEventChoose) == false){
					System.out.println("It is not a valid input, please enter a number.");
					continue;
				}
				else if (Integer.parseInt(rndEventChoose) < 1 || Integer.parseInt(rndEventChoose) > 2){
					System.out.println("It is not a valid input, please enter a valid number.");
					continue;
				}
				else{
					game.setRndEventChoose(Integer.parseInt(rndEventChoose));
					break;
				}
			}
			
			if (rndEventChoose.equals("1")){
				System.out.println("Your pet has been healed and into a normal status.");
				player.spendMoney(50);
				pet.petHealth = 50;
				pet.setMisbehaving(false);
			}
			else if (rndEventChoose.equals("2")){
				pet.setMisbehaving(true);
			}
			pet.checker();
		}
		
		else if (rnd >= 95){
			System.out.println("Your pet has won a lotty, $$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			player.spendMoney(-rndLotty);
		}
		else{
			System.out.println("No random event happened today, what a peaceful day!");
		}
	}
	
	public void gameInstruction(){
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|                                                                            |");
		System.out.println("|          This is a virtual pets game, game allows from 1-3 Player.         |");
		System.out.println("|Each Player could have up to 3 pets, each pets have up to 2 actions per day.|");
		System.out.println("|        Your pets will dead once the health point equal or below to 0.      |");
		System.out.println("|                 You could only revive your pet once.                       |");
		System.out.println("|                        Good luck and have fun!                             |");
		System.out.println("|                                                                            |");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	}
	
	/**
	 * Prints all actions player can choose to do.
	 */
	private void printActions(){
			System.out.println("You action are:");
			System.out.println("0. Print How Much Money You Have");
			System.out.println("1. Print Pet Stats");
			System.out.println("2. Print Current Player's Food Inventory");
			System.out.println("3. Print Current Player's Toy Inventory");
			System.out.println("4. Visit Food Store");
			System.out.println("5. Visit Toy Store");
			System.out.println("6. Feed Pet");
			System.out.println("7. Play With Pet");
			System.out.println("8. Put Pet To Sleep");
			System.out.println("9. Make Pet Visit The Bathroom");
			System.out.println("10. Finish For The Day");
			System.out.println("11. Move to the next player");
	}
	
	/**
	 * Allows player to input choises made.
	 * @return choosenValue is for player to choose his/her actions
	 */
	public int chooseInput(){
		while(true){
			try {
				choosenValue = sc.nextInt();
				return choosenValue;				
			}
			catch(Exception e){
				sc.nextLine();
				System.out.println("Please re-enter a valid number");
				printActions();
			}
		}
	}
	
	// check if a "string number" is an integer.
    // returns true or false
	/**
	 * help function to catch the wrong input
	 * @param integer
	 * @return an integer value
	 */
    public static boolean isInt(String integer) {
        boolean value;
        try {
            // try to convert the string in a number
            Integer.parseInt(integer);
            value = true;
        } catch (Exception e) {
            value = false;
        }
        return value;
    }
}
