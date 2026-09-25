package waffles.utils.lang.utilities.patterns.lexic;

import java.util.Comparator;

/**
 * A {@code LexicOrder} orders objects in a lexicographic manner.
 *
 * @author Waffles
 * @since Sep 25, 2026
 * @version 1.1
 *
 *
 * @param <O>  an object type
 * @see Comparator
 */
public interface LexicOrder<O> extends Comparator<O>
{
	/**
	 * Computes an object length.
	 * 
	 * @param obj  an object
	 * @return  a length
	 */
	public abstract int length(O obj);
	
	/**
	 * Returns an order {@code Iterable}.
	 * 
	 * @return  an order iterable
	 * 
	 * 
	 * @see Iterable
	 */
	public abstract Iterable<Integer> Order();
	
	/**
	 * Compares two objects at an ordered index.
	 * 
	 * @param o1  an object
	 * @param o2  an object
	 * @param ord  an order
	 * @return  a comparison of o1 vs o2
	 */
	public abstract int compare(O o1, O o2, int ord);
	
	
	@Override
	public default int compare(O o1, O o2)
	{
		int l1 = length(o1);
		int l2 = length(o2);
		
		for(Integer ord : Order())
		{			
			if(l1 <= ord)
			{
				if(l2 <= ord)
					return 0;
				return -1;
			}

			if(l2 <= ord)
			{
				return +1;
			}
			
			int c = compare(o1, o2, ord);
			if(c != 0)
			{
				return c;
			}
		}
		
		return 0;
	}
}
