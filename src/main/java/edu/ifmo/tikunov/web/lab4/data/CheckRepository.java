package edu.ifmo.tikunov.web.lab4.data;

import edu.ifmo.tikunov.web.lab4.model.CheckModel;
import edu.ifmo.tikunov.web.lab4.model.WebUserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckRepository extends CrudRepository<CheckModel, Long> {
    List<CheckModel> findAllByUser(WebUserModel user);
}
