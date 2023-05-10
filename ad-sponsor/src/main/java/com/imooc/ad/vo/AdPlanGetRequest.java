package com.imooc.ad.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanGetRequest {
//    这个请求是传送以下系列的id，用于批量处理的
//    一个请求使用一个vo来进行序列化传输
    private Long userId;
    private List<Long> Ids;
    public  boolean validate(){
        return userId!=null && !CollectionUtils.isEmpty(Ids);
    }

}
