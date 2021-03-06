package com.sunda.passbook.dao;

import com.sunda.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 老蹄子 on 2018/8/17 上午10:50
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * 通过 id 获取商户对象
     * @param id 商户 id
     * @return {@link Merchants}
     * */
    Merchants findById(Integer id);

    /**
     * 根据商户名称获取商户对象
     * @param name 商户名称
     * @return {@link Merchants}
     * */
    Merchants findByName(String name);

    /**
     * 根据商户 ids 获取商户对象
     * @param ids 商户 ids
     * @return {@link Merchants}
     * */
    List<Merchants> findByIdIn(List<Integer> ids);


}
