package com.sytac.timesheet.controller;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.service.TimesheetQueryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;

@RestController
@RequestMapping("/api/v1/timesheet")
@lombok.AllArgsConstructor
public class TimesheetQueryController {

    private final TimesheetQueryService timesheetQueryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Timesheet> findByMonthYear(@RequestParam("year") final int year, @RequestParam("month") final Month month) {
        return ResponseEntity.ok(timesheetQueryService.findByMonthYear(year, month));
    }

}
