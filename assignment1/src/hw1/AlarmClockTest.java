package hw1;

public class AlarmClockTest
{
	public static void main(String[] args)
	{
		
//		createID("Riley", "McCloskey");
		
		
		
		
		
		
		AlarmClock clock = new AlarmClock();
		System.out.println(clock.getClockTime());
		System.out.println("Expected: 0");
		
		clock.advanceTime(120);
		System.out.println(clock.getClockTime());
		System.out.println("Expected: 120");
		
		clock.advanceTime(1450);
		System.out.println(clock.getClockTime());
		System.out.println("Expected: 130");
		
		clock.setTime(10, 40);
		System.out.println(clock.getClockTime());
		System.out.println("Expected: 640");
		
		clock.advanceTime(1, 10);
		System.out.println(clock.getClockTime());
		System.out.println("Expected: 710");
		
		clock.advanceTime(24, 10);
		System.out.println(clock.getClockTime());
		System.out.println("Expected: 720");
		
		clock.setTime(3, 10);
		System.out.println(clock.getClockTimeAsString());
		System.out.println("Expected: 03:10");
		
		clock.setAlarmTime(12, 45);
		System.out.println(clock.getAlarmTimeAsString());
		System.out.println("Expected: 12:45");

		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		

		clock.alarmOn();
		
		clock.setTime(2, 0);
		clock.setAlarmTime(2, 30);
		
		System.out.println(clock.getClockTimeAsString());
		System.out.println("Expected: 02:00");
		System.out.println(clock.getAlarmTimeAsString());
		System.out.println("Expected: 02:30");
		
		clock.advanceTime(15);
		System.out.println(clock.getClockTimeAsString());
		System.out.println("Expected: 02:15");
		
		System.out.println(clock.isRinging());
		System.out.println("Expected: false");
		
		clock.advanceTime(15); 
		System.out.println(clock.isRinging());
		System.out.println("Expected: true");
		
		clock.advanceTime(15); 
		System.out.println(clock.isRinging());
		System.out.println("Expected: true");
		
		clock.alarmOff(); 
		System.out.println(clock.isRinging()); 
		System.out.println("Expected: false");

		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		
		
		AlarmClock c1 = new AlarmClock(11, 45);
		System.out.println(c1.getClockTimeAsString());
		System.out.println("Expected: 11:45");
		
		
		
	}

}
