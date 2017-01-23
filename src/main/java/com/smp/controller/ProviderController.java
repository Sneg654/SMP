package com.smp.controller;

import com.smp.model.Provider;
import com.smp.model.User;
import com.smp.service.ProviderService;
import com.smp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */

@Controller
@RequestMapping("/provider")
public class ProviderController {


    @Autowired
    private ProviderService providerService;

    @RequestMapping("/list")
    public ModelAndView list(ModelMap model) {
        List<Provider> providers = providerService.getAll();
        model.put("providers", providers);
        return new ModelAndView("providers", model);
    }
    @RequestMapping("/provform")
    public ModelAndView showform() {
        return new ModelAndView("edit/provider", "command", new Provider());
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@ModelAttribute("providerId") Long providerId) {
        providerService.delete(providerId);
        return new ModelAndView("redirect:/provider/list");
    }

    @RequestMapping("/provcorrect")
    public ModelAndView editForm(@ModelAttribute("providerId") Long providerId) {
        Provider provider = providerService.findById(providerId);
        return new ModelAndView("edit/provider", "command", provider);
    }
    @RequestMapping("/save")
    public ModelAndView save(@ModelAttribute("provider") Provider provider) {
       providerService.save(provider);
        return new ModelAndView("redirect:/provider/list");
    }
}
