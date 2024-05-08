package com.challenge.challenge.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.validation.constraints.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Object that represents a Booking")
public class BookingDto {

    @Schema(
            description = "Unique identifier",
            type = "string",
            example = "663a1f0faf84a552416eafd5")
    private String id;

    @Schema(
            description = "Name",
            type = "string",
            example = "Victor Ciceia")
    @NotNull(message = "The 'name' field needs to have a value")
    @NotBlank(message = "The 'name' field cannot be blank")
    private String name;

    @Schema(
            description = "Email",
            type = "string",
            example = "victor.ciceia@test.com")
    @NotNull(message = "The 'email' field needs to have a value")
    @Email(message = "The 'email' field must be a valid email address")
    @NotBlank(message = "The 'email' field cannot be blank")
    private String email;

    @Schema(
            description = "Origin",
            type = "string",
            example = "Guatemala")
    @NotNull(message = "The 'origin' field needs to have a value")
    @NotBlank(message = "The 'origin' field cannot be blank")
    private String origin;

    @Schema(
            description = "Destination",
            type = "string",
            example = "Paraguay")
    @NotNull(message = "The 'destination' field needs to have a value")
    @NotBlank(message = "The 'destination' field cannot be blank")
    private String destination;

    @Schema(
            description = "Duration in hours",
            type = "Integer",
            example = "5")
    private Integer duration;

    @Schema(
            description = "Departure",
            type = "Date",
            example = "2024-05-08T17:55:51.541Z")
    @NotNull(message = "The 'departure' field needs to have a value")
    private Date departure;

}
