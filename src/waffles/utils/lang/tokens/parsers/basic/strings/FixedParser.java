package waffles.utils.lang.tokens.parsers.basic.strings;

import waffles.utils.lang.Characters;
import waffles.utils.lang.tokens.parsers.Parsable;
import waffles.utils.lang.utilities.patterns.Labelled;

/**
 * A {@code FixedParser} parses a fixed string literal.
 *
 * @author Waffles
 * @since 27 Feb 2024
 * @version 1.1
 * 
 * 
 * @see Parsable
 */
public class FixedParser implements Parsable<String>
{
	/**
	 * The {@code Hints} interface defines settings for a {@code FixedParser}.
	 *
	 * @author Waffles
	 * @since 09 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see Labelled
	 */
	@FunctionalInterface
	public static interface Hints extends Labelled
	{
		/**
		 * Indicates whether to ignore case.
		 * 
		 * @return  {@code true} to ignore case
		 */
		public default boolean ignoreCase()
		{
			return false;
		}
	}
	
	
	private int len;
	private Hints hints;
	
	/**
	 * Creates a new {@code FixedParser}.
	 * 
	 * @param s  a fixed string
	 */
	public FixedParser(String s)
	{
		this(() -> s);
	}
		
	/**
	 * Creates a new {@code FixedParser}.
	 * 
	 * @param h  parser hints
	 * 
	 * 
	 * @see Hints
	 */
	public FixedParser(Hints h)
	{
		hints = h;
	}
	
	
	/**
	 * Returns {@code FixedParser} hints.
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
	 * Returns current parser length.
	 * 
	 * @return  a parser length
	 */
	public int Length()
	{
		return len;
	}
	
	
	@Override
	public String generate()
	{
		String src = Hints().Label();
		if(Length() != src.length())
		{
			throw new Parsable.Error("Could not find string literal.");
		}
		
		return src;
	}
		
	@Override
	public boolean consume(Character s)
	{
		String src = Hints().Label();
		if(Length() < src.length())
		{
			char t = src.charAt(Length());
			
			char u = Characters.toUpperCase(s);
			char v = Characters.toUpperCase(t);
			
			boolean iCase = Hints().ignoreCase();
			if((!iCase && s == t) || (iCase && u == v))
			{
				len++;
				return true;
			}
		}
		
		return false;
	}
		
	@Override
	public void reset()
	{
		len = 0;
	}
}