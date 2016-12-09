package ru.itis.kpfu.servlet.hiber.dao;

import ru.itis.kpfu.servlet.model.User;

import java.util.List;

/**
 * Created by Марат on 09.12.2016.
 */
public interface UserDao {
    public void add(User user);

    public void update(User user);

    public void delete(Long id);

    public List findAll();

    public User findByPrimaryKey(Long id);

    public User findByLogin(String login);
}
