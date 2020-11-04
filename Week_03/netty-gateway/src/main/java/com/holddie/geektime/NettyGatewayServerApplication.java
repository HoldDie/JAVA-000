package com.holddie.geektime;


import com.holddie.geektime.inbound.HttpInboundServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * //  http://localhost:8888/api/hello  ==> gateway API
 * //  http://localhost:8088/api/hello  ==> backend service
 *
 * @author HoldDie
 * @version 1.0
 * @date 2020/11/4 9:15 PM
 */
public class NettyGatewayServerApplication {

    private static Logger logger = LoggerFactory.getLogger(NettyGatewayServerApplication.class);

    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "1.0.0";

    public static void main(String[] args) {
        String proxyServer = System.getProperty("proxyServer", "http://localhost:8088");
        String proxyPort = System.getProperty("proxyPort", "8888");
        int port = Integer.parseInt(proxyPort);
        logger.info("{} {} starting...", GATEWAY_NAME, GATEWAY_VERSION);
        HttpInboundServer server = new HttpInboundServer(port, proxyServer);
        logger.info("{} {} started at http://localhost:{} for server:{}", GATEWAY_NAME, GATEWAY_VERSION, port, proxyServer);
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
