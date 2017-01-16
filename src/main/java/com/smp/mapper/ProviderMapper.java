package com.smp.mapper;

import com.smp.model.Provider;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Component
public class ProviderMapper implements RowMapper<Provider> {
    @Override
    public Provider mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Provider provider = new Provider();
        provider.setProviderId(resultSet.getLong("provider_id"));
        provider.setName(resultSet.getString("name"));
        provider.setPhone(resultSet.getString("phone"));
        provider.setDescription(resultSet.getString("description"));
        return provider;
    }
}
