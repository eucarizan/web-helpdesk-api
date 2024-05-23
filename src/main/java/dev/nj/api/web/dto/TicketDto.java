package dev.nj.api.web.dto;

public record TicketDto(
        long id,
        String title,
        String description,
        String severity,
        String status
) {
}
