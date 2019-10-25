package com.sytac.timesheet.mapper;

import com.sytac.timesheet.domain.dtos.TimesheetEntry;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Predicate;

public interface LocalDateToTimesheetEntryMapper extends Predicate<LocalDate>, Function<LocalDate, TimesheetEntry> {


}
