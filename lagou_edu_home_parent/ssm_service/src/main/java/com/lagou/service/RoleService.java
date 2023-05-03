package com.lagou.service;

import com.lagou.domain.Role;

import java.util.List;

public interface RoleService {

    //查询角色列表
    public List<Role> findAllRole(Role role);
}
