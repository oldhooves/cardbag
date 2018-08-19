package com.sunda.passbook.vo;

import com.sunda.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 老蹄子 on 2018/8/19 下午9:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplateInfo {

    /** 优惠券模板 */
    private PassTemplate passTemplate;

    /** 优惠券对应的商户 */
    private Merchants merchants;
}
