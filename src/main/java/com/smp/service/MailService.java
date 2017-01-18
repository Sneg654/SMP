package com.smp.service;

import com.smp.model.StateStore;

import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/18/2017.
 */
public interface MailService {
     void sendEmail();
     void messageBodyFrom(List<StateStore> stateStoreList);
}
