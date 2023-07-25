package zeno.util.lang.time.format;

import zeno.util.lang.Format;
import zeno.util.lang.Strings;
import zeno.util.lang.time.Time;

/**
 * The {@code FMTTime} class defines a {@code Format} for a {@code Time} object.
 * </br> The formatter accepts the following chunk strings.
 * <ul>
 * <li>{@code h+}: Displays the number of hours, padded with zeroes on the left.</li>
 * <li>{@code m+}: Displays the number of minutes, padded with zeroes on the left.</li>
 * <li>{@code s+}: Displays the number of seconds, padded with zeroes on the left.</li>
 * </ul> 
 * 
 * @author Waffles
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
	 * @param fmt    a format string
	 * @param delim  a chunk delimiter
	 * 
	 * 
	 * @see String
	 */
	public FMTTime(String fmt, String delim)
	{
		super(fmt, delim);
	}
	
	@Override
	public Chunk<Time> create(String fmt)
	{
		if(fmt.matches("h+"))
			return Hours(fmt.length());
		if(fmt.matches("m+"))
			return Minutes(fmt.length());
		if(fmt.matches("s+"))
			return Seconds(fmt.length());
		
		return time -> fmt;
	}

		
	Chunk<Time> Seconds(int length)
	{
		return time ->
		{
			String parse = "" + time.Seconds();
			if(parse.length() < length)
			{
				return Strings.padLeft(parse, '0', length);
			}
			
			return parse.substring(parse.length() - length);
		};
	}

	Chunk<Time> Minutes(int length)
	{
		return time ->
		{
			String parse = "" + time.Minutes();
			if(parse.length() < length)
			{
				return Strings.padLeft(parse, '0', length);
			}
			
			return parse.substring(parse.length() - length);
		};
	}
	
	Chunk<Time> Hours(int length)
	{
		return time ->
		{
			String parse = "" + time.Hours();
			if(parse.length() < length)
			{
				return Strings.padLeft(parse, '0', length);
			}
			
			return parse.substring(parse.length() - length);
		};
	}
}