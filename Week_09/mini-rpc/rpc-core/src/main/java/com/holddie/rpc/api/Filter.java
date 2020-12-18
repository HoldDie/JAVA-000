package com.holddie.rpc.api;

public interface Filter {

    boolean filter(RpcfxRequest request);

    // Filter next();

}
