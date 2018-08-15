package com.sunda.merchants.dao;

import com.sunda.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 老蹄子 on 2018/8/15 下午9:08
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    Merchants findById(Integer id);

    Merchants findByName(String name);
}
