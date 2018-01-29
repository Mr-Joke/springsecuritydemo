package com.example.demo.services;

import org.slf4j.Logger;
import com.example.demo.domain.SysUser;
import com.example.demo.repositories.SysUserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by 11014219 on 2018/1/29.
 */
public class CustomUserService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserService.class);
    @Autowired
    private SysUserRepository sysUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.findByUsername(username);
        if (sysUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        logger.info("var username:{}",username);
        logger.info("user's username:{}",sysUser.getUsername());
        logger.info("user's password:{}",sysUser.getPassword());
        return sysUser;
    }
}
