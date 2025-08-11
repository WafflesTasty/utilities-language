package waffles.utils.lang.tokens.parsers.basic.primitive;

import waffles.utils.lang.tokens.parsers.choice.FixedSetParser;

/**
 * A {@code NullParser} parses a null value from a string.
 *
 * @author Waffles
 * @since 13 Dec 2023
 * @version 1.1
 * 
 * 
 * @param <O>  an output token class
 * @see FixedSetParser
 */
public class NullParser<O> extends FixedSetParser<O>
{
	/**
	 * Creates a new {@code NullParser}.
	 */
	public NullParser()
	{
		super("null", "NULL");
	}


	@Override
	public O compute(String s)
	{
		return null;
	}
}