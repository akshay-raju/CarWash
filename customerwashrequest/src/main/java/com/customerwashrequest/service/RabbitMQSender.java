/*
 * package com.customerwashrequest.service;
 * 
 * import org.springframework.amqp.core.AmqpTemplate; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.stereotype.Service;
 * 
 * import com.customerwashrequest.pojo.WashOrder;
 * 
 * 
 * @Service public class RabbitMQSender {
 * 
 * @Autowired private AmqpTemplate rabbitTemplate;
 * 
 * @Value("${carwash.rabbitmq.exchange}") private String exchange;
 * 
 * @Value("${carwash.rabbitmq.routingkey}") private String routingkey;
 * 
 * public void send(WashOrder order) { rabbitTemplate.convertAndSend(exchange,
 * routingkey, order); System.out.println("Send msg = " + order);
 * 
 * } }
 */