package com.zh.eth.mapper;


import com.zh.eth.domain.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 会员管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Mapper
public interface UsersMapper 
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
     * 删除会员管理
     * 
     * @param id 会员管理ID
     * @return 结果
     */
    public int deleteUsersById(Long id);

    /**
     * 批量删除会员管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUsersByIds(String[] ids);
}
