package com.sourcedevelopers.anagramrestful.domains;

import java.util.EnumMap;

import org.springframework.stereotype.Component;

@Component
public class Word {

	private EnumMap<SIGNATURES, Integer> wordSignature = new EnumMap<>(SIGNATURES.class);
	private EnumMap<SIGNATURES, String> wordLetters = new EnumMap<>(SIGNATURES.class);

	private String word;

	public Word() {

	}

	/**
	 * @return the wordSignature
	 */
	public EnumMap<SIGNATURES, Integer> getWordSignature() {
		return wordSignature;
	}

	/**
	 * @param wordSignature the wordSignature to set
	 */
	public void setWordSignature(EnumMap<SIGNATURES, Integer> wordSignature) {
		this.wordSignature = wordSignature;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the wordLetters
	 */
	public EnumMap<SIGNATURES, String> getWordLetters() {
		return wordLetters;
	}

	/**
	 * @param wordLetters the wordLetters to set
	 */
	public void setWordLetters(EnumMap<SIGNATURES, String> wordLetters) {
		this.wordLetters = wordLetters;
	}




}
