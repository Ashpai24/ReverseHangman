package Application;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Model.Word;
import database.WordDAO;

public class Game {
	
	private ArrayList<Word> listOfWords = new ArrayList<>();
	private ArrayList<Character> lettersUsed = new ArrayList<>();
	private WordDAO dataAccessObject = new WordDAO();
	private int lengthOfWord;
	
	public Game(int len) throws SQLException {
		
		
		listOfWords = dataAccessObject.getWordsByLength(len);
	}
	
	public void checkIndexOfWords(char character, int index) {
		
		//Looping through list of words. 
		for(int i = 0; i < listOfWords.size(); i++) {
			if(listOfWords.get(i).getWordName().charAt(index) != character) {
				//Remove the word from the list if the character does not exist in the word. 
				listOfWords.remove(i);
			}
		}
	}
	
	public String getCommonLetter() {
		HashMap<Character, Integer> commonLetter = new HashMap<>();
		
		// Taking the list of the words
		for(int listCounter = 0; listCounter < listOfWords.size(); listCounter++) {
			//Iterating inside each of the words contained within the list of words.
			for(int index = 0; index < listOfWords.get(listCounter).getWordName().length(); index++) {
				// Need to check that the character does not already have a KV pair. 
				char character = listOfWords.get(listCounter).getWordName().charAt(index);
				
				// If the character is already in the hashmap
				if(commonLetter.containsKey(character)) {
					
					//Increment the count of the value by 1.
					Integer num = commonLetter.get(character);
					num++;
					commonLetter.replace(character, num);
				}
				
				//Character is not in the hashmap
				else {
					
					Integer num = 1;
					commonLetter.put(character, num);
				}
			}
			
		}
		
		return String.valueOf(getMostUsedChar(commonLetter));
	}
	
	private char getMostUsedChar(HashMap<Character, Integer> commonLetter) {
		ArrayList<Character> listOfKeys = new ArrayList<>();
		
		for(Map.Entry<Character, Integer> entry : commonLetter.entrySet()) {
			listOfKeys.add(entry.getKey());
	}
		
		int max = 0;
		char mostUsed = 'a';
		for(int i = 0; i < listOfKeys.size(); i++) {
			if(commonLetter.get(listOfKeys.get(i)) > max) {
				max = commonLetter.get(listOfKeys.get(i));
				mostUsed = listOfKeys.get(i);
			}
		}
		
		return mostUsed;

		

	}
	
	
}
