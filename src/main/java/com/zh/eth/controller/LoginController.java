package com.zh.eth.controller;

import com.zh.eth.domain.Users;
import com.zh.eth.dto.AjaxResult;
import com.zh.eth.service.IUsersService;
import com.zh.eth.utils.StringUtils;
import com.zh.eth.utils.TokenProccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private IUsersService usersService;

    @PostMapping("")
    @ResponseBody
    public AjaxResult list(Users users)
    {
        if(StringUtils.isEmpty(users.getPhone()) || StringUtils.isEmpty(users.getPassword())){
            return AjaxResult.error("请把信息填写完整");
        }
        Users users1 = usersService.userLogin(users);
        if(users1 == null){
            return AjaxResult.error("账号或密码错误");
        }else {
            users1.setToken(TokenProccessor.makeToken());
            usersService.updateUsers(users1);
            return AjaxResult.success(users1.getToken());
        }
    }
    @PostMapping("/register")
    @ResponseBody
    public AjaxResult register(Users users)
    {
        if(StringUtils.isEmpty(users.getPhone()) || StringUtils.isEmpty(users.getPassword())){
            return AjaxResult.error("请把信息填写完整");
        }
        Users users1 = usersService.selectByPhone(users.getPhone());
        if(users1 != null){
            return AjaxResult.error("该账号已存在");
        }else {
            users.setCreateTime(com.ruoyi.common.utils.DateUtils.getTime());
            users.setReferId((long) 0);
            users.setUuid((long) 0);
            usersService.insertUsers(users);
            return AjaxResult.success();
        }
    }
    @PostMapping("/updatePwd")
    @ResponseBody
    public AjaxResult updatePwd(HttpServletRequest request, Users user, String newPwd)
    {
        Object token1 = request.getHeader("token");
        String token = token1 == null ? "" : token1.toString();
        if(StringUtils.isNotEmpty(token)){
            Users users = usersService.selectByToken(token);
            if(users == null){
                return AjaxResult.error("用户不存在，请重新登录");
            }
            if(!users.getPassword().equals(user.getPassword())){
                return AjaxResult.error("原密码校验失败！");
            }
            users.setPassword(newPwd);
            usersService.updateUsers(users);
            return AjaxResult.success();
        }else {
            return AjaxResult.error("用户登录信息失效，请重新登录");
        }
    }

    @PostMapping("/exit")
    @ResponseBody
    public AjaxResult exit(HttpServletRequest request){
        Object token1 = request.getHeader("token");
        String token = token1 == null ? "" : token1.toString();
        if(StringUtils.isNotEmpty(token)){
            Users users = usersService.selectByToken(token);
            if(users == null){
                return AjaxResult.success();
            }
            users.setToken(" ");
            usersService.updateUsers(users);
            return AjaxResult.success();
        }else {
            return AjaxResult.success();
        }
    }

}
