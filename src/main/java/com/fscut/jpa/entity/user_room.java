package com.fscut.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liuxinwei
 * @date 2022/9/15 9:15
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class user_room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createTime;
    private Date updateTime;
    @ManyToOne
    private User user;
    @ManyToOne
    private Room room;
}
