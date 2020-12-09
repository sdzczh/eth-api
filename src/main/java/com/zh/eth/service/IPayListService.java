package com.zh.eth.service;


import com.zh.eth.domain.PayList;

import java.util.List;

/**
 * 认购列表Service接口
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
public interface IPayListService 
{
    /**
     * 查询认购列表
     * 
     * @param id 认购列表ID
     * @return 认购列表
     */
    public PayList selectPayListById(Long id);

    /**
     * 查询认购列表列表
     * 
     * @param payList 认购列表
     * @return 认购列表集合
     */
    public List<PayList> selectPayListList(PayList payList);

    /**
     * 新增认购列表
     * 
     * @param payList 认购列表
     * @return 结果
     */
    public int insertPayList(PayList payList);

    /**
     * 修改认购列表
     * 
     * @param payList 认购列表
     * @return 结果
     */
    public int updatePayList(PayList payList);

    /**
     * 批量删除认购列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePayListByIds(String ids);

    /**
     * 删除认购列表信息
     * 
     * @param id 认购列表ID
     * @return 结果
     */
    public int deletePayListById(Long id);
}
