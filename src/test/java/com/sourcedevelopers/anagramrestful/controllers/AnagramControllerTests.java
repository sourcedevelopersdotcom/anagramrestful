package com.sourcedevelopers.anagramrestful.controllers;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AnagramControllerTests {

	@Autowired
	private AnagramController anagramController;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void createAnagrams_GivenBestSecretSentenceAsArgument_ThenShouldReturnResultsInExerciseDefinition() {
		//Given
		List<String> expectedResults = Arrays.asList("beet crests", "beets crest", "beret sects", "berets sect", "beset crest", "best erects", "best secret", "bests crete",
													 "bests erect", "bet erst sec", "bet rest sec", "bet secrets", "bets erects", "bets secret", "better cess", "betters sec");

		//When
		List<String> results = anagramController.createAnagrams("Best Secret");
		//Then
		assertArrayEquals("Test", expectedResults.toArray(), results.toArray());
	}

	@Test
	public void createAnagrams_GivenITCrowdSentenceAsArgument_ThenShouldReturnResultsInExerciseDefinition() {
		//Given
		List<String> expectedResults = Arrays.asList("cod writ", "cord wit", "cow dirt", "doc writ", "tic word");
		//When
		List<String> results = anagramController.createAnagrams("IT-Crowd");
		//Then
		assertArrayEquals("Test", expectedResults.toArray(), results.toArray());
	}

	@Test
	public void createAnagrams_GivenAschheimSentenceAsArgument_ThenShouldReturnResultsInExerciseDefinition() {
		//Given
		List<String> expectedResults = Arrays.asList("aches him", "ash chime", "chase him", "chime has", "hash mice", "hic shame", "mice shah");
		//When
		List<String> results = anagramController.createAnagrams("Aschheim");
		//Then
		assertArrayEquals("Test", expectedResults.toArray(), results.toArray());
	}

}
