package com.muchbeeer.kotlindb.repository

import com.muchbeeer.kotlindb.model.Schools
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchoolDataSource : JpaRepository<Schools, String>