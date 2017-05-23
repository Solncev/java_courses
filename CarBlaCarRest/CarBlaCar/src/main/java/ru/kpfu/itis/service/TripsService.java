package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Automobile;
import ru.kpfu.itis.model.Trip;
import ru.kpfu.itis.model.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TripsService {

    Trip addTrip(@WebParam Trip trip);

    void update(@WebParam Trip trip);

    List<Trip> findAll();

    List<Trip> findAllOrderDate();

    List<Trip> findByStatusOrderDate();

    List<Trip> findBySearch(@WebParam String departure, @WebParam String destination);

    Trip findById(@WebParam Long id);

    List<Trip> lastTrips();

    List<Trip> lastEndsTripsForMonth(@WebParam User user);

    List<Trip> findByAuto(@WebParam Automobile automobile);
}
