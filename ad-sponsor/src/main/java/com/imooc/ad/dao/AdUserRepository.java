package com.imooc.ad.dao;


import com.imooc.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

//经典的dao层，进行设置的接口实现jpa，这样可以操作
//第一个是要查询的元素，第二个是主键属性long
public interface AdUserRepository extends JpaRepository<AdUser,Long> {
//    默认已近实现了普通的增删改查
    AdUser findByUsername(String username);

}
