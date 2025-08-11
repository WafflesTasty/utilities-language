package waffles.utils.lang.tokens.format.regex.values;

import waffles.utils.lang.Strings;
import waffles.utils.lang.tokens.format.regex.RegexValue;
import waffles.utils.tools.patterns.Computable;

/**
 * 
 * An {@code RXLPadder} left pads a generated string to the length of the format.
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 *
 *
 * @param <O>  an object type
 * @see RegexValue
 */
public class RXLPadder<O> implements RegexValue<O>
{
	private char chp;
	private Computable<O, String> src;
	
	/**
	 * Creates a new {@code RXLPadder}.
	 * 
	 * @param c  a padding character
	 * @param s  a computable source
	 * 
	 * @see Computable
	 */
	public RXLPadder(char c, Computable<O, String> s)
	{
		chp = c;
		src = s;
	}
	
	
	@Override
	public String generate(O obj, String fmt)
	{
		int len = fmt.length();
		String s = src.compute(obj);
		if(s.length() < len)
		{
			return Strings.padLeft(s, chp, len);
		}
		
		return s.substring(s.length() - len);
	}
}