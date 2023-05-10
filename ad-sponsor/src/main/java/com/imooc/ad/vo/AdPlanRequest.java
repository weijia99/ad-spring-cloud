package com.imooc.ad.vo;


import com.sun.org.apache.xpath.internal.objects.XString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

//用于传送adplan的关注数据库字段
@Data
@AllArgsConstructor
@NoArgsConstructor
/*主要就是用来检验传来的构成这个序列类是不是合法*/
public class AdPlanRequest {
    private Long id;
    private  Long userId;
    private String planName;
    private String startDate;
    private String endDate;


    public boolean createValidate() {

        return userId != null
                && !StringUtils.isEmpty(planName)
                && !StringUtils.isEmpty(startDate)
                && !StringUtils.isEmpty(endDate);
    }

    public boolean updateValidate() {
        return id != null && userId != null;
    }

    public boolean deleteValidate() {
        return id != null && userId != null;
    }


}
