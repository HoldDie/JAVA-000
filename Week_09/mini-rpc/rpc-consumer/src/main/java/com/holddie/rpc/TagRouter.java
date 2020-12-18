package com.holddie.rpc;

import com.holddie.rpc.api.Router;

import java.util.List;

public class TagRouter implements Router {
    @Override
    public List<String> route(List<String> urls) {
        return urls;
    }
}