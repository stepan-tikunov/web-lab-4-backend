package edu.ifmo.tikunov.web.lab4.controller.auth;

import edu.ifmo.tikunov.web.lab4.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebInterceptorsConfig implements WebMvcConfigurer {

    @Autowired
    private JwtService jwtService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthHandlerInterceptor(jwtService));
    }
}
