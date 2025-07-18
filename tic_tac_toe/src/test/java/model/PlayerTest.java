package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import player.Player;

public class PlayerTest {
	
	   @Test
	    void testPlayerNameAndMark() {
	        Player player = new Player("Alice", MarkType.X);
	        assertEquals("Alice", player.getName());
	        assertEquals(MarkType.X, player.getMark());
	    }

}
