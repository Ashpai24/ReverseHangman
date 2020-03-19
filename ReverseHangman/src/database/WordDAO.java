package database;

import java.sql.*;
import java.util.ArrayList;

import Model.Word;

public class WordDAO {
	
	java.sql.Connection connection;
	
	public WordDAO(){
		
		try {
			connection = DatabaseUtil.connect();
			System.out.println("Connection has passed");
			PreparedStatement ps = connection.prepareStatement("SET SQL_SAFE_UPDATES = 0");
			ps.execute();
		}
		
		catch(Exception e) {
			connection = null;
			System.out.println("Connection has failed.");
		}
	}
	
	
	
	public ArrayList<Word> getWordsByLength(String wordLength) throws SQLException{
		
		ArrayList<Word> listOfWords = new ArrayList<Word>();
		
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM Dictionary WHERE WordLength = ?");
		ps.setString(1, wordLength);
		
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			Word w = generateWord(result);
			listOfWords.add(w);
		}
		
		return listOfWords;
		
	}
	
	private Word generateWord(ResultSet result) throws SQLException {
		String word = result.getString("Word");
		int length = result.getInt("WordLength");
		
		
		return new Word(word, length);
	}
}
