package com.noxus.draven.tk.controller;

import com.noxus.draven.tk.entities.Employee;
import com.noxus.draven.tk.mappers.EmployeeMapper;
import com.noxus.draven.tk.mappers.MyE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private MyE myE;


//    @GetMapping("test")
//    public List<Employee> test() {
//        return employeeMapper.selectAll();
//    }

    @GetMapping("selectOne/{empId}")
    public Employee selectOne(@PathVariable("empId") Integer empId) {
        return employeeMapper.selectOne(new Employee(empId, null, null, null));
    }

    @GetMapping("selectAllmyE")
    public void testSelectAllmyE() {
        List<Employee> employees = myE.selectAll();
        employees.forEach(
                System.out::println
        );
        List<Employee> employee = myE.selectAll();
        employee.forEach(
                System.out::println
        );
    }

    @GetMapping("selectAll")
    public void testSelectAll() {
        List<Employee> employees = employeeMapper.selectAll();
        employees.forEach(
                System.out::println
        );
        List<Employee> employee = employeeMapper.selectAll();
        employee.forEach(
                System.out::println
        );
    }


}
