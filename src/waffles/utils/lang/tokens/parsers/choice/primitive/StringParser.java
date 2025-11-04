package waffles.utils.lang.tokens.parsers.choice.primitive;

import waffles.utils.lang.tokens.parsers.basic.strings.DelimitParser;
import waffles.utils.lang.tokens.values.primitive.StringToken;

/**
 * A {@code StringTokenParser} extends literal parsing with a general
 * string parser, which generates strings consisting of any
 * characters, enclosed by delimiter characters.
 *
 * @author Waffles
 * @since 21 Mar 2024
 * @version 1.1
 *
 *
 * @param <O>  an object type
 * @see LiteralParser
 */
public class StringParser<O> extends LiteralParser<O>
{
	/**
	 * Creates a new {@code StringParser}.
	 * 
	 * @param d  a delimiter
	 */
	public StringParser(char d)
	{
		add(new DelimitParser(d));
	}
	
	/**
	 * Creates a new {@code StringParser}.
	 */
	public StringParser()
	{
		this(StringToken.DELIMITER);
	}
}