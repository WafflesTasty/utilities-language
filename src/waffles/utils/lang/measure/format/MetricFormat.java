package waffles.utils.lang.measure.format;

import waffles.utils.lang.measure.Metric;
import waffles.utils.lang.tokens.format.regex.RegexFormat;
import waffles.utils.lang.tokens.format.regex.RegexFormat.Hints;
import waffles.utils.lang.tokens.format.regex.values.RXRPadder;

/**
 * A {@code MetricFormat} defines a formatter for {@code Metric}.
 * As an implementation of {@code RegexFormat}, it allows the following expressions.
 * <ul>
 *  <li>{@code v+}: Displays the value, padded with zeroes on the right.</li>
 *  <li> {@code E}: Displays the prefix exponent.</li>
 *  <li> {@code P}: Displays the prefix as label.</li>
 *  <li> {@code R}: Displays the prefix radix.</li>
 *  <li> {@code U}: Displays the unit as label.</li>
 * </ul>
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 *
 * 
 * @see RegexFormat
 * @see Metric
 */
public class MetricFormat extends RegexFormat<Metric>
{
	/**
	 * Creates a new {@code MetricFormat}.
	 * 
	 * @param h  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public MetricFormat(Hints h)
	{
		super(h);
		put("v+", new RXRPadder<>('0', m -> "" + m.Value()));
		put("E", (m, s) -> m.Prefix().Exponent());
		put("P", (m, s) -> m.Prefix().Label());
		put("R", (m, s) -> m.Prefix().Radix());
		put("U", (m, s) -> m.Unit().Label());
	}
	
	/**
	 * Creates a new {@code MetricFormat}.
	 * 
	 * @param s  a format string
	 */
	public MetricFormat(String s)
	{
		this(() -> s);
	}
}