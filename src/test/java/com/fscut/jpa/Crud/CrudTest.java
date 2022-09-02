package com.fscut.jpa.Crud;

import com.fscut.jpa.entity.User;
import com.fscut.jpa.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author liuxinwei
 * @date 2022/9/2 9:41
 */

public class CrudTest {
    @Resource
    private UserRepo userRepo;

    @Test
    public void crudRepository() {
        User user = new User();
        user.setAddress("巴基斯坦");
        user.setAge(200);
        user.setName("小花");
        userRepo.save(user);
    }
}
