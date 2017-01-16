package com.smp.mapper;

import com.smp.model.Organization;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Component
public class OrganazationMappper implements RowMapper<Organization> {
    @Override
    public Organization mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Organization org = new Organization();
        org.setOrgId(resultSet.getLong("org_id"));
        org.setOrgName(resultSet.getString("org_name"));


        return org;
    }
}