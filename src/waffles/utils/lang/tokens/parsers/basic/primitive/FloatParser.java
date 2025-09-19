package waffles.utils.lang.tokens.parsers.basic.primitive;

import waffles.utils.lang.tokens.parsers.basic.BasicParser;
import waffles.utils.lang.utilities.enums.Existence;
import waffles.utils.tools.primitives.Array;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code FloatParser} parses an arbitrary floating-point value.
 *
 * @author Waffles
 * @since 18 Mar 2024
 * @version 1.1
 * 
 * 
 * @see BasicParser
 */
public class FloatParser extends BasicParser<Float>
{
	private static final char[] SIGNS = new char[]{'-', '+'};
	
	private static final char PERIOD = '.';
	
	private static enum State
	{
		INITIAL,
		INTEGER,
		FRACTION,
		DONE;
	}
	
	
	private State state;
	private Existence sign;
	
	/**
	 * Creates a new {@code FloatParser}.
	 * 
	 * @param s  a sign existence
	 * 
	 * 
	 * @see Existence
	 */
	public FloatParser(Existence s)
	{
		state = State.INITIAL;
		sign = s;
	}
	
	/**
	 * Creates a new {@code FloatParser}.
	 */
	public FloatParser()
	{
		this(Existence.OPTIONAL);
	}
	
	
	@Override
	public Float compute(String s)
	{
		if(s.length() == 0)
			return 0f;
		if(s.length() == 1)
		{
			char c = s.charAt(0);
			if(Array.contents.has(SIGNS, c))
			{
				return Floats.parse(s + "1.0");
			}
		}
		
		return Floats.parse(s);
	}
		
	@Override
	public boolean allows(Character s)
	{
		switch(state)
		{
		case INITIAL:
		{
			if(Length() == 0)
			{
				if(Array.contents.has(SIGNS, s))
				{
					return sign != Existence.ABSENT;
				}
				
				if(sign == Existence.OBLIGATORY)
				{
					return false;
				}
			}
			
			if(Character.isDigit(s))
			{
				state = State.INTEGER;
				return true;
			}
			
			state = State.DONE;
			return false;
		}
		case INTEGER:
		{
			if(s == PERIOD)
			{
				state = State.FRACTION;
				return true;
			}
		}
		case FRACTION:
		{
			if(Character.isDigit(s))
			{
				return true;
			}
			
			state = State.DONE;
		}
		case DONE:
		default:
			return false;
		}
	}
		
	@Override
	public void reset()
	{
		state = State.INITIAL;
		super.reset();
	}
}