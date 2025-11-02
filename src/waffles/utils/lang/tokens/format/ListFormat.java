package waffles.utils.lang.tokens.format;

import java.util.Iterator;

import waffles.utils.lang.tokens.ListToken;
import waffles.utils.lang.tokens.Token;

/**
 * A {@code ListFormat} defines a formatter for a {@code ListToken}.
 *
 * @author Waffles
 * @since 13 Mar 2024
 * @version 1.1
 *
 *
 * @param <T>  a token type
 * @see ListToken
 * @see Format
 * @see Token
 */
public class ListFormat<T extends Token> implements Format<ListToken<T>>
{
	/**
	 * Defines a default {@code ListFormat} lower bound.
	 */
	public static final char LOWER = '[';
	/**
	 * Defines a default {@code ListFormat} upper bound.
	 */
	public static final char UPPER = ']';
	/**
	 * Defines a default {@code ListFormat} separator.
	 */
	public static final char SEPARATOR = ',';
	
	
	/**
	 * The {@code Hints} interface defines {@code ListFormat} settings.
	 *
	 * @author Waffles
	 * @since 08 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see PairFormat
	 */
	public interface Hints extends PairFormat.Hints
	{
		/**
		 * Returns the lower bound of the {@code ListFormat}.
		 * 
		 * @return  a lower bound character
		 */
		public abstract Character LowerBound();
		
		/**
		 * Returns the upper bound of the {@code ListFormat}.
		 * 
		 * @return  an upper bound character
		 */
		public abstract Character UpperBound();
		
		/**
		 * Returns a {@code ListFormat} compact state.
		 * 
		 * @return  a compact state
		 */
		public default boolean isCompact()
		{
			return true;
		}
	}
	
	/**
	 * A {@code Descriptor} describes the data in a {@code ListToken}.
	 *
	 * @author Waffles
	 * @since 08 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see Iterator
	 */
	public class Descriptor implements Iterator<String>
	{
		private String next;
		private Iterator<T> tokens;
		
		/**
		 * Creates a new {@code Descriptor}.
		 * 
		 * @param list  a token list
		 * 
		 * 
		 * @see ListToken
		 */
		public Descriptor(ListToken<T> list)
		{
			tokens = list.Tokens().iterator();
		}
		
		
		String findNext()
		{
			Character l = Hints().LowerBound();
			Character u = Hints().UpperBound();
			Character s = Hints().Separator();
			
			if(tokens.hasNext())
			{
				if(next == null)
					return "" + l;
				
				T tkn = tokens.next();

				String cnd = tkn.condense();
				if(tokens.hasNext())
					return cnd + s;
				return cnd;
			}
			
			if(next != null)
				return "" + u;			
			return null;
		}

		@Override
		public boolean hasNext()
		{
			return next != null;
		}

		@Override
		public String next()
		{
			String curr = next;
			next = findNext();
			return curr;
		}
	}
	
	
	private Hints hints;
		
	/**
	 * Creates a new {@code ListFormat}.
	 */
	public ListFormat()
	{
		this(LOWER, SEPARATOR, UPPER);
	}

	/**
	 * Creates a new {@code ListFormat}.
	 * 
	 * @param sep  separator between list objects
	 */
	public ListFormat(char sep)
	{
		this(new Hints()
		{
			@Override
			public Character LowerBound()
			{
				return null;
			}

			@Override
			public Character UpperBound()
			{
				return null;
			}
			
			@Override
			public char Separator()
			{
				return sep;
			}
		});
	}
	
	/**
	 * Creates a new {@code ListFormat}.
	 * 
	 * @param low  lower character of the list
	 * @param upp  upper character of the list
	 */
	public ListFormat(char low, char upp)
	{
		this(low, ',', upp);
	}
	
	/**
	 * Creates a new {@code ListFormat}.
	 * 
	 * @param low  lower character of the list
	 * @param sep  separator between list objects
	 * @param upp  upper character of the list
	 */
	public ListFormat(char low, char sep, char upp)
	{
		this(new Hints()
		{
			@Override
			public Character LowerBound()
			{
				return low;
			}

			@Override
			public Character UpperBound()
			{
				return upp;
			}
			
			@Override
			public char Separator()
			{
				return sep;
			}
		});
	}
	
	/**
	 * Creates a new {@code ListFormat}.
	 * 
	 * @param h  format hints
	 * 
	 * 
	 * @see Hints
	 */
	public ListFormat(Hints h)
	{
		hints = h;
	}
	
	/**
	 * Returns {@code ListFormat} hints.
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
	public Iterable<String> describe(ListToken<T> tkn)
	{
		return () -> new Descriptor(tkn);
	}
	
	@Override
	public String parse(ListToken<T> list)
	{
		Character l = Hints().LowerBound();
		Character u = Hints().UpperBound();
		Character s = Hints().Separator();
		Character x = Hints().Spacing();
		
		
		String prs = "";
		if(l != null)
		{
			prs += l;
		}
		
		boolean isEmpty = true;
		for(T tkn : list.Tokens())
		{
			if(!isEmpty)
			{
				prs += s;
			}
			
			prs += x + tkn.condense() + x;
			isEmpty = false;
		}

		if(u != null)
		{
			prs += u;
		}
		
		return prs;
	}
}