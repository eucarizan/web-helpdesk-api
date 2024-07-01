package dev.nj.api.web.dto;

import java.util.Set;

public record EmployeeDto(
        String employee_id,
        String first_name,
        String middle_name,
        String last_name,
        String department,
        Set<TicketBasicDto> assignedTickets,
        Set<TicketBasicDto> watchedTickets
) {
}
