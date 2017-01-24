package com.smp.service;

import com.smp.mapper.OrganazationMappper;
import com.smp.mapper.UserMapper;
import com.smp.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private OrganazationMappper orgMapper;

    public  int addOrg(String name){
        Map<String, Object> params = new HashMap();

        params.put("name", name);
     return namedParameterJdbcTemplate.update("insert into organization(org_name) values(:name)",params);
    };
    @Override
    public List<Organization> getAll() {
        return namedParameterJdbcTemplate.query("select * from organization", Collections.emptyMap(),orgMapper );
    }

    public int deleteOrg(Long orgId){
        Map<String, Object> params = new HashMap();
        params.put("id", orgId);
        return namedParameterJdbcTemplate.update("delete from organization where org_id=:id",params);
    };
}
