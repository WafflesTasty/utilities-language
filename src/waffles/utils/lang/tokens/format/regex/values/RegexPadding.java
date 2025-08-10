package waffles.utils.lang.tokens.format.regex.values;

import waffles.utils.lang.Strings;
import waffles.utils.lang.tokens.format.regex.RegexValue;
import waffles.utils.tools.patterns.Computable;

/**
 * 
 * A {@code RegexPadding} pads a generated string to the length of the format.
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 *
 *
 * @param <O>  an object type
 * @see RegexValue
 */
public class RegexPadding<O> implements RegexValue<O>
{
	private Computable<O, String> src;
	
	/**
	 * Creates a new {@code RegexPadding}.
	 * 
	 * @param s  a computable source
	 * 
	 * 
	 * @see Computable
	 */
	public RegexPadding(Computable<O, String> s)
	{
		src = s;
	}
	
	
	@Override
	public String generate(O obj, String fmt)
	{
		int len = fmt.length();
		String s = src.compute(obj);
		if(s.length() < len)
		{
			return Strings.padLeft(s, '0', len);
		}
		
		return s.substring(s.length() - len);
	}
}