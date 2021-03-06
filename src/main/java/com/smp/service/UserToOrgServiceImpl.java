package com.smp.service;

import com.smp.mapper.UserToOrgMapper;
import com.smp.model.UserToOrg;
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

    public List<UserToOrg> findByOrgId(Long orgId) {

            Map<String, Object> params = new HashMap();
            params.put("orgId", orgId);
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM user2org where org_id=:orgId", params,
                mapper
        );
    }

    public List<UserToOrg> findByUserId(Long userId) {

        Map<String, Object> params = new HashMap();
        params.put("userId", userId);
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM user2org where user_id=:userId", params,
                mapper
        );
    }

    public int deleteByOrgId(Long orgId){
        Map<String, Object> params = new HashMap();
        params.put("orgId", orgId);
        return namedParameterJdbcTemplate.update(
                "delete FROM user2org where org_id=:orgId", params);
    };
    public int insert(Long orgId, Long userId){
        Map<String, Object> params = new HashMap();
        params.put("orgId", orgId);
        params.put("userId", userId);
        return namedParameterJdbcTemplate.update(
                "insert into user2org(org_id, user_id) values (:orgId, :userId)", params);
    };
}