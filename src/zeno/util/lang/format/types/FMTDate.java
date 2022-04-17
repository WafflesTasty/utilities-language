package zeno.util.lang.format.types;

import zeno.util.lang.Strings;
import zeno.util.lang.format.Format;
import zeno.util.lang.time.Date;

/**
 * The {@code FMTDate} class defines a format for a {@code Date}.
 * </br> The format accepts the following format strings.
 * <ul>
 * <li>{@code %Y%}: Displays the number of the year.</li>
 * <li>{@code %M%}: Displays the number of the month.</li>
 * <li>{@code %D%}: Displays the number of the day of the month.</li>
 * <li>{@code %y+%}: Displays the number of the year, padded with zeroes on the left.</li>
 * <li>{@code %m+%}: Displays the number of the month, padded with zeroes on the left.</li>
 * <li>{@code %d+%}: Displays the number of the day of the month, padded with zeroes on the left.</li>
 * <li>{@code %WEEKDAY%}: Displays the full name of the day of the week.</li>
 * <li>{@code %MONTH%}: Displays the full name of the month.</li>
 * </ul> 
 * 
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @see Format
 * @see Date
 */
public class FMTDate extends Format<Date>
{	
	/**
	 * Creates a new {@code FMTDate}.
	 * 
	 * @param fmt  a format string
	 * 
	 * 
	 * @see String
	 */
	public FMTDate(String fmt)
	{
		super(fmt);
	}
	
	
	@Override
	public Group<Date> create(String fmt)
	{
		if(fmt.matches("d+"))
			return GRPDay(fmt.length());
		if(fmt.matches("m+"))
			return GRPMonth(fmt.length());
		if(fmt.matches("y+"))
			return GRPYear(fmt.length());
		
		if(fmt.matches("D"))
			return GRPFullDay();
		if(fmt.matches("M"))
			return GRPFullMonth();
		if(fmt.matches("Y"))
			return GRPFullYear();
		
		if(fmt.matches("WEEKDAY"))
			return GRPWeekDay();
		if(fmt.matches("MONTH"))
			return GRPMonth();
		
		return null;
	}

	
	private Group<Date> GRPDay(int size)
	{
		return date ->
		{
			String result = "" + date.DayOfMonth();
			if(size > result.length())
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
	
	private Group<Date> GRPMonth(int size)
	{
		return date ->
		{
			String result = "" + date.Month().Index();
			if(size > result.length())
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
	
	private Group<Date> GRPYear(int size)
	{
		return date ->
		{
			String result = "" + date.Year();
			if(size > result.length())
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
	
	
	private Group<Date> GRPFullDay()
	{
		return date -> "" + date.DayOfMonth();
	}
	
	private Group<Date> GRPFullMonth()
	{
		return date -> "" + date.Month().Index();
	}
	
	private Group<Date> GRPFullYear()
	{
		return date -> "" + date.Year();
	}
	
	
	private Group<Date> GRPWeekDay()
	{
		return date ->
		{
			return date.DayOfWeek().Name();
		};
	}
	
	private Group<Date> GRPMonth()
	{
		return date ->
		{
			return date.Month().Name();
		};
	}
}