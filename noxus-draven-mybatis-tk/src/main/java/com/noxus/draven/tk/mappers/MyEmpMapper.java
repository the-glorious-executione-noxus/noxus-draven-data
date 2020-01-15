package com.noxus.draven.tk.mappers;

import com.noxus.draven.tk.entities.Employee;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@RegisterMapper
public interface MyEmpMapper<T> {

    /**
     * 查询全部结果
     *
     * @return
     */
    @SelectProvider(type = MySelectProvider.class, method = "dynamicSQL")
    List<T> selectAll();
}
