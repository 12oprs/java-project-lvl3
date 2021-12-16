#### CI:
![CI](https://github.com/12oprs/java-project-lvl3/actions/workflows/CI.yml/badge.svg)

#### CodeCoverage TestCoverage:
[![Test Coverage](https://api.codeclimate.com/v1/badges/67c9dd2e49df1d96fad2/test_coverage)](https://codeclimate.com/github/12oprs/java-project-lvl3/test_coverage)

#### CodeCoverage Maintainability:
[![Maintainability](https://api.codeclimate.com/v1/badges/67c9dd2e49df1d96fad2/maintainability)](https://codeclimate.com/github/12oprs/java-project-lvl3/maintainability)

#### Hexlet tests and linter status:
[![Actions Status](https://github.com/12oprs/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/12oprs/java-project-lvl3/actions)

### Description
This is tiny library for creating model of conditions and checking input parameter for compliance with it.
Lib allows to create models for next types of input params: Integer, String, Map.
Also it can create complex models based on Map.

### Usage
StringSchema schema1 = new Validator().string(); //create schema for strings
schema1.required();                  //add condition (x -> x != null && x != "")
schema1.contains("sample");          //add condition
schema1.minLength(10);		     //add condition
schema1.isValid("string sample");    //check param for compliance 

You also do it in chain style:
schema1.required().contains("sample").minLength(10).isValid("string sample"); //true

NumberSchema schema2 = new Validator().number(); //create schema for integers
schema2.isValid(null);		     //true
schema2.required().isValid(null);    //false
schema2.positive().isValid(10);	     //true

MapSchema schema3 = new Validator().map(); //create schema for maps
schema3.sizeof(2).isValid(Map.of("dog", "Rex", "cat", "Barsik")); //true

Creating model for checking values in Map:
schema1 = new Validator().string().required();
schema2 = new Validator().number().positive();
schema3 = new Validator.map().shape(Map.of("name", schema1, 
					   "age", schema2); 
schema3.isValid(Map.of("name", "Vasya"
		       "age", 100));	//true
schema3.isValid(Map.of("name", "Petya",
		       "age", -5));	//false


### API
Integer
  - required(): numberSchema
  - positive(): numberSchema
  - range(min: int, max: int): NumberSchema
  - isValid(number: int | null): boolean
String
  - required(): StringSchema
  - contains(sample: String): StringSchema
  - minLength(limit: int): StringSchema
  - isValid(string: String | null): boolean
Map  
  - required(): MapSchema
  - sizeof(limit: int): MapSchema
  - shape(): MapSchema
  - shape(schema: Map<String, NumberSchema | StringSchema | MapSchema>): MapSchema
  - isValid(): boolean
