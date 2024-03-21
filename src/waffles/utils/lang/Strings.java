package waffles.utils.lang;

import waffles.utils.lang.util.iterators.CharIterator;
import waffles.utils.tools.primitives.Integers;

/**
 * The {@code Strings} class defines basic operations for {@code String} objects.
 * 
 * @author Waffles
 * @since Sep 30, 2016
 * @version 1.1
 */
public final class Strings
{
	/**
	 * Returns a system-dependent line separator.
	 * 
	 * @return  a new line
	 */
	public static String newLine()
	{
		return System.lineSeparator();
	}
	
	/**
	 * Repeats a character multiple times in a string.
	 * 
	 * @param c  a character to repeat
	 * @param size  a string size
	 * @return  a repeated string
	 * 
	 * 
	 * @see String
	 */
	public static String repeat(char c, int size)
	{
		if(size > 0)
		{
			return String.format("%1$" + size + "s", "").replace(' ', c);
		}
		
		return "";
	}

	
	/**
	 * Replaces the first occurrence of a regex in a string.
	 * 
	 * @param s   a string to modify
	 * @param r1  a regex string to look for
	 * @param r2  a string to replace with
	 * @return    a modified string
	 * 
	 * 
	 * @see String
	 */
	public static String replaceFirst(String s, String r1, String r2)
	{
		return s.replaceFirst(r1, r2);
	}
	
	/**
	 * Replaces the last occurrence of a regex in a string.
	 * 
	 * @param s   a string to modify
	 * @param r1  a regex string to look for
	 * @param r2  a string to replace with
	 * @return    a modified string
	 * 
	 * 
	 * @see String
	 */
	public static String replaceLast(String s, String r1, String r2)
	{
		return s.replaceFirst("(?s)(.*)" + r1, "$1" + r2);
	}
	
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
		return o + repeat(c, Integers.max(0, size - o.toString().length()));
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
		return repeat(c, Integers.max(0, size - o.toString().length())) + o;
	}
	
	/**
	 * Returns an {@code Iterable} over characters of a string.
	 * 
	 * @param s  a target string
	 * @return   a character iterable
	 * 
	 * 
	 * @see Character
	 * @see Iterable
	 */
	public static Iterable<Character> iterate(String s)
	{
		return () -> new CharIterator(s);
	}
	
	/**
	 * Checks if a string contains a whitespace character.
	 * 
	 * @param s  a string to check
	 * @return  {@code true} if the string contains whitespace
	 */
	public static boolean hasWhiteSpace(String s)
	{
		for(char c : iterate(s))
		{
			if(Character.isWhitespace(c))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	private Strings()
	{
		// NOT APPLICABLE
	}
}