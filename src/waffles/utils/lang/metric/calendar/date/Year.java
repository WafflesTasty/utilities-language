package waffles.utils.lang.metric.calendar.date;

import waffles.utils.tools.patterns.properties.counters.Indexable;

/**
 * A {@code Year} defines the largest segment in a {@code Date}.
 * Each year has a long index and can provide the current day value.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 * 
 * @see Indexable
 */
public interface Year extends Indexable
{
	/**
	 * Returns the day of the {@code Month}.
	 * 
	 * @return  a month day
	 */
	public abstract long Day();
}