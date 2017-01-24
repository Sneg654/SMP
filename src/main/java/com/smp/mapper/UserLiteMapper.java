package com.smp.mapper;

import com.smp.model.UserLite;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergey_Stefoglo on 1/24/2017.
 */
@Component
public class UserLiteMapper implements RowMapper<UserLite> {

@Override
public UserLite mapRow(ResultSet rs, int rowNum) throws SQLException {
    UserLite user = new UserLite();
    user.setUserId(rs.getLong("user_id"));
    user.setName(rs.getString("name"));

    return user;
}
}
