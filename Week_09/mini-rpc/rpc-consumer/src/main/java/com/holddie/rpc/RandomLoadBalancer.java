package com.holddie.rpc;

import com.holddie.rpc.api.LoadBalancer;

import java.util.List;

public class RandomLoadBalancer implements LoadBalancer {
    @Override
    public String select(List<String> urls) {
        return urls.get(0);
    }
}