import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	public GradeBook g1;
	public GradeBook g2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(55.5);
		g1.addScore(55.05);
		g2 = new GradeBook(5);
		g2.addScore(25.2525);
		g2.addScore(50.0);
		g2.addScore(0);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1=null;
		g2=null;
	}

	@Test
	void testAddScore() {
		assertEquals(g1.toString(),"55.5 55.05");
		assertTrue(g1.addScore(0));
		assertEquals(g1.toString(),"55.5 55.05 0.0");
		assertTrue(g1.addScore(1.1));
		assertEquals(g1.toString(),"55.5 55.05 0.0 1.1");
		assertTrue(g1.addScore(-1.1));
		assertEquals(g1.toString(),"55.5 55.05 0.0 1.1 -1.1");
		assertFalse(g1.addScore(5));
		assertEquals(g1.toString(),"55.5 55.05 0.0 1.1 -1.1");
		
		assertEquals(g2.toString(),"25.2525 50.0 0.0");
		assertTrue(g2.addScore(0));
		assertEquals(g2.toString(),"25.2525 50.0 0.0 0.0");
		assertTrue(g2.addScore(1));
		assertEquals(g2.toString(),"25.2525 50.0 0.0 0.0 1.0");
	}

	@Test
	void testSum() {
		assertEquals(g2.sum(),75.2525);
		assertTrue(g2.addScore(25.75));
		assertEquals(g2.sum(),101.0025);
		
		assertEquals(g1.sum(),110.55);
		assertTrue(g1.addScore(-55.55));
		assertEquals(g1.sum(),55);
		assertTrue(g1.addScore(7));
		assertEquals(g1.sum(),62);
	}

	@Test
	void testMinimum() {
		assertEquals(g2.minimum(),0);
		assertTrue(g2.addScore(1.1));
		assertEquals(g2.minimum(),0);
		assertTrue(g2.addScore(-1.1));
		assertEquals(g2.minimum(),-1.1);
	}

	@Test
	void testFinalScore() {
		assertEquals(g1.finalScore(),55.5);
		assertTrue(g1.addScore(1));
		assertEquals(g1.finalScore(),110.55);
		assertTrue(g1.addScore(1));
		assertEquals(g1.finalScore(),111.55);
		assertTrue(g1.addScore(0));
		assertEquals(g1.finalScore(),112.55);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(g1.getScoreSize(),2);
		assertTrue(g1.addScore(0));
		assertEquals(g1.getScoreSize(),3);
		assertTrue(g1.addScore(1.1));
		assertEquals(g1.getScoreSize(),4);
		assertTrue(g1.addScore(-1.1));
		assertEquals(g1.getScoreSize(),5);
		assertFalse(g1.addScore(5));
		assertEquals(g1.getScoreSize(),5);
		
		assertEquals(g2.getScoreSize(),3);
		assertTrue(g2.addScore(0));
		assertEquals(g2.getScoreSize(),4);
		assertTrue(g2.addScore(1.1));
		assertEquals(g2.getScoreSize(),5);
	}

	@Test
	void testToString() {
		assertEquals(g1.toString(),"55.5 55.05");
		assertTrue(g1.addScore(0));
		assertEquals(g1.toString(),"55.5 55.05 0.0");
		assertTrue(g1.addScore(1.1));
		assertEquals(g1.toString(),"55.5 55.05 0.0 1.1");
		assertTrue(g1.addScore(-1.1));
		assertEquals(g1.toString(),"55.5 55.05 0.0 1.1 -1.1");
		assertFalse(g1.addScore(5));
		assertEquals(g1.toString(),"55.5 55.05 0.0 1.1 -1.1");
		
		assertEquals(g2.toString(),"25.2525 50.0 0.0");
		assertTrue(g2.addScore(0));
		assertEquals(g2.toString(),"25.2525 50.0 0.0 0.0");
		assertTrue(g2.addScore(1.0));
		assertEquals(g2.toString(),"25.2525 50.0 0.0 0.0 1.0");
	}

}
