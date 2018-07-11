package com.example.demo.servletUploadify;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hello on 2018/7/3.
 */
public interface resourceListRepository extends JpaRepository<ResourceList, String> {
}
