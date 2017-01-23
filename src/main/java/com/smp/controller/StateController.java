package com.smp.controller;

import com.smp.model.Provider;
import com.smp.model.StateStore;
import com.smp.service.ProviderService;
import com.smp.service.StateStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/list")
    public ModelAndView list(ModelMap model) {
        List<StateStore> stateStores = stateStoreService.getAll();
        Map<String, Object> params = new HashMap<>();
        params.put("stateStores", stateStores);
        return new ModelAndView("store", params);
    }

    @RequestMapping(value = "/det", method = RequestMethod.POST)
    public ModelAndView detail(@ModelAttribute("id") String id,
                               @ModelAttribute("orgId") Long orgId,

                               ModelMap model) {

        StateStore stateStore = stateStoreService.findById(new StateStore(orgId, id)).get(0);
//         stateStore = stateStoreService.findById(new StateStore(1L, "S")).get(0);
        if (!stateStore.getProviderId().equals(0L)) {
            stateStore.setProvider(providerService.findById(stateStore.getProviderId()));
        } else {
            stateStore.setProvider(new Provider());
        }
        ModelAndView modelAndView = new ModelAndView("edit/store", "command", stateStore);
        List<Provider> list = providerService.getAll();

        modelAndView.addObject("provs", list);

        return modelAndView;
    }

    @RequestMapping(value = "/saveStore", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("stateStore") StateStore stateStore, @RequestParam("newProviderId") Long newProviderId) {
        if (newProviderId.equals(0L)) {
            stateStore.setProviderId(null);
        } else if (!newProviderId.equals(-1L)) {
            stateStore.setProviderId(newProviderId);
        }
        //
            stateStore.setOrgId(1L);
            //
            stateStoreService.fullUpdate(stateStore);

            return new ModelAndView("redirect:/state/list");//will redirect to viewemp request mapping
        }

    }
