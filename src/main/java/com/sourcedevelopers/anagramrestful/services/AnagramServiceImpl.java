package com.sourcedevelopers.anagramrestful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcedevelopers.anagramrestful.domains.Anagram;

@Service
public class AnagramServiceImpl implements AnagramService {

	@Autowired
	private Anagram anagram;

	@Autowired
	private SentenceService sentenceService;

	@Override
	public List<String> getAnagrams(String phrase) {
		String rawSentence = sentenceService.removeSpecialCharsAndWhiteSpaces(phrase);
		return null;
	}

}
