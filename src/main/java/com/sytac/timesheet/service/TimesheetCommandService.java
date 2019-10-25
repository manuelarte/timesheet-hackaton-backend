package com.sytac.timesheet.service;

import com.sytac.timesheet.domain.dtos.Timesheet;

import java.time.Month;

public interface TimesheetCommandService {

    Timesheet saveTimesheet(int year, Month month, Timesheet timesheet);
}
