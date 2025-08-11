package waffles.utils.lang.tokens.parsers.basic;

import waffles.utils.lang.Characters;
import waffles.utils.lang.tokens.format.PairFormat;
import waffles.utils.lang.tokens.format.PairFormat.Hints;
import waffles.utils.lang.tokens.parsers.Parsable;

/**
 * A {@code PairParser} parses a key-value pair separated by a character.
 * These are usually collected into a {@code PairToken}.
 *
 * @author Waffles
 * @since 19 Mar 2024
 * @version 1.1
 *
 *
 * @param <O>  an object type
 * @see Parsable
 */
public abstract class PairParser<O> implements Parsable<O>
{
	private static enum State
	{
		BEFORE,
		DURING,
		AFTER,
		DONE;
	}
	

	private Hints hints;
	private Parsable<?> curr;
	private State state;

	/**
	 * Creates a new {@code PairParser}.
	 */
	public PairParser()
	{
		this(PairFormat.SEPARATOR);
	}
	
	/**
	 * Creates a new {@code PairParser}.
	 * 
	 * @param h  parser hints
	 * 
	 * 
	 * @see Hints
	 */
	public PairParser(Hints h)
	{
		state = State.BEFORE;
		curr = KeyParser();
		hints = h;
	}
	
	/**
	 * Creates a new {@code PairParser}.
	 * 
	 * @param s  a separator
	 */
	public PairParser(char s)
	{
		this(() -> s);
	}
	
	/**
	 * Returns {@code PairParser} hints.
	 * 
	 * @return  parser hints
	 * 
	 * 
	 * @see Hints
	 */
	public Hints Hints()
	{
		return hints;
	}
	
	
	/**
	 * Returns a {@code Parser} for a pair key.
	 * 
	 * @return  a key parser
	 * 
	 * 
	 * @see Parsable
	 */
	public abstract Parsable<?> KeyParser();
	
	/**
	 * Returns a {@code Parser} for a pair value.
	 * 
	 * @return  a value parser
	 * 
	 * 
	 * @see Parsable
	 */
	public abstract Parsable<?> ValueParser();
		

	@Override
	public boolean consume(Character s)
	{
		switch(state)
		{
		case BEFORE:
		{
			if(Characters.isWhiteSpace(s))
				return true;
			state = State.DURING;
		}
		case DURING:
		{
			if(curr.consume(s))
				return true;
			if(curr == ValueParser())
			{
				state = State.DONE;
				return false;
			}
			
			state = State.AFTER;
		}
		case AFTER:
		{
			if(Characters.isWhiteSpace(s))
				return true;
			if(s == Hints().Separator())
			{
				state = State.BEFORE;
				curr = ValueParser();
				
				return true;
			}
			
			state = State.DONE;
			return false;
		}
		case DONE:
		default:
			return false;
		}
	}
		
	@Override
	public void reset()
	{
		KeyParser().reset();
		ValueParser().reset();
		state = State.BEFORE;
		curr = KeyParser();
	}
}