package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(Role role){
        if (role.getId() == null){
            roleService.saveRole(role);
        }else {
            roleService.updateRole(role);
        }
        return new ResponseResult(true,200,"success",null);
    }

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> menuList = roleService.findAllMenu();
        HashMap<String, Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);
        return new ResponseResult(true,200,"success",map);
    }


    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(int roleId){
        List<String> menuRelations = roleService.findMenuByRoleId(roleId);
        return new ResponseResult(true,200,"success",menuRelations);
    }

    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVO roleMenuVO){
        roleService.RoleContextMenu(roleMenuVO);
        return new ResponseResult(true,200,"success",null);
    }

    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(int id){
        roleService.deleteRole(id);
        return new ResponseResult(true,200,"success",null);
    }
}
