package com.example.demo.servletUploadify;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hello on 2018/7/3.
 */
@Entity
public class ResourceList {
    @Id
    String resourceId;
    String serverName;
    String resourceName;
    String resourceOwner;
    String classId;
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getResourceOwner() {
        return resourceOwner;
    }

    public void setResourceOwner(String resourceOwner) {
        this.resourceOwner = resourceOwner;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
