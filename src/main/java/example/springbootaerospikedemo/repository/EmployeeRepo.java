package example.springbootaerospikedemo.repository;

import example.springbootaerospikedemo.pojo.Employee;
import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends AerospikeRepository<Employee,Integer> {
}
