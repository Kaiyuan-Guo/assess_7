package com.hist.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gky
 * @date 2023/05/05
 * @apiNote
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private boolean isAdmin;
    private String email;
    private Long tel;
    private String realName;
    private String remarks;

}
