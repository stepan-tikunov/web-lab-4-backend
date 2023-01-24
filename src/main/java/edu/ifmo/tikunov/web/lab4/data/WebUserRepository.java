package edu.ifmo.tikunov.web.lab4.data;

import edu.ifmo.tikunov.web.lab4.model.WebUser;
import edu.ifmo.tikunov.web.lab4.model.WebUserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepository extends CrudRepository<WebUserModel, Long> {
    WebUserModel findByUsername(String username);
    boolean existsByUsername(String username);

    default WebUserModel findByUserInterface(WebUser user) {
        return findByUsername(user.getUsername());
    }
}
