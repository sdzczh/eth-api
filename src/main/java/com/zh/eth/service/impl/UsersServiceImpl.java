package com.zh.eth.service.impl;

import com.zh.eth.domain.Users;
import com.zh.eth.mapper.UsersMapper;
import com.zh.eth.service.IUsersService;
import com.zh.eth.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Service
public class UsersServiceImpl implements IUsersService
{
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询会员管理
     * 
     * @param id 会员管理ID
     * @return 会员管理
     */
    @Override
    public Users selectUsersById(Long id)
    {
        return usersMapper.selectUsersById(id);
    }

    /**
     * 查询会员管理列表
     * 
     * @param users 会员管理
     * @return 会员管理
     */
    @Override
    public List<Users> selectUsersList(Users users)
    {
        return usersMapper.selectUsersList(users);
    }

    /**
     * 新增会员管理
     * 
     * @param users 会员管理
     * @return 结果
     */
    @Override
    public int insertUsers(Users users)
    {
        users.setCreateTime(com.ruoyi.common.utils.DateUtils.getTime());
        return usersMapper.insertUsers(users);
    }

    /**
     * 修改会员管理
     * 
     * @param users 会员管理
     * @return 结果
     */
    @Override
    public int updateUsers(Users users)
    {
        return usersMapper.updateUsers(users);
    }

    /**
     * 删除会员管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUsersByIds(String ids)
    {
        return usersMapper.deleteUsersByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员管理信息
     * 
     * @param id 会员管理ID
     * @return 结果
     */
    @Override
    public int deleteUsersById(Long id)
    {
        return usersMapper.deleteUsersById(id);
    }

    @Override
    public Users userLogin(Users users) {
        List<Users> users1 = usersMapper.selectUsersList(users);
        return users1 == null || users1.size() == 0 ? null : users1.get(0);
    }

    @Override
    public Users selectByToken(String token) {
        Users users = new Users();
        users.setToken(token);
        List<Users> users1 = usersMapper.selectUsersList(users);
        return users1 == null || users1.size() == 0 ? null : users1.get(0);
    }

    @Override
    public Users selectByPhone(String phone) {
        Users users = new Users();
        users.setPhone(phone);
        List<Users> users1 = usersMapper.selectUsersList(users);
        return users1 == null || users1.size() == 0 ? null : users1.get(0);
    }
}
