/**
 * 
 */
package code;

import java.math.BigDecimal;
/**
 * @author Ankita
 *
 */
public class MarkupView {

	public static String printOutputFormat(BigDecimal basePrice)
	{
		BigDecimal finalBasePrice = basePrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		String dollarBasePrice = "$"+finalBasePrice.toString();
		return dollarBasePrice;
	}

}
