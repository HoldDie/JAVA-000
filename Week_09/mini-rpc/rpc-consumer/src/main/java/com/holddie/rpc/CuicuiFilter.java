package com.holddie.rpc;

import com.holddie.rpc.api.Filter;
import com.holddie.rpc.api.RpcfxRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CuicuiFilter implements Filter {
    @Override
    public boolean filter(RpcfxRequest request) {
        log.info("filter {} -> {}", this.getClass().getName(), request.toString());
        return true;
    }
}