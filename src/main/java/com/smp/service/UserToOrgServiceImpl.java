package com.smp.service;

import com.smp.mapper.UserToOrgMapper;
import com.smp.model.UserToOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Service
public class UserToOrgServiceImpl implements UserToOrgService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private UserToOrgMapper mapper;

    @Override
    public List<UserToOrg> getAll() {
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM user2org", Collections.emptyMap(),
                mapper
        );
    }
}