package com.fscut.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author liuxinwei
 * @date 2022/9/13 17:27
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_cat",
        uniqueConstraints = {@UniqueConstraint(name = "unique_age",columnNames = "age"),
        @UniqueConstraint(name = "unique_name",columnNames = {"name","age"})},
        indexes = {@Index(name = "nameIndex",columnList = "name")})
@Access(value = AccessType.FIELD)
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) NOT NULL COMMENT '主键' ")
    private Integer id;

    @Column(columnDefinition = "varchar(30) DEFAULT '' COMMENT '宠物名'")
    private String name;

    @Column(columnDefinition = "int(11) DEFAULT NULL COMMENT '年龄'")
    private Integer age;
}
