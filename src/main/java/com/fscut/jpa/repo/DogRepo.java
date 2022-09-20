package com.fscut.jpa.repo;

import com.fscut.jpa.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuxinwei
 * @date 2022/9/15 17:41
 */
public interface DogRepo extends JpaRepository<Dog,Integer> {
}
