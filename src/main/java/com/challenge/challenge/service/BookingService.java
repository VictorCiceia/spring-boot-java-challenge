package com.challenge.challenge.service;

import com.challenge.challenge.dto.BookingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service defining methods for performing operations related to bookings.
 */
public interface BookingService {

    /**
     * Get all bookings
     *
     * @param pageable a Pageable object defining pagination and sorting of the results
     * @return a page of BookingDto objects
     */
    Page<BookingDto> all(Pageable pageable);

    /**
     * Finds a booking by its ID.
     *
     * @param id the ID of the booking to find
     * @return the BookingDto object corresponding to the specified ID, or null if not found
     */
    BookingDto findById(String id);

    /**
     * Saves a new booking.
     *
     * @param bookingDto the BookingDto object representing the booking to save
     * @return the saved BookingDto object
     */
    BookingDto save(BookingDto bookingDto);

    /**
     * Updates an existing booking.
     *
     * @param bookingDto the BookingDto object with the updated booking data
     * @param id         the ID of the booking to update
     * @return the updated BookingDto object
     */
    BookingDto update(BookingDto bookingDto, String id);

    /**
     * Deletes a booking by its ID.
     *
     * @param id the ID of the booking to delete
     */
    void deleteById(String id);

}
