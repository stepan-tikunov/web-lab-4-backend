package edu.ifmo.tikunov.web.lab4.service;

import edu.ifmo.tikunov.web.lab4.data.WebUserRepository;
import edu.ifmo.tikunov.web.lab4.model.WebUser;
import edu.ifmo.tikunov.web.lab4.model.WebUserModel;
import edu.ifmo.tikunov.web.lab4.model.request.WebUserPasswordRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUserService {
    private WebUserRepository webUserRepository;

    @Transactional
    public WebUser create(WebUserPasswordRequest request) throws Exception {
        if (!webUserRepository.existsByUsername(request.getUsername())) {
            WebUserModel user = new WebUserModel(request.getUsername(), request.getPassword());
            webUserRepository.save(user);
            return user;
        }

        throw new UserExistsException();
    }

    public WebUser validate(WebUserPasswordRequest request) throws Exception {
        if (webUserRepository.existsByUsername(request.getUsername())) {
            WebUserModel user = webUserRepository.findByUsername(request.getUsername());
            if (!user.validatePassword(request.getPassword()))
                throw new PasswordCheckException();
            return user;
        }

        throw new NoSuchUserException();
    }

    @Autowired
    public void setWebUserRepository(WebUserRepository webUserRepository) {
        this.webUserRepository = webUserRepository;
    }
}
