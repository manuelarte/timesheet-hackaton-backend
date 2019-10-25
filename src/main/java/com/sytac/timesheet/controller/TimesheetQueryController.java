package com.sytac.timesheet.controller;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.service.TimesheetQueryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.time.YearMonth;

@RestController
@RequestMapping("/api/v1/timesheet/{year}/{month}")
@lombok.AllArgsConstructor
public class TimesheetQueryController {

    private final TimesheetQueryService timesheetQueryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Timesheet> findByMonthYear(@PathVariable final int year, @PathVariable final Month month) {
        return ResponseEntity.ok(timesheetQueryService.findByMonthYear(YearMonth.of(year, month)));
    }

}
