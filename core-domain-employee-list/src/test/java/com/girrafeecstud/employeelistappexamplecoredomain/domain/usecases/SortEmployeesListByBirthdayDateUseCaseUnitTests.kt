package com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases

import com.girrafeecstud.core_domain.domain.base.BusinessResult
import com.girrafeecstud.coredomainemployeelistentities.domain.entities.Employee
import com.girrafeecstud.coreunittestsemployeelistsampledata.utils.data.samples.employeelists.employeesListSortedByBirthdayDateExample
import com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories.EmployeeListRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class SortEmployeesListByBirthdayDateUseCaseUnitTests {

    private lateinit var sortEmployeesListByBirthdayDateUseCase: SortEmployeesListByBirthdayDateUseCase

    private lateinit var employeesListRepository: EmployeeListRepository

    @Before
    fun setUp() {
        employeesListRepository = mock()
        sortEmployeesListByBirthdayDateUseCase = SortEmployeesListByBirthdayDateUseCase(
            repository = employeesListRepository
        )
    }

    @Test
    fun `EXPECT employees list` () {
        runBlocking {

            whenever(
                employeesListRepository.sortEmployeesListByBirthdayDate()
            ).thenReturn(
                flow {
                    emit(
                        BusinessResult.Success(
                            _data = employeesListSortedByBirthdayDateExample
                        )
                    )
                }
            )

            val expectedResult = employeesListSortedByBirthdayDateExample

            var actualResult: List<Employee>? = null

            sortEmployeesListByBirthdayDateUseCase()
                .collect{ result ->
                    when (result) {
                        is BusinessResult.Success -> {
                            actualResult = result.data
                        }
                    }
                }

            Assert.assertEquals(expectedResult, actualResult)
        }
    }

}