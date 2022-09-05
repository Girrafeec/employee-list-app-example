package com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases

import com.girrafeecstud.core_domain.domain.base.BaseResult
import com.girrafeecstud.employeelistappexamplecoredomain.domain.entities.Employee
import com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories.EmployeeListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmployeesListUseCase @Inject constructor(
    private val repository: EmployeeListRepository
) {
    suspend operator fun invoke(): Flow<BaseResult<List<Employee>>> {
        return repository.getEmployeesList()
    }
}