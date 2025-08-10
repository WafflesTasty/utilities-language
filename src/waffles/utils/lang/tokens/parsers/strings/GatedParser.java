package waffles.utils.lang.tokens.parsers.strings;

import waffles.utils.lang.Characters;
import waffles.utils.lang.tokens.parsers.Parsable;
import waffles.utils.lang.tokens.parsers.basic.AnyParser;
import waffles.utils.tools.patterns.Computable;

/**
 * A {@code GatedParser} parses a string gated by a delimiter.
 * A string can be preceded by whitespace but must otherwise
 * start with the delimiter provided to the parser,
 * i.e. when the delimiter is the hashtag # then
 * the following line is a valid string.
 * <p>
 * # This is a comment.
 *
 * @author Waffles
 * @since 22 Mar 2024
 * @version 1.1
 *
 * 
 * @param <O>  an output type
 * @see Computable
 * @see Parsable
 */
public abstract class GatedParser<O> implements Computable<String, O>, Parsable<O>
{
	static enum State
	{
		FAILED,
		INITIAL,
		GATED;
	}
	
	
	private char delim;
	private State state;
	private AnyParser any;

	/**
	 * Creates a new {@code GatedParser}.
	 * 
	 * @param d  a delimiter
	 */
	public GatedParser(char d)
	{
		state = State.INITIAL;
		any = new AnyParser();
		delim = d;
	}

	
	@Override
	public O generate()
	{
		return compute(any.generate());
	}
	
	@Override
	public boolean consume(Character s)
	{
		switch(state)
		{
		case INITIAL:
		{
			if(Characters.isWhiteSpace(s))
				return true;
			if(s == delim)
			{
				state = State.GATED;
				return true;
			}
			
			state = State.FAILED;
			return false;
		}
		case GATED:
			return any.consume(s);
		case FAILED:
		default:
			return false;
		}
	}
	
	@Override
	public void reset()
	{
		state = State.INITIAL;
		any.reset();
	}
}