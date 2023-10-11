package agenda;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HolidayCalendarTest {

	@Test
	void testCreateASpecificHolidayAndCertifyItIsAHoliday() {
	Agenda agenda = createAgendaWithChristmas();
	LocalDate testingDate = createALocalDate(2024,12,25);
	assertTrue(agenda.isHoliday(testingDate));
	}

	@Test
	void testCreateASpecificHolidayAndShowThatTheLocalDayIsNotThatHoliday() {
	Agenda agenda = createAgendaWithChristmas();
	LocalDate testingDate = LocalDate.of(2024, 2, 2);
	assertFalse(agenda.isHoliday(testingDate));
	}

	@Test
	void testCreateTwoSpecificHolidaysAndShowThatTheLocalDateIsOneHolidayAndNotTheOther() {
    Agenda agenda = createAgendaWithChristmasAndNewYear();
    assertTrue(agenda.isHoliday(LocalDate.of(2024, 12, 25)));
	}

	@Test
	void testCreateTwoSpecificHolidaysAndShowThatTheLocalDateIsOneHolidayAndNotTheOther2() {
    Agenda agenda = createAgendaWithChristmasAndNewYear();
    LocalDate testingDate = LocalDate.of(2024, 1, 1);
    assertTrue(agenda.isHoliday(testingDate));
	}
	
	@Test
	void testCreateTwoSpecificHolidaysAndShowThatTheLocalDateIsNotAHoliday() {
    Agenda agenda = createAgendaWithChristmasAndNewYear();
    assertFalse(agenda.isHoliday(LocalDate.of(2021, 2, 2)));
    assertFalse(agenda.isHoliday(LocalDate.of(2021, 2, 2)));
	}
	
	@Test
	void testCheckIfLocalSundayIsAHoliday() {
    Agenda agenda = createAgendaWithWeeklyHoliday();
    assertTrue(agenda.isHoliday(LocalDate.of(2024, 12, 29)));
	}

	@Test
	void testCheckThatANotLocalSundayIsNotAHoliday() {
    Agenda agenda = createAgendaWithWeeklyHoliday();
    assertFalse(agenda.isHoliday(LocalDate.of(2024, 2, 2)));
	}
	
	@Test
	void testCreateAVacationPeriodAndAssertThatTheLocalDateIsInThatHoliday() {
	    Agenda agenda = createAgendaWithAExtendedHoliday();
	    assertTrue(agenda.isHoliday(LocalDate.of(2024, 1, 18)));
	}

	@Test
	void testCreateAVacationPeriodAndDenyThatTheLocalDateIsInThatHoliday() {
	    Agenda agenda = createAgendaWithAExtendedHoliday();
	    assertFalse(agenda.isHoliday(LocalDate.of(2024, 2, 18)));
	}
	
	@Test
	void testCheckIfHolidayInAgendaWithMultipleExtendedHolidays() {
		Agenda agenda = createAgendaWithTwoExtendedHolidays();
	    assertTrue(agenda.isHoliday(LocalDate.of(2024, 1, 18)));
	    assertTrue(agenda.isHoliday(LocalDate.of(2024, 7, 18)));   
	}

	@Test
	void testCheckIfHolidayInAgendaAndSundayWithMultipleExtendedHolidays() {
		Agenda agenda = createAgendaWithTwoExtendedHolidays();
		addWeeklyHoliday(agenda);
	    assertTrue(agenda.isHoliday(LocalDate.of(2024, 1, 20)));
	    assertTrue(agenda.isHoliday(LocalDate.of(2024, 1, 20)));    
	}
	
	@Test
	void testCheckIfNotHolidayInAgendaAndNotSundayWithMultipleExtendedHolidays() {
		Agenda agenda = createAgendaWithTwoExtendedHolidays();
		addWeeklyHoliday(agenda);
	    assertFalse(agenda.isHoliday(LocalDate.of(2024, 3, 18)));
	    assertFalse(agenda.isHoliday(LocalDate.of(2024, 3, 18)));    
	}
	
	public LocalDate createALocalDate(int year, int month, int day) {
		LocalDate testingDate = LocalDate.of(year, month, day);
		return testingDate;
	}

	public Agenda createAgendaWithChristmas() {
		Agenda agenda = new Agenda();
		HolidayCalendar christmas = new SpecificHoliday(25, 12);
		agenda.addHoliday(christmas);
		return agenda;
	}

	public Agenda createAgendaWithChristmasAndNewYear() {
		Agenda agenda = new Agenda();
		HolidayCalendar christmas = new SpecificHoliday(25, 12);
		HolidayCalendar newYear = new SpecificHoliday(1, 1);
		agenda.addHoliday(christmas);
		agenda.addHoliday(newYear);
		return agenda;
	}
	
	public void addWeeklyHoliday(Agenda agenda) {
		HolidayCalendar weeklyHoliday = new WeeklyHoliday(0, 0);
		agenda.addHoliday(weeklyHoliday);
	}
	
	public Agenda createAgendaWithWeeklyHoliday() {
		Agenda agenda = new Agenda();
		addWeeklyHoliday(agenda);
		return agenda;
	}

	public Agenda createAgendaWithAExtendedHoliday() {
		Agenda agenda = new Agenda();
	    LocalDate startDateOfVacation = LocalDate.of(2024, 1, 15);
	    LocalDate endDateOfVacation = LocalDate.of(2024, 2, 1);
	    HolidayCalendar summerVacation = new ExtendedHoliday(startDateOfVacation, endDateOfVacation);
	    agenda.addHoliday(summerVacation);
		return agenda;
	}
	
	public Agenda createAgendaWithTwoExtendedHolidays() {
		Agenda agenda = new Agenda();
		LocalDate startDateOfVacation = LocalDate.of(2024, 1, 15);
	    LocalDate endDateOfVacation = LocalDate.of(2024, 2, 1);
	    LocalDate winterStartDateOfVacation = LocalDate.of(2024, 7, 15);
	    LocalDate winterEndDateOfVacation = LocalDate.of(2024, 8, 1);
	    
	    HolidayCalendar summerVacation = new ExtendedHoliday(startDateOfVacation, endDateOfVacation);
	    HolidayCalendar winterVacation = new ExtendedHoliday(winterStartDateOfVacation,winterEndDateOfVacation);
	    agenda.addHoliday(summerVacation);
	    agenda.addHoliday(winterVacation);
		return agenda;
	}
	
	
}
