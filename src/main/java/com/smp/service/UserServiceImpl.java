package com.smp.service;

import com.smp.mapper.UserLiteMapper;
import com.smp.mapper.UserMapper;
import com.smp.model.User;
import com.smp.model.UserLite;
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
    @Autowired
    private UserLiteMapper userLiteMapper;

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
    public  List<UserLite> getLiteAll(){
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM user", Collections.emptyMap(),
                userLiteMapper
        );

    };

    public int delete(Long userId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return namedParameterJdbcTemplate.update(
                "delete  FROM user where user_id=:userId", params);
    };
    @Override
    public User findById(Long userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM user where user_id=:userId", params,
                userMapper).get(0);
    }


    @Override
    public int save(User user) {
        String sqlInsert = "insert into user(name,login,password,email,phone,role) " +
                "values(:name,:login,:password,:email,:phone,:role)";

        String sqlUpdate = "update user set  name=:name ,login=:login,password=:password,email:=email,phone=:phone,role=:role where user_id=:userId";


        Map<String, Object> params = new HashMap<>();
        params.put("userId", user.getUserId());
        params.put("name", user.getName());
        params.put("login", user.getLogin());
        params.put("password", user.getPassword());
        params.put("email", user.getEmail());
        params.put("phone", user.getPhone());
        params.put("role", user.getRole());
        if (user.getUserId() != null) {
            namedParameterJdbcTemplate.update(sqlUpdate, params);
        } else {
            namedParameterJdbcTemplate.update(sqlInsert, params);
        }
        return 0;
    }

    ;
}
