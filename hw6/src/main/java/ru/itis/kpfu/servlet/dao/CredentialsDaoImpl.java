package ru.itis.kpfu.servlet.dao;


import ru.itis.kpfu.servlet.dao.factory.ConnectionFactory;
import ru.itis.kpfu.servlet.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CredentialsDaoImpl implements CredentialsDao {

    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    public void add(User user) {

        try {
            String querystring = "INSERT INTO credentials(id, login, password) VALUES (?, ?,?)";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setLong(1, user.getId());
            ptmt.setString(2, user.getLogin());
            ptmt.setString(3, user.getPassword());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(User user) {
        try {
            String querystring = "UPDATE credentials SET login =?,password =? WHERE id = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);

            ptmt.setString(1, user.getLogin());
            ptmt.setString(2, user.getPassword());
            ptmt.setLong(3, user.getId());
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Long id) {
        try {
            String querystring = "DELETE FROM credentials WHERE id =?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setLong(1, id);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public List findAll() {
        List users = new ArrayList();
        User user = null;
        try {
            String querystring = "SELECT * FROM credentials";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return users;
    }

    public User findByPrimaryKey(Long id) {
        User user = null;
        try {
            String querystring = "SELECT * FROM credentials WHERE id = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setLong(1, id);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setLogin(rs.getString(1));
                user.setPassword(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return user;
    }

    public User findByLogin(String login) {
        User user = null;
        try {
            String querystring = "SELECT * FROM credentials WHERE login = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, login);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return user;
    }
}
