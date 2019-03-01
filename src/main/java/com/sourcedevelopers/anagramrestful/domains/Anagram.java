package com.sourcedevelopers.anagramrestful.domains;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Anagram {

	private String sentence;

	/**
	 * @return the sentence
	 */
	public String getSentence() {
		return sentence;
	}

	/**
	 * @param sentence the sentence to set
	 */
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}


}
