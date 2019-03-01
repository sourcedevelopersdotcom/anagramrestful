package com.sourcedevelopers.anagramrestful.services;

import com.sourcedevelopers.anagramrestful.domains.Dictionary;

public interface DictionaryService {

	public void loadDictionary() throws Exception;

	void setDictionary(Dictionary dictionary);

	Dictionary getDictionary();
}
