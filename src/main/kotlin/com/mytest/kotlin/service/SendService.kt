package com.mytest.kotlin.service

import com.mytest.kotlin.config.RabbitMqConfig
import org.springframework.amqp.rabbit.core.CorrelationDataPostProcessor
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.rabbit.support.CorrelationData
import org.springframework.stereotype.Component
import java.util.*

@Component
class SendService(val rabbitTemplate: RabbitTemplate) {

    fun sendMsg(jsonstring: String) {
        println("开始发消息---------------------")
        val correlationData = CorrelationData(UUID.randomUUID().toString())
        rabbitTemplate.convertAndSend("myexchange", "myqueue", jsonstring, correlationData)
    }
}