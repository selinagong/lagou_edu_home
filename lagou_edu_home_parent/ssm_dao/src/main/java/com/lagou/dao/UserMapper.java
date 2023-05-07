package com.lagou.dao;

import com.lagou.domain.User;
import com.lagou.domain.UserVO;

import java.util.List;

public interface UserMapper {

    //查询所有用户
    public List<User> findAllUserByPage(UserVO userVO);

    //修改用户状态
    public void updateUserStatus(User user);

    //用户登陆
    public User login(User user);


    // 分配角色(回显) findUserRoleById

    // 分配角色权限 userContextRole

    // 获取用户拥有的菜单权限 getUserPermissions
}
