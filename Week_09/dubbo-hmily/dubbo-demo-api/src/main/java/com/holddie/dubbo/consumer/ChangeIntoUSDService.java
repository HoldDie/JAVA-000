package com.holddie.dubbo.consumer;

import org.dromara.hmily.annotation.Hmily;

public interface ChangeIntoUSDService {

    @Hmily
    void changeFromCNH(Integer userID, Integer amount);

}
