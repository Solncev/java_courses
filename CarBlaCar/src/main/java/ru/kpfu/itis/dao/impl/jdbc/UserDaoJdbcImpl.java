package ru.kpfu.itis.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ru.kpfu.itis.dao.UsersDao;
import ru.kpfu.itis.dao.factory.JDBCConnectionFactory;
import ru.kpfu.itis.dao.impl.hibernate.AutosDaoHibernateImpl;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.DriversService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJdbcImpl implements UsersDao {

    private static final Logger logger = Logger.getLogger(AutosDaoHibernateImpl.class);

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private DriversService driversService;


    @Override
    public void save(User user) {
        //TODO: реализовать метод
        try {
            connection = JDBCConnectionFactory.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO users (id, avatar, email, firstname, nickname, password, role, surname) VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getAvatar());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstname());
            preparedStatement.setString(5, user.getNickname());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.setString(8, user.getSurname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findOne(Long userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByNickname(String nickname) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByNicknameIgnoreCase(String name) {
        //TODO: реализовать метод
        User user = null;
        try {
            connection = JDBCConnectionFactory.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE LOWER (nickname) LIKE LOWER (?) ");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            user = new User();
            user.setId(resultSet.getLong("id"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));
            user.setAvatar(resultSet.getString("avatar"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setEmail(resultSet.getString("email"));
            user.setRole(resultSet.getString("role"));
            user.setSurname(resultSet.getString("surname"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByEmailIgnoreCase(String email) {
        return null;
    }

}
