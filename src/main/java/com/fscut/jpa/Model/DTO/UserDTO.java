package com.fscut.jpa.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNullApi;

/**
 * @author liuxinwei
 * @date 2022/9/2 19:17
 */
@Data
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String address;
}
