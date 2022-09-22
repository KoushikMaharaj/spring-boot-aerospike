package example.springbootaerospikedemo.service;

import example.springbootaerospikedemo.pojo.Employee;
import example.springbootaerospikedemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Iterable<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepo.findById(id);
    }

    public void deleteById(Integer id){
        employeeRepo.deleteById(id);
    }
}
