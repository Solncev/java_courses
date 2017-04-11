package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Driver;
import ru.kpfu.itis.model.Trip;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UsersRepository;
import ru.kpfu.itis.service.UsersService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepository usersRepository;

    public User addUser(User user) {
        usersRepository.save(user);
        return user;
    }

    public User findById(Long id) {
        User user = usersRepository.findOne(id);
        return user;
    }

    public void update(User user) {
        usersRepository.save(user);
    }

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    public User findByNickname(String name) {
        return usersRepository.findByNicknameIgnoreCase(name);
    }

    public User findByEmail(String email) {
        return usersRepository.findByEmailIgnoreCase(email);
    }

    public List<Trip> findAllLastMonthTrips(Driver driver) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();
        return usersRepository.find10LastMonthTripsByDriver(driver, new Date(), result);
    }
}