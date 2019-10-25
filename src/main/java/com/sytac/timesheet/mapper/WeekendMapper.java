package com.sytac.timesheet.mapper;

import com.sytac.timesheet.domain.dtos.TimesheetEntry;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
@Order(2)
public class WeekendMapper implements LocalDateToTimesheetEntryMapper{

    @Override
    public TimesheetEntry apply(LocalDate localDate) {
        final var timesheetEntry = new TimesheetEntry();
        timesheetEntry.setDate(LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()));
        return timesheetEntry;
    }

    @Override
    public boolean test(LocalDate localDate) {
        return localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
