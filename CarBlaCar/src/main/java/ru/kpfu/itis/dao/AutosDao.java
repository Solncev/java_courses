package ru.kpfu.itis.dao;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.model.Automobile;

import java.util.List;

@Component
public interface AutosDao {

    void save(Automobile automobile);

    List<Automobile> findAll();

    Automobile findOne(Long id);

}
