package waffles.utils.lang.calendar.format;

import waffles.utils.lang.calendar.Date;
import waffles.utils.lang.tokens.format.regex.RegexFormat;
import waffles.utils.lang.tokens.format.regex.RegexFormat.Hints;
import waffles.utils.lang.tokens.format.regex.values.RXLPadder;

/**
 * A {@code DateFormat} defines a formatter for {@code Date}.
 * As an implementation of {@code RegexFormat}, it allows the following expressions.
 * <ul>
 *  <li>{@code Y}: Displays the number of the year.</li>
 *  <li>{@code M}: Displays the number of the month.</li>
 *  <li>{@code D}: Displays the number of the day of the month.</li>
 *  <li>{@code y+}: Displays the number of the year, padded with zeroes on the left.</li>
 *  <li>{@code m+}: Displays the number of the month, padded with zeroes on the left.</li>
 *  <li>{@code d+}: Displays the number of the day of the month, padded with zeroes on the left.</li>
 *  <li>{@code WEEKDAY}: Displays the full name of the day of the week.</li>
 *  <li>{@code MONTH}: Displays the full name of the month.</li>
 * </ul>
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 *
 * 
 * @see RegexFormat
 * @see Date
 */
public class DateFormat extends RegexFormat<Date>
{
	/**
	 * Creates a new {@code DateFormat}.
	 * 
	 * @param h  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public DateFormat(Hints h)
	{
		super(h);
		
		put("MONTH", (d, s) -> d.MonthName());
		put("WEEKDAY", (d, s) -> d.WeekDayName());
		
		put("Y", (d, s) -> "" + d.Year());
		put("M", (d, s) -> "" + d.MonthOfYear());
		put("D", (d, s) -> "" + d.DayOfMonth());
		
		put("y+", new RXLPadder<>('0', d -> "" + d.Year()));
		put("m+", new RXLPadder<>('0', d -> "" + d.MonthOfYear()));
		put("d+", new RXLPadder<>('0', d -> "" + d.DayOfMonth()));
	}
	
	/**
	 * Creates a new {@code DateFormat}.
	 * 
	 * @param s  a format string
	 */
	public DateFormat(String s)
	{
		this(() -> s);
	}
}