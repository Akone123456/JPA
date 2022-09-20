package com.fscut.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author liuxinwei
 * @date 2022/9/13 16:51
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_dog")
@Builder
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) NOT NULL COMMENT '主键' ")
    private Integer id;

    @Column(columnDefinition = "varchar(30) DEFAULT '' COMMENT '宠物名'")
    private String name;

    @Column(columnDefinition = "int(11) DEFAULT NULL COMMENT '年龄'")
    private Integer age;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '种类'")
    private String type;
}
