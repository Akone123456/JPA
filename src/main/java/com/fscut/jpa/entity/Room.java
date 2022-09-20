package com.fscut.jpa.entity;

import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.List;

/**
 * @author liuxinwei
 * @date 2022/9/14 17:47
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "room")
    private List<user_room> roomList;

    private String title;

    @ManyToMany
    @JoinTable(name = "user_room",
    joinColumns = @JoinColumn(name = "room_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
