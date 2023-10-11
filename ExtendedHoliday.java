package agenda;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class ExtendedHoliday extends HolidayCalendar {
	private LocalDate startingDay;
	private LocalDate finalDay;

	public ExtendedHoliday(LocalDate startDay,LocalDate lastDay) {
		super(0, 0);
		startingDay = startDay;
		finalDay = lastDay;
	}

	@Override
	public boolean checkIfHoliday(LocalDate specificDay, Agenda agenda) {
		return agenda.checkIfExtendedHoliday(specificDay, this);	

	}

	public ChronoLocalDate getStartingDay() {
		return startingDay;
	}

	public ChronoLocalDate getFinalDay() {
		return finalDay;
	}
	


}
