package agenda;

import java.time.LocalDate;

public class WeeklyHoliday extends HolidayCalendar{

	public WeeklyHoliday(int holidayDay, int holidayMonth) {
		super(holidayDay, holidayMonth);
	}

	@Override
	public boolean checkIfHoliday(LocalDate specificDay, Agenda agenda) {
		return agenda.checkIfWeeklyHoliday(specificDay, this);
	}

}
