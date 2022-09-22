package example.springbootaerospikedemo.controller;

import example.springbootaerospikedemo.pojo.Employee;
import example.springbootaerospikedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Employee employee) {
        System.out.println(employee);
        Employee employee1 = employeeService.save(employee);
        System.out.println(employee1);
        if (employee1 != null) {
            return new ResponseEntity<>("Employee with id " + employee1.getEmpId() + " is created.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Employee is not created", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer empId) {
        Optional<Employee> employee = employeeService.findById(empId);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee with id " + empId + " not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        Iterable<Employee> employees = employeeService.findAll();
        if (employees != null) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        return new ResponseEntity<>("Employess not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>("Employee deleted with id " + id, HttpStatus.OK);
    }

}
