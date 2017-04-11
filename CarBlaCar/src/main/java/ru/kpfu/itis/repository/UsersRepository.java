package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.model.Driver;
import ru.kpfu.itis.model.Passenger;
import ru.kpfu.itis.model.Trip;
import ru.kpfu.itis.model.User;

import java.util.Date;
import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {

    User findByNickname(String nickname);

    User findByEmail(String email);

    User findByNicknameIgnoreCase(String name);

    User findByEmailIgnoreCase(String email);

    @Query("select t from Trip t where t.driver = :driver and t.date <= :currentDate and t.date >= :monthAgoDate")
    List<Trip> find10LastMonthTripsByDriver(@Param("driver") Driver driver,
                                            @Param("currentDate") Date currentDate,
                                            @Param("monthAgoDate") Date monthAgoDate);

    @Query("select t from Trip t where t.passenger = :passenger and t.date <= :currentDate and t.date >= :monthAgoDate")
    List<Trip> find10LastMonthTripsByPassenger(@Param("passenger") Passenger passenger,
                                               @Param("currentDate") Date currentDate,
                                               @Param("monthAgoDate") Date monthAgoDate);
}
