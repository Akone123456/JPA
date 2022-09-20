package com.fscut.jpa.repo;

import com.fscut.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author liuxinwei
 * @date 2022/9/20 16:32
 */
public interface UserRepo extends JpaSpecificationExecutor<User>, JpaRepository<User,Integer> {
}
