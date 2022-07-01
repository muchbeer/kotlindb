package com.muchbeeer.kotlindb.controller

import com.muchbeeer.kotlindb.model.Schools
import com.muchbeeer.kotlindb.servicevm.SchoolService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ResourceController(private val service : SchoolService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun noElementFound(ex : NoSuchElementException) : ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)     }


    @GetMapping("/schools")
    fun retrieveSchools() : List<Schools> = service.retrieveSchools()

    @GetMapping("/schools/{id}")
    fun retrieveSchoolById(@PathVariable("id") schoolID : String) : Schools = service.retrieveBySchool(schoolID)

    @PostMapping("/schools/post")
    fun saveSchools(@RequestBody school : Schools) : Schools =  service.saveSchools(school)

    @PatchMapping("/schools/{id}")
    fun updateSchool(@PathVariable("id") schoolID: String, @RequestBody payload : Schools) : Schools =
        service.updateSchoolById(schoolID, payload)

    @DeleteMapping("/schools/{id}")
    fun deleteSchool(@PathVariable("id") schoolID: String) : Unit = service.deleteSchoolById(schoolID)
}