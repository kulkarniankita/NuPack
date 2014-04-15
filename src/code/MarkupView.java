package code;

import java.math.BigDecimal;
/**
 * MarkupView is responsible for displaying the final output to the user
 * It formats the input & output to provide a clean UI to the user
 * @author Ankita Kulkarni
 *
 */
public class MarkupView {

	/*
	 * This method formats the basePrice by rounding the 2 numbers after decimal using ROUND_HALF_UP
	 * BigDecimal ROUND_HALF_UP is the ideal way for performing monetary calculations
	 *  & ROUND_HALF_UP providing the least bias is recommended
	 * @link http://www.javapractices.com/topic/TopicAction.do?Id=13
	 */
	public static String printOutputFormat(BigDecimal basePrice)
	{
		/*
		 * Sets scale of base price to 2 decimal round half up 
		 * example, 1591.5777570 turns to 1591.58
		 */
		BigDecimal finalBasePrice = basePrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		//Prepends '$' sign to base price for representing money
		String dollarBasePrice = "$"+finalBasePrice.toString();
		return dollarBasePrice;
	}

}
