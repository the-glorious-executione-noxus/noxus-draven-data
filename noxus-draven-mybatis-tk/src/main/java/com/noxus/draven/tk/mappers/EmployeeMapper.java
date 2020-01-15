package com.noxus.draven.tk.mappers;

import com.noxus.draven.tk.entities.Employee;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.common.Mapper;

@CacheNamespace(flushInterval=30000)
public interface EmployeeMapper extends Mapper<Employee> {
}