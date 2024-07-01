package dev.nj.api.web.dto;

public record TicketBasicDto(
        long id,
        String title,
        String description,
        String severity,
        String status
) {
}
