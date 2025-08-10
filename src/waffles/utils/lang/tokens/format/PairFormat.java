package waffles.utils.lang.tokens.format;

import waffles.utils.lang.tokens.PairToken;
import waffles.utils.lang.tokens.Token;

/**
 * A {@code PairFormat} generates a format string from a {@code PairToken}.
 *
 * @author Waffles
 * @since 07 Aug 2025
 * @version 1.1
 *
 *
 * @param <K>  a key type
 * @param <V>  a value type
 * @see PairToken
 * @see Format
 * @see Token
 */
public class PairFormat<K extends Token, V extends Token> implements Format<PairToken<K, V>>
{
	/**
	 * Defines a default {@code PairFormat} spacing.
	 */
	public static final char SPACING = ' ';
	/**
	 * Defines a default {@code PairFormat} separator.
	 */
	public static final char SEPARATOR = ':';
	
	/**
	 * The {@code Hints} interface define settings
	 * for a {@code PairFormat}.
	 *
	 * @author Waffles
	 * @since 07 Aug 2025
	 * @version 1.1
	 */
	@FunctionalInterface
	public static interface Hints
	{		
		/**
		 * Returns a {@code PairFormat} separator.
		 * 
		 * @return  a separator
		 */
		public abstract char Separator();
		
		/**
		 * Returns a {@code PairFormat} spacing.
		 * 
		 * @return  a spacing
		 */
		public default char Spacing()
		{
			return SPACING;
		}
	}
	
	
	private Hints hints;
	
	/**
	 * Creates a new {@code PairFormat}.
	 */
	public PairFormat()
	{
		this(SEPARATOR);
	}
	
	/**
	 * Creates a new {@code PairFormat}.
	 * 
	 * @param h  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public PairFormat(Hints h)
	{
		hints = h;
	}
	
	/**
	 * Creates a new {@code PairFormat}.
	 * 
	 * @param s  a separator
	 */
	public PairFormat(char s)
	{
		this(() -> s);
	}
	
	/**
	 * Returns {@code PairFormat} hints.
	 * 
	 * @return  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public Hints Hints()
	{
		return hints;
	}
	

	@Override
	public String parse(PairToken<K, V> p)
	{
		K key = p.Key();
		V val = p.Value();
		
		String s = "";
		s += key.condense();
		s += Hints().Spacing();
		s += Hints().Separator();
		s += Hints().Spacing();
		s += val.condense();
		return s;
	}
}