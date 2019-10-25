package com.sytac.timesheet.service.impl;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.domain.dtos.TimesheetEntry;
import com.sytac.timesheet.mapper.LocalDateToTimesheetEntryMapper;
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
@lombok.AllArgsConstructor
class TimesheetQueryServiceImpl implements TimesheetQueryService {

    private final List<LocalDateToTimesheetEntryMapper> mappers;

    @Override
    public Timesheet findByMonthYear(final YearMonth yearMonth) {
        final List<TimesheetEntry> timesheetEntries = IntStream.rangeClosed(1, yearMonth.lengthOfMonth())
                .mapToObj(day -> LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), day))
                .map(map())
                .collect(Collectors.toList());
        final var timesheet = new Timesheet();
        timesheet.setClient("ING");
        timesheet.setStatus(Timesheet.Status.DRAFT);
        timesheet.setTimesheets(timesheetEntries);
        return timesheet;
    }

    private Function<LocalDate, TimesheetEntry> map() {
        return localDate ->
            mappers.stream().filter(m -> m.test(localDate)).findFirst().get().apply(localDate);
    }

}
