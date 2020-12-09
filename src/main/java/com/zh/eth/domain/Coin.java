package com.zh.eth.domain;

import lombok.Data;

/**
 * 币种管理对象 coin
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Data
public class Coin
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 币种名称 */
    private String coinName;


}
