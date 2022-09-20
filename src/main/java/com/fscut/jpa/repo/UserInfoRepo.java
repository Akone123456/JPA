package com.fscut.jpa.repo;

import com.fscut.jpa.entity.UserInfo;
import com.fscut.jpa.entity.UserInfoID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuxinwei
 * @date 2022/9/14 9:28
 */
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {
}
