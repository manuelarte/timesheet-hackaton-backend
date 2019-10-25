package com.sytac.timesheet.adapters.bamboo.client;

import com.sytac.timesheet.adapters.bamboo.model.BambooEmployee;
import com.sytac.timesheet.adapters.bamboo.model.BambooEmployeesList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class BambooEmployeesClient {

    private final String url;
    private final RestTemplate restTemplate;

    public BambooEmployeesClient(
            RestTemplate restTemplate,
            @Value("${bamboo.api.endpoints.employees}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<BambooEmployee> getEmployees() {
        final ResponseEntity<BambooEmployeesList> response = restTemplate.getForEntity(url, BambooEmployeesList.class);
        validate(response);
        return Optional.ofNullable(response.getBody())
                .map(BambooEmployeesList::getEmployees)
                .orElseThrow(()->new RuntimeException("BambooEmployeesClient failed to get employees: null list"));
    }

    private void validate(ResponseEntity<BambooEmployeesList> response) {
        final int statusCodeValue = response.getStatusCodeValue();
        if (statusCodeValue < 200 || statusCodeValue > 299)
            throw new RuntimeException("BambooEmployeesClient failed to get employees: Status code " + statusCodeValue);
    }
}
