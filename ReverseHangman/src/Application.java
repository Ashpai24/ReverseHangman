import java.sql.SQLException;

import Application.Game;

public class Application {
	public static void main(String[] args) throws SQLException {
		Game g = new Game(2);
		g.getCommonLetter();
	}


}
