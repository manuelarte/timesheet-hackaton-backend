package com.sytac.timesheet.service;

import com.sytac.timesheet.domain.dtos.Timesheet;

import java.time.YearMonth;

public interface TimesheetCommandService {

    Timesheet submitTimesheet(final YearMonth yearMonth, Timesheet timesheet);
}
