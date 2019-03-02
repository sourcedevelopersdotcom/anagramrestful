package com.sourcedevelopers.anagramrestful.domains;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sourcedevelopers.anagramrestful.services.SentenceService;
import com.sourcedevelopers.anagramrestful.services.SignatureService;

@Component
@Scope("prototype")
public class Word {

	private EnumMap<WORDTYPE, Integer> wordSignature = new EnumMap<>(WORDTYPE.class);
	private EnumMap<WORDTYPE, String> wordLetters = new EnumMap<>(WORDTYPE.class);
	private Map<Character, Integer> wordLetterOcurrences;

	private String text;


	@Autowired
	private SentenceService sentenceService;
	@Autowired
	private SignatureService signatureService;


	/**
	 * @return the wordSignature
	 */
	public EnumMap<WORDTYPE, Integer> getWordSignature() {
		return wordSignature;
	}

	/**
	 * @param wordSignature the wordSignature to set
	 */
	public void setWordSignature(EnumMap<WORDTYPE, Integer> wordSignature) {
		this.wordSignature = wordSignature;
	}

	/**
	 * @return the word
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param word the word to set
	 */
	public void setText(String word) {
		this.text = word;
		String cleanedLine = sentenceService.removeSpecialCharsAndWhiteSpaces(text);
		String orderedLine = sentenceService.orderStringAlphabetically(cleanedLine);
		this.getWordLetters().put(WORDTYPE.WORD, orderedLine);
		this.getWordLetters().put(WORDTYPE.SIMPLIFIED_WORD, sentenceService.removeDuplicates(orderedLine));
		this.getWordLetters().put(WORDTYPE.VOWELS, sentenceService.extractVowels(orderedLine));
		this.getWordLetters().put(WORDTYPE.CONSONANTS, sentenceService.extractConsonants(orderedLine));
		this.getWordSignature().put(WORDTYPE.SIMPLIFIED_WORD, signatureService.getSimplifiedWordSignature(this.getWordLetters().get(WORDTYPE.SIMPLIFIED_WORD)));
		this.wordLetterOcurrences = sentenceService.getLettersOcurrencesMap(orderedLine);
	}

	/**
	 * @return the wordLetters
	 */
	public EnumMap<WORDTYPE, String> getWordLetters() {
		return wordLetters;
	}

	/**
	 * @param wordLetters the wordLetters to set
	 */
	public void setWordLetters(EnumMap<WORDTYPE, String> wordLetters) {
		this.wordLetters = wordLetters;
	}

	/**
	 * @return the wordLetterOcurrences
	 */
	public Map<Character, Integer> getWordLetterOcurrences() {
		return wordLetterOcurrences;
	}

	/**
	 * @param wordLetterOcurrences the wordLetterOcurrences to set
	 */
	public void setWordLetterOcurrences(Map<Character, Integer> wordLetterOcurrences) {
		this.wordLetterOcurrences = wordLetterOcurrences;
	}




}
