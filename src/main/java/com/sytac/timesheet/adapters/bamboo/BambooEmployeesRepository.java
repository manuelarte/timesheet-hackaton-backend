package com.sytac.timesheet.adapters.bamboo;

import com.sytac.timesheet.adapters.bamboo.client.BambooEmployeesClient;
import com.sytac.timesheet.adapters.bamboo.model.BambooEmployee;
import com.sytac.timesheet.core.model.Employee;
import com.sytac.timesheet.core.port.EmployeesRepository;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
class BambooEmployeesRepository implements EmployeesRepository {

    private final BambooEmployeesClient bambooEmployeesClient;

    BambooEmployeesRepository(BambooEmployeesClient bambooEmployeesClient) {
        this.bambooEmployeesClient = bambooEmployeesClient;
    }

    @Override
    public Optional<Employee.Id> getEmployeeId(Employee.Email email) {
        val employees = bambooEmployeesClient.getEmployees();
        val employeeEmail = email.toString();
        val desiredEmployee = employees.stream()
                .filter(e -> e.getWorkEmail().equals(employeeEmail))
                .findAny();
        return desiredEmployee.map(e -> new Employee.Id(e.getId()));
    }
}
