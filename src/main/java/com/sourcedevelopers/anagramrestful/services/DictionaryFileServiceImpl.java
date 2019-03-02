package com.sourcedevelopers.anagramrestful.services;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.sourcedevelopers.anagramrestful.domains.Dictionary;
import com.sourcedevelopers.anagramrestful.domains.Word;

@Service
public class DictionaryFileServiceImpl implements DictionaryService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private Dictionary dictionary;
	@Autowired
	BeanFactory beanFactory;

	@Value("${dictionary.path}")
	private String dictionaryPath;

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.DictionaryService#loadDictionary()
	 */
	@Override
	@EventListener(ContextRefreshedEvent.class)
	public void loadDictionary() throws Exception{
		File file = ResourceUtils.getFile("classpath:" + dictionaryPath);
		try (BufferedReader br = Files.newBufferedReader( Paths.get(file.getAbsolutePath()))) {
			dictionary.setWords(br.lines().filter(line -> line.length() > 2).map(initializeWord).collect(Collectors.toList()));
		} catch (Exception e) {
			logger.error(e);
		}
	}

	Function<String, Word> initializeWord = (String line) -> {
		Word word = beanFactory.getBean(Word.class);
		word.setText(line);
		return word;
	};

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.DictionaryService#getDictionary()
	 */
	@Override
	public Dictionary getDictionary() {
		return dictionary;
	}

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.DictionaryService#setDictionary(com.sourcedevelopers.anagramrestful.domains.Dictionary)
	 */
	@Override
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}


}
