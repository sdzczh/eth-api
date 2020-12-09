package com.zh.eth.service;


import com.zh.eth.domain.PayConfig;

import java.util.List;

/**
 * 认购配置Service接口
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
public interface IPayConfigService 
{
    /**
     * 查询认购配置
     * 
     * @param id 认购配置ID
     * @return 认购配置
     */
    public PayConfig selectPayConfigById(Long id);

    /**
     * 查询认购配置列表
     * 
     * @param payConfig 认购配置
     * @return 认购配置集合
     */
    public List<PayConfig> selectPayConfigList(PayConfig payConfig);

    /**
     * 新增认购配置
     * 
     * @param payConfig 认购配置
     * @return 结果
     */
    public int insertPayConfig(PayConfig payConfig);

    /**
     * 修改认购配置
     * 
     * @param payConfig 认购配置
     * @return 结果
     */
    public int updatePayConfig(PayConfig payConfig);

    /**
     * 批量删除认购配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePayConfigByIds(String ids);

    /**
     * 删除认购配置信息
     * 
     * @param id 认购配置ID
     * @return 结果
     */
    public int deletePayConfigById(Long id);
}
