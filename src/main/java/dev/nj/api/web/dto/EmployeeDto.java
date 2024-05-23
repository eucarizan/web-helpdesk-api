package dev.nj.api.web.dto;

public record EmployeeDto(
        String employeeId,
        String firstName,
        String middleName,
        String lastName,
        String department
) {
}
