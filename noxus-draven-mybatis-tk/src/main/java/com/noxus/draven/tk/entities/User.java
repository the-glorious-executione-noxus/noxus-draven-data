package com.noxus.draven.tk.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CREATE TABLE `table_user` (
 * `user_id` INT NOT NULL AUTO_INCREMENT,
 * `user_name` VARCHAR (100) NULL,
 * `address` VARCHAR (100) NULL,
 * `season` VARCHAR (100) NULL,
 * PRIMARY KEY (`user_id`)
 * );
 *
 * @author Lenovo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "table_user")
public class User {

    @Id
    private Integer userId;

    private String userName;

    //@ColumnType(typeHandler=AddressTypeHandler.class)
    @Column
    private Address address;

    //在枚举类型这里无法使用@ColumnType注解注册MyBatis内置的枚举类型处理器
    //@ColumnType(typeHandler=EnumTypeHandler.class)
    @Column
    private SeasonEnum season;

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", address=" + address + ", season=" + season
                + "]";
    }
}
