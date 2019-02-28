package com.sourcedevelopers.anagramrestful.domains;

import java.util.HashMap;
import java.util.List;

public class Dictionary {

	private enum SIGNATURES{VOCALS, CONSONANTS}

	HashMap<String, HashMap<String, V>> words;

	/**
	 * @return the words
	 */
	public List<String> getWords() {
		return words;
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(List<String> words) {
		this.words = words;
	}



}
