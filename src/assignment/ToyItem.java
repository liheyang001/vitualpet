package assignment;

/**
 * 
 * @author Aaron Bong and Heyang Li
 * extends all toys into toy item.
 * so they are going to inherit all attribute that toy item has.
 * set the name, durability, happiness and price for each toy.
 */
class Lego extends ToyItem{
	public Lego(){
		super("LEGO", 100, 10, 65);
	}
}

class BarbieDoll extends ToyItem{
	public BarbieDoll(){
		super("Barbie Doll", 100, 12, 50);
	}
}

class NinjaTurtle extends ToyItem{
	public NinjaTurtle(){
		super("NinjaTurtle", 80, 15, 28);
	}
}

class StarWars extends ToyItem{
	public StarWars(){
		super("StarWars", 100, 20, 73);
	}
}

class Pikachu extends ToyItem{
	public Pikachu(){
		super("Pikachu", 85, 7, 39);
	}
}

class ToyCar extends ToyItem{
	public ToyCar(){
		super("toyCar", 90, 11, 45);
	}
}

/**
 * 
 * Initialize all attribute to toy items.
 *
 */
public class ToyItem {
	private String name;
	private int durability;
	private int happypoint;
	private int price;
	
	public ToyItem(String name, int durability, int happypoint, int price) {
		this.name = name;
		this.durability = durability;
		this.happypoint = happypoint;
		this.price = price;
	}
	
	/**
	 * get toy name
	 * @return toy name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * get toy's durability
	 * @return toy durability
	 */
	public int getDurability(){
		return durability;
	}
	
	/**
	 * when pet play toy, it pass in the aggressive, so toy's durability will deducted 
	 * @param value
	 */
	public void setDurability(int value){
		this.durability -= value;
	}
	
	/**
	 * Decreases toy by specified amount, toy is destroyed when durability less or equal to 0 
	 * @param amount the amount of damage dones to the toy
	 * @return true if toy is destroyed, false otherwise
	 */
	public boolean decreaseDurability(int amount) {
		if (durability - amount <= 0) {
			durability = 0;
			return true;
		}
		durability -= amount;
		return false;
	}
	
	/**
	 * get happy point for toy
	 * @return happy point
	 */
	public int getHappypoint(){
		return happypoint;
	}
	
	/**
	 * get toy's price
	 * @return toy price
	 */
	public int getPrice(){
		return price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ToyItem))
			return false;
		ToyItem other = (ToyItem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
