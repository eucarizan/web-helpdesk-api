package dev.nj.api.web.dto;

public record EmployeeBasicDto(
        String employee_id,
        String first_name,
        String middle_name,
        String last_name,
        String department
) {
}
