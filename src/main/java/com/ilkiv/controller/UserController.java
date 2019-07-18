package com.ilkiv.controller;

import com.ilkiv.model.User;
import com.ilkiv.controller.external.model.UserRegister;
import com.ilkiv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public ModelAndView add(@ModelAttribute User user, ModelAndView mw) {
        userService.add(user);
        List<User> users = userService.getAll()
                .orElseGet(Collections::emptyList);
        mw.addObject("users", users);
        mw.setViewName("users");
        return mw;
    }

    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    public ModelAndView getById(@RequestParam("u_id") Long id, ModelAndView mw) {
        mw.addObject("user", userService.getById(id));
        mw.setViewName("user");
        return mw;
    }

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView mw) {
        List<User> users = userService.getAll()
                .orElseGet(Collections::emptyList);
        mw.addObject("users", users);
        mw.setViewName("users");
        return mw;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView mw) {
        mw.addObject("user", new User());
        mw.setViewName("login");
        return mw;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView login(@ModelAttribute User user, ModelAndView mw) {
//        mw.addObject("user", new User());
//        mw.setViewName("home");
//        return mw;
//    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView mw) {
        mw.addObject("user", new UserRegister());
        mw.setViewName("register");
        return mw;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute UserRegister userRegister,  BindingResult br, ModelAndView mw) {
        userService.add(User.of(userRegister));
        mw.addObject("user", new User());
        mw.setViewName("login");
        return mw;
    }
}
