package com.sourcedevelopers.anagramrestful.services;

import com.sourcedevelopers.anagramrestful.domains.Dictionary;
import com.sourcedevelopers.anagramrestful.domains.Word;

public interface DictionaryService {

	/**
	 * This method loads every time the Context is refreshed, the words contained into the dictionary file defined in the application.properties into a {@link Dictionary} object
	 * with a list of {@link Word} objects
	 * @throws Exception
	 */
	public void loadDictionary() throws Exception;

	/**
	 * @param dictionary the dictionary to set
	 */
	void setDictionary(Dictionary dictionary);

	/**
	 * @return the dictionary
	 */
	Dictionary getDictionary();
}
