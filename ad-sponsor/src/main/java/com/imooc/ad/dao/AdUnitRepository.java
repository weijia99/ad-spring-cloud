package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdUnitRepository extends JpaRepository<AdUnit,Long> {

    AdUnit findByPlanIdAndUnitName(Long planId,String unitName);

    /**
     * 根据推广单元的状态查询 推广单元的集合
     * @param status
     * @return
     */
    List<AdUnit> findAllByUnitStatus(Integer status);
}
