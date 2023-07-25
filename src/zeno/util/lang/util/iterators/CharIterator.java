package zeno.util.lang.util.iterators;

import java.util.Iterator;

/**
 * The {@code CharIterator} class iterates over the characters in a {@code String}.
 *
 * @author Waffles
 * @since 24 Jul 2020
 * @version 1.0
 * 
 * 
 * @see Iterator
 * @see String
 */
public class CharIterator implements Iterator<String>
{
	private int index;
	private String source;
	
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
		source = s;
	}
	
	
	@Override
	public boolean hasNext()
	{
		return index < source.length();
	}

	@Override
	public String next()
	{
		return "" + source.charAt(index++);
	}
}