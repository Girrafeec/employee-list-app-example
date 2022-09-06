package com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories

import com.girrafeecstud.core_domain.domain.base.BusinessResult
import com.girrafeecstud.coredomainemployeelistentities.domain.entities.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeListRepository {

    suspend fun getEmployeesList(): Flow<BusinessResult<List<Employee>>>

    suspend fun sortEmployeesListByAlphabet(): Flow<BusinessResult<List<Employee>>>

    suspend fun sortEmployeesListByBirthdayDate(): Flow<BusinessResult<List<Employee>>>

    suspend fun getEmployeesListByDepartment(employeeDepartmentName: String): Flow<BusinessResult<List<Employee>>>

    suspend fun searchEmployee(searchKeyword: String): Flow<BusinessResult<List<Employee>>>

}