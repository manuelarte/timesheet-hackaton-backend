package com.sytac.timesheet.service;

import com.sytac.timesheet.domain.dtos.Timesheet;

import java.time.YearMonth;

public interface TimesheetQueryService {

    Timesheet findByMonthYear(YearMonth yearMonth);
}
