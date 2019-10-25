package com.sytac.timesheet.domain.port;

import com.sytac.timesheet.domain.model.Employee;

import java.util.Optional;

public interface EmployeesRepository {
    Optional<Employee.Id> getEmployeeId(Employee.Email email);
}
