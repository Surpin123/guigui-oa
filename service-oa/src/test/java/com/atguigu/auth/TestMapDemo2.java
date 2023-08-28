package com.atguigu.auth;


import com.atguigu.auth.service.SysRoleService;
import com.atguigu.auth.service.impl.SysRoleServiceImpl;
import com.atguigu.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMapDemo2 {

    @Autowired SysRoleService service;

    @Test
    public void getAll(){
        List<SysRole> list = service.list();
        list.forEach(System.out::println);
    }
}
