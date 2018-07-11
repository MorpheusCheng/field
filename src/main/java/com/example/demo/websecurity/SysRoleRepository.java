package com.example.demo.websecurity;

import org.hibernate.boot.archive.scan.spi.PackageInfoArchiveEntryHandler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hello on 2018/4/6.
 */
public interface SysRoleRepository extends JpaRepository<SysRole,Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from sys_role  where id =(select t.id from (SELECT MAX(id) AS id FROM sys_role) AS t)",nativeQuery = true)
    public void deleteSysRoleById();
}
