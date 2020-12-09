package com.zh.eth.mapper;


import com.zh.eth.domain.Coin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 币种管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Mapper
public interface CoinMapper 
{
    /**
     * 查询币种管理
     * 
     * @param id 币种管理ID
     * @return 币种管理
     */
    public Coin selectCoinById(Long id);

    /**
     * 查询币种管理列表
     * 
     * @param coin 币种管理
     * @return 币种管理集合
     */
    public List<Coin> selectCoinList(Coin coin);

    /**
     * 新增币种管理
     * 
     * @param coin 币种管理
     * @return 结果
     */
    public int insertCoin(Coin coin);

    /**
     * 修改币种管理
     * 
     * @param coin 币种管理
     * @return 结果
     */
    public int updateCoin(Coin coin);

    /**
     * 删除币种管理
     * 
     * @param id 币种管理ID
     * @return 结果
     */
    public int deleteCoinById(Long id);

    /**
     * 批量删除币种管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCoinByIds(String[] ids);
}
