package com.example.demo.servletDownload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by hello on 2018/7/3.
 */
@WebServlet("/downloadFile")
public class DownloadFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/octet-stream");
        String fileName=req.getParameter("fileName");
        File file=new File(fileName);
        String name[]=fileName.split("\\\\");
        String temp=name[name.length-1];
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition","attachment;filename=" + temp);
        resp.setContentLength((int) file.length());
        FileInputStream fis=null;
        fis=new FileInputStream(file);
        byte[] buffer=new byte[1024*1024*8*50];
        int count=0;
        while ((count=fis.read(buffer))>0)
        {
            resp.getOutputStream().write(buffer,0,count);
        }
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
