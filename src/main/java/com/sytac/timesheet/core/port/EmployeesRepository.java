package com.sytac.timesheet.core.port;

import com.sytac.timesheet.core.model.Employee;

import java.util.Optional;

public interface EmployeesRepository {
    public Optional<Employee.Id> getEmployeeId(Employee.Email email);
}
