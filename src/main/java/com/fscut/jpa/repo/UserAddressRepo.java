package com.fscut.jpa.repo;

import com.fscut.jpa.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * @author liuxinwei
 * @date 2022/9/14 17:11
 */
public interface UserAddressRepo extends JpaRepository<UserAddress,Integer> , QueryByExampleExecutor<UserAddress> {

}
