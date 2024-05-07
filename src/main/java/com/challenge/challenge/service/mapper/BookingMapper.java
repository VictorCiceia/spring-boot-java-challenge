package com.challenge.challenge.service.mapper;

import com.challenge.challenge.dto.BookingDto;
import com.challenge.challenge.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingDto toDto(BookingEntity entity);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "origin", source = "origin")
    @Mapping(target = "destination", source = "destination")
    @Mapping(target = "duration", source = "duration")
    @Mapping(target = "id", ignore = true)
    BookingEntity toEntity(BookingDto dto);

}
