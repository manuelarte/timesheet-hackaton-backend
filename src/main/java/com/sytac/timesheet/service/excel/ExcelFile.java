package com.sytac.timesheet.service.excel;

import com.sytac.timesheet.domain.HoursType;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.time.YearMonth;

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
    private static final int STANDBY_ROW = 20;

    private static final int DATE_ROW = 1;
    private static final int DATE_COL = 13;

    private static final int CUSTOMER_ROW = 0;
    private static final int CUSTOMER_COL = 13;

    private static final int CONSULTANT_ROW = 0;
    private static final int CONSULTANT_COL = 1;

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

    public void addHours(final int day, final Double hours, final HoursType type) {
        if (hours == null || hours <= 0) {
            return;
        }

        final Row row = xlsSheet.getRow(getRowNumByType(type));
        final Cell cell = row.getCell(COLUMN_OFFSET + day);
        cell.setCellValue(hours);
    }

    public void addPeriod(final YearMonth yearMonth) {
        final Row row = xlsSheet.getRow(DATE_ROW);
        final Cell cell = row.getCell(DATE_COL);
        cell.setCellValue(yearMonth.toString());
    }

    public void addCustomer(final String customerName) {
        final Row row = xlsSheet.getRow(CUSTOMER_ROW);
        final Cell cell = row.getCell(CUSTOMER_COL);
        cell.setCellValue(customerName);
    }

    public void addConsultant(final String consultantFullName) {
        final Row row = xlsSheet.getRow(CONSULTANT_ROW);
        final Cell cell = row.getCell(CONSULTANT_COL);
        cell.setCellValue(consultantFullName);
    }

    public String save() {
        String fileName = null;
        try {
            final File file = File.createTempFile("timesheet", ".xls");
            final OutputStream out = new FileOutputStream(file);
            xlsSheet.getWorkbook().write(out);
            fileName = file.getAbsolutePath();
        } catch (IOException e) {
            log.error("Unable to save XLS file", e);
        }

        return fileName;
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
            case STANDBY: return STANDBY_ROW;
            default: return -1;
        }
    }
}
