package agenda;

import java.time.LocalDate;

public class SpecificHoliday extends HolidayCalendar {


	public SpecificHoliday(int holidayDay, int holidayMonth) {
		super(holidayDay, holidayMonth);
	}

	@Override
	public boolean checkIfHoliday(LocalDate specificDate, Agenda agenda) {
		return agenda.checkIfSpecificHoliday(specificDate, this);	
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	
}
