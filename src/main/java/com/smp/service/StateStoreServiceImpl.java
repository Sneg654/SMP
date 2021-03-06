package com.smp.service;

import com.smp.mapper.StateStoreMapper;
import com.smp.model.StateStore;
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
public class StateStoreServiceImpl implements StateStoreService {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private StateStoreMapper stateStoreMapper;



    @Override
    public List<StateStore> findByOrgId(Long orgId) {


        String sql = "select * from   STATE_STORE " +
                "where org_id=:orgId";
        Map<String, Object> params = new HashMap();
        params.put("orgId", orgId);
        namedParameterJdbcTemplate.query(sql, params, stateStoreMapper);
        return namedParameterJdbcTemplate.query(sql, params, stateStoreMapper);
    }

    @Override


    public List<StateStore> findForSending(Long orgId) {


        String sql = "select * from   STATE_STORE " +
                "where org_id=:orgId and is_send=0 and is_check=1";
        Map<String, Object> params = new HashMap();
        params.put("orgId", orgId);
        namedParameterJdbcTemplate.query(sql, params, stateStoreMapper);
        return namedParameterJdbcTemplate.query(sql, params, stateStoreMapper);
    }

    @Override()
    public List<StateStore> findById(StateStore stateStore) {
        String sql = "select * from   STATE_STORE" +
                " where org_id=:orgId and nomeclature_id=:nomeclatureId";
        Map<String, Object> params = new HashMap();
        params.put("orgId", stateStore.getOrgId());
        params.put("nomeclatureId", stateStore.getNomeclatureID());


        return namedParameterJdbcTemplate.query(sql, params, stateStoreMapper);
    }


    @Override
    public List<StateStore> getAll() {
        return namedParameterJdbcTemplate.query("SELECT * FROM STATE_STORE", Collections.emptyMap(), stateStoreMapper);
    }

    @Override
    public int insertStore(StateStore stateStore) {
        String sql = "INSERT INTO state_store (NOMECLATURE_ID, ORG_ID, NAME, MIN, MAX, FOLD, COST, COUNT, provider_id, IS_CHECK, IS_SEND) VALUES " +
                " (:nomeclatureId, :orgId,:name,:min,:max,:fold,:cost,:count,null,0,0)";

        Map<String, Object> params = new HashMap<>();
        params.put("nomeclatureId", stateStore.getNomeclatureID());
        params.put("orgId", stateStore.getOrgId());
        params.put("name", stateStore.getName());
        params.put("min", stateStore.getCount().intValue());
        params.put("max", stateStore.getCount().intValue());
        params.put("fold", 1);
        params.put("cost", stateStore.getCost());
        params.put("count", stateStore.getCount());
        try {
            namedParameterJdbcTemplate.update(sql, params);
            return 0;
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }

    }

    public int autoUpdate(StateStore stateStore) {
        String sql = "UPDATE STATE_STORE SET COST=:cost, COUNT=:count, IS_SEND=0 where NOMECLATURE_ID=:nomeclatureId and ORG_ID=:orgId";
        Map<String, Object> params = new HashMap<>();
        params.put("nomeclatureId", stateStore.getNomeclatureID());
        params.put("orgId", stateStore.getOrgId());
        params.put("count", stateStore.getCount());
        params.put("cost", stateStore.getCost());
        try {
            namedParameterJdbcTemplate.update(sql, params);
            return 0;
        } catch (Exception ex) {
            return -1;
        }

    }

    public int fullUpdate(StateStore stateStore) {
        String sql = "UPDATE STATE_STORE " +
                " SET COST=:cost, " +
                "COUNT=:count, " +
                "MIN=:min, " +
                "MAX=:max, " +
                "FOLD=:fold, " +
                "IS_CHECK=:ckeck, " +
                "cost=:cost, " +
                "provider_id=:providerId " +
                " where NOMECLATURE_ID=:nomeclatureId and ORG_ID=:orgId";
        Map<String, Object> params = new HashMap<>();
        params.put("nomeclatureId", stateStore.getNomeclatureID());
        params.put("orgId", stateStore.getOrgId());
        params.put("count", stateStore.getCount());
        params.put("cost", stateStore.getCost());
        params.put("min", stateStore.getMin());
        params.put("max", stateStore.getMax());
        params.put("fold", stateStore.getFold());
        params.put("ckeck", stateStore.getCheck());
        params.put("providerId", stateStore.getProviderId());

        try {
            namedParameterJdbcTemplate.update(sql, params);
            return 0;
        } catch (Exception ex) {
            return -1;
        }

    }


    public int sendUpdate(StateStore stateStore) {
        String sql = "UPDATE STATE_STORE SET IS_SEND=1 where NOMECLATURE_ID=:nomeclatureId and ORG_ID=:orgId";
        Map<String, Object> params = new HashMap<>();
        params.put("nomeclatureId", stateStore.getNomeclatureID());
        params.put("orgId", stateStore.getOrgId());
        try {
            namedParameterJdbcTemplate.update(sql, params);
            return 0;
        } catch (Exception ex) {
            return -1;
        }

    }

}
