package com.sourcedevelopers.anagramrestful.services;

import java.util.List;

public interface AnagramService {
	/**
	 * Given a phrase as argument it creates and returns all the anagrams built with the words in the dictionary defined into application.properties file
	 * @param phrase
	 * @return
	 */
	List<String> getAnagrams(String phrase);
}
