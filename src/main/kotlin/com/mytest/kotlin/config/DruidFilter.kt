package com.mytest.kotlin.config

import com.alibaba.druid.support.http.WebStatFilter
import javax.servlet.annotation.WebFilter
import javax.servlet.annotation.WebInitParam

/**
 * 过滤静态资源
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = ["/*"], initParams = [(WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"))])
class DruidFilter : WebStatFilter()