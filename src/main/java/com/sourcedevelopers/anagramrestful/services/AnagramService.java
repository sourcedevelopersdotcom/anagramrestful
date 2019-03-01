package com.sourcedevelopers.anagramrestful.services;

import java.util.List;

public interface AnagramService {
	List<String> getAnagrams(String phrase);
}
