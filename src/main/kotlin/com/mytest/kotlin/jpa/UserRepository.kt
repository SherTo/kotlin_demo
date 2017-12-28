package com.mytest.kotlin.jpa

import com.mytest.kotlin.domain.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserRepository :  CrudRepository<User, Int> {
    @Query("select user from User as user  where user.name=:name")
    fun getUserList(@Param("name") name: String): MutableList<User>
}