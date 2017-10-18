/**
 * 
 */
package assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author hli60
 *
 */
public class ShopTest {

	@Rule 
	public ExpectedException thrown = ExpectedException.none();
		Player player;
		ToyItem ToyCar;
		Map<FoodItem, Integer> foodInventory = new HashMap<>();
		ToyShop toyshop;
		List <ToyItem> toyItem;
		FoodShop foodshop;
		FoodItem salmon;
		

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = new Player();
		ToyCar = new ToyItem("toyCar",90, 11, 45);
		toyshop = new ToyShop();
		toyItem = new ArrayList<>();
		foodshop = new FoodShop();
		salmon = new FoodItem("Salmon",25,15);
	}

	@Test
	public void testBuyToy() {
		player.getMoney();
		toyshop.chosenToy = 6;
		toyshop.buyToy(player);
		toyItem.add(ToyCar);
		try{
			toyshop.chosenToy = 7;
		} catch (Exception e){
		}
		assertEquals(955, player.getMoney());
		assertEquals(ToyCar.getName(), player.getToys().get(0).getName());

	}
	@Test
	public void testBuyFood() {
		assertEquals(1000, player.getMoney());
		
		player.getMoney();
		foodshop.chosenFood = 2;
		foodshop.purchaseNum = 200;
		assertEquals(1000, player.getMoney());
		
		foodshop.chosenFood = 2;
		foodshop.purchaseNum = 10;
		foodshop.buyFood(player);
		
		try{
			foodshop.chosenFood = 7;
			foodshop.purchaseNum = -1;
		} catch (Exception e){
		}
		
		assertEquals(850, player.getMoney());
	}
}
