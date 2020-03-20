package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Application.Game;

class GameTest {

	@Test
	void test() throws SQLException {
		Game game = new Game(2);
		assertTrue(game.getCommonLetter().equals("o"));
	}

}
