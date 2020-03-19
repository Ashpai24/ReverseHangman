package Model;

public class Word {
	
	
	//Instance Variables
	private String wordName;
	private int length;
	
	//Constructor
	public Word(String wordName, int length) {
		this.wordName = wordName;
		this.length = length;
	}
	
	
	//Setters and Getters for Instance Variables
	public String getWordName() {
		return wordName;
	}
	public int getLength() {
		return length;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	

}
