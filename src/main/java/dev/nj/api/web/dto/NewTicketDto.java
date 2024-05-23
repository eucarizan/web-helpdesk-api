package dev.nj.api.web.dto;

public record NewTicketDto(
        String title,
        String description,
        String severity,
        String status
) {
}
