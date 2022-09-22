package example.springbootaerospikedemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.aerospike.mapping.Field;
import org.springframework.data.annotation.Id;

@Data
@Document(collection = "employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Field(value = "employee_id")
    private Integer empId;

    @Field(value = "employee_name")
    private String empName;

    @Field(value = "employee_type")
    private String empType;
}
