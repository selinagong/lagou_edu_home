package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.UserVO;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVO userVO){
        PageInfo user = userService.findAllUserByPage(userVO);
        return new ResponseResult(true,200,"success", user);
    }

    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(int id, String status){
        userService.updateUserStatus(id, status);
        return new ResponseResult(true,200,"success",status);
    }
}
