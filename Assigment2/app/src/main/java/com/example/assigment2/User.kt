package com.example.assigment2
import java.util.UUID
import java.io.Serializable

data class User (

    val name: String,
    val email: String,
    val password: String,
    val id: UUID = UUID.randomUUID()
) : Serializable