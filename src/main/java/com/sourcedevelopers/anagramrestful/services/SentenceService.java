package com.sourcedevelopers.anagramrestful.services;

import java.util.Map;

import com.sourcedevelopers.anagramrestful.domains.Word;

public interface SentenceService {
	/**
	 * This method order alphabetically the string passed as argument
	 * @param sentence
	 * @return
	 */
	String orderStringAlphabetically(String sentence);
	/**
	 * This method removes the duplicated letters in the string passed as argument
	 * @param sentence
	 * @return
	 */
	String removeDuplicates(String sentence);
	/**
	 * This method extract and returns a new string with the vowels contained in the string passed as argument
	 * @param sentence
	 * @return
	 */
	String extractVowels(String sentence);
	/**
	 * This method extract and returns a new string with the consonat contained in the string passed as argument
	 * @param sentence
	 * @return
	 */
	String extractConsonants(String sentence);
	/**
	 * This method returns a new string with the the characters contained in the string passed as argument that be between the [a-z] range
	 * @param sentence
	 * @return
	 */
	String removeSpecialCharsAndWhiteSpaces(String sentence);
	/**
	 * This method returns a {@link Map} with the letters into the string passed as argument as keys, and their occurrences in the string as Integer values in the map.
	 * @param sentence
	 * @return
	 */
	Map<Character, Integer> getLettersOcurrencesMap(String sentence);
	/**
	 * This method returns a String with the {@link Word} "text" fields of both words passed as arguments separated by a white space
	 * @param word1
	 * @param word2
	 * @return
	 */
	String joinWords(Word word1, Word word2);
}
