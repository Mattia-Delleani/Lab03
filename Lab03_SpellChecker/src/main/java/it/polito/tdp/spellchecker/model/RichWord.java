package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String word;
	private boolean correct;
	/**Converte le parole del testo {@code String} in ingresso in tipo {@code RichWord}, settando il valore {@code correct} a {@code false}
	 * @param word Stringa in ingresso.
	 */
	public RichWord(String word) {
		super();
		this.word = word;
		this.correct = false;
	}
	
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}



	@Override
	public String toString() {
		return "RichWord [word=" + word + ", correct=" + correct + "]";
	}
	
	
	
	
	

}
