package com.girrafeecstud.coredomainemployeelistentities.domain.entities

data class Employee(
    val employeeId: String,
    val employeeAvatarUrl: String,
    val employeeFirstName: String,
    val employeeLastName: String,
    val employeeUserTag: String,
    val employeeDepartmentName: String,
    val employeePosition: String,
    val employeeBirthdayDate: String,
    val employeePhoneNumber: String
)