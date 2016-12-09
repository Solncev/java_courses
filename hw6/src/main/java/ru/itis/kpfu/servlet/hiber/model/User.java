package ru.itis.kpfu.servlet.hiber.model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created by Марат on 09.12.2016.
 */

@Entity
@Table(name = "credentials",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id"),
                @UniqueConstraint(columnNames = "login")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "login", unique = true, nullable = false, length = 100)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
