package waffles.utils.lang.tokens.parsers.strings;

import waffles.utils.lang.tokens.parsers.basic.BasicParser;

/**
 * A {@code RegexParser} parses a regular expression.
 * This parser will only function correctly if the given
 * regex matches with all substrings starting at zero.
 *
 * @author Waffles
 * @since 27 Feb 2024
 * @version 1.1
 * 
 * 
 * @see BasicParser
 */
public class RegexParser extends BasicParser<String>
{
	private String regex;
	
	/**
	 * Creates a new {@code RegexParser}.
	 * 
	 * @param r  a regex string
	 */
	public RegexParser(String r)
	{
		regex = r;
	}

	
	@Override
	public String compute(String s)
	{
		return s;
	}
	
	@Override
	public boolean allows(Character s)
	{
		if(super.allows(s))
		{
			return generate().matches(regex);
		}
	
		return false;
	}
}