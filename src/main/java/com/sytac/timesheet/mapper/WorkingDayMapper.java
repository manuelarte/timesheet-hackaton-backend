package com.sytac.timesheet.mapper;

import com.sytac.timesheet.domain.dtos.TimesheetEntry;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
@Order
public class WorkingDayMapper implements LocalDateToTimesheetEntryMapper{

    @Override
    public TimesheetEntry apply(LocalDate localDate) {
        final var timesheetEntry = new TimesheetEntry();
        timesheetEntry.setDate(LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()));
        timesheetEntry.setWorked(8D);
        return timesheetEntry;
    }

    @Override
    public boolean test(LocalDate localDate) {
        return true;
    }
}
