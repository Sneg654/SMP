package com.smp.controller;

import com.smp.model.*;
import com.smp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Controller
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateStoreService stateStoreService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private UserToOrgService userToOrgService;

    @Autowired
    private OrgService orgService;

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, ModelMap model) {
        Map<String, Object> params = new HashMap<>();
        User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        List<UserToOrg> userToOrgs = userToOrgService.findByUserId(user.getUserId());
        List<StateStore> stateStores = new ArrayList<StateStore>();
        if (userToOrgs.size() > 0) {
            stateStores = stateStoreService.findByOrgId(userToOrgs.get(0).getOrgId());
            for (StateStore stateStore : stateStores) {
                if (stateStore.getProviderId() != null && !stateStore.getProviderId().equals(0L)) {
                    stateStore.setProvider(providerService.findById(stateStore.getProviderId()));
                }
            }
            params.put("orgName", orgService.findById(userToOrgs.get(0).getOrgId()).getOrgName());
        }
        List<Organization> organizations = new ArrayList<>();
        for (UserToOrg userToOrg : userToOrgs) {
            organizations.add(orgService.findById(userToOrg.getOrgId()));
        }

        params.put("orgs", organizations);
        params.put("stateStores", stateStores);
        return new ModelAndView("store", params);
    }


    @RequestMapping("/listByOrg")
    public ModelAndView list(HttpServletRequest request, ModelMap model, @RequestParam("choseOrgId") Long choseOrgId) {
        Map<String, Object> params = new HashMap<>();
        User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        List<UserToOrg> userToOrgs = userToOrgService.findByUserId(user.getUserId());
        List<StateStore> stateStores = new ArrayList<StateStore>();
        if (userToOrgs.size() > 0) {
            stateStores = stateStoreService.findByOrgId(choseOrgId);
            for (StateStore stateStore : stateStores) {
                if (stateStore.getProviderId() != null && !stateStore.getProviderId().equals(0L)) {
                    stateStore.setProvider(providerService.findById(stateStore.getProviderId()));
                }
            }

            params.put("orgName", orgService.findById(choseOrgId).getOrgName());
        }
        List<Organization> organizations = new ArrayList<>();
        for (UserToOrg userToOrg : userToOrgs) {
            organizations.add(orgService.findById(userToOrg.getOrgId()));
        }

        params.put("orgs", organizations);
        params.put("stateStores", stateStores);
        return new ModelAndView("store", params);
    }


    @RequestMapping(value = "/det", method = RequestMethod.POST)
    public ModelAndView detail(@ModelAttribute("id") String id,
                               @ModelAttribute("orgId") Long orgId,

                               ModelMap model) {

        StateStore stateStore = stateStoreService.findById(new StateStore(orgId, id)).get(0);
        if (!stateStore.getProviderId().equals(0L)) {
            stateStore.setProvider(providerService.findById(stateStore.getProviderId()));
        } else {
            stateStore.setProvider(new Provider());
        }
        ModelAndView modelAndView = new ModelAndView("edit/store", "command", stateStore);
        List<Provider> list = providerService.getAll();

        modelAndView.addObject("provs", list);
        modelAndView.addObject("orgId", orgId);

        return modelAndView;
    }

    @RequestMapping(value = "/saveStore", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("stateStore") StateStore stateStore,
                             @RequestParam("newProviderId") Long newProviderId,
                             @RequestParam("orgId") Long orgId) {
        if (newProviderId.equals(0L)) {
            stateStore.setProviderId(null);
        } else if (!newProviderId.equals(-1L)) {
            stateStore.setProviderId(newProviderId);
        }
        //TODO
        stateStore.setOrgId(orgId);
        //
        stateStoreService.fullUpdate(stateStore);

//        return new ModelAndView("redirect:/state/list");//will redirect to viewemp request mapping
        return new ModelAndView("redirect:/state/list");//will redirect to viewemp request mapping
    }

}
