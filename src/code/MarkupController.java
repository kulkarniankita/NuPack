package code;


public class MarkupController
{
	/**
	 * MarkupController acts as a library for getter & setter methods for
	 * BASE_PRICE, NUM_OF_PEOPLE and TYPE_OF_MATERIAL
	 *  
	 * @author Ankita Kulkarni
	 */
	private String BASE_PRICE;
	private String NUM_OF_PEOPLE;
	private String[] TYPE_OF_MATERIAL;
	
	
	/*Constructor with 3 parameters
	 * @param BASE_PRICE base price of the system
	 * @param NUM_OF_PEOPLE number of people in the system
	 * @param TYPE_OF_MATERIAL type of materials in the system, an array since user can enter multiple materials
	 */
	
	public MarkupController(String BASE_PRICE, String NUM_OF_PEOPLE,String[] TYPE_OF_MATERIAL)
	{
		this.BASE_PRICE = BASE_PRICE;
		this.NUM_OF_PEOPLE = NUM_OF_PEOPLE;
		this.TYPE_OF_MATERIAL= TYPE_OF_MATERIAL;
	}
	
	//gets the base Price
	public String getBasePrice()
	{
		return this.BASE_PRICE;
	}
	
	//sets the base Price
	public void setBasePrice(String BASE_PRICE)
	{
		this.BASE_PRICE = BASE_PRICE;
	}
	
	//gets the Number of people
	public String getNumOfPeople()
	{
		return NUM_OF_PEOPLE;
	}
	
	//sets the number of people
	public void setNumOfPeople(String NUM_OF_PEOPLE)
	{
		this.NUM_OF_PEOPLE = NUM_OF_PEOPLE;
	}
	
	//Gets the array of types of material	
	public String[] getTypeOfMaterial()
	{
		return TYPE_OF_MATERIAL;
	}
	
	//Sets the array of types of material
	public void setTypeOfMaterial(String[] TYPE_OF_MATERIAL)
	{
		this.TYPE_OF_MATERIAL=  TYPE_OF_MATERIAL;
	}
}
