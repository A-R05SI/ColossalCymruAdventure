import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovementTestSuite {

	@Test
	public void tc1() {
		MovementManager classUnderTest = new MovementManager();
		assertEquals(-3, classUnderTest.movePlayer(-3, "n"));
	}
	
	@Test
	public void tc2() {
		MovementManager classUnderTest = new MovementManager();
		assertEquals(4, classUnderTest.movePlayer(4, "s"));
	}
	
	@Test
	public void tc3() {
		MovementManager classUnderTest = new MovementManager();
		assertEquals(-5, classUnderTest.movePlayer(-5, "w"));
	}

	@Test
	public void tc4() {
		MovementManager classUnderTest = new MovementManager();
		assertEquals(7, classUnderTest.movePlayer(7, "e"));
	}
	
	@Test
	public void tc5() {
		MovementManager classUnderTest = new MovementManager();
		assertEquals(1, classUnderTest.movePlayer(2, "n"));
	}
	
	@Test
	public void tc6() {
		MovementManager classUnderTest = new MovementManager();
		assertEquals(1, classUnderTest.movePlayer(0, "s"));
	}
	
	@Test
	public void tc7() {
		MovementManager classUnderTest = new MovementManager();
		assertEquals(2, classUnderTest.movePlayer(3, "w"));
	}
	
	@Test
	public void tc8() {
		MovementManager classUnderTest = new MovementManager();
		assertEquals(4, classUnderTest.movePlayer(3, "e"));
	}
}
