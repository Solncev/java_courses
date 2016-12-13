package dao.impl.jdbc;

import dao.CVDao;
import model.CV;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CVDaoJDBCImpl extends JDBCTemplate implements CVDao {

    public CV getCvById(Long cvId) {
        return null;
    }

    public List<CV> cvList() {
        HashMap<Long, CV> cvMap = new HashMap<Long, CV>();

        //TODO: 5. create sql
        String query = "SELECT *\n" +
                "FROM users\n" +
                "  JOIN cv ON users.id = cv.user_id\n" +
                "  JOIN cv_category ON cv.id = cv_category.cv_id\n" +
                "  JOIN category ON cv_category.category_id = category.id";
        //TODO: 6. get cv by id, using (cv row mapper)
        try {
            con = getConnection();
            ptmt = con.prepareStatement(query);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                CV.CV_ROW_MAPPER(rs, cvMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (List<CV>) cvMap.values();
    }

    public void add(CV cv) {
        //TODO: 12. add new CV to db by jdbc
        String query = "INSERT INTO cv(user_id, education,experience,text,title) VALUES(?,?,?,?,?)";
        try {
            con = getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setLong(1, cv.getUser().getId());
            ptmt.setString(2, cv.getEducation());
            ptmt.setString(3, cv.getExperience());
            ptmt.setString(4, cv.getText());
            ptmt.setString(5, cv.getTitle());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
