package com.imooc.ad.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.impl.CreativeService;
import com.imooc.ad.vo.CreativeResponse;
import com.imooc.ad.vo.CreativeReuqest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CreativeOPController {
    private final CreativeService creativeService;

    public CreativeOPController(CreativeService creativeService) {
        this.creativeService = creativeService;
    }
    @PostMapping("/create/creative")
    public CreativeResponse createCreative(@RequestBody CreativeReuqest reuqest) throws AdException {
        log.info("ad-sponsor: createCreative -> {}", JSON.toJSONString(reuqest));
        return creativeService.creatCreative(reuqest);
    }
}
