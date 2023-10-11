package agenda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Agenda {

	public ArrayList <HolidayCalendar> holidays = new ArrayList<HolidayCalendar>();
		
	public void addHoliday(HolidayCalendar holiday) {
		holidays.add(holiday);
	}
	
    public boolean isHoliday(LocalDate date) {
        return holidays.stream()
                .anyMatch(holiday -> holiday.checkIfHoliday(date, this));
	}
    
    public boolean checkIfSpecificHoliday(LocalDate date, SpecificHoliday holiday) {
        return date.getMonthValue() == holiday.getMonth()&& date.getDayOfMonth() == holiday.getDay();
    }

    public boolean checkIfWeeklyHoliday(LocalDate date, WeeklyHoliday holiday) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public boolean checkIfExtendedHoliday(LocalDate date, ExtendedHoliday holiday) {
        return !date.isBefore(holiday.getStartingDay()) && !date.isAfter(holiday.getFinalDay());
    }
}
