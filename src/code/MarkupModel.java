package code;

import java.util.HashMap;
import java.math.BigDecimal;

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
}
