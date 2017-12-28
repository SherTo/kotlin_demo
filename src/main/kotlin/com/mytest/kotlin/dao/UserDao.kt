package com.mytest.kotlin.dao

import com.mytest.kotlin.domain.User


interface UserDao {
    fun addUser(user: User): User

    fun getUserById(id: Int): User

    fun getListByName(name: String): MutableList<User>
}