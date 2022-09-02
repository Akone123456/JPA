package com.fscut.jpa;

import com.fscut.jpa.entity.User;
import com.fscut.jpa.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

@SpringBootTest
class JpaApplicationTests {

    @Test
    void contextLoads() {
    }
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

    @Test
    public void crudFindAllBySort() {
        userRepo.findAll(Sort.by(new Sort.Order(Sort.Direction.DESC,"id")))
                .forEach(System.out::println);
    }

    @Test
    public void crudFindAllByPageable() {
        userRepo.findAll(PageRequest.of(1,3,Sort.by(new Sort.Order(Sort.Direction.DESC,"id"))))
                .forEach(System.out::println);
    }

    @Test
    public void userFind() {
        userRepo.findByNameLike("李",Sort.by(new Sort.Order(Sort.Direction.DESC,"id")))
                .forEach(System.out::println);
    }

    @Test
    public void userFindByPageable() {
        userRepo.findByNameLike("李"
                ,PageRequest.of(1,3,Sort.by(new Sort.Order(Sort.Direction.DESC,"id"))))
                .forEach(System.out::println);
    }

    @Test
    public void userFindByPageableCount() {
        Page<User> userPage = userRepo.findByNameLikePage("李"
                , PageRequest.of(1, 3, Sort.by(new Sort.Order(Sort.Direction.DESC, "id"))));
        System.out.println(userPage.getTotalElements());

    }

    @Test
    public void firstAndTop() {
        userRepo.findFirst4ByNameLike("李%").forEach(System.out::println);

        userRepo.findTop3ByNameLike("李%").forEach(System.out::println);

    }


}
