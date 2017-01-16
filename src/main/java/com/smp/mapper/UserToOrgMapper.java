package com.smp.mapper;

import com.smp.model.User;
import com.smp.model.UserToOrg;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Component
public class UserToOrgMapper implements RowMapper<UserToOrg> {


    @Override
    public UserToOrg mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserToOrg userToOrg = new UserToOrg();
        userToOrg.setOrgId(rs.getLong("id"));
        userToOrg.setUserId(rs.getLong("user_id"));
        userToOrg.setOrgId(rs.getLong("org_id"));

        return userToOrg;
    }
}
