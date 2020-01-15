package com.noxus.draven.tk.mappers;

import com.noxus.draven.tk.entities.Employee;
import org.apache.ibatis.annotations.CacheNamespace;

@CacheNamespace
public interface MyE extends MyEmpMapper<Employee> {

}
