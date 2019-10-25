package com.sytac.timesheet.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.Month;
import java.time.YearMonth;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith({SpringExtension.class})
public class TimesheetQueryControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    void testGetTimesheet() throws Exception {
        final var yearMonth = YearMonth.of(2019, Month.JANUARY);
        mvc.perform(get("/api/v1/timesheet/{year}/{month}", yearMonth.getYear(), yearMonth.getMonth())
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.client").value(Matchers.notNullValue()))
                .andExpect(jsonPath("$.status").value(Matchers.is("DRAFT")))
                .andExpect(jsonPath("$.timesheets", hasSize(yearMonth.lengthOfMonth())));
    }

}
