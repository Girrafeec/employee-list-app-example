package com.girrafeecstud.employeelistappexamplecoredomain.domain.entities

data class Employee(
    val employeeId: String,
    val employeeAvatarUrl: String,
    val employeeFirstName: String,
    val employeeSecondName: String,
    val employeeUserTag: String,
    val employeeDepartmentName: String,
    val employeePosition: String,
    val employeeBirthdayDate: String,
    val employeePhoneNumber: String
)
