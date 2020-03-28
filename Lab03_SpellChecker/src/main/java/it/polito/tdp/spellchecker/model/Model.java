package it.polito.tdp.spellchecker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Model {
	
	private Dictionary dictionary;
	private int errorNumber;
	
	public Model() {
		
		dictionary = new Dictionary();
		errorNumber = 0;
	}
	
	public String checkTest(String language, String input) {
		
		language= "C:\\Users\\mattia\\git\\Lab03\\Lab03_SpellChecker\\src\\main\\resources\\"+language + ".txt";
		System.out.println("FILE: "+language);
		this.dictionary.loadDictionary(language);
		
		input.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		input.toLowerCase();
		
		List<String> inputList = new ArrayList<>();
		List<RichWord> list;
	
		//String[] st = input.split(" "); DOVREBBE ESSERE PIU PERFORMANTE

		StringTokenizer st = new StringTokenizer(input);
		 
		while(st.hasMoreElements()) {
		inputList.add(st.nextToken());
		}
		
		
		
		list = this.dictionary.spellCheckTest(inputList);
		System.out.println(list.toString());
		errorNumber = 0;
		String result = "";
		for(RichWord rw: list) {
			if(!rw.isCorrect()) {
				errorNumber++;
				if(result.equals(""))
					result += rw.getWord();
				else
					result +="\n"+rw.getWord();
			}
		}
				
		return result;
		
		
	}
	

	
	
	public int getErrorNumber() {
		return errorNumber;
	}

	public Dictionary getDictionary() {
		return dictionary;
	}	
	
	
	

}
