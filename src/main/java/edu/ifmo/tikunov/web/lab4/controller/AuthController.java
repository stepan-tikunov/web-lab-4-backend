package edu.ifmo.tikunov.web.lab4.controller;

import edu.ifmo.tikunov.web.lab4.model.WebUser;
import edu.ifmo.tikunov.web.lab4.model.request.WebUserPasswordRequest;
import edu.ifmo.tikunov.web.lab4.model.response.WebUserTokenResponse;
import edu.ifmo.tikunov.web.lab4.service.JwtService;
import edu.ifmo.tikunov.web.lab4.service.WebUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/auth/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    private JwtService jwtService;
    private WebUserService webUserService;

    @PostMapping("/register")
    @CrossOrigin
    public WebUserTokenResponse register(@RequestBody @Valid WebUserPasswordRequest request) throws Exception {
        WebUser user = webUserService.create(request);
        String token = jwtService.generateToken(user);
        return new WebUserTokenResponse(user.getUsername(), token);
    }

    @PostMapping("/login")
    @CrossOrigin
    public WebUserTokenResponse login(@RequestBody @Valid WebUserPasswordRequest request) throws Exception {
        WebUser user = webUserService.validate(request);
        String token = jwtService.generateToken(user);
        return new WebUserTokenResponse(user.getUsername(), token);
    }

    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Autowired
    public void setWebUserService(WebUserService webUserService) {
        this.webUserService = webUserService;
    }
}
