package com.sunda.passbook.service;

import com.sunda.passbook.vo.PassTemplate;

/**
 * Created by 老蹄子 on 2018/8/19 下午7:13
 */
public interface IHBasePassService {

    /**
     * 将 PassTemplate 写入 HBase
     * @param passTemplate {@link PassTemplate}
     * @return true/false
     * */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);
}
