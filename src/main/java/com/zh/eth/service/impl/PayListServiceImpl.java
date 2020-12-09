package com.zh.eth.service.impl;

import com.zh.eth.domain.PayList;
import com.zh.eth.mapper.PayListMapper;
import com.zh.eth.service.IPayListService;
import com.zh.eth.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 认购列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Service
public class PayListServiceImpl implements IPayListService
{
    @Autowired
    private PayListMapper payListMapper;

    /**
     * 查询认购列表
     * 
     * @param id 认购列表ID
     * @return 认购列表
     */
    @Override
    public PayList selectPayListById(Long id)
    {
        return payListMapper.selectPayListById(id);
    }

    /**
     * 查询认购列表列表
     * 
     * @param payList 认购列表
     * @return 认购列表
     */
    @Override
    public List<PayList> selectPayListList(PayList payList)
    {
        return payListMapper.selectPayListList(payList);
    }

    /**
     * 新增认购列表
     * 
     * @param payList 认购列表
     * @return 结果
     */
    @Override
    public int insertPayList(PayList payList)
    {
        payList.setCreateTime(com.ruoyi.common.utils.DateUtils.getTime());
        return payListMapper.insertPayList(payList);
    }

    /**
     * 修改认购列表
     * 
     * @param payList 认购列表
     * @return 结果
     */
    @Override
    public int updatePayList(PayList payList)
    {
        return payListMapper.updatePayList(payList);
    }

    /**
     * 删除认购列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePayListByIds(String ids)
    {
        return payListMapper.deletePayListByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除认购列表信息
     * 
     * @param id 认购列表ID
     * @return 结果
     */
    @Override
    public int deletePayListById(Long id)
    {
        return payListMapper.deletePayListById(id);
    }
}
