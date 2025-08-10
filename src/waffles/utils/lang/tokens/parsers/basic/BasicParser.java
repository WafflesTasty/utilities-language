package waffles.utils.lang.tokens.parsers.basic;

import waffles.utils.lang.tokens.parsers.Parsable;
import waffles.utils.tools.patterns.Computable;
import waffles.utils.tools.patterns.properties.Gateway;
import waffles.utils.tools.primitives.Array;

/**
 * A {@code BasicParser} consumes characters iteratively into a substring.
 * A {@code Gateway} can be supplied at construction, which decides which
 * characters are allowed and which are not. In addition, this parser
 * always blocks character values which are equal to null.
 *
 * @author Waffles
 * @since 13 Dec 2023
 * @version 1.1
 *
 * 
 * @param <O>  an output type
 * @see Computable
 * @see Parsable
 * @see Gateway
 */
public abstract class BasicParser<O> implements Computable<String, O>, Gateway<Character>, Parsable<O>
{	
	private String subs;
	private Gateway<Character> gate;
	
	/**
	 * Creates a new {@code BasicParser}.
	 * 
	 * @param g  a character gate
	 * 
	 * 
	 * @see Gateway
	 */
	public BasicParser(Gateway<Character> g)
	{
		subs = "";
		gate = g;
	}
	
	/**
	 * Creates a new {@code BasicParser}.
	 * 
	 * @param set  a character set
	 */
	public BasicParser(char... set)
	{
		this(s -> Array.contents.has(set, s));
	}
		
	/**
	 * Creates a new {@code BasicParser}.
	 */
	public BasicParser()
	{
		gate = s -> true;
		subs = "";
	}
		
	/**
	 * Returns the current parser length.
	 * 
	 * @return  a string length
	 */
	public int Length()
	{
		return subs.length();
	}
	
	
	@Override
	public O generate()
	{
		return compute(subs);
	}
	
	@Override
	public boolean allows(Character s)
	{
		if(s == null)
			return false;
		return gate.allows(s);
	}
	
	@Override
	public boolean consume(Character s)
	{
		if(allows(s))
		{
			subs += s;
			return true;
		}
		
		return false;
	}
			
	@Override
	public void reset()
	{
		subs = "";
	}
}