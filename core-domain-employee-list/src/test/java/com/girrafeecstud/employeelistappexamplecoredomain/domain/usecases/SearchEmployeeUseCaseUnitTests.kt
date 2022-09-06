package com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases

import com.girrafeecstud.core_domain.domain.base.BusinessResult
import com.girrafeecstud.coredomainemployeelistentities.domain.entities.Employee
import com.girrafeecstud.coreunittestsemployeelistsampledata.utils.data.samples.employeelists.employeesListBySearchKeywordFExample
import com.girrafeecstud.coreunittestsemployeelistsampledata.utils.data.samples.inputparameters.searchKeywordF
import com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories.EmployeeListRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class SearchEmployeeUseCaseUnitTests {

    private lateinit var searchEmployeeUseCase: SearchEmployeeUseCase

    private lateinit var employeesListRepository: EmployeeListRepository

    @Before
    fun setUp() {
        employeesListRepository = mock()
        searchEmployeeUseCase = SearchEmployeeUseCase(
            repository = employeesListRepository
        )
    }

    @Test
    fun `EXPECT employees list` () {
        runBlocking {

            whenever(
                employeesListRepository.searchEmployee(
                    searchKeyword = searchKeywordF
                )
            ).thenReturn(
                flow {
                    emit(
                        BusinessResult.Success(
                            _data = employeesListBySearchKeywordFExample
                        )
                    )
                }
            )

            val expectedResult = employeesListBySearchKeywordFExample

            var actualResult: List<Employee>? = null

            searchEmployeeUseCase(
                searchKeyword = searchKeywordF
            )
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