package com.sytac.timesheet.service.excel;

import org.junit.jupiter.api.Test;

import static com.sytac.timesheet.domain.HoursType.*;

class ExcelFileTest {

    @Test
    void createExcelFile() {
        final ExcelFile xls = new ExcelFile();
        xls.addHours(1, 8D, WORK);
        xls.addHours(2, 8D, WORK);
        xls.addHours(3, 8D, COURSE);
        xls.addHours(4, 4D, DOCTOR);
        xls.addHours(4, 4D, WORK);
        xls.save();

        // then manually check the output :)
    }

}