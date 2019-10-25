package com.sytac.timesheet.service.excel;

import org.junit.jupiter.api.Test;

import static com.sytac.timesheet.domain.HoursType.*;

class ExcelFileTest {

    @Test
    void createExcelFile() {
        final ExcelFile xls = new ExcelFile();
        xls.addHours(1, 8, WORK);
        xls.addHours(2, 8, WORK);
        xls.addHours(3, 8, COURSE);
        xls.addHours(4, 4, DOCTOR);
        xls.addHours(4, 4, WORK);
        xls.save();

        // then manually check the output :)
    }

}