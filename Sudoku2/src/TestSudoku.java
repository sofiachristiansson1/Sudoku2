import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSudoku {
	Sudoku s;

	@Before
	public void setUp() throws Exception {
		s = new Sudoku();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}
	
	@Test
	public void testInsertNumber() {
		try {
			s.insertNumber("a",1,1);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// successful test
		}
	}
	
	@Test
	public void testGetNumber() {
		s.insertNumber(1, 1, 1);
		assertTrue("getNumber false", s.getNumber(1,1) == 1);
	}
	
	@Test
	public void testClear() {
		s.insertNumber(1, 1, 1);
		s.clear();
		assertTrue("clear false", s.getNumber(1,1) == 0);
	}
	
	
	@Test
	public void testsolveEmpty() {
		assertTrue("Could not find solution of empty sudoku", s.solve(0,0) );
	}
	
	@Test
	public void testsolvesolveble() {
		s.insertNumber(8, 0, 2);
		s.insertNumber(9, 0, 5);
		s.insertNumber(6, 0, 7);
		s.insertNumber(2, 0, 8);
		s.insertNumber(5, 1, 8);
		s.insertNumber(1, 2, 0);
		s.insertNumber(2, 2, 2);
		s.insertNumber(5, 2, 3);
		s.insertNumber(2, 3, 3);
		s.insertNumber(1, 3, 4);
		s.insertNumber(9, 3, 7);
		s.insertNumber(5, 4, 1);
		s.insertNumber(6, 4, 6);
		s.insertNumber(6, 5, 0);
		s.insertNumber(2, 5, 7);
		s.insertNumber(8, 5, 8);
		s.insertNumber(4, 6, 0);
		s.insertNumber(1, 6, 1);
		s.insertNumber(6, 6, 3);
		s.insertNumber(8, 6, 5);
		s.insertNumber(8, 7, 0);
		s.insertNumber(6, 7, 1);
		s.insertNumber(3, 7, 4);
		s.insertNumber(1, 7, 6);
		s.insertNumber(4, 8, 6);
		assertTrue("Could not find solution of solveble sudoku", s.solve(0,0));
	}
	
	@Test
	public void testsolveFalseRow() {
		s.insertNumber(1, 1, 1);
		s.insertNumber(1, 2, 1);
		assertFalse("Could find solution of unsolve(0,0)ble sudoku", s.solve(0,0) );
		
	}
	
	@Test
	public void testsolveFalseColumn() {
		s.insertNumber(1, 1, 3);
		s.insertNumber(1, 1, 8);
		assertFalse("Could find solution of unsolve(0,0)ble sudoku", s.solve(0,0) );

	}
	
	@Test
	public void testsolveFalseRegion() {
		s.insertNumber(1, 1, 1);
		s.insertNumber(1, 2, 2);
		assertFalse("Could find solution of unsolve(0,0)ble sudoku", s.solve(0,0) );
		
	}
}
