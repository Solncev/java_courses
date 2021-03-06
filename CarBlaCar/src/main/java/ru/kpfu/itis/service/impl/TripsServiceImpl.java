package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Trip;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.specs.TripSpecs;
import ru.kpfu.itis.repository.TripsRepository;
import ru.kpfu.itis.service.TripsService;

import java.util.Date;
import java.util.List;

@Service
public class TripsServiceImpl implements TripsService {

    @Autowired
    TripsRepository tripsRepository;

    public Trip addTrip(Trip trip) {
        tripsRepository.save(trip);
        return trip;
    }

    public void update(Trip trip) {
        tripsRepository.save(trip);
    }

    public List<Trip> findAll() {
        return (List<Trip>) tripsRepository.findAll();
    }

    public List<Trip> findAllOrderDate() {
        return tripsRepository.findAllByOrderByDateDesc();
    }

    public List<Trip> findByStatusOrderDate() {
        return tripsRepository.findByStatusOrderByDateDesc("Ожидание");
    }

    public List<Trip> findBySearch(String departure, String destination) {
        return tripsRepository.findByDepartureAndDestinationOrderByDateDesc(departure, destination);
    }

    public Trip findById(Long id) {
        return tripsRepository.findOne(id);
    }

    public List<Trip> lastTrips() {
        return tripsRepository.findTop10ByOrderByDateDesc();
    }

    @Override
    public List<Trip> lastEndsTripsForMonth(User user) {
        Date currentDate = new Date();
        return tripsRepository.findAll(Specifications.where(TripSpecs.checkParams(user, currentDate)));
    }
}
