package waffles.utils.lang.tokens.values.primitive;

import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.tokens.format.values.StringFormat;
import waffles.utils.lang.tokens.format.values.StringFormat.Hints;
import waffles.utils.lang.tokens.parsers.choice.primitive.StringParser;

/**
 * A {@code StringToken} extends the {@code LiteralToken} token with a general string.
 * This string can contain any valid characters, surrounded by a delimiter.
 * These delimiters are usually double quotes by default.
 *
 * @author Waffles
 * @since 21 Mar 2024
 * @version 1.1
 *
 * 
 * @see LiteralToken
 */
public class StringToken extends LiteralToken
{
	/**
	 * A {@code StringToken.Parser} generates literal tokens.
	 *
	 * @author Waffles
	 * @since 09 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see StringParser
	 */
	public static class Parser extends StringParser<StringToken>
	{
		/**
		 * Creates a new {@code Parser}.
		 */
		public Parser()
		{
			this(StringToken.DELIMITER);
		}
		
		/**
		 * Creates a new {@code Parser}.
		 * 
		 * @param d  a delimiter
		 */
		public Parser(char d)
		{
			super(d);
		}
				
		
		@Override
		public StringToken compute(Object o)
		{
			return new StringToken(o);
		}
	}
	
	
	/**
	 * Defines the default delimiter for a {@code StringToken}.
	 */
	public static final char DELIMITER = '"';
	
	
	/**
	 * Creates a new {@code StringToken}.
	 * 
	 * @param val  an integer value
	 */
	public StringToken(int val)
	{
		super(val);
	}
	
	/**
	 * Creates a new {@code StringToken}.
	 * 
	 * @param val  a float value
	 */
	public StringToken(float val)
	{
		super(val);
	}
	
	/**
	 * Creates a new {@code StringToken}.
	 * 
	 * @param val  a boolean value
	 */
	public StringToken(boolean val)
	{
		super(val);
	}
	
	
	/**
	 * Creates a new {@code StringToken}.
	 * 
	 * @param val  a string value
	 */
	public StringToken(String val)
	{
		super(val);
	}
	
	/**
	 * Creates a new {@code StringToken}.
	 * 
	 * @param val  an object value
	 */
	public StringToken(Object val)
	{
		super(val);
	}
	
		
	/**
	 * Returns a {@code StringToken} formatter.
	 * 
	 * @param h  format hints
	 * @return   a formatter
	 * 
	 * 
	 * @see Format
	 * @see Hints
	 */
	public Format<?> Formatter(Hints h)
	{
		return new StringFormat<>(h);
	}
	
	/**
	 * Returns a {@code StringToken} formatter.
	 * 
	 * @param d  a string delimiter
	 * @return   a formatter
	 * 
	 * 
	 * @see PrimitiveToken
	 * @see Format
	 */
	public Format<?> Formatter(char d)
	{
		return Formatter(() -> d);
	}
	
	@Override
	public Format<?> Formatter()
	{
		return Formatter('"');
	}
}