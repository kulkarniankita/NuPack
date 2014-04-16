NuPack
======

 - A system Markup calculator used in Repackaging industry which is developed in Java

Features:
--------
 - NuPack app quickly estimates the Final Cost depending on different markups.
 - The following are the markups:
   - Flat Markup of 5% on all jobs
   - Markup of 1.2% for per Working person
   - Type of materials markup:
     - For pharmaceuticals, 7.5% markup
     - For food, 13% markup
	 - For electronics, 2% markup
	 - For everything else, No markup

Usage:
------------------
Compile app:

    javac NuPack MainCalculator.java

Run app:

    java NuPack MainCalculator
    
Test app with different Inputs:

 - Go to code/MainCalculator.java
 - Edit <code>BASE_PRICE NUM_OF_PEOPLE & TYPE_OF_MATERIAL</code>
	 
Derived Formula for Calculating Final Price:
-------------------------------------------
 - newBasePrice = basePrice * FlatMarkup + basePrice
 - totalMarkupForWorkingPeople = num of people * markup per working person
 - finalbaseprice = newBasePrice * (1 + totalMarkupForWorkingPeople + totalTypeOfMaterialMarkup)
 
Formula Example:
---------------
 <b>Input 1</b> | <b>Input 2</b>| <b>Input 3</b>|
 -------------- | --------------| --------------|
 $1299.99       | $5432.00      | $12456.95     |
 3 people       | 1 person      | 4 people      |
 food           | drugs         | books         |
 <b>Output 1</b>| <b>Output 2</b>| <b>Output 3</b>|
 $1591.58       | $6199.81       | $13707.63      |
 
 <b>Calculation for Input 1:</b><br>
    newBasePrice = basePrice (1299.99) * FlatMarkup(0.05) + basePrice (1299.99) = 1364.9895<br>
    totalMarkupForWorkingPeople = num of people (3) * markup per working person (0.012) = 0.036 <br>
    finalbaseprice = newBasePrice (1364.9895) * (1 + totalMarkupForWorkingPeople (0.036) + totalTypeOfMaterialMarkup (0.13 for food))<br>
    finalbaseprice = 1591.58

 <b>Calculation for Input 2:</b><br>
    newBasePrice = basePrice (5432.00) * FlatMarkup(0.05) + basePrice (5432.00) = 5703.6 <br>
    totalMarkupForWorkingPeople = num of people (1) * markup per working person (0.012) = 0.012<br>
    finalbaseprice = newBasePrice (5703.6) * (1 + totalMarkupForWorkingPeople (0.012) + totalTypeOfMaterialMarkup (0.075))<br>
    finalbaseprice = 6199.81
    
 <b>Calculation for Input 3:</b><br>
    newBasePrice = basePrice (12456.95) * FlatMarkup(0.05) + basePrice (12456.95) = 13079.7975<br>
    totalMarkupForWorkingPeople = num of people (4) * markup per working person (0.012) = 0.048<br>
    finalbaseprice = newBasePrice (13079.7975) * (1 + totalMarkupForWorkingPeople (0.048) + totalTypeOfMaterialMarkup (0 for books))<br>
    finalbaseprice = 13707.63
    
Assumptions:
------------
 - Requirement of the app was no user input nor console hence values were provided in variables <code>BASE_PRICE, NUM_OF_PEOPLE & TYPE_OF_MATERIAL </code> in the MainCalculator class
 - Since the input had '$' in <code>BASE_PRICE</code> & 'person' or 'people' in <code>NUM_OF_PEOPLE</code> hence '$' sign, 'person' or 'people' keyword along with whitespace was removed after input is entered as per point 1) as that should not result in bad input
 - <code>BASE_PRICE</code> has to be a Big decimal value as its recommened to have Big Decimal whereever there is monetary value & <code>NUM_OF_PEOPLE</code> has to be a integer
 - If there are duplicate items in <code>TYPE_OF_MATERIAL</code>, only 1 item is considered for calculation for example, {"food","food"} as <code>TYPE_OF_MATERIAL</code> can only occur once in re-packaging
 - <code>TYPE_OF_MATERIAL</code> is added in HashMap as provided i.e. only food, drugs/pharmaceuticals, electronics are added for now as we don't have a various types of food materials and so on.
 
Java Design of the App:
-----------------------
 - NuPack App acts as a library to any existing application. The methods & variables are designed in a way that only needs to be called if you want to perform calculation
 - The app is designed like a MVC (Model view controller) logic app where the Model is used to store the data & perform calculations, Controller acts as the getter & setter for values from user & View is used to print the final input & output to the user as MVC format helps any developer to understand the structure & can also embed this app into another MVC app for use
 - Controller uses getter & setter methods to get & set values from user because of encapsulation hence the code is protective. This also helps in unit testing & allow control over your code.
 - BigDecimal is used for representing money because of its accuracy in precision. The following method:     
   <code>BigDecimal finalBasePrice = basePrice.setScale(2, BigDecimal.ROUND_HALF_UP); </code> It sets the scale to 2 for accurate precision & uses ROUND_HALF_UP so that the last digit gets mathematically rounded.   
 - HashMap is used to store markup percent for <code>TYPE_OF_MATERIAL</code> hashmap stores key, value pairs where key is <code>TYPE_OF_MATERIAL</code> & value is its markup percent as lookup for key, value is O(1) as per Big Oh notation.

 
Java Testing of the App:
------------------------
 - NuPack app uses JUnit as a Testing Framework for the test driven development 
 - JUnit was used to first test the basic functionality of the app i.e. getting input & validating that
 - Every module when coded was unit tested immediately in order to cover all test cases
 - Seperate methods such as <code>validateNullArgument, validateEmptyArgument, validateEmptyArgument, validateDollarCheck, validateNumOfPeopleKeyword</code> are added so that user input can be properly validated & unit testing becomes easier

References:
-----------
 - Why to use BigDecimal, Retrieved from <a>http://www.javapractices.com/topic/TopicAction.do?Id=13</a>
 - ROUND_UP & setScale of 2, Retrieved from <a>http://www.javaranch.com/journal/2003/07/MoneyInJava.html</a>
 - Unit Testing with JUnit - Tutorial, Retrieved from <a>http://www.vogella.com/tutorials/JUnit/article.html</a>

 
 

