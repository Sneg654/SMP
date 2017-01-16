package com.smp.service;

import com.smp.mapper.UserMapper;
import com.smp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/15/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM user", Collections.emptyMap(),
                userMapper
        );
    }
}
