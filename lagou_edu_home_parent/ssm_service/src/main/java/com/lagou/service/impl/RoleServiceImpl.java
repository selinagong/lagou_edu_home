package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Menu;
import com.lagou.domain.Role;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    @Override
    public void saveRole(Role role) {
        Date date = new Date();
        role.setCreatedTime(date);
        role.setUpdatedTime(date);

        roleMapper.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        Date date = new Date();
        role.setUpdatedTime(date);

        roleMapper.updateRole(role);
    }

    @Override
    public List<Menu> findAllMenu() {
        return roleMapper.findAllMenu();
    }

    @Override
    public List<Integer> findMenuByRoleId(int roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }
}
