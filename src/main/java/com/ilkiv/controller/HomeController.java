package com.ilkiv.controller;

import com.ilkiv.controller.exceptions.UserAlreadyRegisteredException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String homePage() {
        throw new UserAlreadyRegisteredException();
    }

    @RequestMapping(value = "/params", method = RequestMethod.GET)
    public ModelAndView paramExample(@RequestParam(required = false) String name, @RequestParam int age) {
        ModelAndView mw = new ModelAndView();
        mw.addObject("name", name);
        mw.addObject("age", age);
        mw.setViewName("params");
        return mw;
    }
}
