package service;

import model.Student;

import java.math.BigInteger;

/**
 * Created by Марат on 23.05.2017.
 */
public interface StudentService {

    Student getStudentById(BigInteger id);

    void deleteMinScore();
}
