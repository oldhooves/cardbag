package com.sunda.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by 老蹄子 on 2018/8/19 下午9:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    /** 用户 id */
    private Long userId;

    /** 优惠券模板信息 */
    private List<PassTemplateInfo> passTemplateInfos;
}
