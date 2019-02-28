package com.sourcedevelopers.anagramrestful.services;

import com.sourcedevelopers.anagramrestful.domains.Dictionary;

public interface DictionaryManager {

	public Dictionary loadDictionary(String source);
}
