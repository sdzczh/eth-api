package com.zh.eth.service.impl;

import com.zh.eth.domain.Coin;
import com.zh.eth.mapper.CoinMapper;
import com.zh.eth.service.ICoinService;
import com.zh.eth.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 币种管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Service
public class CoinServiceImpl implements ICoinService
{
    @Autowired
    private CoinMapper coinMapper;

    /**
     * 查询币种管理
     * 
     * @param id 币种管理ID
     * @return 币种管理
     */
    @Override
    public Coin selectCoinById(Long id)
    {
        return coinMapper.selectCoinById(id);
    }

    /**
     * 查询币种管理列表
     * 
     * @param coin 币种管理
     * @return 币种管理
     */
    @Override
    public List<Coin> selectCoinList(Coin coin)
    {
        return coinMapper.selectCoinList(coin);
    }

    /**
     * 新增币种管理
     * 
     * @param coin 币种管理
     * @return 结果
     */
    @Override
    public int insertCoin(Coin coin)
    {
        return coinMapper.insertCoin(coin);
    }

    /**
     * 修改币种管理
     * 
     * @param coin 币种管理
     * @return 结果
     */
    @Override
    public int updateCoin(Coin coin)
    {
        return coinMapper.updateCoin(coin);
    }

    /**
     * 删除币种管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCoinByIds(String ids)
    {
        return coinMapper.deleteCoinByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除币种管理信息
     * 
     * @param id 币种管理ID
     * @return 结果
     */
    @Override
    public int deleteCoinById(Long id)
    {
        return coinMapper.deleteCoinById(id);
    }
}
