package com.sytac.timesheet.controller;

import com.sytac.timesheet.domain.dtos.Timesheet;
import com.sytac.timesheet.service.TimesheetCommandService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.time.YearMonth;

@RestController
@RequestMapping("/api/v1/timesheet/{year}/{month}")
@lombok.AllArgsConstructor
public class TimesheetCommandController {

    private final TimesheetCommandService timesheetCommandService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Timesheet> saveTimesheet(@PathVariable final int year, @PathVariable final Month month,
                                                   @RequestBody final Timesheet timesheet) {
        return ResponseEntity.ok(timesheetCommandService.saveTimesheet(YearMonth.of(year, month), timesheet));
    }

}
