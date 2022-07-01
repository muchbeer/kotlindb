package com.muchbeeer.kotlindb.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table

@Entity
@Table(name = "schools")
data class Schools(
    @JsonProperty("school_name")
    @Column(name = "school_name", nullable = false)
    val schoolName : String,
    @JsonProperty("school_place")
    @Column(name = "school_place", nullable = true)
    val schoolPlace : String,
    @JsonProperty("student_no")
    @Column(name = "student_no", unique = true, nullable = false)
    @Id val schoolNumber : String,

)
