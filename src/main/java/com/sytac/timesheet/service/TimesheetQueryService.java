package com.sytac.timesheet.service;

import com.sytac.timesheet.domain.dtos.Timesheet;

import java.time.Month;

public interface TimesheetQueryService {

    Timesheet findByMonthYear(int year, Month month);
}
