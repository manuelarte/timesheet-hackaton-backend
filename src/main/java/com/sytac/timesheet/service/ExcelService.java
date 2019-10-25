package com.sytac.timesheet.service;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.service.excel.ExcelFile;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

import static com.sytac.timesheet.domain.HoursType.*;

@Service
public class ExcelService {

    public void createExcelFile(final YearMonth yearMonth, final Timesheet timesheet) {

        final ExcelFile file = new ExcelFile();
        file.addPeriod(yearMonth);

        for (final var entry : timesheet.getTimesheets()) {
            final int day = entry.getDate().getDayOfMonth();

            file.addHours(day, entry.getWorked(), WORK);
            file.addHours(day, entry.getInternal_hours(), INTERNAL);
            file.addHours(day, entry.getCourses(), COURSE);
            file.addHours(day, entry.getLeave(), LEAVE);
            file.addHours(day, entry.getSpecial_leave(), SPEC_LEAVE);
            file.addHours(day, entry.getSick(), SICK);
            file.addHours(day, entry.getDoctor(), DOCTOR);
            file.addHours(day, entry.getStandby(), STANDBY);
//            file.addHours(day, entry.getPart_time_leave(), SPEC_LEAVE); // TODO: not mapped in the Excel file
        }

        file.save();
    }

}
