package com.challenge.challenge.controller;

import com.challenge.challenge.dto.BookingDto;
import com.challenge.challenge.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

    final static String BASE_URL = "/booking";

    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = standaloneSetup(bookingController).build();
    }

    @Test
    void testFindById() {
        final String id = "663bcc0223075d28936b623f";
        BookingDto bookingDto = new BookingDto();
        when(bookingService.findById(id)).thenReturn(bookingDto);
        final BookingDto result = bookingController.findById(id);
        // Asserts
        assertEquals(bookingDto, result);
    }

    @Test
    public void testFindByIdExistingBooking() throws Exception {
        final String id = "3bcc0223075d289";
        final Date fecha = new Date();
        BookingDto bookingDto = new BookingDto(id, "Victor", "victor@test.com", "Paraguay", "Guatemala", 1, fecha);
        when(bookingService.findById(id)).thenReturn(bookingDto);

        mockMvc.perform(get(BASE_URL + "/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is("Victor")))
                .andExpect(jsonPath("$.email", is("victor@test.com")))
                .andExpect(jsonPath("$.origin", is("Paraguay")))
                .andExpect(jsonPath("$.destination", is("Guatemala")))
                .andExpect(jsonPath("$.duration", is(1)))
                .andExpect(jsonPath("$.departure", is(fecha.getTime())));

        verify(bookingService, times(1)).findById(id);
    }

    @Test
    void testGetAll() {
        final List<BookingDto> bookingDtos = new ArrayList<>();
        final Page<BookingDto> page = new PageImpl<>(bookingDtos);
        final Pageable pageable = Pageable.unpaged();
        when(bookingService.all(pageable)).thenReturn(page);
        Page<BookingDto> result = bookingController.getAll(pageable);
        // Asserts
        assertEquals(page, result);
    }

    @Test
    void testCreateBooking() {
        final BookingDto bookingDto = new BookingDto();
        when(bookingService.save(any(BookingDto.class))).thenReturn(bookingDto);
        final BookingDto result = bookingController.createUser(bookingDto);
        // Assert
        assertEquals(bookingDto, result);
    }

    @Test
    void testUpdateBooking() {
        final String id = "663bcc0223075d28936b623f";
        final BookingDto bookingDto = new BookingDto();
        when(bookingService.update(any(), eq(id))).thenReturn(bookingDto);
        final BookingDto result = bookingController.updateUser(id, bookingDto);
        // Assert
        assertEquals(bookingDto, result);
        verify(bookingService, times(1)).update(any(), anyString());
    }

    @Test
    void testDeleteBooking() {
        final String id = "663bcc0223075d28936b623f";
        final ResponseEntity<Void> result = bookingController.deleteUser(id);
        // Assert
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(bookingService, times(1)).deleteById(id);
    }

}