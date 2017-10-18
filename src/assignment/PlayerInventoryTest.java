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
public class PlayerInventoryTest {

	@Rule 
	public ExpectedException thrown = ExpectedException.none();
		Player player;
		ToyItem toy;
		Map<FoodItem, Integer> foodInventory = new HashMap<>();
		FoodItem fish;
		FoodItem bone;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = new Player();
		toy = new ToyItem("toy",10,5,15);
	}

	@Test
	public void testAddToy() {
		player.addToy(toy);
		assertTrue(player.hasToy(toy));
	}
	
	@Test
	public void testGetToys(){
		player = new Player();
		player.addToy(toy);
		List <ToyItem> toyItem = new ArrayList<>();
		toyItem.add(toy);
		assertEquals(toyItem, player.getToys());
	}

	@Test
	public void testFoodQuantity(){
		player.addFood(fish, 5);
		assertEquals(5 ,player.getFoodQuantity(fish));
	}

	@Test
	public void testUseFood(){
		player.addFood(fish, 10);
		assertEquals(true, player.useFood(fish));
		Player player1 = new Player();
		player1.addFood(bone, 0);
		assertEquals(false, player1.useFood(bone));
	}


}
