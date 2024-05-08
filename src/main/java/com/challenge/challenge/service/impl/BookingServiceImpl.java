package com.challenge.challenge.service.impl;

import com.challenge.challenge.Repository.BookingRepository;
import com.challenge.challenge.dto.BookingDto;
import com.challenge.challenge.entity.BookingEntity;
import com.challenge.challenge.exception.ResourceNotFoundException;
import com.challenge.challenge.service.BookingService;
import com.challenge.challenge.service.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Page<BookingDto> all(final Pageable pageable) {
        return this.bookingRepository.findAll(pageable)
                .map(this.bookingMapper::toDto);
    }

    @Override
    public BookingDto findById(final String id) {
        return this.bookingMapper.toDto(this.findEntityById(id));
    }

    @Override
    public BookingDto save(final BookingDto bookingDto) {
        final BookingEntity entity = this.bookingMapper.toEntity(bookingDto);
        return this.bookingMapper.toDto(this.bookingRepository.save(entity));
    }

    @Override
    public BookingDto update(final BookingDto bookingDto, final String id) {
        final BookingEntity entity = this.findEntityById(id);
        final BookingEntity bookingUpdating = this.bookingMapper.toEntity(bookingDto);
        bookingUpdating.setId(entity.getId());
        return this.bookingMapper.toDto(this.bookingRepository.save(bookingUpdating));
    }

    @Override
    public void deleteById(final String id) {
        final BookingEntity entity = this.findEntityById(id);
        this.bookingRepository.delete(entity);
    }

    private BookingEntity findEntityById(final String id) {
        return this.bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "ID", id));
    }
}
