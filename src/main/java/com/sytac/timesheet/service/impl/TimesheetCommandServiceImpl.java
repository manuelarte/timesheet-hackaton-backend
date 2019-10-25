package com.sytac.timesheet.service.impl;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.service.EmailService;
import com.sytac.timesheet.service.ExcelService;
import com.sytac.timesheet.service.TimesheetCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.YearMonth;

@AllArgsConstructor
@Component
class TimesheetCommandServiceImpl implements TimesheetCommandService {

    private ExcelService excelService;
    private EmailService emailService;

    @Override
    public Timesheet saveTimesheet(final YearMonth yearMonth, final Timesheet timesheet) {
        final String filePath = excelService.createExcelFile(yearMonth, timesheet);

        // change the status to submitted
        timesheet.setStatus(Timesheet.Status.SUBMITTED);

        emailService.send("manuel.doncel@sytac.io", "TEST Timesheet", "Hereby you may find blah blah", filePath);
        return timesheet;
    }
}
