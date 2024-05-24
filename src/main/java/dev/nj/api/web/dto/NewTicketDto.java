package dev.nj.api.web.dto;

import jakarta.validation.constraints.NotBlank;

public record NewTicketDto(
        @NotBlank(message = "title should not be blank")
        String title,
        @NotBlank(message = "description should not be blank")
        String description,
        @NotBlank(message = "severity should not be blank")
        String severity,
        @NotBlank(message = "status should not be blank")
        String status
) {
}
