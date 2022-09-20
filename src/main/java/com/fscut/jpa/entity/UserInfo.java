package com.fscut.jpa.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author liuxinwei
 * @date 2022/9/14 9:24
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "user")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer ages;
    private String telephone;
    @OneToOne(cascade = {CascadeType.PERSIST},orphanRemoval = true)
    private User user;
}
