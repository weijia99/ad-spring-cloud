package com.imooc.ad.service.impl;

import com.imooc.ad.constant.Constants;
import com.imooc.ad.dao.AdUserRepository;
import com.imooc.ad.entity.AdUser;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IUserService;
import com.imooc.ad.utils.CommonUtils;
import com.imooc.ad.vo.CreateUserRequest;
import com.imooc.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//标记为service实体
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    private final AdUserRepository adUserRepository;
//    使用构造函数注入，不是用autowired

    public UserServiceImpl(AdUserRepository adUserRepository) {
        this.adUserRepository = adUserRepository;
    }

    /*开启事务*/
    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        if(!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdUser adUser = adUserRepository.findByUsername(request.getUsername());
        if(null!=adUser){
           throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
//         现在就是来进行创建新的用户
//        把传入的request封装成ad user
        AdUser user = adUserRepository.save(new AdUser(
                request.getUsername(), CommonUtils.md5(request.getUsername())
        ));
        return new CreateUserResponse(user.getId(),user.getUsername(),user.getToken(),
                user.getCreateTime(),user.getUpdateTime());
    }
}
