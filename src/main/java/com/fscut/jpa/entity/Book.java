package com.fscut.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author liuxinwei
 * @date 2022/9/13 16:45
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) NOT NULL COMMENT '主键' ")
    private Integer id;

    @Column(columnDefinition = "varchar(30) DEFAULT '' COMMENT '书名'")
    private String bookName;

    @Column(columnDefinition = "int(11) DEFAULT 0  COMMENT '数量'")
    private Integer amount;
}
