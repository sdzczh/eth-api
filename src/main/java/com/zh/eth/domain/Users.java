package com.zh.eth.domain;

import lombok.Data;

/**
 * 会员管理对象 users
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Data
public class Users
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 手机号 */
    private String phone;

    /** 密码 */
    private String password;

    /** token */
    private String token;

    /** uid */
    private Long uuid;

    /** 推荐人id */
    private Long referId;

    private String createTime;
}
