package com.sourcedevelopers.anagramrestful.domains;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Dictionary {

	@Autowired
	List<Word> words;

	/**
	 * @return the dictionary
	 */
	public List<Word> getWords() {
		return words;
	}

	/**
	 * @param dictionary the dictionary to set
	 */
	public void setWords(List<Word> words) {
		this.words = words;
	}

}
