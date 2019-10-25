package com.sytac.timesheet.mapper;

import com.sytac.timesheet.domain.dtos.TimesheetEntry;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.Set;

@Component
@Order(1)
public class NationalHolidaysMapper implements LocalDateToTimesheetEntryMapper{

    // TODO retrieve them from somewhere
    private final Set<MonthDay> HARDCODED = Set.of(
            MonthDay.of(Month.JANUARY, 1),
            MonthDay.of(Month.DECEMBER, 25),
            MonthDay.of(Month.JANUARY, 26)
    );

    @Override
    public TimesheetEntry apply(LocalDate localDate) {
        final var timesheetEntry = new TimesheetEntry();
        timesheetEntry.setDate(LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()));
        timesheetEntry.setLeave(8D);
        return timesheetEntry;
    }

    @Override
    public boolean test(LocalDate localDate) {
        return HARDCODED.contains(MonthDay.from(localDate));
    }
}
