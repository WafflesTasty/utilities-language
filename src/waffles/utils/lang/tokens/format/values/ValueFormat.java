package waffles.utils.lang.tokens.format.values;

import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.tokens.values.ValueToken;

/**
 * A {@code ValueFormat} defines a formatter for a {@code ValueToken}.
 * Formatting is done through the {{@link #toString()} method.
 *
 * @author Waffles
 * @since 04 Nov 2025
 * @version 1.1
 *
 *
 * @param <T>  a token type
 * @see ValueToken
 * @see Format
 */
public class ValueFormat<T extends ValueToken<?>> implements Format<T>
{
	/**
	 * The {@code Hints} interface defines settings for a {@code ValueFormat}.
	 *
	 * @author Waffles
	 * @since 04 Nov 2025
	 * @version 1.1
	 */
	@FunctionalInterface
	public static interface Hints
	{
		/**
		 * Returns a string representing {@code NULL}.
		 * 
		 * @return  a null string
		 */
		public abstract String Null();
	}

	
	private Hints hints;
	
	/**
	 * Creates a new {@code ValueFormat}.
	 */
	public ValueFormat()
	{
		this(() -> "");
	}
	
	/**
	 * Creates a new {@code ValueFormat}.
	 * 
	 * @param h  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public ValueFormat(Hints h)
	{
		hints = h;
	}

	/**
	 * Returns {@code ValueFormat} hints.
	 * 
	 * @return  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public Hints Hints()
	{
		return hints;
	}
	
	
	@Override
	public String parse(T tkn)
	{
		Object val = tkn.Value();
		if(val == null)
		{
			return Hints().Null();
		}
		
		return val.toString();
	}	
}
