package com.sourcedevelopers.anagramrestful.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourcedevelopers.anagramrestful.services.AnagramService;

@RestController
@RequestMapping("/api")
public class AnagramController {

	private List<String> anagrams = new ArrayList<String>();


	@Autowired
	private AnagramService anagramService;

	@PostMapping("/anagrams")
	public List<String> createAnagrams(@RequestBody String phrase) {
		anagrams = anagramService.getAnagrams(phrase);
		return anagrams;
	}
}
