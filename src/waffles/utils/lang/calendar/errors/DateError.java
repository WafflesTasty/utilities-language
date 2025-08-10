package waffles.utils.lang.calendar.errors;

import waffles.utils.lang.calendar.Date;
import waffles.utils.lang.utilities.ISO;

/**
 * An {@code DateError} is thrown when creating a non-existent {@code ISODate}.
 *
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @see RuntimeException
 */
public class DateError extends RuntimeException
{
	private static final long serialVersionUID = 2899037336843828510L;

	
	/**
	 * Creates a new {@code DateError}.
	 * 
	 * @param d  a target date
	 * 
	 *  
	 * @see Date
	 */
	public DateError(Date d)
	{
		super("The date " + d.parse(ISO.Format.SHORT) + " does not exist in the ISO calendar.");
	}
}