package com.sytac.timesheet.service.impl;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.service.TimesheetCommandService;
import org.springframework.stereotype.Component;

import java.time.Month;

@Component
class TimesheetCommandServiceImpl implements TimesheetCommandService {

    @Override
    public Timesheet saveTimesheet(final int year, final Month month, final Timesheet timesheet) {
        // change the status to submitted
        timesheet.setStatus(Timesheet.Status.SUBMITTED);
        return timesheet;
    }

}
