package com.challenge.challenge.Repository;

import com.challenge.challenge.entity.BookingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<BookingEntity, String> {
}
