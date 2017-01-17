package com.smp.controller;

import com.smp.model.User;
import com.smp.service.UserService;
import com.smp.service.UserToOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/15/2017.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserToOrgService userToOrgService;

    @RequestMapping("/list")
    public ModelAndView list(ModelMap model) {
        List<User> users = userService.getAll();
        model.put("users", users);
        return new ModelAndView("users", model);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") User user) {
        userService.save(user);
        return new ModelAndView("redirect:/users/list");//will redirect to viewemp request mapping
    }

    @RequestMapping("/userform")
    public ModelAndView showform() {
        return new ModelAndView("edit/user", "command", new User());
    }
}
