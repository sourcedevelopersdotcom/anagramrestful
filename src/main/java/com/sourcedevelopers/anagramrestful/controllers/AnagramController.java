package com.sourcedevelopers.anagramrestful.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourcedevelopers.anagramrestful.services.AnagramService;

@RestController
@RequestMapping("/api")
public class AnagramController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private AnagramService anagramService;

	@PostMapping("/anagrams")
	public List<String> createAnagrams(@RequestBody String phrase) {
		return anagramService.getAnagrams(phrase);
	}
}
