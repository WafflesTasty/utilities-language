package waffles.utils.lang.tokens.format.regex;

import waffles.utils.lang.tokens.Token;
import waffles.utils.lang.utilities.patterns.Labelled;
import waffles.utils.tools.patterns.Computable;

/**
 * A {@code RegexToken} defines a token for a {@code RegexParser}.
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 *
 * 
 * @param <T>  a token type
 * @see Computable
 * @see RegexValue
 * @see Labelled
 * @see Token
 */
public class RegexToken<T extends Token> implements Labelled, RegexValue<T>
{
	/**
	 * The {@code Type} enum defines {@code RegexToken} types.
	 *
	 * @author Waffles
	 * @since 10 Aug 2025
	 * @version 1.1
	 */
	public static enum Type
	{
		/**
		 * A static token is not modified.
		 */
		STATIC,
		/**
		 * A regex token is converted.
		 */
		REGEX;
	}


	private String label;
	private RegexValue<T> value;

	/**
	 * Creates a new {@code RegexToken}.
	 * 
	 * @param l  a label string
	 * @param v  a regex value
	 * 
	 * 
	 * @see RegexValue
	 */
	public RegexToken(String l, RegexValue<T> v)
	{
		label = l;
		value = v;
	}
	

	@Override
	public String generate(T tkn, String s)
	{
		return value.generate(tkn, s);
	}

	@Override
	public String Label()
	{
		return label;
	}
}