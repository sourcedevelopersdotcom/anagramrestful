package com.sourcedevelopers.anagramrestful.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sourcedevelopers.anagramrestful.domains.WORDTYPE;
import com.sourcedevelopers.anagramrestful.domains.Word;

/**
 * @author micmm
 *
 */
@Service
public class SentenceServiceImpl implements SentenceService {

	static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
	static List<Character> consonants = new ArrayList<>();
	static List<Character> alphabet = new ArrayList<>();

	static {
	    for (char letter = 'a'; letter <= 'z'; letter++) {
	    	alphabet.add(letter);
	        if(!vowels.contains(letter)) {
	            consonants.add(letter);
	        }
	    }
	}

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#orderStringAlphabetically(java.lang.String)
	 */
	@Override
	public String orderStringAlphabetically(String sentence) {
		char[] wordChars = sentence.toCharArray();
		Arrays.sort(wordChars);
		return new String(wordChars);
	}


	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#removeDuplicates(java.lang.String)
	 */
	@Override
	public String removeDuplicates(String sentence) {
		StringBuilder stringResult = new StringBuilder();
		sentence.chars().distinct().forEach(c -> stringResult.append((char) c));
		return stringResult.toString();
	}


	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#extractVowels(java.lang.String)
	 */
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
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#extractConsonants(java.lang.String)
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




	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#getLettersOcurrencesMap(java.lang.String)
	 */
	@Override
	public Map<Character, Integer> getLettersOcurrencesMap(String sentence) {
 		Map<Character, Integer> letterOccurences = new HashMap<>();
		sentence.chars().forEach(c -> letterOccurences.put(new Character((char) c) , 0));
		sentence.chars().forEach(c -> letterOccurences.put(new Character((char) c) , letterOccurences.get((char)c) + 1));
		return letterOccurences;
	}


	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SentenceService#joinWords(com.sourcedevelopers.anagramrestful.domains.Word, com.sourcedevelopers.anagramrestful.domains.Word)
	 */
	@Override
	public String joinWords(Word word1, Word word2) {
		return word1.getText() + " " + word2.getText();
	}


}

