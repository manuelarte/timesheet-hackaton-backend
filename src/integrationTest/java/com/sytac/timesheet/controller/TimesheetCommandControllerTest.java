package com.sytac.timesheet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sytac.timesheet.Util;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith({SpringExtension.class})
public class TimesheetCommandControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    void testPostTimesheet() throws Exception {

        final var timesheet = Util.createDefaultTimesheet(YearMonth.of(2019, Month.JANUARY));

        mvc.perform(post("/api/v1/timesheet/2019/January")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(timesheet)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.client").value(Matchers.notNullValue()))
                .andExpect(jsonPath("$.status").value(Matchers.is("SUBMITTED")))
                .andExpect(jsonPath("$.timesheets", hasSize(31)));
    }

}
