package com.smp.controller;

import com.smp.model.Organization;
import com.smp.service.OrgService;
import com.smp.service.UserToOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Controller
@RequestMapping("/org")

public class OrgController {

    @Autowired
    private OrgService orgService;

    @Autowired
    private UserToOrgService userToOrgService;

    @RequestMapping("/list")
    public ModelAndView list(ModelMap model) {
        List<Organization> organizations = orgService.getAll();
        model.put("orgs", organizations);
        return new ModelAndView("orgs", model);
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam(value = "orgName", required = true) String orgName, ModelMap model) {

        int result = orgService.addOrg(orgName);
        List<Organization> organizations = orgService.getAll();
        model.put("orgs", organizations);
        return new ModelAndView("orgs", model);
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "orgId", required = true) Long orgId, ModelMap model) {

        int result = orgService.deleteOrg(orgId);
        List<Organization> organizations = orgService.getAll();
        model.put("orgs", organizations);
        return new ModelAndView("orgs", model);
    }


}
