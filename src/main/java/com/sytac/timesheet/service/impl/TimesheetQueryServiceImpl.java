package com.sytac.timesheet.service.impl;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.domain.dtos.TimesheetEntry;
import com.sytac.timesheet.service.TimesheetQueryService;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
class TimesheetQueryServiceImpl implements TimesheetQueryService {

    @Override
    public Timesheet findByMonthYear(final YearMonth yearMonth) {
        final List<TimesheetEntry> timesheetEntries = IntStream.rangeClosed(1, yearMonth.lengthOfMonth())
                .mapToObj(day -> LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), day))
                .map(map())
                .collect(Collectors.toList());

        // TODO
        Timesheet timesheet = new Timesheet();
        timesheet.setClient("ING");
        timesheet.setStatus(Timesheet.Status.DRAFT);
        timesheet.setTimesheets(timesheetEntries);

        return timesheet;
    }

    private Function<LocalDate, TimesheetEntry> map() {
        return localDate -> {
            final var timesheetEntry = new TimesheetEntry();
            timesheetEntry.setDate(LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()));
            if (isWeekend().test(localDate)) {
                // TODO
            } else {
                timesheetEntry.setWorked(8);
            }
            return timesheetEntry;
        };
    }

    private Predicate<LocalDate> isWeekend() {
        return localDate ->
             localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

}
