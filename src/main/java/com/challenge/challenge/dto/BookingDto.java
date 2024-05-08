package com.challenge.challenge.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String name;

    @Schema(
            description = "Email",
            type = "string",
            example = "victor.ciceia@test.com")
    private String email;

    @Schema(
            description = "Origin",
            type = "string",
            example = "Guatemala")
    private String origin;

    @Schema(
            description = "Destination",
            type = "string",
            example = "Paraguay")
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
    private Date departure;

}
