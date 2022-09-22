package example.springbootaerospikedemo.service;

import example.springbootaerospikedemo.pojo.Employee;
import example.springbootaerospikedemo.repository.EmployeeRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@Disabled
class EmployeeServiceTest {

    @MockBean
    EmployeeRepo repo;
    @Autowired
    EmployeeService service;

    @Test
    void save() {
        Employee expectedEmployee = new Employee(123, "ram", "intern");
        when(repo.save(expectedEmployee)).thenReturn(expectedEmployee);
        Employee actualEmployee = service.save(new Employee(123, "ram", "intern"));
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void findAll() {
        Iterable<Employee> employees = Arrays.asList(new Employee[]{new Employee(123, "ram", "intern")
                , new Employee(124, "sham", "intern")});
        when(repo.findAll()).thenReturn(employees);
        assertEquals(employees, service.findAll());
    }

    @Test
    void findById() {
        Employee expectedEmployee = new Employee(123, "ram", "intern");
        when(repo.findById(expectedEmployee.getEmpId())).thenReturn(Optional.of(expectedEmployee));
        //Employee actualEmployee = new Employee(123, "ram", "intern");
        assertEquals(Optional.of(expectedEmployee), service.findById(123));
    }
}