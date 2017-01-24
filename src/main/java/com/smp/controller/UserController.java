package com.smp.controller;

import com.smp.model.User;
import com.smp.model.UserLite;
import com.smp.model.UserToOrg;
import com.smp.service.UserService;
import com.smp.service.UserToOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/15/2017.
 */
@Controller
@RequestMapping("/users")
public class UserController {
private static  final String pref="!id_";
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

    @RequestMapping("/delete")
    public ModelAndView delete(@ModelAttribute("userId") Long userId) {
        userService.delete(userId);
        return new ModelAndView("redirect:/users/list");
    }

    @RequestMapping("/usercorrect")
    public ModelAndView editForm(@ModelAttribute("userId") Long userId) {
        User user = userService.findById(userId);
        return new ModelAndView("edit/user", "command", user);
    }

    @RequestMapping("/saveList")
    public ModelAndView saveList(HttpServletRequest req, ModelMap model) {
        req.getRequestURI();
        Long orgId=Long.valueOf(req.getParameter("orgId"));
        userToOrgService.deleteByOrgId(orgId);
        for(String[] params:req.getParameterMap().values()){
            if(params[0].indexOf(pref)!=-1){

                userToOrgService.insert(orgId,Long.valueOf(params[0].substring(4))) ;
                System.out.println("org id  "+orgId+"  user_id "+params[0]+"  :"+params[0].substring(4));
            }
        }
        return new ModelAndView("redirect:/org/list");
    }

    @RequestMapping("/listLite")
    public ModelAndView listLite(@RequestParam(value = "orgId") Long orgId, ModelMap model) {
        List<UserLite> userLites = userService.getLiteAll();
        List<UserToOrg> userToOrgs = userToOrgService.findByOrgId(orgId);


        for (UserLite user : userLites) {
            for (UserToOrg userToOrg : userToOrgs) {
                if (user.getUserId().equals(userToOrg.getUserId())) {
                    user.setAdded(true);
                    break;
                } else {
                    user.setAdded(false);
                }
            }
        }
        model.put("orgId", orgId);
        model.put("users", userLites);
        return new ModelAndView("edit/orguser", model);
    }
}
