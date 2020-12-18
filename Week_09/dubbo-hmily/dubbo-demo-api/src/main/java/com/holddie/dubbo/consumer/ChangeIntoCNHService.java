package com.holddie.dubbo.consumer;

import org.dromara.hmily.annotation.Hmily;

public interface ChangeIntoCNHService {

    @Hmily
    void changeFromUSD(Integer userID, Integer amount);
}
