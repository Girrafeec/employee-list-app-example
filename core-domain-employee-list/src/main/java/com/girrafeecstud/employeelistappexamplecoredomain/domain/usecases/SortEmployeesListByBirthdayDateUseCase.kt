package com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases

import com.girrafeecstud.core_domain.domain.base.BusinessResult
import com.girrafeecstud.coredomainemployeelistentities.domain.entities.Employee
import com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories.EmployeeListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SortEmployeesListByBirthdayDateUseCase @Inject constructor(
    private val repository: EmployeeListRepository
) {
    suspend operator fun invoke(): Flow<BusinessResult<List<Employee>>> {
        return repository.sortEmployeesListByBirthdayDate()
    }
}