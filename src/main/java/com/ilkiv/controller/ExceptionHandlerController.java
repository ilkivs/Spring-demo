package com.ilkiv.controller;

import com.ilkiv.controller.exceptions.UserAlreadyRegisteredException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Throwable.class)
    public ModelAndView handleAll() {
        ModelAndView mw = new ModelAndView();
        mw.setViewName("error");
        return mw;
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<String> alreadyRegistered() {
        return ResponseEntity.status(409).body("User is already registered");
    }
}
