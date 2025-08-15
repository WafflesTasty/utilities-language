package waffles.utils.lang.tokens.format.regex;

import waffles.utils.lang.Strings;
import waffles.utils.lang.tokens.Token;
import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.tokens.format.regex.RegexToken.Type;
import waffles.utils.lang.tokens.parsers.basic.AnyParser;
import waffles.utils.lang.utilities.patterns.Labelled;
import waffles.utils.sets.countable.wrapper.JavaList;

/**
 * A {@code RegexFormat} parses a {@code Token} according to a regex format string.
 * The format string separates static and dynamic pieces of text through a delimiter.
 * Through the {{@link #put(String, RegexValue)} method, a dynamic piece can be
 * mapped to a {@code RegexValue}, if it matches the corresponding regex.
 * 
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.1
 * 
 * 
 * @param <T>  a token type
 * @see Format
 * @see Token
 */
public class RegexFormat<T extends Token> implements Format<T>
{
	/**
	 * Defines a default delimiter for a {@code RegexFormat}.
	 */
	public static final char DELIMITER = '§';
	
	/**
	 * The {@code Hints} interface defines {@code RegexFormat} settings.
	 *
	 * @author Waffles
	 * @since 10 Aug 2025
	 * @version 1.1
	 * 
	 * @see Labelled
	 */
	@FunctionalInterface
	public static interface Hints extends Labelled
	{
		/**
		 * Returns a delimiter for the {@code Hints}.
		 * 
		 * @return  a delimiter character
		 */
		public default char Delimiter()
		{
			return DELIMITER;
		}
	}
	
	
	private Type type;
	private AnyParser parser;
	private JavaList<RegexToken<T>> regex;
	private Hints hints;
	
	/**
	 * Creates a new {@code RegexFormat}.
	 * 
	 * @param h  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public RegexFormat(Hints h)
	{
		char d = h.Delimiter();
		parser = new AnyParser(c -> c != d);
		regex = new JavaList<>();
		type = Type.STATIC;
		hints = h;
	}
	
	/**
	 * Creates a new {@code RegexFormat}.
	 * 
	 * @param s  a format string
	 */
	public RegexFormat(String s)
	{
		this(() -> s);
	}
	
	
	/**
	 * Puts a regex into the {@code RegexFormat}.
	 * 
	 * @param r  a regex string
	 * @param v  a regex value
	 * 
	 * 
	 * @see RegexValue
	 */
	public void put(String r, RegexValue<T> v)
	{
		regex.add(new RegexToken<>(r, v));
	}
	
	/**
	 * Puts a regex into the {@code RegexFormat}.
	 * 
	 * @param r  a regex string
	 * @param v  a value string
	 */
	public void put(String r, String v)
	{
		put(r, (tkn, s) -> v);
	}
		
	/**
	 * Returns the {@code RegexFormat} hints.
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
	public String parse(T tkn)
	{		
		String fmt = Hints().Label();
		type = Type.STATIC;
		parser.reset();
		
		
		String result = "";
		for(char c : Strings.iterate(fmt))
		{
			if(!parser.consume(c))
			{
				String s = parser.generate();
				if(type == Type.STATIC)
					type = Type.REGEX;
				else
				{
					type = Type.STATIC;
					for(RegexToken<T> r : regex)
					{
						if(s.matches(r.Label()))
						{
							s = "" + r.generate(tkn, s);
							break;
						}
					}
				}
				
				parser.reset();
				result += s;
			}
		}
		
		return result;
	}
}