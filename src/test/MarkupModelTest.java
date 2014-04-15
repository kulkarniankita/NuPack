package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import code.MarkupModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * MarkupModelTest class is responsible for testing the MarkupModel class
 * @author Ankita Kulkarni
 */
public class MarkupModelTest {

	/*
	 * The below variable names store sample inputs to various test cases
	 */
	private String examplebasePrice;
	private String exampleNumOfPeople;
	private String[] exampleTypeOfMaterial;
	
	/*
	 * Stores actual & expected results for assertEquals method in 
	 * all test cases
	 */
	private BigDecimal actualResult;
	private String[] expectedResult;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/* 
	 * Checks to see if the type of materials entered by user &
	 * hashmap keys matches or not & if it does then gets the value markup
	 * 
	 *  Conditions such as: "FOOD" & "food" should result in value 0.13 & electronics 
	 *  should result in 0.02
	 */
	
	@Test
	public void testGetMarkupTypeOfMaterialValues() 
	{
		// Test input
		exampleTypeOfMaterial = new String[]{"FOOD","electronics"};
		expectedResult = new String[]{"0.13","0.02"};
		int i=0;
		for(String typeOfMaterial:exampleTypeOfMaterial)
		{			
			// Testing method
			actualResult = MarkupModel.getMarkupTypeOfMaterialsValues(typeOfMaterial);
			
			// Asserts that 2 objects are equal
			assertEquals(new BigDecimal(expectedResult[i]),actualResult);
			i++;
		}
	}
	
	/*
	 * This method checks if the calculations are accurate along with input
	 * If Base price contains $ then it trims it, 
	 * for num of people, it accepts people key
	 * for type of material, it checks for duplicates for example: drugs, drugs
	 * and also checks the case
	 * Then it prints the output & rounds it upto 2 decimal
	 */
	
	@Test
	public void testCalcMarkupSystemFormula() 
	{
		// Test input
		examplebasePrice = "$5432.00";
		exampleNumOfPeople = "1";
		exampleTypeOfMaterial = new String[]{"drugs","DRUGS"};
		
		String expectedBasePrice = "$6199.81";
		
		// Testing method
		String actualResult = MarkupModel.calculateMarkupSystemFormula(examplebasePrice, exampleNumOfPeople, exampleTypeOfMaterial);
		
		// Asserts that 2 objects are equal
		assertEquals(expectedBasePrice,actualResult);
	}
}
