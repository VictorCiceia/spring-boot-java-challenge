package com.challenge.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private Long id;

    private String name;

    private String email;

    private String origin;

    private String destination;

    private int duration;

    private Date departure;

}
