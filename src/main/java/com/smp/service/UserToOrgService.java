package com.smp.service;

import com.smp.model.UserToOrg;

import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
public interface UserToOrgService {
    List<UserToOrg> getAll();

    List<UserToOrg> findByOrgId(Long orgId);
    List<UserToOrg> findByUserId(Long orgId);

    int deleteByOrgId(Long orgId);
    int insert(Long orgId, Long userId);

}
