package com.sourcedevelopers.anagramrestful.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

	static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
	static List<Character> consonants = new ArrayList<>();

	static {
	    for (char latter = 'a'; latter <= 'z'; latter++) {
	        if(!vowels.contains(latter)) {
	            consonants.add(latter);
	        }
	    }
	}

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#removeSpecialCharsAndWhiteSpaces()
	 */
	@Override
	public String orderStringAlphabetically(String sentence) {
		char[] wordChars = sentence.toCharArray();
		Arrays.sort(wordChars);
		return new String(wordChars);
	}

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#removeSpecialCharsAndWhiteSpaces()
	 */
	@Override
	public String removeDuplicates(String sentence) {
		StringBuilder stringResult = new StringBuilder();
		sentence.chars().distinct().forEach(c -> stringResult.append((char) c));
		return stringResult.toString();
	}

	@Override
	public String extractVowels(String sentence) {
		StringBuilder stringResult = new StringBuilder();
		sentence.chars().distinct().forEach(letter -> {
			if(vowels.contains((char) letter))
				stringResult.append((char) letter);
		});
		return stringResult.toString();
	}

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#removeSpecialCharsAndWhiteSpaces()
	 */
	@Override
	public String extractConsonants(String sentence) {
		StringBuilder stringResult = new StringBuilder();
		sentence.chars().distinct().forEach(letter -> {
			if(consonants.contains((char) letter))
				stringResult.append((char) letter);
		});
		return stringResult.toString();
	}

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#removeSpecialCharsAndWhiteSpaces()
	 */
	@Override
	public String removeSpecialCharsAndWhiteSpaces(String sentence) {
		StringBuilder stringResult = new StringBuilder();
		sentence.toLowerCase().chars().forEach(letter -> {
			if(consonants.contains((char) letter) || vowels.contains((char) letter))
				stringResult.append((char) letter);
		});
		return stringResult.toString();
	}



//	Function<String, String> orderStringAlphabeticallyAndRemoveDuplicates = (String temp) -> {
	//	char[] wordChars = temp.toCharArray();
	//	Arrays.sort(wordChars);
	//	String testString = new String(wordChars);
	//	StringBuilder stringResult = new StringBuilder();
	//	testString.chars().distinct().forEach(c -> stringResult.append((char) c));
	//	return stringResult.toString();
	//};

//	String orderStringAlphabeticallyAndRemoveDuplicates(String line) {
	//	char[] wordChars = line.toCharArray();
	//	Arrays.sort(wordChars);
	//	String testString = new String(wordChars);
	//	StringBuilder stringResult = new StringBuilder();
	//	testString.chars().distinct().forEach(c -> stringResult.append((char) c));
	//	return stringResult.toString();
	//}
}

