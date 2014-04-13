package code;
import code.MarkupController;

/**
 * MainCalculator -- This program is the entry point of the NuPack application which
 * takes input from constructor as follows: BASE_PRICE, NUM_OF_PEOPLE & TYPE_OF_MATERIAL
 * Several methods such as validateNullArgument, validateEmptyArgument, validateEmptyArgument, 
 * validateDollarCheck, validateNumOfPeopleKeyword are implemented to validate various inputs that can be
 * entered in the program
 * 
 * @author Ankita Kulkarni
 */
public class MainCalculator {

	//BASE PRICE 
	private static String BASE_PRICE="1299.99";
	
	//Number of People
	private static String NUM_OF_PEOPLE= "8 people";
	
	//Types of materials
	private static String TYPE_OF_MATERIAL[] = new String[]{"FOOD","electronics"};
		
	//Error messages are stored in this
	private static String message;
	
	//status remains true if validation for error checking passes the test i.e. program has handled all test cases
	private static boolean status= true;
	
	/* 
	 * MSG_ARGUMENT_NULL, MSG_INVALID_BASE_PRICE, MSG_INVALID_NUM_OF_PEOPLE, MSG_INSUFFICIENT_ARGUMENTS are the messages
	 * displayed when a particular test case fails in the below methodsS
	 * 
	 */
	
	//@param MSG_ARGUMENT_NULL is printed when validateNullArgument() returns false
	private static final String MSG_ARGUMENT_NULL = "Mandatory inputs cannot be null, <BASE_PRICE>, <NUM_OF_PEOPLE> is mandatory";
	private static final String MSG_ARGUMENT_NULL_TYPE_OF_MATERIAL = "One of the arguments is null in <Type of Material>";
	
	//@param MSG_INSUFFICIENT_ARGUMENTS is printed when validateEmptyArgument() returns false
	private static final String MSG_INSUFFICIENT_ARGUMENTS = "Insufficient number of values <BASE PRICE>, <NUM OF PEOPLE>, <TYPE OF MATERIAL>(Optional)";	
	
	//@param MSG_INVALID_BASE_PRICE and/or MSG_INVALID_NUM_OF_PEOPLE is printed when validateNumberFormat() returns false
	private static final String MSG_INVALID_VALUE = "The <BASE PRICE>/<NUM OF PEOPLE> is not in correct number format";
	
	//System error code 1 denotes invalid argument from user
	private static final int SYSTEM_ERROR_CODE_INVALID_INPUT = 1;
	
	//Main function instantiates the default constructor
	public static void main(String[] args) {
		
		//Values are added to constructor in format: <BASE PRICE>, <NUM OF PEOPLE>, <TYPE OF MATERIAL>
		MarkupController markupControllerObject = new MarkupController(BASE_PRICE,NUM_OF_PEOPLE, TYPE_OF_MATERIAL);
		
		//gets base price from MarkupController's getter method
		BASE_PRICE = markupControllerObject.getBasePrice();
		
		//gets number of people from MarkupController's getter method
		NUM_OF_PEOPLE = markupControllerObject.getNumOfPeople();	
		
		/*
		 * Gets the types of materials from MarkupControllers getter method & is a array as multiple types
		 * of materials can be involved
		 */
		
		for(int i=0;i< markupControllerObject.getTypeOfMaterial().length;i++)
		{
			TYPE_OF_MATERIAL = markupControllerObject.getTypeOfMaterial();
		}
		
		/*
		 * Removes $ sign & whitespace from Base Price if present
		 * and returns only the double value
		 */
		BASE_PRICE = validateDollarCheck(BASE_PRICE);
		
		/*
		 * Removes keyword 'people' & whitespace from Number of 
		 * people if present & returns only number
		 */
		NUM_OF_PEOPLE = validateNumOfPeopleKeyword(NUM_OF_PEOPLE);
		
		//checks if the values in constructor are valid otherwise exits system
		if(!validateNullArgument(BASE_PRICE,NUM_OF_PEOPLE,TYPE_OF_MATERIAL) || !MainCalculator.validateEmptyArgument(BASE_PRICE,NUM_OF_PEOPLE) || !MainCalculator.validateNumberFormat(BASE_PRICE, NUM_OF_PEOPLE))
		{
			//System must exit if any of the conditions are true in if condition
			exit(SYSTEM_ERROR_CODE_INVALID_INPUT);
			
		}
	}
	
