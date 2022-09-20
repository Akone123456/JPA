package com.fscut.jpa.Crud;

import com.fscut.jpa.repo.UserInfoRepo;
import com.fscut.jpa.repo.UserRepo11;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

/**
 * @author liuxinwei
 * @date 2022/9/3 9:45
 */
@SpringBootTest
public class QueryTest {

    @Resource
    private UserRepo11 userRepo;
    @Resource
    private UserInfoRepo userInfoRepo;

    @Test
    public void BaseQuery(){
        System.out.println(userRepo.findByAddress("上海"));
    }

    @Test
    public void testSqlPageable(){
        userRepo.findByNameLike12("李%",
                PageRequest.of(1,3, Sort.by(new Sort.Order(Sort.Direction.DESC,"id"))))
                .forEach(System.out::println);
    }
    @Test
    public void testSqlPageable123(){
        userRepo.findByNameLike123("李%",
                       Sort.by(new Sort.Order(Sort.Direction.DESC,"id")))
                .forEach(System.out::println);
    }

//    @Test
//    public void queryIndex(){
//        userInfoRepo.save(UserInfo.builder()
//                .ages(1)
//                .userInfoID(UserInfoID.builder()
//                        .name("jack")
//                        .telephone("123456789").build()).build());
//
//        userInfoRepo.findById(UserInfoID.builder()
//                .name("jack")
//                .telephone("123456789").build());
//    }

//    @Test
//    public void queryIndex2(){
//        userInfoRepo.save(UserInfo.builder()
//        .ages(1)
//        .name("jack")
//        .telephone("123456789").build());
//
//        userInfoRepo.findById(UserInfoID.builder()
//                .name("jack")
//                .telephone("123456789").build());
//    }
}
