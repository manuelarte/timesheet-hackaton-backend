package com.sytac.timesheet.service.excel;

import com.sytac.timesheet.domain.HoursType;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

@Slf4j
public class ExcelFile {
    private static final String TEMPLATE_XLS_PATH = "/xls/template.xls";

    private static final int COLUMN_OFFSET = 0;
    private static final int WORKED_ROW = 4;
    private static final int INTERNAL_HOURS_ROW = 5;
    private static final int COURSES_ROW = 6;
    private static final int LEAVE_ROW = 7;
    private static final int SPEC_LEAVE_ROW = 8;
    private static final int SICKNESS_ROW = 10;
    private static final int DOCTOR_ROW = 11;

    private Sheet xlsSheet;

    public ExcelFile() {
        final InputStream inputStream = ExcelFile.class.getResourceAsStream(TEMPLATE_XLS_PATH);
        try {
            final Workbook workbook =  new HSSFWorkbook(inputStream);
            xlsSheet = workbook.getSheetAt(0);
        } catch (final IOException e) {
            log.error("Unable to open template XLS file", e);
        }
    }

    public void addHours(final int day, final int hours, final HoursType type) {
        final Row row = xlsSheet.getRow(getRowNumByType(type));
        final Cell cell = row.getCell(COLUMN_OFFSET + day);
        cell.setCellValue(hours);
    }

    public void save() {
        try {
            final File file = File.createTempFile("timesheet", ".xls");
            final OutputStream out = new FileOutputStream(file);
            xlsSheet.getWorkbook().write(out);
        } catch (IOException e) {
            log.error("Unable to save XLS file", e);
        }

    }

    private int getRowNumByType(final HoursType type) {
        switch (type) {
            case WORK: return WORKED_ROW;
            case INTERNAL: return INTERNAL_HOURS_ROW;
            case COURSE: return COURSES_ROW;
            case LEAVE: return LEAVE_ROW;
            case SPEC_LEAVE: return SPEC_LEAVE_ROW;
            case SICK: return SICKNESS_ROW;
            case DOCTOR: return DOCTOR_ROW;
            default: return -1;
        }
    }
}