	//Validates if BASE PRICE OR NUMBER OF PEOPLE or TYPE OF MATERIAL is NULL
	public static boolean validateNullArgument(String BASE_PRICE,String NUM_OF_PEOPLE, String[] TYPE_OF_MATERIAL)
	{
		//sizeTypeOfMaterial is the length of TYPE_OF_MATERIAL
		int sizeTypeOfMaterial = TYPE_OF_MATERIAL.length;
		
		//countNullCheck counts the number of null arguments in the string array of type of material
		int countNullCheck=0;
				
		for(int i=0;i< sizeTypeOfMaterial;i++)
		{
			if(TYPE_OF_MATERIAL[i] == null)
			{
				countNullCheck++;
			}
		}		
		
		/*
		 * If one of the arguments in string array "Type of Material" 
		 * is null, prints an error to the user but continues execution
		 */
		if(countNullCheck > 0)
		{
			message = MSG_ARGUMENT_NULL_TYPE_OF_MATERIAL;
			System.out.println(message);
			
		}
		//if countNullCheck is equal to size of type of material which means all elements in array are null
		if(BASE_PRICE == null || NUM_OF_PEOPLE == null || TYPE_OF_MATERIAL == null || countNullCheck == sizeTypeOfMaterial)
		{
			message = MSG_ARGUMENT_NULL;
			System.out.println(message);
			return false;
		}
		
		return status;
	}
	
	/*
	 * Validates if BASE PRICE OR NUMBER OF PEOPLE IS EMPTY
	 * If empty, then returns a message or returns true 
	 */
	public static boolean validateEmptyArgument(String BASE_PRICE, String NUM_OF_PEOPLE)
	{
		if(BASE_PRICE.isEmpty() || NUM_OF_PEOPLE.isEmpty())
		{
			message = MSG_INSUFFICIENT_ARGUMENTS;
			System.out.println(message);
			return false;
		}
		return status;
	}
	
	//Validates if BASE PRICE OR NUMBER OF PEOPLE Is in valid format
	public static boolean validateNumberFormat(String BASE_PRICE, String NUM_OF_PEOPLE) 
	{
		/*
		 * If base price is a proper double value & number of people is a proper integer 
		 * else throw exception
		 */
		try
		{
			Double.parseDouble(BASE_PRICE);
			Integer.parseInt(NUM_OF_PEOPLE);
		}
		catch(NumberFormatException exception)
		{
			message = MSG_INVALID_VALUE;
			System.out.println(message);
			return false;
		}
		
	return status;
	}
	//validates if a '$' sign is in front of Base Price & trims it
	public static String validateDollarCheck(String BASE_PRICE)
	{
		if(BASE_PRICE.length() > 0)
		{
			if(BASE_PRICE.charAt(0) == '$')
			{
				BASE_PRICE = BASE_PRICE.trim().substring(1);
			}
		}
		return BASE_PRICE;
	} 
	
	//Validates if user enters 'Number of people' as '8 people' & removes keyword people with whitespace
	public static String validateNumOfPeopleKeyword(String NUM_OF_PEOPLE)
	{
		//Regular expression where s* removes whitespace & \b checks for people
		String regex = "\\s*\\bpeople\\b\\s*";
		NUM_OF_PEOPLE = NUM_OF_PEOPLE.replaceAll(regex, "");
		return NUM_OF_PEOPLE;
	}
	
	//Exits the system
	public static void exit(int status)
	{
		System.exit(status);
	}

}
