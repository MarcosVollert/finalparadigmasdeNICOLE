package agenda;

import java.time.LocalDate;

public abstract class HolidayCalendar {
	public int day;
	public int month;
	
	public HolidayCalendar(int holidayDay, int holidayMonth) {
		day = holidayDay;
		month = holidayMonth;
	}
	
	public abstract boolean checkIfHoliday( LocalDate specificDay, Agenda agenda);
}