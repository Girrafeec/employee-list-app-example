package com.girrafeecstud.employeelistappexamplecoredomain.domain.usecases

import com.girrafeecstud.core_domain.domain.base.BusinessResult
import com.girrafeecstud.coredomainemployeelistentities.domain.entities.Employee
import com.girrafeecstud.coreunittestsemployeelistsampledata.utils.data.samples.employeelists.employeesListByAndroidDepartmentExample
import com.girrafeecstud.coreunittestsemployeelistsampledata.utils.data.samples.inputparameters.androidDepartmentName
import com.girrafeecstud.employeelistappexamplecoredomain.domain.repositories.EmployeeListRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetEmployeesListByDepartmentUseCaseUnitTests {

    private lateinit var getEmployeesListByDepartmentUseCase: GetEmployeesListByDepartmentUseCase

    private lateinit var employeesListRepository: EmployeeListRepository

    @Before
    fun setUp() {
        employeesListRepository = mock()
        getEmployeesListByDepartmentUseCase = GetEmployeesListByDepartmentUseCase(
            repository = employeesListRepository
        )
    }

    @Test
    fun `EXPECT employees list` () {
        runBlocking {

            whenever(
                employeesListRepository.getEmployeesListByDepartment(
                    employeeDepartmentName = androidDepartmentName
                )
            ).thenReturn(
                flow {
                    emit(
                        BusinessResult.Success(
                            _data = employeesListByAndroidDepartmentExample
                        )
                    )
                }
            )

            val expectedResult = employeesListByAndroidDepartmentExample

            var actualResult: List<Employee>? = null

            getEmployeesListByDepartmentUseCase(
                employeeDepartmentName = androidDepartmentName
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