package com.challenge.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOOKINGS")
public class BookingEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ORIGIN", nullable = false)
    private String origin;

    @Column(name = "DESTINATION", nullable = false)
    private String destination;

    @Column(name = "DURATION", nullable = false)
    private int duration;

    @Column(name = "DEPARTURE", nullable = false)
    private Date departure;

}
