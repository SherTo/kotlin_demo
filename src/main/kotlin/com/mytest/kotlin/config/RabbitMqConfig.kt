package com.mytest.kotlin.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableRabbit
class RabbitMqConfig {

    @Bean
    fun queue() = Queue("myqueue", true)

    @Bean
    fun topExchange() = TopicExchange("myexchange")

    @Bean
    fun binding() = BindingBuilder.bind(queue()).to(topExchange()).with("myqueue")

}