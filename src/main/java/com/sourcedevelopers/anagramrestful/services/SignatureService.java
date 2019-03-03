package com.sourcedevelopers.anagramrestful.services;

public interface SignatureService {
	/**
	 * This method returns an Integer with the 32 bits representation signature of the letters contained in the string passed as argument without duplicates
	 * @param simplifiedWord
	 * @return
	 */
	Integer getSimplifiedWordSignature(String simplifiedWord);
}
