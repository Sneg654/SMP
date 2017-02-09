package com.smp.mapper;

import com.smp.model.Provider;
import com.smp.model.StateStore;
import com.smp.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Component
public class StateStoreMapper implements RowMapper<StateStore> {

    @Override
    public StateStore mapRow(ResultSet rs, int rowNum) throws SQLException {
        StateStore stateStore = new StateStore();
        stateStore.setNomeclatureID(rs.getString("nomeclature_id"));
        stateStore.setName(rs.getString("name"));
        stateStore.setOrgId(rs.getLong("org_id"));
        stateStore.setMin(rs.getInt("min"));
        stateStore.setMax(rs.getInt("max"));
        stateStore.setFold(rs.getInt("fold"));
        stateStore.setCost(rs.getDouble("cost"));
        stateStore.setProviderId(rs.getLong("provider_id"));
        stateStore.setCheck(rs.getBoolean("is_check"));
        stateStore.setSend(rs.getBoolean("is_send"));
        stateStore.setCount(rs.getDouble("count"));
        return stateStore;
    }
}
