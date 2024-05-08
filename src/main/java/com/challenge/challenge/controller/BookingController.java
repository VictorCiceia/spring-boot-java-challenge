package com.challenge.challenge.controller;

import com.challenge.challenge.dto.BookingDto;
import com.challenge.challenge.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("{id}")
    public BookingDto findById(@PathVariable("id") final Long id) {
        return this.bookingService.findById(id);
    }

    @GetMapping
    public Page<BookingDto> getAll(final Pageable pageable) {
        return this.bookingService.all(pageable);
    }

    @PostMapping
    public BookingDto createUser(@RequestBody final BookingDto bookingDto) {
        return this.bookingService.save(bookingDto);
    }

    @PutMapping("{id}")
    public BookingDto updateUser(@PathVariable("id") final Long id, @RequestBody final BookingDto bookingDto) {
        return this.bookingService.update(bookingDto, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") final Long id) {
        this.bookingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
