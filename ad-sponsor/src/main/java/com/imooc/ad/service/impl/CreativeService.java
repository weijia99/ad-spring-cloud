package com.imooc.ad.service.impl;

import com.imooc.ad.dao.CreativeRepository;
import com.imooc.ad.entity.Creative;
import com.imooc.ad.service.ICreativeService;
import com.imooc.ad.vo.CreativeResponse;
import com.imooc.ad.vo.CreativeReuqest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class CreativeService implements ICreativeService {

    private final CreativeRepository creativeRepository;

    public CreativeService(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    @Transactional
    public CreativeResponse creatCreative(CreativeReuqest reuqest) {
        Creative creative = creativeRepository.save(
                reuqest.convertToEntity()
        );
        return new CreativeResponse(creative.getId(),creative.getName());
    }
}
