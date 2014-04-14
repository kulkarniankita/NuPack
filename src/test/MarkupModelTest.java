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
}
