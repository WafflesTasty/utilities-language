package waffles.utils.lang.util.iterators;

import java.util.Iterator;

/**
 * The {@code CharIterator} class iterates over the characters in a {@code String}.
 *
 * @author Waffles
 * @since 24 Jul 2020
 * @version 1.1
 * 
 * 
 * @see Character
 * @see Iterator
 */
public class CharIterator implements Iterator<Character>
{
	private int curr;
	private String src;
	
	/**
	 * Creates a new {@code CharIterator}.
	 * 
	 * @param s  a target string
	 * 
	 * 
	 * @see String
	 */
	public CharIterator(String s)
	{
		src = s;
	}
	
	
	@Override
	public boolean hasNext()
	{
		return curr < src.length();
	}

	@Override
	public Character next()
	{
		return src.charAt(curr++);
	}
}