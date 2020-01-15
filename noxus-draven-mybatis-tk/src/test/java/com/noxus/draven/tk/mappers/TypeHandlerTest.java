package com.noxus.draven.tk.mappers;


import com.noxus.draven.tk.TkMyBatisApplication;
import com.noxus.draven.tk.entities.Address;
import com.noxus.draven.tk.entities.SeasonEnum;
import com.noxus.draven.tk.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TkMyBatisApplication.class)
public class TypeHandlerTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testQueryUser() {

        Integer userId = 8;

        User user = userMapper.selectByPrimaryKey(userId);

        System.out.println(user);
    }

    @Test
    public void testSaveUser() {

        User user = new User(null, "tom08", new Address("AAA", "BBB", "CCC"), SeasonEnum.AUTUMN);

        userMapper.insert(user);

    }

}
