package com.zh.eth.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 认购配置对象 pay_config
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Data
public class PayConfig
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 名称 */
    private String name;

    /** 币种 */
    private Long coinId;

    /** 交付币种 */
    private Long toCoin;

    /** 预设价格 */
    private Long proportion;

    /** 总量 */
    private BigDecimal total;

    /** 开关 */
    private Long onOff;

    /** 开始时间 */
    private String startTime;

    /** 结束时间 */
    private String endTime;

    /** 锁仓天数 */
    private Long numbersTime;

    /** 规则 */
    private String rules;

    /** 项目介绍 */
    private String infos;

}
