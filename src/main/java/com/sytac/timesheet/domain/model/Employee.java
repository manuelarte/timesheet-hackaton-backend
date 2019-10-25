package com.sytac.timesheet.domain.model;

import lombok.Value;

public class Employee {

    @Value
    public static class Id{
        private int value;

        public Id(String value) {
            this.value=Integer.parseInt(value);
        }
    }

    @Value
    public static class Email {
        private String value;

    }
}
