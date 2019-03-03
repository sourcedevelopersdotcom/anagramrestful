package com.sourcedevelopers.anagramrestful.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcedevelopers.anagramrestful.domains.Anagram;
import com.sourcedevelopers.anagramrestful.domains.Dictionary;
import com.sourcedevelopers.anagramrestful.domains.WORDTYPE;
import com.sourcedevelopers.anagramrestful.domains.Word;

@Service
public class AnagramServiceImpl implements AnagramService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private Word sentence;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private SentenceService sentenceService;

	@Autowired
	BeanFactory beanFactory;

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.AnagramService#getAnagrams(java.lang.String)
	 */
	@Override
	public List<String> getAnagrams(String phrase) {
		sentence.setText(phrase);
		List<Word> dictionarySifted = siftDictionary(sentence);
		List<Anagram> anagrams = new ArrayList<>();
		findAnagramsInSiftedDictionary(dictionarySifted, sentence, anagrams);
		List<String> solution = anagrams.stream().map(a -> a.getSentence()).collect(Collectors.toList());
		return solution;
	}

	private List<Word> siftDictionary(Word sentence) {
		List<Word> dictionarySifted = new ArrayList<Word>();
		Dictionary dictionary = dictionaryService.getDictionary();

		for (Word word: dictionary.getWords()) {
			int comparison = ~ sentence.getWordSignature().get(WORDTYPE.SIMPLIFIED_WORD) & word.getWordSignature().get(WORDTYPE.SIMPLIFIED_WORD);
			if (comparison == 0) {
				dictionarySifted.add(word);
			}
		}

		return dictionarySifted;
	}

	private void findAnagramsInSiftedDictionary(List<Word> dictionary, Word sentence, List<Anagram> results) {

		for(int i = 0; i < dictionary.size(); i++) {
			Word word = dictionary.get(i);
			findMatch(dictionary, word, sentence, results, i);
		}
		return;
	}


	private void findMatch(List<Word> dictionary, Word word, Word sentence, List<Anagram> results, int index) {
		if(areWordsEquals(word, sentence)) {
			Anagram anagram = beanFactory.getBean(Anagram.class);
			anagram.setSentence(word.getText());
			results.add(anagram);
			return;
		}

		if(word.getWordLetters().get(WORDTYPE.WORD).length() < sentence.getWordLetters().get(WORDTYPE.WORD).length()) {
			for(int i = index+1; i < dictionary.size(); i++) {
				String text = sentenceService.joinWords(word, dictionary.get(i));
				Word combinedWord = beanFactory.getBean(Word.class);
				combinedWord.setText(text);
				if(doLettersMatch(combinedWord, sentence))
					findMatch(dictionary, combinedWord, sentence, results, i);
			}
		}
		return;
	}

	private Boolean areWordsEquals(Word word, Word sentence) {
		return word.getWordLetters().get(WORDTYPE.WORD).length() == sentence.getWordLetters().get(WORDTYPE.WORD).length() &&
			   word.getWordLetters().get(WORDTYPE.WORD).equals(sentence.getWordLetters().get(WORDTYPE.WORD));
	}

	private Boolean doLettersMatch(Word word, Word sentence) {
		List<Boolean> values = word.getWordLetterOcurrences().keySet().stream().map(key -> word.getWordLetterOcurrences().get(key) <= sentence.getWordLetterOcurrences().get(key)).collect(Collectors.toList());
		Boolean valid = values.stream().allMatch(value -> value == true);
		return valid;
	}

}
