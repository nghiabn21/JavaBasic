package com.example.token.api;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorControllerImpl implements ErrorController {
    private static final String PATH = "/error";
    @RequestMapping("/error")
    public void handleError(HttpServletRequest request) throws Throwable {
        if (request.getAttribute("javax.servlet.error.exception") != null) {
            throw (Throwable) request.getAttribute("javax.servlet.error.exception");
        }
    }

//https://stackoverflow.com/questions/34595605/how-to-manage-exceptions-thrown-in-filters-in-spring
// https://stackoverflow.com/questions/65070223/how-to-throw-custom-exception-from-jwt-authentication-filter
}