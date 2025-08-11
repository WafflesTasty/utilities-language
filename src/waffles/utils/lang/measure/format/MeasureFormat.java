package waffles.utils.lang.measure.format;

import waffles.utils.lang.measure.Measure;
import waffles.utils.lang.tokens.format.regex.RegexFormat;
import waffles.utils.lang.tokens.format.regex.RegexFormat.Hints;
import waffles.utils.lang.tokens.format.regex.values.RXRPadder;

/**
 * A {@code MeasureFormat} defines a formatter for {@code Measure}.
 * As an implementation of {@code RegexFormat}, it allows the following expressions.
 * <ul>
 *  <li>{@code v+}: Displays the value, padded with zeroes on the right.</li>
 *  <li> {@code E}: Displays the prefix as radix exponent.</li>
 *  <li> {@code P}: Displays the prefix as label.</li>
 *  <li> {@code U}: Displays the unit.</li>
 * </ul>
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 *
 * 
 * @see RegexFormat
 * @see Measure
 */
public class MeasureFormat extends RegexFormat<Measure>
{
	/**
	 * Creates a new {@code MeasureFormat}.
	 * 
	 * @param h  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public MeasureFormat(Hints h)
	{
		super(h);
		put("v+", new RXRPadder<>('0', m -> "" + m.Value()));
		put("P", (m, s) -> m.Prefix().Label());
		put("U", (m, s) -> m.Unit().Label());
		put("E", (m, s) ->
		{
			int rad = m.Prefix().Radix();
			int exp = m.Prefix().Exponent();
			return rad + "^" + exp;
		});
	}
	
	/**
	 * Creates a new {@code MeasureFormat}.
	 * 
	 * @param s  a format string
	 */
	public MeasureFormat(String s)
	{
		this(() -> s);
	}
}