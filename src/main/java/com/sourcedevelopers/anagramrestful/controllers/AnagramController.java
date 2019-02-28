package com.sourcedevelopers.anagramrestful.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnagramController {

	@PostMapping("/anagrams")
	public void createAnagrams(@RequestBody String phrase) {

	}
}
