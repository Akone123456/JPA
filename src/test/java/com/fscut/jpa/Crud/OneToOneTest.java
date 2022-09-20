package com.fscut.jpa.Crud;

import com.fscut.jpa.entity.User;
import com.fscut.jpa.entity.UserAddress;
import com.fscut.jpa.entity.UserInfo;
import com.fscut.jpa.repo.UserAddressRepo;
import com.fscut.jpa.repo.UserInfoRepo;
import com.fscut.jpa.repo.UserRepo11;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @author liuxinwei
 * @date 2022/9/14 15:26
 */
@SpringBootTest
public class OneToOneTest {
    @Resource
    private UserInfoRepo userInfoRepo;
    @Resource
    private UserRepo11 userRepo;
    @Resource
    private UserAddressRepo addressRepo;

    @Test
    public void tesyPersistAndRemove(){
        User user = User.builder()
                .name("jackxx")
                .email("123456@126.com")
                .build();
        UserInfo userInfo = UserInfo.builder()
                .ages(12)
                .user(user)
                .telephone("12345678")
                .build();
        // 新建UserInfo,级联新建User
        userInfoRepo.save(userInfo);
        // 删除UserInfo,级联删除User
        userInfoRepo.delete(userInfo);
    }

    @Test
    public void testRemove(){
        User user = User.builder()
                .name("jackxx")
                .email("123456@126.com")
                .build();
        UserInfo userInfo = UserInfo.builder()
                .ages(12)
                .user(user)
                .telephone("12345678")
                .build();
        // 新建UserInfo,级联新建User
        userInfoRepo.save(userInfo);
        userInfo.setUser(null);
        // 删除UserInfo,级联删除User
        userInfoRepo.delete(userInfo);
    }

    @Test
    @Transactional
    public void testUserAddress(){
        User user = User.builder()
                .name("jackxx")
                .email("123456@126.com")
                .build();
        UserAddress userAddress = UserAddress.builder()
                .address("shanghai1")
                .user(user)
                .build();
        UserAddress userAddress1 = UserAddress.builder()
                .address("shanghai2")
                .user(user)
                .build();
        addressRepo.saveAll(Lists.newArrayList(userAddress,userAddress1));

        User u = userRepo.findById(1).get();
        System.out.println(u.getName());
        System.out.println(u.getAddress());
    }
}
