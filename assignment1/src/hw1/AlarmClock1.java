package hw1;

/**
 * This class models an alarm clock with a "snooze" feature. The clock has: 
 * a clock time (time of day),
 * an alarm time (time at which the alarm is set to go off), and 
 * an effective alarm time (time at which the alarm will next ring).
 * 
 * @author Riley McCloskey
 *
 */
public class AlarmClock1
{
	/**
	 * the clock time for this alarm clock
	 */
	private int clockTime;
	
	/**
	 * the alarm time for this alarm clock
	 */
	private int alarmTime;
	
	/**
	 * the current state of this alarm clock, on or off
	 */
	private boolean alarmState;
	
	/**
	 * the effective alarm time for this alarm clock, as influenced by snooze
	 */
	private int effectiveAlarmTime;
	
	/**
	 * the current ringing state of this alarm
	 */
	private boolean ring;
	
	/**
	 * the state of the snooze feature, on or off
	 */
	private boolean snooze;
	
	
	/**
	 * Number of minutes in a 24-hour day.
	 */
	public static final int MINUTES_PER_DAY = 1440;
	
	/**
	 * Number of minutes to silence the alarm when snoozing.
	 */
	public static final int SNOOZE_MINUTES = 9;
	
	
	/**
	 * Constructs an alarm clock with initial clock time at 00:00 and alarm time at 01:00.
	 */
	public AlarmClock1()
	{
		clockTime = 0;
		alarmTime = 60;
		ring = false;
		alarmState = false;
		effectiveAlarmTime = alarmTime;
//		Do I need an instance var for snooze?
		snooze = false;
	}
	
	/**
	 * Constructs an alarm clock with given initial clock time and with alarm time at 01:00.
	 * @param hours
	 * 	hour for clock time
	 * @param minutes
	 * 	minutes for clock time
	 */
	public AlarmClock1(int hours, int minutes)
	{
		clockTime = hours * 60 + minutes;
		alarmTime = 60;
		ring = false;
		alarmState = false;
		effectiveAlarmTime = alarmTime;
//		Do I need an instance var for snooze?
		snooze = false;
	}
	
	/**
	 * Advances the clock time by the specified number of minutes.
	 * @param minutes
	 * 	the number of minutes to advance the time
	 */
	public void advanceTime(int minutes)
	{
		clockTime += minutes;
		if (clockTime >= effectiveAlarmTime && alarmState == true)
		{
			ring = true;
		}
		clockTime = clockTime % MINUTES_PER_DAY;
	}
	
	/**
	 * Advances the clock time by the given hours and minutes.
	 * @param hours
	 * 	the number of hours to advance the time
	 * @param minutes
	 * 	the number of minutes to advance the time
	 */
	public void advanceTime(int hours, int minutes)
	{
		clockTime += hours * 60;
		advanceTime(minutes);
	}
	
	/**
	 * Turns off the alarm, stops it from ringing and cancels snooze if it is in effect.
	 */
	public void alarmOff()
	{
		alarmState = false;
		ring = false;
		snooze = false;
		effectiveAlarmTime = alarmTime;
	}
	
	/**
	 * Turns the alarm on.
	 */
	public void alarmOn()
	{
		alarmState = true;
	}
	
	/**
	 * Returns the current alarm time as the number of minutes past midnight.
	 * @return the number of minutes past midnight for the alarm time
	 */
	public int getAlarmTime()
	{
		return alarmTime;
	}
	
	/**
	 * Returns the current alarm time as a string of the form hh:mm.
	 * @return alarm time in string form
	 */
	public String getAlarmTimeAsString()
	{
		int hours = alarmTime / 60;
		int minutes = alarmTime % 60;
		String timeString = String.format("%02d:%02d", hours, minutes);
		return timeString;
	}
	
	/**
	 * Returns the current clock time as the number of minutes past midnight.
	 * @return the current number of minutes past midnight for the clock time
	 */
	public int getClockTime()
	{
		return clockTime;
	}
	
	/**
	 * Returns the current clock time as a string in the form hh:mm.
	 * @return clock time in string form
	 */
	public String getClockTimeAsString()
	{
		int hours = clockTime / 60;
		int minutes = clockTime % 60;
		String timeString = String.format("%02d:%02d", hours, minutes);
		return timeString;
	}
	
	/**
	 * Returns the effective alarm time as the number of minutes past midnight.
	 * @return the number of minutes past midnight for the effective alarm time
	 */
	public int getEffectiveAlarmTime()
	{
		return effectiveAlarmTime;
	}
	
	/**
	 * Returns the effective alarm time as a string in the form hh:mm.
	 * @return effective alarm time in string form
	 */
	public String getEffectiveAlarmTimeAsString()
	{
		int hours = effectiveAlarmTime / 60;
		int minutes = effectiveAlarmTime % 60;
		String timeString = String.format("%02d:%02d", hours, minutes);
		return timeString;
	}
	
	/**
	 * Determines whether the clock is currently ringing.
	 * @return true if the clock is currently ringing
	 */
	public boolean isRinging()
	{
		return ring;
	}
	
	/**
	 * Sets the alarm time to the given hours and minutes.
	 * @param hours
	 * 	hours for alarm time
	 * @param minutes
	 * 	minutes for alarm time
	 */
	public void setAlarmTime(int hours, int minutes)
	{
		alarmTime = hours * 60 + minutes;
//		alarmTime = alarmTime % MINUTES_PER_DAY
//		need to make something that won't allow numbers outside the accepted range and
//		tells them what they need to input instead?
	}
	
	/**
	 * Sets the clock time to the given hours and minutes.
	 * @param hours
	 * 	hours for clock time
	 * @param minutes
	 * 	minutes for clock time
	 */
	public void setTime(int hours, int minutes)
	{
		clockTime = hours * 60 + minutes;
//		Is it necessary to put mod MINUTES_PER_DAY in each method or
//		should I just put it in the getClockTime method?
//		clockTime = clockTime % MINUTES_PER_DAY;
	}
	
	/**
	 * Stops the clock from ringing and sets the effective alarm time for
	 *  SNOOZE_MINUTES minutes after the current clock time.
	 */
	public void snooze()
	{
		snooze = true;
		ring = false;
		effectiveAlarmTime = clockTime + SNOOZE_MINUTES;
	}
}
