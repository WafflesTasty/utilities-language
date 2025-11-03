package waffles.utils.lang.tokens.primitive;

import waffles.utils.lang.tokens.Token;
import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.tokens.parsers.choice.primitive.PrimitiveParser;
import waffles.utils.tools.patterns.properties.values.Valuable;

/**
 * A {@code PrimitiveToken} defines a {@code Token} for a primitive value.
 * Primitives are parsed based on their {@code toString()} method.
 *
 * @author Waffles
 * @since 21 Mar 2024
 * @version 1.1
 * 
 * 
 * @see Valuable
 * @see Token
 */
public class PrimitiveToken implements Token, Valuable<Object>
{
	/**
	 * A {@code PrimitiveToken.Parser} generates primitive tokens.
	 *
	 * @author Waffles
	 * @since 09 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see PrimitiveParser
	 */
	public static class Parser extends PrimitiveParser<PrimitiveToken>
	{
		@Override
		public PrimitiveToken compute(Object o)
		{
			return new PrimitiveToken(o);
		}
	}
	
	
	private Object value;
	
	/**
	 * Creates a new {@code PrimitiveToken}.
	 * 
	 * @param val  an integer value
	 */
	public PrimitiveToken(int val)
	{
		this((Integer) val);
	}
	
	/**
	 * Creates a new {@code PrimitiveToken}.
	 * 
	 * @param val  a float value
	 */
	public PrimitiveToken(float val)
	{
		this((Float) val);
	}
	
	/**
	 * Creates a new {@code PrimitiveToken}.
	 * 
	 * @param val  a boolean value
	 */
	public PrimitiveToken(boolean val)
	{
		this((Boolean) val);
	}
	
	/**
	 * Creates a new {@code PrimitiveToken}.
	 * 
	 * @param val  an object value
	 */
	public PrimitiveToken(Object val)
	{
		value = val;
	}
	
	/**
	 * Changes the {@code PrimitiveToken}.
	 * 
	 * @param val  an object value
	 */
	public void setValue(Object val)
	{
		value = val;
	}
	

	@Override
	public Format<? extends Valuable<?>> Formatter()
	{
		return obj ->
		{
			Object val = obj.Value();
			if(val != null)
			{
				return val.toString();
			}
			
			return "";
		};
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof PrimitiveToken)
		{
			PrimitiveToken t = (PrimitiveToken) o;
			return t.Value() == Value();
		}

		return false;
	}
	
	@Override
	public Object Value()
	{
		return value;
	}
}