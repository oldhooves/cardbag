package com.sunda.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 老蹄子 on 2018/8/15 下午9:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

    /** 商户 id: 创建失败则为 -1 */
    private Integer id;
}
