package com.imooc.ad.client;

import com.imooc.ad.client.vo.AdPlan;
import com.imooc.ad.client.vo.AdPlanGetRequest;
import com.imooc.ad.vo.CommonResponse;

import java.util.List;

public class SponsorClientHystrix implements SponsorClient{
    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
//        调度器，上面失败，这个才会实现
        return new CommonResponse<>(-1,"eureka-client-ad-sponsor error");
    }
}
