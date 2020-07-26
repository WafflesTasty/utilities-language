package zeno.util.lang;

import zeno.util.lang.util.CharIterator;

/**
 * The {@code Strings} class defines basic operations for {@code String} objects.
 * 
 * @author Zeno
 * @since Sep 30, 2016
 * @version 1.0
 */
public final class Strings
{
	/**
	 * Pads the right side of an object string up to a given size.
	 * 
	 * @param o     an object to parse
	 * @param c     a padding character
	 * @param size  a target string size
	 * @return  a right-padded string
	 * 
	 * 
	 * @see Object
	 * @see String
	 */
	public static String padRight(Object o, char c, int size)
	{
		return String.format("%1$-" + size + "s", o).replace(' ', c);
	}
	
	/**
	 * Pads the left side of an object string up to a given size.
	 * 
	 * @param o     an object to parse
	 * @param c     a padding character
	 * @param size  a target string size
	 * @return  a left-padded string
	 * 
	 * 
	 * @see Object
	 * @see String
	 */
	public static String padLeft(Object o, char c, int size)
	{
		return String.format("%1$" + size + "s", o).replace(' ', c);
	}

	/**
	 * Returns an {@code Iterable} over characters of a string.
	 * 
	 * @param s  a target string
	 * @return   a character iterable
	 * 
	 * 
	 * @see Iterable
	 * @see String
	 */
	public static Iterable<String> iterate(String s)
	{
		return () -> new CharIterator(s);
	}
	
	
	private Strings()
	{
		// NOT APPLICABLE
	}
}