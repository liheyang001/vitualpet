package assignment;

/**
 * 
 * @author Aaron Bong and Heyang Li
 * extends all food into food item.
 * so they are going to inherit all attribute that food item has.
 * set the name, nutrition value and price for each food.
 */
class Bamboo extends FoodItem{
	public Bamboo(){
		super("Bamboo", 20, 10);
	}
}

class Salmon extends FoodItem{
	public Salmon(){
		super("Salmon", 25, 15);
	}
}

class Carrot extends FoodItem{
	public Carrot(){
		super("Carrot", 10, 8);
	}
}

class Laksa extends FoodItem{
	public Laksa(){
		super("Laksa", 12, 11);
	}
}

class Kebab extends FoodItem{
	public Kebab(){
		super("Kebab", 8, 13);
	}
}

class Chocolatecake extends FoodItem{
	public Chocolatecake(){
		super("Chocolate cake", 9, 17);
	}
}

/**
 * 
 * Initialize all attribute to food items.
 *
 */
public class FoodItem {

	private String name;
	private int nutrition;
	private int price;
	
	public FoodItem(String name, int nutrition, int price) {
		this.name = name;
		this.nutrition = nutrition;
		this.price = price;
	}
	
	/**
	 * get food name
	 * @return food name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * get nutrition value
	 * @return nutrition value
	 */
	
	public int getNutrition() {
		return nutrition;
	}
	
	/**
	 * get food price
	 * @return food price
	 */
	public int getPrice() {
		return price;
	}
	/*
	public static FoodItem laksa() {
		return new FoodItem("Laksa", 2);
	}
	
	public static FoodItem chocolateCake() {
		return new FoodItem("Chocolate Cake", 10);
	}
	*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItem other = (FoodItem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

