package com.lagou.dao;

import com.lagou.domain.Role;

import java.util.List;

public interface RoleMapper {

    //查询角色列表
    public List<Role> findAllRole(Role role);
}
