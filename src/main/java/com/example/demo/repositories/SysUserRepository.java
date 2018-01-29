package com.example.demo.repositories;

import com.example.demo.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 11014219 on 2018/1/29.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String username);
}
