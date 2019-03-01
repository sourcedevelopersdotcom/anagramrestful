package com.sourcedevelopers.anagramrestful.services;

public interface SentenceService {
	String orderStringAlphabetically(String sentence);
	String removeDuplicates(String sentence);
	String extractVowels(String sentence);
	String extractConsonants(String sentence);
	String removeSpecialCharsAndWhiteSpaces(String sentence);
}
