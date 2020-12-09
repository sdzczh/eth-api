package com.zh.eth.service;


import com.zh.eth.domain.Users;

import java.util.List;

/**
 * 会员管理Service接口
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
public interface IUsersService 
{
    /**
     * 查询会员管理
     * 
     * @param id 会员管理ID
     * @return 会员管理
     */
    public Users selectUsersById(Long id);

    /**
     * 查询会员管理列表
     * 
     * @param users 会员管理
     * @return 会员管理集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增会员管理
     * 
     * @param users 会员管理
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改会员管理
     * 
     * @param users 会员管理
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 批量删除会员管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUsersByIds(String ids);

    /**
     * 删除会员管理信息
     * 
     * @param id 会员管理ID
     * @return 结果
     */
    public int deleteUsersById(Long id);

    Users userLogin(Users users);

    Users selectByToken(String token);

    Users selectByPhone(String phone);
}
