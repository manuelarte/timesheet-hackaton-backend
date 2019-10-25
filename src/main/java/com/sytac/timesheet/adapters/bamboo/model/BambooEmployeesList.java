package com.sytac.timesheet.adapters.bamboo.model;

import lombok.Value;

import java.util.List;

@Value
public class BambooEmployeesList {
    private List<BambooEmployee> employees;
}
