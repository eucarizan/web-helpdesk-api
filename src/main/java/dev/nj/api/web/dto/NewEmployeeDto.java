package dev.nj.api.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record NewEmployeeDto(
        @NotBlank(message = "first name should not be blank")
        @JsonProperty(value = "first_name")
        String firstName,
        @NotBlank(message = "middle name should not be blank")
        @JsonProperty(value = "middle_name")
        String middleName,
        @NotBlank(message = "last name should not be blank")
        @JsonProperty(value = "last_name")
        String lastName,
        @NotBlank(message = "department should not be blank")
        String department
){
}
