package com.muchbeeer.kotlindb.servicevm

import com.muchbeeer.kotlindb.model.Schools
import com.muchbeeer.kotlindb.repository.SchoolDataSource
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class SchoolService (val db : SchoolDataSource) {

    fun retrieveSchools() : List<Schools>  = db.findAll()

    fun retrieveBySchool(schoolID : String) : Schools =
        db.findById(schoolID).orElseThrow {

            NoSuchElementException("Did not find the school with id $schoolID")         }


    fun saveSchools(schools: Schools) :  Schools =  db.save( schools)

    fun updateSchoolById(schoolID: String, schools: Schools) : Schools {
        return if (db.existsById(schoolID)) {
            db.save(
                Schools(
                    schoolNumber = schools.schoolNumber,
                    schoolPlace = schools.schoolPlace,
                    schoolName = schools.schoolName
                )
            )
        } else throw NoSuchElementException("No records match the school ID : $schoolID")
    }

    fun deleteSchoolById(schoolID: String) : Unit {
        if (db.existsById(schoolID)) db.deleteById(schoolID) else
            throw NoSuchElementException("No records found to delete")
    }
}