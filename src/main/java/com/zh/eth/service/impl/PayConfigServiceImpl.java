package com.zh.eth.service.impl;

import com.zh.eth.domain.PayConfig;
import com.zh.eth.mapper.PayConfigMapper;
import com.zh.eth.service.IPayConfigService;
import com.zh.eth.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 认购配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Service
public class PayConfigServiceImpl implements IPayConfigService
{
    @Autowired
    private PayConfigMapper payConfigMapper;

    /**
     * 查询认购配置
     * 
     * @param id 认购配置ID
     * @return 认购配置
     */
    @Override
    public PayConfig selectPayConfigById(Long id)
    {
        return payConfigMapper.selectPayConfigById(id);
    }

    /**
     * 查询认购配置列表
     * 
     * @param payConfig 认购配置
     * @return 认购配置
     */
    @Override
    public List<PayConfig> selectPayConfigList(PayConfig payConfig)
    {
        return payConfigMapper.selectPayConfigList(payConfig);
    }

    /**
     * 新增认购配置
     * 
     * @param payConfig 认购配置
     * @return 结果
     */
    @Override
    public int insertPayConfig(PayConfig payConfig)
    {
        return payConfigMapper.insertPayConfig(payConfig);
    }

    /**
     * 修改认购配置
     * 
     * @param payConfig 认购配置
     * @return 结果
     */
    @Override
    public int updatePayConfig(PayConfig payConfig)
    {
        return payConfigMapper.updatePayConfig(payConfig);
    }

    /**
     * 删除认购配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePayConfigByIds(String ids)
    {
        return payConfigMapper.deletePayConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除认购配置信息
     * 
     * @param id 认购配置ID
     * @return 结果
     */
    @Override
    public int deletePayConfigById(Long id)
    {
        return payConfigMapper.deletePayConfigById(id);
    }
}
