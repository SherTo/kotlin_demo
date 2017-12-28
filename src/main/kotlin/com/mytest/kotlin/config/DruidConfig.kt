package com.mytest.kotlin.config

import com.alibaba.druid.pool.DruidDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.sql.SQLException
import javax.sql.DataSource

@Configuration
class DruidConfig {
    @Value("\${spring.datasource.url}")
    val dbUrl: String? = null

    @Value("\${spring.datasource.username}")
    val username: String? = null

    @Value("\${spring.datasource.password}")
    val password: String? = null

    @Value("\${spring.datasource.driver-class-name}")
    val driverClassName: String? = null

    @Value("\${spring.datasource.initialSize}")
    val initialSize: Int = 0

    @Value("\${spring.datasource.minIdle}")
    val minIdle: Int = 0

    @Value("\${spring.datasource.maxActive}")
    val maxActive: Int = 0

    @Value("\${spring.datasource.maxWait}")
    val maxWait: Int = 0

    @Value("\${spring.datasource.timeBetweenEvictionRunsMillis}")
    val timeBetweenEvictionRunsMillis: Int = 0

    @Value("\${spring.datasource.minEvictableIdleTimeMillis}")
    val minEvictableIdleTimeMillis: Int = 0

    @Value("\${spring.datasource.validationQuery}")
    val validationQuery: String? = null

    @Value("\${spring.datasource.testWhileIdle}")
    val testWhileIdle: Boolean = false

    @Value("\${spring.datasource.testOnBorrow}")
    val testOnBorrow: Boolean = false

    @Value("\${spring.datasource.testOnReturn}")
    val testOnReturn: Boolean = false

    @Value("\${spring.datasource.poolPreparedStatements}")
    val poolPreparedStatements: Boolean = false

    @Value("\${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    val maxPoolPreparedStatementPerConnectionSize: Int = 0

    @Value("\${spring.datasource.filters}")
    val filters: String? = null

    @Value("{spring.datasource.connectionProperties}")
    val connectionProperties: String? = null

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    fun dataSource(): DataSource {
        val datasource = DruidDataSource()

        datasource.url = this.dbUrl
        datasource.username = username
        datasource.password = password
        datasource.driverClassName = driverClassName

        //configuration
        datasource.initialSize = initialSize
        datasource.minIdle = minIdle
        datasource.maxActive = maxActive
        datasource.maxWait = maxWait.toLong()
        datasource.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis.toLong()
        datasource.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis.toLong()
        datasource.validationQuery = validationQuery
        datasource.isTestWhileIdle = testWhileIdle
        datasource.isTestOnBorrow = testOnBorrow
        datasource.isTestOnReturn = testOnReturn
        datasource.isPoolPreparedStatements = poolPreparedStatements
        datasource.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize
        try {
            datasource.setFilters(filters)
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        datasource.setConnectionProperties(connectionProperties)
        return datasource
    }

}