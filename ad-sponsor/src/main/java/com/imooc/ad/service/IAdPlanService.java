package com.imooc.ad.service;


import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.AdPlanGetRequest;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;

import java.util.List;

public interface IAdPlanService {
//crud的接口

    AdPlanResponse createAdPlan(AdPlanRequest request)throws AdException;
//    定义接口功能
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request)throws AdException;

    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
