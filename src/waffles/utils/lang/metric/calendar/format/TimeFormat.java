package waffles.utils.lang.metric.calendar.format;

import waffles.utils.lang.metric.calendar.Time;
import waffles.utils.lang.tokens.format.regex.RegexFormat;
import waffles.utils.lang.tokens.format.regex.RegexFormat.Hints;
import waffles.utils.lang.tokens.format.regex.values.RXLPadder;

/**
 * A {@code TimeFormat} defines a formatter for {@code Time}.
 * As an implementation of {@code RegexFormat}, it allows the following expressions.
 * <ul>
 *  <li>{@code h+}: Displays the number of hours, padded with zeroes on the left.</li>
 *  <li>{@code m+}: Displays the number of minutes, padded with zeroes on the left.</li>
 *  <li>{@code s+}: Displays the number of seconds, padded with zeroes on the left.</li>
 * </ul>
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 *
 * 
 * @see RegexFormat
 * @see Time
 */
public class TimeFormat extends RegexFormat<Time>
{
	/**
	 * Creates a new {@code TimeFormat}.
	 * 
	 * @param h  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public TimeFormat(Hints h)
	{
		super(h);
		put("h+", new RXLPadder<>('0', t -> "" + t.Hours()));
		put("m+", new RXLPadder<>('0', t -> "" + t.Minutes()));
		put("s+", new RXLPadder<>('0', t -> "" + t.Seconds()));
	}
	
	/**
	 * Creates a new {@code TimeFormat}.
	 * 
	 * @param s  a format string
	 */
	public TimeFormat(String s)
	{
		this(() -> s);
	}
}