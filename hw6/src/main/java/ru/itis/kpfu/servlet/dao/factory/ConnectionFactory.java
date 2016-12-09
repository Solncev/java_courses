package ru.itis.kpfu.servlet.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory connectionFactory = null;
    private final String driverClassName = "org.postgresql.Driver";
    private final String connectionUrl = "jdbc:postgresql://localhost:5433/logindb";
    private final String dbUser = "postgres";
    private final String dbPwd = "postgres";

    public ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }
}