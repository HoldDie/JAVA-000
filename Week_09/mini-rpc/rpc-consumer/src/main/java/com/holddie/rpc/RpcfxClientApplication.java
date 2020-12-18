package com.holddie.rpc;

import com.holddie.rpc.api.Order;
import com.holddie.rpc.api.OrderService;
import com.holddie.rpc.api.User;
import com.holddie.rpc.api.UserService;
import com.holddie.rpc.client.Rpcfx;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RpcfxClientApplication {

	public static void main(String[] args) {
		UserService userService = Rpcfx.create(UserService.class, "http://localhost:8080/");
		User user = userService.findById(1);
		System.out.println("find user id=1 from server: " + user.getName());

		OrderService orderService = Rpcfx.create(OrderService.class, "http://localhost:8080/");
		Order order = orderService.findOrderById(1992129);
		System.out.println(String.format("find order name=%s, amount=%f", order.getName(), order.getAmount()));

		UserService userService2 = Rpcfx.createFromRegistry(UserService.class, "localhost:2181", new TagRouter(), new RandomLoadBalancer(), new CuicuiFilter());

//		SpringApplication.run(RpcfxClientApplication.class, args);
	}


}



