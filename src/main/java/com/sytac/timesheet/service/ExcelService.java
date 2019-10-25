package com.sytac.timesheet.service;

import com.sytac.timesheet.domain.dtos.Timesheet;

import java.time.YearMonth;

public interface ExcelService {

    String createExcelFile(final YearMonth yearMonth, final Timesheet timesheet);
}
