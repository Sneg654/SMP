package com.smp.service;

import com.smp.model.Organization;

import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
public interface OrgService {
    List<Organization> getAll();
    int addOrg(String name);
    int deleteOrg(Long orgId);
    Organization findById(Long orgId);
}
