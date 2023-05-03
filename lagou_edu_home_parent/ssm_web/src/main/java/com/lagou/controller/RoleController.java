package com.lagou.controller;

import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(Role role){
        List<Role> roleList = roleService.findAllRole(role);
        return new ResponseResult(true,200,"success",roleList);
    }

}
