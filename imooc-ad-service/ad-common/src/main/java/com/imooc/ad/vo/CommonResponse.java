package com.imooc.ad.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//统一返回实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> implements Serializable {
//    三个状态，一个code，一个msg，一个data
//    实现序列化
    private Integer code;
    private String msg;
    private T data;

    public CommonResponse(Integer code,String msg){
        this.msg=msg;
        this.code=code;
    }
}
