package com.muchbeeer.kotlindb.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table(name = "schools")
data class Schools(
    @JsonProperty("school_name")
    @Column(name = "school_name", unique = true, nullable = false)
    val schoolName : String,
    @JsonProperty("school_place")
    @Column(name = "school_place", nullable = true)
    val schoolPlace : String,
    @JsonProperty("student_no")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val schoolNumber : String,

)
