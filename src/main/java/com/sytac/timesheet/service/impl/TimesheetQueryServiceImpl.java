package com.sytac.timesheet.service.impl;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.service.TimesheetQueryService;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.time.YearMonth;

@Component
class TimesheetQueryServiceImpl implements TimesheetQueryService {

    @Override
    public Timesheet findByMonthYear(final YearMonth yearMonth) {
        // TODO
        Timesheet timesheets = new Timesheet();
        timesheets.setClient("ING");
        timesheets.setStatus(Timesheet.Status.DRAFT);

        return timesheets;
    }

}
