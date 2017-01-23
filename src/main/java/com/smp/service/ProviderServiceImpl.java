package com.smp.service;

import com.smp.mapper.ProviderMapper;
import com.smp.model.Provider;
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

    @Override
    public Provider findById(Long id) {
        Map<String, Object> params = new HashMap();
        params.put("id", id);

        return namedParameterJdbcTemplate.query(

                "SELECT * FROM provider where provider_id=:id", params,
                providerMapper
        ).get(0);
    }

    public int delete(Long id) {
        Map<String, Object> params = new HashMap();
        params.put("id", id);

        return namedParameterJdbcTemplate.update(

                "delete FROM provider where provider_id=:id", params
        );
    }

    public int save(Provider provider) {
        String sqlInsert = "insert into  provider (Name, phone,description) values (:name, :phone, :description)";
        String sqlUpdate = "update provider set NAME=:name, PHONE=:phone, DESCRIPTION=:description where PROVIDER_ID=:id";
        Map<String, Object> params = new HashMap();
        params.put("id", provider.getProviderId());
        params.put("name", provider.getName());
        params.put("phone", provider.getPhone());
        params.put("description", provider.getDescription());
        if (provider.getProviderId() != null) {
            namedParameterJdbcTemplate.update(sqlUpdate, params);
        } else {
            namedParameterJdbcTemplate.update(sqlInsert, params);
        }

        return 0;
    }
}
