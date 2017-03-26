package ru.kpfu.itis.dao.impl.jdbc;

import ru.kpfu.itis.dao.DriversDao;
import ru.kpfu.itis.dao.factory.JDBCConnectionFactory;
import ru.kpfu.itis.model.Driver;
import ru.kpfu.itis.service.UsersService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriversDaoJdbcImpl implements DriversDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private UsersService usersService;

    @Override
    public void save(Driver driver) {

    }

    @Override
    public Driver findOne(Long id) {
        return null;
    }

    @Override
    public List<Driver> findAll() {
        return null;
    }

    @Override
    public List<Driver> findTop9ByOrderByRatingDesc() {
        //TODO: реализовать метод
        List<Driver> drivers = new ArrayList<>();
        try {
            connection = JDBCConnectionFactory.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM drivers ORDER BY rating DESC limit 9");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setId(resultSet.getLong("id"));
                driver.setExperience(resultSet.getInt("experience"));
                driver.setRating(resultSet.getInt("rating"));
                driver.setUser(usersService.findById(resultSet.getLong("user_id")));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }
}
