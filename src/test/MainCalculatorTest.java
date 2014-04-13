package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import code.MainCalculator;

/*
 * MainCalculatorTest is responsible for Testing the MainCalculator program 
 * (Entry point of the system)
 */
public class MainCalculatorTest {

	/*
	 * The below variable names store sample inputs to various test cases
	 */
	private String exampleBasePrice;
	private String exampleNumOfPeople;
	private String[] exampleTypeOfMaterial;
	
	/*
	 * Stores actual & expected results for assertEquals method in 
	 * all test cases
	 */
	private boolean actualResult;
	private boolean expectedResult = false;
	
	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	/* 
	 * @param exampleBasePrice, exampleNumOfPeople & exampleTypeOfMaterial - 
	 * stores sample values for testing
	 * tests & Validates if no null is present in base price, 
	 * num of people or type of material
	 */
	
	@Test
	public void testValidateNullArgument() 
	{
		// Test Input 
		exampleBasePrice = "1299.99";
		exampleNumOfPeople = null;
		exampleTypeOfMaterial = new String[]{"food",null};
		
		// Testing Method
		actualResult = MainCalculator.validateNullArgument(exampleBasePrice, exampleNumOfPeople, exampleTypeOfMaterial);
		
		// Asserts that 2 objects are equal
		assertEquals(expectedResult,actualResult);	
	}
	
	/*
	 * Tests whether the arguments are empty or not & shows how the system should be used
	 */
	@Test
	public void testValidateEmptyArgument() 
	{
		// Test Input
		exampleBasePrice = "$1299.99";
		exampleNumOfPeople = "";
		
		// Testing Method
		actualResult = MainCalculator.validateEmptyArgument(exampleBasePrice, exampleNumOfPeople);
		
		// Asserts that 2 objects are equal
		assertEquals(expectedResult,actualResult);	
	}

	/*
	 * Tests whether the base price is in proper double format
	 * and tests whether number of people is in proper integer format 
	 */
	@Test
	public void testValidateNumberFormat()
	{
		// Test Input
		exampleBasePrice = "1299.99price";
		exampleNumOfPeople = "3keyword";
		
		// Testing Method
		actualResult = MainCalculator.validateNumberFormat(exampleBasePrice, exampleNumOfPeople);

		// Asserts that 2 objects are equal
		assertEquals(expectedResult,actualResult);	
	}
	
	
	/*
	 * Tests whether the Number of people input has 'people' keyword & removes it 
	 * along with whitespace as users are likely to enter 'people' with number of people
	 */
	@Test
	public void testvalidateNumOfPeopleKeyword()
	{
		// Test Input
		exampleNumOfPeople = "8 people";
		
		// Testing Method
		String actualResultString = MainCalculator.validateNumOfPeopleKeyword(exampleNumOfPeople);
		
		// Asserts that 2 objects are equal
		assertEquals("8",actualResultString);	
	}

	/*
	 * Tests whether the Base price has a '$' sign or any whitespace as users are likely to enter
	 * '$' with base price
	 */
	@Test
	public void testValidateDollarCheck()
	{
		// Test Input
		exampleBasePrice = "$1299.99 ";
		
		// Testing Method
		String actualResultString = MainCalculator.validateDollarCheck(exampleBasePrice);
		
		// Asserts that 2 objects are equal
		assertEquals("1299.99",actualResultString);	
	}
	
}
