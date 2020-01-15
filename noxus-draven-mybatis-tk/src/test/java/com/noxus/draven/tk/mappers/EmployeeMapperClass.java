package com.noxus.draven.tk.mappers;

import com.noxus.draven.tk.TkMyBatisApplication;
import com.noxus.draven.tk.entities.Employee;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TkMyBatisApplication.class)
public class EmployeeMapperClass {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private MyE myE;

    @Test
    public void testSelectOne() {

        //1.创建封装查询条件的实体类对象(此处需要一个动态处理的方案)
        Employee employee = new Employee(null, "bob", 5560.11, null);

        //2.执行查询
        Employee employeeQueryResult = employeeMapper.selectOne(employee);

        //3.打印
        System.out.println(employeeQueryResult);
    }

    /**
     * Preparing: SELECT emp_id,emp_name,emp_salary,emp_age FROM tabple_emp WHERE emp_id = ?
     */
    @Test
    public void testSelectByPrimaryKey() {
        //1.提供id值
        Integer empId = 3;

        //2.执行根据主键进行的查询
        Employee employee1 = new Employee(2, null, null, 23);
        Employee employee = employeeMapper.selectByPrimaryKey(employee1);

        //3.打印结果
        System.out.println(employee);

    }

    @Test
    public void testExistsWithPrimaryKey() {

        //1.提供主键值
        Integer empId = 33;

        //2.执行查询
        boolean exists = employeeMapper.existsWithPrimaryKey(empId);

        //3.打印结果
        System.out.println(exists);
    }

    @Test
    public void testInsert() {

        //1.创建实体类对象封装要保存到数据库的数据
        Employee employee = new Employee(null, "emp03", 3000.00, 23);

        //2.执行插入操作
        int insert = employeeMapper.insert(employee);

        //3.获取employee对象的主键字段值
        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer empId = employee.getEmpId();
        System.out.println("empId=" + empId);

    }

    @Test
    public void testInsertSelective() {

        //1.创建实体类对象封装要保存到数据库的数据
        Employee employee = new Employee(null, "emp04", null, 23);

        //2.执行插入操作
        employeeMapper.insertSelective(employee);

    }

    @Test
    public void testSelectByExample() {

        //目标：WHERE (emp_salary>? AND emp_age<?) OR (emp_salary<? AND emp_age>?)
        //1.创建Example对象
        Example example = new Example(Employee.class);

        //***********************
        //i.设置排序信息
        example.orderBy("empSalary").asc().orderBy("empAge").desc();

        //ii.设置“去重”
        example.setDistinct(true);

        //iii.设置select字段
        example.selectProperties("empName", "empSalary", "empAge");

        //***********************

        //2.通过Example对象创建Criteria对象
        Criteria criteria01 = example.createCriteria();
        Criteria criteria02 = example.createCriteria();

        //3.在两个Criteria对象中分别设置查询条件
        //property参数：实体类的属性名
        //value参数：实体类的属性值
        criteria01.andGreaterThan("empSalary", 3000)
                .andLessThan("empAge", 25);

        criteria02.andLessThan("empSalary", 5000)
                .andGreaterThan("empAge", 30);

        //4.使用OR关键词组装两个Criteria对象
        example.or(criteria02);

        //5.执行查询
        List<Employee> empList = employeeMapper.selectByExample(example);

        empList.forEach(System.out::println);
    }


    @Test
    public void testSelectAll() {
        List<Employee> employees = myE.selectAll();
        employees.forEach(
                System.out::println
        );
    }
//
//    @Test
//    public void testSelectAll() {
//
//    }
//
//    @Test
//    public void testSelectCount() {
//
//    }
//

//

//
//    }
//

//

//
//    @Test
//    public void testUpdateByPrimaryKey() {
//
//    }
//
//    @Test
//    public void testUpdateByPrimaryKeySelective() {
//
//        //1.创建用于测试的实体类
//        Employee employee = new Employee(7, "empNewName", null, null);
//
//        //2.执行更新
//        employeeMapper.updateEmployeeSelective(employee);
//
//    }
//
//    @Test
//    public void testDelete() {
//
//        //1.声明实体类变量作为查询条件
//        Employee employee = null;
//
//        //2.执行删除
//        employeeMapper.removeEmployee(employee);
//
//    }
//
//    @Test
//    public void testDeleteByPrimaryKey() {
//
//        //1.提供主键值
//        Integer empId = 13;
//
//        //2.执行删除
//        employeeMapper.removeEmployeeById(empId);
//
//    }
//
//
//
//    @Test
//    public void testSelectOneByExample() {
//
//    }
//
//    @Test
//    public void testSelectCountByExample() {
//
//    }
//
//    @Test
//    public void testDeleteByExample() {
//
//    }
//
//    @Test
//    public void testUpdateByExample() {
//
//    }
//
//    @Test
//    public void testUpdateByExampleSelective() {
//
//    }
//
//    @Test
//    public void testSelectByExampleAndRowBounds() {
//
//    }
//
//    @Test
//    public void testSelectByRowBounds() {
//
//        int pageNo = 3;
//        int pageSize = 5;
//
//        int index = (pageNo - 1) * pageSize;
//
//        RowBounds rowBounds = new RowBounds(index, pageSize);
//
//        List<Employee> empList = employeeMapper.getEmpListByRowBounds(rowBounds);
//        for (Employee employee : empList) {
//            System.out.println(employee);
//        }
//
//    }
}
