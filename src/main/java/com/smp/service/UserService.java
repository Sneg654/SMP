package com.smp.service;

import com.smp.model.User;
import com.smp.model.UserLite;

import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/15/2017.
 */
public interface UserService {

    List<User> getAll();
    User findById(Long userId);
    int delete(Long userId);
    int save(User user);

    List<UserLite> getLiteAll();

}
