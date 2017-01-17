package com.smp.controller;

import com.smp.model.StateStore;
import com.smp.service.StateStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/list")
    public ModelAndView list(ModelMap model) {
        List<StateStore> stateStores = stateStoreService.getAll();
        Map<String, Object> params = new HashMap<>();
        params.put("stateStores", stateStores);
        return new ModelAndView("store", params);
    }
}
