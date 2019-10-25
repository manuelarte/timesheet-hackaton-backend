package com.sytac.timesheet;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.domain.dtos.TimesheetEntry;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class Util {

    public static Timesheet createDefaultTimesheet(final YearMonth yearMonth) {

        int daysInMonth = yearMonth.lengthOfMonth(); //28
        final List<TimesheetEntry> list = IntStream.range(1, daysInMonth+1)
                .mapToObj(day -> {
                    TimesheetEntry timesheetEntry = new TimesheetEntry();
                    timesheetEntry.setDate(LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), day));
                    timesheetEntry.setWorked(8D);
                    return timesheetEntry;
                }).collect(Collectors.toList());

        Timesheet timesheet = new Timesheet();
        timesheet.setStatus(Timesheet.Status.DRAFT);
        timesheet.setClient("ING");
        timesheet.setTimesheets(list);
        return timesheet;
    }
}
