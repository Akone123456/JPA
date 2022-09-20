package com.fscut.jpa.Crud;

import com.fscut.jpa.entity.Dog;
import com.fscut.jpa.repo.DogRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import javax.annotation.Resource;

/**
 * @author liuxinwei
 * @date 2022/9/15 17:42
 */
@SpringBootTest
public class QueryByExampleWithDog {
    @Resource
    private DogRepo dogRepo;

    @Test
    public void insert() {
        Dog dog = Dog.builder()
                .age(10)
                .name("JACK").build();
        dogRepo.save(dog);
    }

    /**
     * And查询
     */
    @Test
    public void testBy01(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .build();
        ExampleMatcher matcher = ExampleMatcher.matchingAll();
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }

    /**
     * OR 查询
     */
    @Test
    public void testBy02(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .build();
        ExampleMatcher matcher = ExampleMatcher.matchingAny();
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }

    /**
     *  忽略大小写查询
     */
    @Test
    public void testBy03(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .type("L")
                .build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("name");
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }

    /**
     *  忽略大小写查询
     */
    @Test
    public void testBy04(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .type("L")
                .build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase();
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }


    @Test
    public void testBy05(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .type("L")
                .build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                        .withIncludeNullValues();
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }

    @Test
    public void testBy06(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .type("L")
                .build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues();
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }

    @Test
    public void testBy07(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .type("L")
                .build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name","type");
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }

    @Test
    public void testBy08(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .type("L")
                .build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                        .withStringMatcher( ExampleMatcher.StringMatcher.DEFAULT);
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }
    @Test
    public void testBy09(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .type("L")
                .build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                        .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }

    @Test
    public void testBy10(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .type("L")
                .build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }

    @Test
    public void testBy11(){
        Dog dog = Dog.builder()
                .name("TIMI")
                .age(2)
                .type("L")
                .build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        System.out.println(dogRepo.findAll(Example.of(dog, matcher)));
    }



}
