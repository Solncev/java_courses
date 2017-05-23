package service.impl;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import service.StudentService;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Марат on 23.05.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentById(BigInteger id) {
        return studentRepository.findOne(id);
    }

    public void deleteMinScore() {
        List<Student> studentList = studentRepository.findAll();
        studentList.forEach(student -> student.getScores().remove(
                student.getScores().stream().min((o1, o2) -> o1.getScore().compareTo(o2.getScore())).orElse(null)
        ));
        studentRepository.save(studentList);
    }
}
