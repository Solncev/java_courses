package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Booking;

public interface BookingsRepository extends JpaRepository<Booking, Long> {
}
