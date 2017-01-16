package com.smp.service;

import com.smp.mapper.ProviderMapper;
import com.smp.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private ProviderMapper providerMapper;


    @Override
    public List<Provider> getAll() {
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM provider", Collections.emptyMap(),
                providerMapper
        );
    }
}
