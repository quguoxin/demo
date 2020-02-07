package com.example.websocketserver.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.WebSocketStompClient;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-11-16 0:28
 */
@Component
public class WebSocketServer2 {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public WebSocketServer2(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    @MessageMapping("/news")
    @SendTo("/topic/news")
    public void broadcastNews1(@Payload String message) {

    }

    //也可以使用SimpMessagingTemplate而不是注解@SendTo，
    // 您可以在控制器内自动装配(Autowired)。
    @MessageMapping("/news")
    public void broadcastNews2(@Payload String message) {
        simpMessagingTemplate.convertAndSend("/topic/news", message);
    }

}
