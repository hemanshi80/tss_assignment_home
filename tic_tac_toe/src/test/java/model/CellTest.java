package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CellTest {

	 @Test
	    void testCellInitiallyEmpty() {
	        Cell cell = new Cell();
	        assertEquals(MarkType.EMPTY, cell.getMark());
	    }

	    @Test
	    void testSetMarkX() {
	        Cell cell = new Cell();
	        cell.setMark(MarkType.X);
	        assertEquals(MarkType.X, cell.getMark());
	    }

	    @Test
	    void testSetMarkOnNonEmptyCellThrowsException() {
	        Cell cell = new Cell();
	        cell.setMark(MarkType.O);
	        assertThrows(IllegalStateException.class, () -> cell.setMark(MarkType.X));
	    }

	    @Test
	    void testIsEmpty() {
	        Cell cell = new Cell();
	        assertTrue(cell.isEmpty());
	        cell.setMark(MarkType.X);
	        assertFalse(cell.isEmpty());
	    }
	
}
