package waffles.utils.lang.metric.calendar.date;

import waffles.utils.lang.utilities.patterns.Labelled;
import waffles.utils.tools.patterns.properties.counters.Discernible;

/**
 * A {@code Month} defines a segment of a year in a {@code Date}.
 * Each month has a name, an integer identifier, and can
 * provide the current day value.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 * 
 * @see Discernible
 * @see Labelled
 */
public interface Month extends Discernible, Labelled
{
	/**
	 * Returns the day of the {@code Month}.
	 * 
	 * @return  a month day
	 */
	public abstract long Day();
}