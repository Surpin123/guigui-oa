package com.atguigu.auth;


import com.atguigu.auth.mapper.SysRoleMapper;
import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMapDemo1 {

    // 注入
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void getAll() {

        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        sysRoles.forEach(System.out::println);
    }

    @Test
    public void add() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("Role");
        sysRole.setDescription("3");
        int insert = sysRoleMapper.insert(sysRole);
        System.out.println(insert);
    }

    @Test
    public void update() {
        SysRole sysRole = new SysRole();
        sysRole.setId(11L);
        sysRole.setRoleName("atguigu角色管理员");

        int i = sysRoleMapper.updateById(sysRole);
        System.out.println(i);
    }

    @Test
    public void deleteId() {
        int i = sysRoleMapper.deleteById(11L);
        System.out.println(i);
    }

    @Test
    public void testQuery(){
        QueryWrapper<SysRole> sysRoleQueryWrapper = new QueryWrapper<>();
        sysRoleQueryWrapper.eq("role_name","总经理");
        List<SysRole> sysRoles = sysRoleMapper.selectList(sysRoleQueryWrapper);
        sysRoles.forEach(System.out::println);
    }
    @Test
    public void testQuery1(){

        LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRole::getRoleName,"总经理");  // Lambda表达式的写法
        List list = sysRoleMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }
}
