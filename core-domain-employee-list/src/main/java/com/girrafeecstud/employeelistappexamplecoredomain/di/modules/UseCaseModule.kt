package com.girrafeecstud.employeelistappexamplecoredomain.di.modules

import com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories.EmployeeListRepository
import com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases.GetEmployeesListUseCase
import com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases.GetEmployeesListByDepartmentUseCase
import com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases.SearchEmployeeUseCase
import com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases.SortEmployeesListByAlphabetUseCase
import com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases.SortEmployeesListByBirthdayDateUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetEmployeesListUseCase (
        repository: EmployeeListRepository
    ): GetEmployeesListUseCase {
        return GetEmployeesListUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun provideGetEmployeesListByDepartmentUseCase (
        repository: EmployeeListRepository
    ): GetEmployeesListByDepartmentUseCase {
        return GetEmployeesListByDepartmentUseCase(
            repository = repository
        )
    }

    @Provides
    @Singleton
    fun provideSearchEmployeeUseCase(
        repository: EmployeeListRepository
    ): SearchEmployeeUseCase {
        return SearchEmployeeUseCase(
            repository = repository
        )
    }

    @Provides
    @Singleton
    fun provideSortEmployeesListByAlphabetUseCase(
        repository: EmployeeListRepository
    ): SortEmployeesListByAlphabetUseCase {
        return SortEmployeesListByAlphabetUseCase(
            repository = repository
        )
    }

    @Provides
    @Singleton
    fun provideSortEmployeesListByBirthdayDateUseCase(
        repository: EmployeeListRepository
    ): SortEmployeesListByBirthdayDateUseCase {
        return SortEmployeesListByBirthdayDateUseCase(
            repository = repository
        )
    }

}