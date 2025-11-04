package waffles.utils.lang.tokens.format.values;

import waffles.utils.lang.Strings;
import waffles.utils.lang.tokens.values.ValueToken;
import waffles.utils.tools.patterns.properties.Gateway;

/**
 * A {@code StringFormat} defines a formatter for a {@code ValueToken}.
 * Formatting is done through the {{@link #toString()} method. Any non-primitive
 * types can optionally be surrounded with delimiters for generic strings.
 *
 * @author Waffles
 * @since 04 Nov 2025
 * @version 1.1
 *
 *
 * @param <T>  a token type
 * @see ValueFormat
 * @see ValueToken
 * @see Gateway
 */
public class StringFormat<T extends ValueToken<?>> extends ValueFormat<T> implements Gateway<String>
{
	/**
	 * The {@code Hints} interface defines settings for a {@code ValueFormat}.
	 *
	 * @author Waffles
	 * @since 04 Nov 2025
	 * @version 1.1
	 */
	@FunctionalInterface
	public static interface Hints extends ValueFormat.Hints
	{
		/**
		 * Returns the delimiter of the {@code Hints}.
		 * 
		 * @return  a string delimiter
		 */
		public abstract char Delimiter();
		
		/**
		 * Returns the gateway of the {@code Hints}.
		 * 
		 * @return  a delimiter gateway
		 */
		public default Gateway<String> Delimit()
		{
			return s -> Strings.hasWhiteSpace(s);
		}
		
		
		@Override
		public default String Null()
		{
			return "";
		}
	}

	
	/**
	 * Creates a new {@code StringFormat}.
	 */
	public StringFormat()
	{
		this(() -> '"');
	}
	
	/**
	 * Creates a new {@code StringFormat}.
	 * 
	 * @param h  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public StringFormat(Hints h)
	{
		super(h);
	}

	
	@Override
	public boolean allows(String s)
	{
		return Hints().Delimit().allows(s);
	}	

	@Override
	public String parse(T tkn)
	{
		Object val = tkn.Value();
		if(val == null)
		{
			return Hints().Null();
		}
		
		String s = val.toString();
		if(val instanceof Boolean
		|| val instanceof Number)
		{
			return s;
		}
		
		if(allows(s))
		{
			char d = Hints().Delimiter();
			return d + s + d;
		}
		
		return s;
	}
	
	@Override
	public Hints Hints()
	{
		return (Hints) super.Hints();
	}
}
