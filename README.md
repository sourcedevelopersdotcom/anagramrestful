# anagramrestful

This application is an approach example of creating a solution for the anagram creation word play.

It builds a partial RESTful service with the `creation` action in a `POST`  endpoint, that accepts a string as argument for the anagrams creation. 

## Requirements

* java 8 or higher
* maven

## Program execution

The program can be executed through the next command:

`mvn spring-boot:run`

Then you can make 'POST' calls to the next endpoint passing to it a string as argument in the request body:

`http://localhost:8080/api/anagrams`

## Tests execution

The tests contained in the project can be exeuted through the next command:

`mvn test`