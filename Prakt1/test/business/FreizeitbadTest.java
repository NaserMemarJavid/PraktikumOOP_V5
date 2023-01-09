package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.businessFreizeitbaeder.Freizeitbad;

class FreizeitbadTest {
	
	private Freizeitbad freizeitbad;

	@BeforeEach
	void setUp() throws Exception {
		this.freizeitbad = new Freizeitbad("Stadtbad", "7.0", "17.0","25","24");}

	@AfterEach
	void tearDown() throws Exception {
	}
  
	@Test
	void test() {
//		fail("Not yet implemented");
		assertTrue(()->freizeitbad.getBeckenlaenge() == 25,"Beckenlaenge muss 25 sein!");
		
		
	}

}
