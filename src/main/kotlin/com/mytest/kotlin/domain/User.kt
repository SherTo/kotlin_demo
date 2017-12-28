package com.mytest.kotlin.domain

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "t_user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var name: String = ""
):Serializable
