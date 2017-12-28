package com.mytest.kotlin.config

import com.alibaba.druid.support.http.StatViewServlet
import javax.servlet.annotation.WebInitParam
import javax.servlet.annotation.WebServlet

/**
 * allow 白名单
 * deny  黑名单（优先级高于白名单，同时存在时deny高于allow）
 * loginUsername 访问页面登录名
 * loginPassword 访问页面登录密码
 * resetEnable 是否重置数据
 */
@WebServlet(urlPatterns = ["/druid/*"], initParams = [(WebInitParam(name = "allow", value = "")), (WebInitParam(name = "deny", value = "192.168.0.121")), (WebInitParam(name = "loginUsername", value = "admin")), (WebInitParam(name = "loginPassword", value = "123456")), (WebInitParam(name = "resetEnable", value = "false"))])//禁止页面reset all
class DruidServlet : StatViewServlet()