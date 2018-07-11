package com.example.demo.websecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by hello on 2018/4/2.
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser=sysUserRepository.findByUsername(username);
        System.out.println(sysUser.getPassword());
        System.out.println(username);
        List<SysRole> rolesList=sysUser.getRoles();
        for(SysRole role:rolesList)
        {
            System.out.println(role.getName());
        }
           if(sysUser==null)
           {
               throw new UsernameNotFoundException("用户名不存在");
           }
        return sysUser;
    }
}
