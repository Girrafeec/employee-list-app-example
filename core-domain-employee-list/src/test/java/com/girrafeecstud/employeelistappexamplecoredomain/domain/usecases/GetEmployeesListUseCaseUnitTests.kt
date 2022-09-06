package com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases

import com.girrafeecstud.core_domain.domain.base.BusinessResult
import com.girrafeecstud.coredomainemployeelistentities.domain.entities.Employee
import com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories.EmployeeListRepository
import com.girrafeecstud.coreunittestsemployeelistsampledata.utils.data.samples.employeelists.baseEmployeesListExample
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetEmployeesListUseCaseUnitTests {

    private lateinit var getEmployeesListUseCase: GetEmployeesListUseCase

    private lateinit var employeesListRepository: EmployeeListRepository

    @Before
    fun setUp() {
        employeesListRepository = mock()
        getEmployeesListUseCase = GetEmployeesListUseCase(
            repository = employeesListRepository
        )
    }

    @Test
    fun `EXPECT employees list` () {
        runBlocking {

            whenever(
                employeesListRepository.getEmployeesList()
            ).thenReturn(
                flow {
                    emit(
                        BusinessResult.Success(
                            _data = baseEmployeesListExample
                        )
                    )
                }
            )

            val expectedResult = baseEmployeesListExample

            var actualResult: List<Employee>? = null

            getEmployeesListUseCase()
                .collect{ result ->
                    when (result) {
                        is BusinessResult.Success -> {
                            actualResult = result.data
                        }
                    }
                }

            assertEquals(expectedResult, actualResult)
        }
    }

}