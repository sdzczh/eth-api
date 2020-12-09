package com.zh.eth.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 认购列表对象 pay_list
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Data
public class PayList
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    private Long userId;

    /** 币种 */
    private Long coinId;

    /** 用户地址 */
    private String address;

    /** 状态 0未处理 1成功 2驳回 */
    private Integer status;

    /** 认购期数 */
    private Long pId;

    /** 认购数量 */
    private BigDecimal amount;

    /** 交付币种 */
    private Long toCoin;

    /** 交付数量 */
    private BigDecimal toAmount;

    private String createTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCoinId(Long coinId) 
    {
        this.coinId = coinId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getCoinId()
    {
        return coinId;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setpId(Long pId) 
    {
        this.pId = pId;
    }

    public Long getpId() 
    {
        return pId;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setToCoin(Long toCoin) 
    {
        this.toCoin = toCoin;
    }

    public Long getToCoin() 
    {
        return toCoin;
    }
    public void setToAmount(BigDecimal toAmount) 
    {
        this.toAmount = toAmount;
    }

    public BigDecimal getToAmount() 
    {
        return toAmount;
    }

}
