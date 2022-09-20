package com.fscut.jpa.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author liuxinwei
 * @date 2022/9/14 16:56
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "user")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
