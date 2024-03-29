package waffles.utils.lang.time.format;

import waffles.utils.lang.Format;
import waffles.utils.lang.Strings;
import waffles.utils.lang.format.ChunkFormat;
import waffles.utils.lang.time.Date;

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
 * @version 1.1
 * 
 * 
 * @see ChunkFormat
 * @see Date
 */
public class FMTDate extends ChunkFormat<Date>
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
	public Format<Date> create(String fmt)
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

	
	private Format<Date> Days(int size)
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
	
	private Format<Date> Months(int size)
	{
		return date ->
		{
			String result = "" + date.MonthOfYear();
			if(result.length() < size)
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
	
	private Format<Date> Years(int size)
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
	
	
	private Format<Date> FullDays()
	{
		return date -> "" + date.DayOfMonth();
	}
	
	private Format<Date> FullMonths()
	{
		return date -> "" + date.MonthOfYear();
	}
	
	private Format<Date> FullYears()
	{
		return date -> "" + date.Year();
	}
	
	
	private Format<Date> WeekDay()
	{
		return date ->
		{
			return date.WeekDayName();
		};
	}
	
	private Format<Date> Month()
	{
		return date ->
		{
			return date.MonthName();
		};
	}
}