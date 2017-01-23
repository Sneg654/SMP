package com.smp.service;

import com.smp.model.StateStore;

import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
public interface StateStoreService {
    List<StateStore> getAll();

    List<StateStore> findById(StateStore stateStore);

    List<StateStore> findByOrgId(Long orgId);

    int insertStore(StateStore stateStore);

    int autoUpdate(StateStore stateStore);

    int sendUpdate(StateStore stateStore);

    int fullUpdate(StateStore stateStore);

    List<StateStore> findForSending(Long orgId);

//    List<StateStore> findByOrgId(Long orgId, String nomeclatureId);
}
