package com.fscut.jpa.entity;

import com.fscut.jpa.Enum.SexEnum;
import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.data.domain.PageRequest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liuxinwei
 * @date 2022/9/2 9:38
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "address")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private SexEnum sex;
    private Integer age;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<UserAddress> address;
}
