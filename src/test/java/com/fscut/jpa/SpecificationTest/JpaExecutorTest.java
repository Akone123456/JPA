package com.fscut.jpa.SpecificationTest;

import com.fscut.jpa.Enum.SexEnum;
import com.fscut.jpa.entity.User;
import com.fscut.jpa.entity.UserAddress;
import com.fscut.jpa.repo.UserAddressRepo;
import com.fscut.jpa.repo.UserRepo;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author liuxinwei
 * @date 2022/9/20 16:36
 */
@SpringBootTest
public class JpaExecutorTest {
    @Resource
    private UserRepo userRepo;
    @Resource
    private UserAddressRepo addressRepo;


    @Test
    public void test01(){
        User user = User.builder()
                .name("jack")
                .email("123456@126.com")
                .sex(SexEnum.BOY)
                .age(20)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        addressRepo.saveAll(Lists.newArrayList(UserAddress.builder().user(user).address("shanghai").build(),
                UserAddress.builder().user(user).address("beijing").build()));
    }

    @Test
    public void test02(){
        User userQuery = User.builder()
                .name("jack")
                .email("123456@126.com")
                .sex(SexEnum.BOY)
                .age(20)
                .address(Lists.newArrayList(UserAddress.builder().address("shanghai").build()))
                .build();
        List<User> userList = userRepo.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                // name模糊查询
                if(StringUtils.isNotBlank(userQuery.getName())) {
                    predicateList.add(cb.like(root.get("name"),userQuery.getName()));
                }
                // sex精准查询
                if(userQuery.getSex()!=null) {
                    predicateList.add(cb.equal(root.get("sex"),userQuery.getSex()));
                }
                // age范围查询
                if(userQuery.getAge()!=null){
                    predicateList.add(cb.greaterThanOrEqualTo(root.get("age"),userQuery.getAge()));
                }
//                // 时间区间查询
//                predicateList.add(cb.between(root.get("updateTime"), LocalDate.parse("2022-09-01 12:13:14",DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(),"2022-10-01 12:13:14"));

                if(!ObjectUtils.isEmpty(userQuery.getAddress())) {
                    predicateList.add(cb.in(root.join("address").get("address")).value(userQuery.getAddress().stream().map(a->a.getAddress()).collect(Collectors.toList())));
                }
                return query.where(predicateList.toArray(new Predicate[predicateList.size()])).getRestriction();
            }
        });
        System.out.println(userList);
    }
}
