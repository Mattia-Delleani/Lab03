package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Dictionary {

	private List<String> dictionary;
	
	public Dictionary() {
		dictionary = new ArrayList<String>();
	}
	
	public void loadDictionary(String language) {
		
		try {
			FileReader fr = new FileReader(language);
			BufferedReader br = new BufferedReader(fr);
			String word;
			
				while((word=br.readLine()) != null) {
					
					dictionary.add(word);
					
				}
				br.close();
				fr.close();
				
		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File non trovato");
			throw new RuntimeException();
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nella lettura del file");
			throw new RuntimeException();

		}
		
	}



	public List<RichWord> spellCheckTestLinear(List<String> inputTextList){
		
		List<RichWord> result = new ArrayList<>();
		
		for(String tempS: inputTextList) {
			RichWord richWord = new RichWord(tempS);
			for(int i =0; i<dictionary.size();i++)
				
			if(dictionary.get(i).equals(tempS)) {
				richWord.setCorrect(true);
			}
			result.add(richWord);
		}
		
		return result;
	}
	
	public List<RichWord> spellCheckTestDichotomic(List<String> inputTextList){
		
		List<RichWord> result = new ArrayList<>();
		
		String middle = dictionary.get(dictionary.size()/2);
		
		
		for(String tempS: inputTextList) {
			RichWord richWord = new RichWord(tempS);
			int r = 0;
			r= tempS.compareTo(middle);
			
			if(r==0) {
				richWord.setCorrect(true);
			}else if(r<0) {
				for(int i =0; i<dictionary.size()/2;i++)
					
					if(dictionary.get(i).equals(tempS)) {
						richWord.setCorrect(true);
					}
			}else if(r>0) {
				for(int i =dictionary.size()/2; i<dictionary.size();i++)
					
					if(dictionary.get(i).equals(tempS)) {
						richWord.setCorrect(true);
					}
			}
			
			result.add(richWord);
		}
		
		return result;
	}
}