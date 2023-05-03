package com.lagou.dao;

import com.lagou.domain.User;
import com.lagou.domain.UserVO;

import java.util.List;

public interface UserMapper {

    //查询所有用户
    public List<User> findAllUserByPage(UserVO userVO);

    //修改用户状态
    public void updateUserStatus(User user);
}
