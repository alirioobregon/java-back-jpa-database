package com.example.ali.java_back_jpa_database.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "devices")
class Devices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(unique = true, nullable = false)
    val deviceNumber: String = ""

    @Column(nullable = false)
    private val createAt: LocalDateTime = LocalDateTime.now()


}