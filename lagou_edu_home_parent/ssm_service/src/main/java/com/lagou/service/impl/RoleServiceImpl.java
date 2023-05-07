package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Menu;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuRelation;
import com.lagou.domain.RoleMenuVO;
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
    public List<String> findMenuByRoleId(int roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }

    @Override
    public void RoleContextMenu(RoleMenuVO roleMenuVo) {

        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        System.out.println(roleMenuVo.getMenuIdList());
        for (int mid : roleMenuVo.getMenuIdList()) {
            RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
            roleMenuRelation.setRoleId(roleMenuVo.getRoleId());
            roleMenuRelation.setMenuId(mid);
            roleMenuRelation.setCreatedTime(new Date());
            roleMenuRelation.setUpdatedTime(new Date());
            roleMenuRelation.setCreatedBy("system");
            roleMenuRelation.setUpdatedBy("system");
            roleMapper.RoleContextMenu(roleMenuRelation);
        }
    }

    @Override
    public void deleteRole(int id) {
        roleMapper.deleteRoleContextMenu(id);
        roleMapper.deleteRole(id);
    }
}
