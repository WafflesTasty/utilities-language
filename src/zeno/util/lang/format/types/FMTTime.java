package zeno.util.lang.format.types;

import zeno.util.lang.Strings;
import zeno.util.lang.format.Format;
import zeno.util.lang.time.Time;

/**
 * The {@code FMTTime} class defines a format for a {@code Time}.
 * </br> The format accepts the following format strings.
 * <ul>
 * <li>{@code %h+%}: Displays the number of the year, padded with zeroes on the left.</li>
 * <li>{@code %m+%}: Displays the number of the month, padded with zeroes on the left.</li>
 * <li>{@code %s+%}: Displays the number of the day of the month, padded with zeroes on the left.</li>
 * </ul> 
 * 
 * @author Zeno
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @see Format
 * @see Time
 */
public class FMTTime extends Format<Time>
{	
	/**
	 * Creates a new {@code FMTTime}.
	 * 
	 * @param fmt  a format string
	 * 
	 * 
	 * @see String
	 */
	public FMTTime(String fmt)
	{
		super(fmt);
	}
	
	
	@Override
	public Group<Time> create(String fmt)
	{
		if(fmt.matches("h+"))
			return GRPHour(fmt.length());
		if(fmt.matches("m+"))
			return GRPMinute(fmt.length());
		if(fmt.matches("s+"))
			return GRPSecond(fmt.length());
		
		return null;
	}

	
	private Group<Time> GRPHour(int size)
	{
		return date ->
		{
			String result = "" + date.Hours();
			if(size > result.length())
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
	
	private Group<Time> GRPMinute(int size)
	{
		return date ->
		{
			String result = "" + date.Minutes();
			if(size > result.length())
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
	
	private Group<Time> GRPSecond(int size)
	{
		return date ->
		{
			String result = "" + date.Seconds();
			if(size > result.length())
			{
				return Strings.padLeft(result, '0', size);
			}
			
			return result.substring(result.length() - size);
		};
	}
}