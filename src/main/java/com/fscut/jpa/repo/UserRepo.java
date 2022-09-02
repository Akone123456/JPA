
package com.fscut.jpa.repo;

import com.fscut.jpa.Model.DTO.UserDTO;
import com.fscut.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author liuxinwei
 * @date 2022/9/2 9:39
 */
public interface UserRepo extends PagingAndSortingRepository<User, Integer>, JpaRepository<User, Integer> {

    User findByIdAndAddress(int id, String address);

    @Query(value = "FROM User u WHERE u.name LIKE ?1%")
    List<User> findByNameLike(String name, Sort sort);

    @Query(value = "FROM User u WHERE u.name LIKE ?1%")
    List<User> findByNameLike(String name, Pageable pageable);

    @Query(value = "FROM User u WHERE u.name LIKE ?1%")
    Page<User> findByNameLikePage(String name, Pageable pageable);

    List<User> findTop3ByNameLike(@NonNull  String name);

    @Nullable
    List<User> findFirst4ByNameLike(String name);

    UserDTO findByIdAndName(int id,String name);


}
