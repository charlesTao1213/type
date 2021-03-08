package dorm.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-03-01 20:16:57
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 685438022857808245L;

    private String username;
    private String password;
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }


}