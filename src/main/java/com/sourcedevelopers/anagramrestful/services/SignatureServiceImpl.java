package com.sourcedevelopers.anagramrestful.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class SignatureServiceImpl implements SignatureService {

	static HashMap<Character, Integer> alphabetSignatures = new HashMap<>();

	static {
		int signature = 1;
		for (char letter = 'a'; letter <= 'z'; letter++) {
	    	alphabetSignatures.put(letter, signature);
	    	signature = signature << 1;
	    }
	}

	/* (non-Javadoc)
	 * @see com.sourcedevelopers.anagramrestful.services.SignatureService#getSimplifiedWordSignature(java.lang.String)
	 */
	@Override
	public Integer getSimplifiedWordSignature(String simplifiedWord) {
		int value = simplifiedWord.chars().map(letter -> alphabetSignatures.get((char) letter)).sum();
		return new Integer(value);
	}

}
