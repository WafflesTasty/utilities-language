package zeno.util.lang.time.format;

import zeno.util.lang.Format;
import zeno.util.lang.Strings;
import zeno.util.lang.time.Date;

/**
 * The {@code FMTDate} class defines a format for a {@code Date} object.
 * </br> The formatter accepts the following chunk strings.
 * <ul>
 * <li>{@code Y}: Displays the number of the year.</li>
 * <li>{@code M}: Displays the number of the month.</li>
 * <li>{@code D}: Displays the number of the day of the month.</li>
 * <li>{@code y+}: Displays the number of the year, padded with zeroes on the left.</li>
 * <li>{@code m+}: Displays the number of the month, padded with zeroes on the left.</li>
 * <li>{@code d+}: Displays the number of the day of the month, padded with zeroes on the left.</li>
 * <li>{@code WEEKDAY}: Displays the full name of the day of the week.</li>
 * <li>{@code MONTH}: Displays the full name of the month.</li>
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
	 * @param fmt    a format string
	 * @param delim  a chunk delimiter
	 * 
	 * 
	 * @see String
	 */
	public FMTDate(String fmt, String delim)
	{
		super(fmt, delim);
	}
	
	@Override
	public Chunk<Date> create(String fmt)
	{
		if(fmt.matches("d+"))
			return Days(fmt.length());
		if(fmt.matches("m+"))
			return Months(fmt.length());
		if(fmt.matches("y+"))
			return Years(fmt.length());
		
		if(fmt.matches("D"))
			return FullDays();
		if(fmt.matches("M"))
			return FullMonths();
		if(fmt.matches("Y"))
			return FullYears();
		
		if(fmt.matches("WEEKDAY"))
			return WeekDay();
		if(fmt.matches("MONTH"))
			return Month();
		
		return date -> fmt;
	}

	
	private Chunk<Date> Days(int size)
	{
		return date ->
		{
			String result = "" + date.DayOfMonth();
			if(result.length() < size)
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
	
	private Chunk<Date> Months(int size)
	{
		return date ->
		{
			String result = "" + date.Month().Index();
			if(result.length() < size)
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
	
	private Chunk<Date> Years(int size)
	{
		return date ->
		{
			String result = "" + date.Year();
			if(result.length() < size)
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
	
	
	private Chunk<Date> FullDays()
	{
		return date -> "" + date.DayOfMonth();
	}
	
	private Chunk<Date> FullMonths()
	{
		return date -> "" + date.Month().Index();
	}
	
	private Chunk<Date> FullYears()
	{
		return date -> "" + date.Year();
	}
	
	
	private Chunk<Date> WeekDay()
	{
		return date ->
		{
			return date.DayOfWeek().Name();
		};
	}
	
	private Chunk<Date> Month()
	{
		return date ->
		{
			return date.Month().Name();
		};
	}
}