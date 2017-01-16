package com.smp.service;

import com.smp.mapper.OrganazationMappper;
import com.smp.mapper.UserMapper;
import com.smp.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private OrganazationMappper orgMapper;


    @Override
    public List<Organization> getAll() {
        return namedParameterJdbcTemplate.query("select * from organization", Collections.emptyMap(),orgMapper );
    }
}
