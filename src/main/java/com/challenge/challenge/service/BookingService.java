package com.challenge.challenge.service;

import com.challenge.challenge.dto.BookingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {

    Page<BookingDto> all(Pageable pageable);

    BookingDto findById(String id);

    BookingDto save(BookingDto bookingDto);

    BookingDto update(BookingDto bookingDto, String id);

    void deleteById(String id);

}
