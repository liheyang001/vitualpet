/**
 * 
 */
package assignment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Aaron Bong and Heyang Li
 *
 */
public class PetTest {

	@Rule 
	public ExpectedException thrown = ExpectedException.none();
		Player player;
		Pet pet1;
		Pet pet2;
		Pet pet3;
		FoodItem bamboo;
		ToyItem pc;
		ToyItem toyCar;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = new Player();
		pet1 = new Whale("Haha");
		pet2 = new Panda("Haha");
		pet3 = new Wolf("Mimi");
		bamboo = new Bamboo();
		pc = new ToyItem("pc", 10, 10, 10);
		toyCar = new ToyCar();//"Toy Car", 20, 20, 20);
	}

	@Test
	public void testHungry() {
		pet1.hungry = 19;
		assertEquals(true ,pet1.isHungry());
		pet2.hungry = 101;
		assertEquals(false ,pet2.isHungry());
	}
	
	@Test
	public void testTired() {
		pet1.tired = 19;
		assertEquals(false ,pet1.isTired());
		pet2.tired = 82;
		assertEquals(true ,pet2.isTired());
	}
	
	@Test
	public void testSick() {
		pet1.petHealth = 20;
		assertEquals(true ,pet1.isSick());
		pet2.petHealth = 19;
		assertEquals(true ,pet2.isSick());
		pet3.petHealth = -10;
		assertEquals(false ,pet3.isSick());
	}
	
	@Test
	public void testDead() {
		pet1.petHealth = 0;
		assertEquals(false ,pet1.isDead());
		pet2.petHealth = 101;
		assertEquals(false ,pet2.isDead());
		pet3.petHealth = -10;
		assertEquals(true ,pet3.isDead());
	}
	
	@Test
	public void testChecker(){
		pet1.petHealth = 20;
		pet1.petMood = 10;
		pet1.isHungry();
		pet1.checker();
		assertEquals(15, pet1.getPetHealth());
		assertEquals(0, pet1.getPetMood());
		assertEquals(true, pet1.isSick());
		
		pet2.tired = 80;
		pet2.petHealth = 20;
		pet2.isTired();
		pet2.checker();
		assertEquals(5, pet2.getPetHealth());
		
		pet3.petHealth = -1;
		pet3.canRevive = false;
		pet3.isDead();
		pet3.checker();
		assertEquals(-1, pet3.getPetHealth());
	}
	
	@Test
	public void feed(){
		pet1.feed(bamboo);
		assertEquals(56, pet1.getWeight());
		assertEquals(50, pet1.getPetMood());
		pet2.feed(bamboo);
		assertEquals(95, pet2.getWeight());
	}
	
	@Test
	public void play(){
		pet1.play(pc);
		assertEquals(65, pet1.getPetMood());
		pet2.play(toyCar);
		assertEquals(62, pet2.getPetMood());
	}
	
	@Test
	public void testSleep(){
		pet1.sleep();
		assertEquals(90, pet1.getPetHealth());
		pet2.sleep();
		assertEquals(20, pet2.getTired());
	}
	
	@Test
	public void testToilet(){
		pet3.toilet();
		assertEquals(30, pet3.getPetFeed());
		pet1.toilet();
		assertEquals(35, pet1.getPetFeed());
	}
}


