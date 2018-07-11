package com.example.demo.servletUploadify;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by hello on 2018/7/1.
 */
@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {
    private String uploadPath = "D:\\服务器上传的文件\\"; // 上传文件的目录
    private File file;

    @Autowired resourceListRepository resourceListRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResourceList resourceList=new ResourceList();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String ownername=req.getParameter("owner");
        System.out.println(ownername);
        resourceList.setResourceOwner(ownername);//用户名称
        resourceList.setTime(String.valueOf(new Date()));
        String savePath=req.getContextPath();
        savePath=uploadPath+savePath;
        File f1 = new File(savePath);
        System.out.println(savePath);
        if (!f1.exists()) {
            f1.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf-8");
        List<FileItem> fileItemList=null;
        try {
            fileItemList=upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        Iterator<FileItem> fileItemIterator=fileItemList.iterator();
        String name="";
        String extName="";
        while(fileItemIterator.hasNext())
        {
            FileItem item= fileItemIterator.next();
            if(!item.isFormField())
            {
                name=item.getName();
                resourceList.setResourceName(name);
                long size=item.getSize();
                String type=item.getContentType();
              //  System.out.println(size + " " + type);
                if (name == null || name.trim().equals("")) {
                    continue;
                }
                if (name.lastIndexOf(".") >= 0) {
                    extName = name.substring(name.lastIndexOf("."));
                }
                do {
                    // 生成文件名：
                    name = UUID.randomUUID().toString();
                    file = new File(savePath + name + extName);
                    resourceList.setResourceId(name);
                    resourceList.setServerName(savePath+name+extName);//设置服务器端的名字。
                } while (file.exists());

                try {
                    item.write(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                resourceListRepository.save(resourceList);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
