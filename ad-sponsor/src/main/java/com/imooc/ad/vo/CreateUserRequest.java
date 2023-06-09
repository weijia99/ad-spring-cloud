package com.imooc.ad.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String username;
    public boolean validate(){
        return StringUtils.isEmpty(username);
    }
}
