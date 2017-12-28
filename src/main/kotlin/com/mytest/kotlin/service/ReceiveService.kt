package com.mytest.kotlin.service

import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ReceiveService {
    @RabbitHandler
    @RabbitListener(queues = ["myqueue"])
    fun getMessage(message: String) {
        println("收到的消息：--$message")
    }
}