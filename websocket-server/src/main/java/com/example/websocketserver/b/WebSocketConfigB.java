package com.example.websocketserver.b;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-11-15 23:52
 */
@Configuration
//注解开启使用STOMP协议来传输基于代理(message broker)的消息,
// 这时控制器支持使用@MessageMapping,就像使用@RequestMapping一样
@EnableWebSocketMessageBroker
public class WebSocketConfigB implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // 注册一个 stomp 终端（这个路径待会js里面会用到）
        // 如果需要跨域，在addEndpoint后面调用 setAllowedOrigins("*")
        registry.addEndpoint("/myEndpoint").withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // 注册多个（参数是可变参数）服务端接收消息前缀（这个路径待会js里面也会用到）
        registry.setApplicationDestinationPrefixes("/receiver");

        // 注册多个（参数是可变参数）服务端发送消息前缀（这个路径待会js里面会结合实现类路径用到）
        registry.enableSimpleBroker("/queueSender", "/topicSender");

    }
}
