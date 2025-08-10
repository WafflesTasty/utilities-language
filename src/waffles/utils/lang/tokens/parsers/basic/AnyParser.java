package waffles.utils.lang.tokens.parsers.basic;

import waffles.utils.tools.patterns.properties.Gateway;

/**
 * An {@code AnyParser} consumes any character and outputs its substring.
 *
 * @author Waffles
 * @since 18 Mar 2024
 * @version 1.1
 *
 * 
 * @see BasicParser
 */
public class AnyParser extends BasicParser<String>
{
	/**
	 * Creates a new {@code AnyParser}.
	 */
	public AnyParser()
	{
		super();
	}
	
	/**
	 * Creates a new {@code AnyParser}.
	 * 
	 * @param set  a character set
	 */
	public AnyParser(char... set)
	{
		super(set);
	}
	
	/**
	 * Creates a new {@code AnyParser}.
	 * 
	 * @param g  a character gate
	 * 
	 * 
	 * @see Gateway
	 */
	public AnyParser(Gateway<Character> g)
	{
		super(g);
	}
	
	
	@Override
	public String compute(String s)
	{
		return s;
	}
}