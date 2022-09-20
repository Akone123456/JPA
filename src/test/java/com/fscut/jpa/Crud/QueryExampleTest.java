package com.fscut.jpa.Crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fscut.jpa.entity.User;
import com.fscut.jpa.entity.UserAddress;
import com.fscut.jpa.repo.UserAddressRepo;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author liuxinwei
 * @date 2022/9/15 15:08
 */
@SpringBootTest
public class QueryExampleTest {

    @Resource
    private UserAddressRepo userAddressRepo;

    @Test
    public void test01 () {
        User user = User.builder()
                .name("jack")
                .email("123456@126.com")
                .age(20)
                .build();
        userAddressRepo.saveAll(Lists.newArrayList(UserAddress.builder()
                .address("shanghai").user(user).build(),UserAddress.builder()
                .address("beijing").user(user).build()));
    }

    @Test
    public void testQBEE() throws JsonProcessingException {
        User user = User.builder()
                .name("jack")
                .age(20)
                .email("12345")
                .build();
        UserAddress userAddress = UserAddress.builder()
                .address("shanghai")
                .user(user)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        // 创建匹配器,构建动态查询条件
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("user.email",ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("address",ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withIncludeNullValues();
        Page<UserAddress> u = userAddressRepo.findAll(Example.of(userAddress,exampleMatcher), PageRequest.of(0,2));
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(u));
    }



}
