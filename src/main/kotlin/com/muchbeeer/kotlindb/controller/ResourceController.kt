package com.muchbeeer.kotlindb.controller

import com.muchbeeer.kotlindb.model.Schools
import com.muchbeeer.kotlindb.servicevm.SchoolService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ResourceController(private val service : SchoolService) {

    @GetMapping("/schools")
    fun retrieveSchools() : List<Schools> = service.retrieveSchools()

    @GetMapping("/schools/{id}")
    fun retrieveSchoolById(@PathVariable("id") schoolID : String) : Schools = service.retrieveBySchool(schoolID)

    @PostMapping("/schools/post")
    fun saveSchools(@RequestBody school : Schools) { service.saveSchools(school) }

    @PatchMapping("/schools/{id}")
    fun updateSchool(@PathVariable("id") schoolID: String, @RequestBody payload : Schools) : Schools =
        service.updateSchoolById(schoolID, payload)

    @DeleteMapping("/schools/{id}")
    fun deleteSchool(@PathVariable("id") schoolID: String) : Unit = service.deleteSchoolById(schoolID)
}