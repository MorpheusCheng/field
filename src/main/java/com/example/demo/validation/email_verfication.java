package com.example.demo.validation;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by hello on 2018/3/23.
 */

@Service
public class email_verfication {
    String string;
    final  String server = "smtp.163.com";
    final  String username = "18792962699@163.com";
    final String password = "sxuyan1521949504";

    final String from="18792962699@163.com";
    String to="";
    final  String host = "smtp.163.com";

    public void  sendidentifycode() throws MessagingException {


        //获取系统属性
        Properties properties=System.getProperties();

        //设置邮件服务器
        properties.put("mail.smtp.ssl.enable","true");

        properties.setProperty("mail.smtp.host",host);

        properties.put("mail.smtp.auth","true");

        properties.setProperty("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(properties);

        MimeMessage message = new MimeMessage(session);

        // Set From: 头部头字段
        message.setFrom(new InternetAddress(from));

        // Set To: 头部头字段
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to));

        // Set Subject: 头部头字段
        message.setSubject("验证码：");

     /*   int a[]=new int[4];
        String string=" ";
        for(int i=0;i<4;i++)
        {
            a[i]= (int)(Math.random()*10);
            string+=a[i]+" ";
            //  System.out.println(a[i]+" ");
        }*/
        // 设置消息体
        // System.out.println(string);
        message.setText(string);
        // 发送消息
        Transport transport = session.getTransport();
        transport.connect(server, username, password);
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
//   Transport.send(message);
        System.out.println("Sent message successfully....from Field.com");
       // return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
