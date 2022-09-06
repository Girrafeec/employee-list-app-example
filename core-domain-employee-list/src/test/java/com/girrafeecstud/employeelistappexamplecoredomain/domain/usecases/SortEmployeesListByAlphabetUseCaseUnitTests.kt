package com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases

import com.girrafeecstud.core_domain.domain.base.BusinessResult
import com.girrafeecstud.coredomainemployeelistentities.domain.entities.Employee
import com.girrafeecstud.coreunittestsemployeelistsampledata.utils.data.samples.employeelists.employeesListSortedByAlphabetExample
import com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories.EmployeeListRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class SortEmployeesListByAlphabetUseCaseUnitTests {

    private lateinit var sortEmployeesListByAlphabetUseCase: SortEmployeesListByAlphabetUseCase

    private lateinit var employeesListRepository: EmployeeListRepository

    @Before
    fun setUp() {
        employeesListRepository = mock()
        sortEmployeesListByAlphabetUseCase = SortEmployeesListByAlphabetUseCase(
            repository = employeesListRepository
        )
    }

    @Test
    fun `EXPECT employees list` () {
        runBlocking {

            whenever(
                employeesListRepository.sortEmployeesListByAlphabet()
            ).thenReturn(
                flow {
                    emit(
                        BusinessResult.Success(
                            _data = employeesListSortedByAlphabetExample
                        )
                    )
                }
            )

            val expectedResult = employeesListSortedByAlphabetExample

            var actualResult: List<Employee>? = null

            sortEmployeesListByAlphabetUseCase()
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