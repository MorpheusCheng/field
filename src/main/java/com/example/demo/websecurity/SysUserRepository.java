package com.example.demo.websecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hello on 2018/4/2.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    public SysUser findByUsername(String username);
    @Transactional
    @Modifying
    @Query(value = "delete from sys_user  where id =( select t.id from (SELECT MAX(id) as id FROM sys_user) as t)",nativeQuery = true)
    public void deleteSysUserById();
}
