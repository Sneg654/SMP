package com.smp.service;

import com.smp.mapper.UserMapper;
import com.smp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergey_Stefoglo on 1/15/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private JdbcTemplate template;

    @Override
    public List<User> getAll() {
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM user", Collections.emptyMap(),
                userMapper
        );
    }

    @Override
    public int save(User user) {
        String sql = "insert into user(user_id,name,login,password,email,phone,role) " +
                "values(:userId, :name,:login,:password,:email,:phone,:role)";

        Map<String, Object> params = new HashMap<>();
        params.put("userId", user.getUserId());
        params.put("name", user.getName());
        params.put("login", user.getLogin());
        params.put("password", user.getPassword());
        params.put("email", user.getEmail());
        params.put("phone", user.getPhone());
        params.put("role", user.getRole());
        namedParameterJdbcTemplate.update(sql, params);

        return 0;
    }

    ;
}
