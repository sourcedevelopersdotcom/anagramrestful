package com.sourcedevelopers.anagramrestful.services;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.sourcedevelopers.anagramrestful.domains.Dictionary;
import com.sourcedevelopers.anagramrestful.domains.SIGNATURES;
import com.sourcedevelopers.anagramrestful.domains.Word;

@Service
public class DictionaryFileServiceImpl implements DictionaryService {

	@Autowired
	private Dictionary dictionary;
	@Autowired
	private SentenceService sentenceService;

	@Value("${dictionary.path}")
	private String dictionaryPath;

	@Override
	@EventListener(ContextRefreshedEvent.class)
	public void loadDictionary() throws Exception{
		File file = ResourceUtils.getFile("classpath:" + dictionaryPath);
		try (BufferedReader br = Files.newBufferedReader( Paths.get(file.getAbsolutePath()))) {
			dictionary.setWords(br.lines().map(initializeWord).collect(Collectors.toList()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Function<String, Word> initializeWord = (String line) -> {
		Word word = new Word();
		word.setWord(line);
		String orderedLine = sentenceService.orderStringAlphabetically(line);
		word.getWordLetters().put(SIGNATURES.WORD, orderedLine);
		word.getWordLetters().put(SIGNATURES.SIMPLIFIED_WORD, sentenceService.removeDuplicates(orderedLine));
		word.getWordLetters().put(SIGNATURES.VOWELS, sentenceService.extractVowels(orderedLine));
		word.getWordLetters().put(SIGNATURES.CONSONANTS, sentenceService.extractConsonants(orderedLine));
		return word;
	};

	/**
	 * @return the dictionary
	 */
	@Override
	public Dictionary getDictionary() {
		return dictionary;
	}

	/**
	 * @param dictionary the dictionary to set
	 */
	@Override
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}


}
