package com.sytac.timesheet.service.impl;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.mapper.TimesheetMapper;
import com.sytac.timesheet.repository.TimesheetRepository;
import com.sytac.timesheet.service.EmailService;
import com.sytac.timesheet.service.ExcelService;
import com.sytac.timesheet.service.TimesheetCommandService;
import org.springframework.stereotype.Component;

import java.time.YearMonth;

@lombok.AllArgsConstructor
@Component
class TimesheetCommandServiceImpl implements TimesheetCommandService {

    private final TimesheetMapper timesheetMapper;
    private final TimesheetRepository timesheetRepository;
    private final ExcelService excelService;
    private final EmailService emailService;

    @Override
    public Timesheet submitTimesheet(final YearMonth yearMonth, final Timesheet timesheet) {
        final var saved = timesheetRepository.save(timesheetMapper.apply(timesheet));
        final String filePath = excelService.createExcelFile(yearMonth, timesheet);

        // change the status to submitted
        timesheet.setStatus(Timesheet.Status.SUBMITTED);

        emailService.send("gianluigi.disconzi@sytac.io", "TEST Timesheet", "Hereby you may find blah blah", filePath);
        return timesheet;
    }
}
