package com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories

import com.girrafeecstud.core_domain.domain.base.BaseResult
import com.girrafeecstud.employeelistappexamplecoredomain.domain.entities.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeListRepository {

    suspend fun getEmployeesList(): Flow<BaseResult<List<Employee>>>

    suspend fun sortEmployeesListByAlphabet(): Flow<BaseResult<List<Employee>>>

    suspend fun sortEmployeesListByBirthdayDate(): Flow<BaseResult<List<Employee>>>

    suspend fun getEmployeesListByDepartment(employeeDepartmentName: String): Flow<BaseResult<List<Employee>>>

    suspend fun searchEmployee(searchKeyword: String): Flow<BaseResult<List<Employee>>>

}