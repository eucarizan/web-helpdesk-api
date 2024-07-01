package dev.nj.api.web.dto;

import java.util.Set;

public record TicketDto(
        long id,
        String title,
        String description,
        String severity,
        String status,
        EmployeeBasicDto assignee,
        Set<EmployeeBasicDto> watchers
) {
}
