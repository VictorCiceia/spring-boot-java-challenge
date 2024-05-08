package com.challenge.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking_collection")
public class BookingEntity {

    @Id
    private String id;

    private String name;

    private String email;

    private String origin;

    private String destination;

    private Integer duration;

    private Date departure;

}
