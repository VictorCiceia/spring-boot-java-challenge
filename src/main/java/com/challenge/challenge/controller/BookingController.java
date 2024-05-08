package com.challenge.challenge.controller;

import com.challenge.challenge.dto.BookingDto;
import com.challenge.challenge.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/booking")
@Tag(name = "Booking", description = "Endpoints to work with Bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("{id}")
    @Operation(summary = "Get by ID", description = "Get a Booking by the ID attribute", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = BookingDto.class)))}
    )
    public BookingDto findById(@PathVariable("id") final String id) {
        return this.bookingService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Get all", description = "Get all Bookings", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = BookingDto.class)))}
    )
    public Page<BookingDto> getAll(final Pageable pageable) {
        return this.bookingService.all(pageable);
    }

    @PostMapping
    @Operation(summary = "Create", description = "Create a new Booking", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = BookingDto.class)))}
    )
    public BookingDto createUser(@Validated @RequestBody final BookingDto bookingDto) {
        return this.bookingService.save(bookingDto);
    }

    @PutMapping("{id}")
    @Operation(summary = "Update", description = "Update a Booking by the ID attribute", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = BookingDto.class)))}
    )
    public BookingDto updateUser(@PathVariable("id") final String id, @Valid @RequestBody final BookingDto bookingDto) {
        return this.bookingService.update(bookingDto, id);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete", description = "Delete a Booking by the ID attribute", responses = {
            @ApiResponse(responseCode = "204", description = "Successful operation")}
    )
    public ResponseEntity<Void> deleteUser(@PathVariable("id") final String id) {
        this.bookingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
