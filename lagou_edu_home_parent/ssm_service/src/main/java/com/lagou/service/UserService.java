package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;


public interface UserService {

    //查询所有用户
    public PageInfo<User> findAllUserByPage(UserVO userVO);

    //修改用户状态
    public void updateUserStatus(int id, String status);
}
