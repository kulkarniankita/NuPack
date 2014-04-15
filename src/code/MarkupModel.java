package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;
import code.MarkupView;
public class MarkupModel {

	/**
	 * MarkupModel acts as a Model where it stores values of the system obtained from
	 * MarkupController & performs calculations
	 * @Author Ankita Kulkarni
	 */
	
	//Flat Markup on all jobs is 5%
	private static final String FLAT_MARKUP_ALL_JOBS = "0.05";
	
	//For each working person, markup is 1.2%
	private static final String MARKUP_PER_WORKING_PERSON = "0.012";
	
	
	/*
	 * HashMap stores <key,value> pairs where key is the type of material & value is 
	 * its respective percentage markup
	 * Used HashMap as its easy to lookup any existing value stored in HashMap 
	 * Runtime Complexity of finding a element is O(1) hence faster
	 */
	
	public static HashMap<String,String> markupTypeOfMaterials = new HashMap<String,String>(){
		{
			// puts <key,value> in HashMap i.e. <type of material,markup Percent>
			put("pharmaceuticals", "0.075");
			put("drugs", "0.075");
			put("food", "0.13");
			put("electronics", "0.02");
		}		
	};
	
	//FlatMarkup is stored in a Big Decimal object as its a decimal value
	private static BigDecimal getFlatMarkup()
	{
		return new BigDecimal(FLAT_MARKUP_ALL_JOBS);	
	}
	
	//Markup for every working person is stored in a Big Decimal object for calculations
	private static BigDecimal getMarkupPerWorkingPerson()
	{
		return new BigDecimal(MARKUP_PER_WORKING_PERSON);	
	}
	
	/*
	 * @param TYPE_OF_MATERIAL provides type of material string array from user
	 * This method checks if any key of hashmap matches to a key provided by user & only returns 
	 * that key
	 */
	
	public static BigDecimal getMarkupTypeOfMaterialsValues(String TYPE_OF_MATERIAL)
	{
		/*
		 * containsKey() checks if there is any matching key in hashmap & TYPE_OF_MATERIAL
		 * toLowerCase() all keys in Type of material is converted to lower case to match the
		 * hashmap key example: FOOD and food are identical materials
		 */
		if(markupTypeOfMaterials.containsKey(TYPE_OF_MATERIAL.toLowerCase()))
		{
			//Only matched key is returned
			return new BigDecimal(markupTypeOfMaterials.get(TYPE_OF_MATERIAL.toLowerCase()));
		}
		
		//If key doesn't match, 0 is returned as there is 'No- Markup'
		return new BigDecimal("0");
	}	
	
	/*
	 * Calculates the main functionality of the system
	 * 
	 */
	public static String calculateMarkupSystemFormula(String BASE_PRICE, String NUM_OF_PEOPLE, String[] TYPE_OF_MATERIAL)
	{
		/*
		 * Removes $ sign & whitespace from Base Price if present
		 * and returns only the double value
		 */
		BASE_PRICE = MainCalculator.validateDollarCheck(BASE_PRICE);
		
		/*
		 * Removes keyword 'people' & whitespace from Number of 
		 * people if present & returns only number
		 */
		NUM_OF_PEOPLE = MainCalculator.validateNumOfPeopleKeyword(NUM_OF_PEOPLE);
		/*
		 * Converts base price, number of people into BigDecimal for
		 * calculations
		 */
		BigDecimal basePrice = new BigDecimal(BASE_PRICE);
		BigDecimal numOfPeople = new BigDecimal(NUM_OF_PEOPLE);        
		
		/*
		 * The elements from Type of materials are added in a Set as
		 * it helps remove duplicates
		 * for eg: In condition like 'food' and 'food', only 1 type
		 * 'food' markup will be calculated
		 */
		Set<String> typeOfMaterialSet = null;
		for(String element:TYPE_OF_MATERIAL)
		{
			typeOfMaterialSet = new HashSet<String>(Arrays.asList(element));
		}
		//When Type of Material does not match hashmap keys then '0' is added
		BigDecimal totalTypeOfMaterialMarkup = new BigDecimal("0");
				
		/*
		 * Only those elements from Type of material that match
		 * the hashmap keys are added for calculations
		 */
		for(String typeOfMaterial:typeOfMaterialSet)
		{
			BigDecimal typeOfMaterialMarkup = getMarkupTypeOfMaterialsValues(typeOfMaterial);
			totalTypeOfMaterialMarkup = totalTypeOfMaterialMarkup.add(typeOfMaterialMarkup);
		}
		
		/*
		 * Formula for calculating flat markups on all jobs
		 * newBasePrice = basePrice * FlatMarkup (0.05)+ basePrice
		 */
		BigDecimal newBasePrice = basePrice.multiply(getFlatMarkup()).add(basePrice);
		
		/*
		 * Formula for calculating the markup for the number of people
		 * Markup for working people = num of people * markup per working person (0.012)
		 */
		BigDecimal totalMarkupForWorkingPeople = numOfPeople.multiply(getMarkupPerWorkingPerson());
		
		/*
		 * Formula for Final Base Price is:
		 * finalbaseprice = newBasePrice * (1+totalMarkupForWorkingPeople+totalTypeOfMaterialMarkup)
		 * 
		 */
		BigDecimal finalBasePrice = newBasePrice.multiply
									(BigDecimal.ONE.
									add(totalMarkupForWorkingPeople).
									add(totalTypeOfMaterialMarkup));
		
		/*
		 * returns the final base price by rounding upto 2 digits after decimal along with '$' sign
		 */
		String outputBasePrice = MarkupView.printOutputFormat(finalBasePrice);
		System.out.print(outputBasePrice);
		return outputBasePrice;
	}
}
