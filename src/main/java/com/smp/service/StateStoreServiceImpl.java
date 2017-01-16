package com.smp.service;

import com.smp.mapper.StateStoreMapper;
import com.smp.model.StateStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Service
public class StateStoreServiceImpl implements StateStoreService {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private StateStoreMapper stateStoreMapper;


    @Override
    public List<StateStore> getAll() {
        return namedParameterJdbcTemplate.query("SELECT * FROM STATE_STORE", Collections.emptyMap(), stateStoreMapper);
    }
}
