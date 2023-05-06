package com.lagou.service;

import com.lagou.domain.Menu;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuRelation;

import java.util.List;

public interface RoleService {

    //查询角色列表
    public List<Role> findAllRole(Role role);

    //新增角色
    public void saveRole(Role role);

    //修改角色
    public void updateRole(Role role);

    //查询所有菜单
    public List<Menu> findAllMenu();

    //根据角色ID查询关联菜单ID
    public List<Integer> findMenuByRoleId(int roleId);
}
