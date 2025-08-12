package waffles.utils.lang.metric.calendar.date;

/**
 * A {@code Week} defines a segment of a year in a {@code Date}.
 * Each week can provide the current day name.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 */
@FunctionalInterface
public interface Week
{
	/**
	 * Returns the day name of the {@code Week}.
	 * 
	 * @return  a week day name
	 */
	public abstract String DayName();
}