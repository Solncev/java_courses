package repository;

import model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

/**
 * Created by Марат on 23.05.2017.
 */
public interface StudentRepository extends MongoRepository<Student, BigInteger> {
}
