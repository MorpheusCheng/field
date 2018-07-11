package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.validation.UserRepository;
import com.example.demo.websecurity.SysRole;
import com.example.demo.websecurity.SysRoleRepository;
import com.example.demo.websecurity.SysUser;
import com.example.demo.websecurity.SysUserRepository;
import net.sf.json.JSONArray;
import org.jboss.jandex.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import com.example.demo.validation.email_verfication;

import javax.mail.MessagingException;
import java.util.*;

/**
 * Created by hello on 2018/3/14.
 */
@RestController
public class SearchController {
    @Autowired
    email_verfication email_verfication;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SysUserRepository sysUserRepository;

    @Autowired
    SysRoleRepository sysRoleRepository;

    public String random() {
        int a[] = new int[4];
        String string = " ";
        for (int i = 0; i < 4; i++) {
            a[i] = (int) (Math.random() * 10);
            string += a[i];
            //  System.out.println(a[i]+" ");
        }
        return string;
    }


    //注册提交的信息
    @RequestMapping("/register")
    public String Signupfunction(@RequestBody User user) throws MessagingException {
        System.out.println("进入注册");
        //  System.out.println("title:"+user.getTitle()+"username: "+user.getUsername()+"password: "+user.getPassword()+"email:"+user.getEmail());

        System.out.println(user.toString());
        //user表中保存用户
        userRepository.save(user);

//保存用户名和角色
        SysRole sysRole = new SysRole();
        SysUser sysUser = new SysUser();
        List<SysRole> sysRoles = new ArrayList<>();
        sysUser.setPassword(user.getPassword());
        sysUser.setUsername(user.getUsername());
        sysRole.setName(user.getTitle());
        sysUser.setRoles(sysRoles);
        sysRoles.add(sysRole);

        sysUserRepository.save(sysUser);
        sysRoleRepository.save(sysRole);

        String string = this.random();


        //设置要发送的随机数
        email_verfication.setString(string);
        email_verfication.setTo(user.getEmail());
        email_verfication.sendidentifycode();
        return string;
    }

    @PostMapping(value = "/rollback")
    public void delete() {
        sysRoleRepository.deleteSysRoleById();
        sysUserRepository.deleteSysUserById();
        String a = "删除成功";
        return;
    }

    @Autowired
    QuestionOperator questionOperator;

    @PostMapping("/saveQuestion")
    public String saveQueston(@RequestParam("own") String own, @RequestParam("question_keyword") String question_keyword, @RequestParam("question") String question) {
        Question question1 = new Question();
        question1.setOwn(own);
        question1.setQuestionkeyword(question_keyword);
        question1.setQuestion(question);
        Question que = questionOperator.save(question1);
        return String.valueOf(que.getQuestionid());
    }

    @Autowired
    MessageSave messageSave;

    @PostMapping("/saveMessage")
    public String saveMessage(@RequestParam(value = "own", required = false) String own, @RequestParam(value = "question_id", required = false) String question_id,
                              @RequestParam(value = "message", required = false) String message, @RequestParam(value = "time", required = false) String time) {
        Message message1 = new Message();
        message1.setOwn(own);
        message1.setQuestionid(Integer.parseInt(question_id));
        message1.setMessage(message);
        message1.setTime(time);
        messageSave.save(message1);
        return "";
    }

    @PostMapping("/allMessage")
    public String findAllMessage(@RequestParam("question_id") String question_id) {
        List<Message> list = messageSave.findByQuestionid(new Integer(question_id));
        JSONArray ja = JSONArray.fromObject(list);
        return ja.toString();
    }


    @Autowired
    saveClassInfo saveClassInfo;

    @PostMapping("/OpenClass")
    public String saveClassInfo(@RequestParam("className") String className,@RequestParam("classId") String classId){
        classInfo ci=new classInfo();
        ci.setClassName(className);
        ci.setClassId(classId);
        saveClassInfo.save(ci);
        return "ok";
    }

    @PostMapping("/deleteclass")
    public String deleteClass(@RequestParam("classId") String classId){
        classInfo ci = new classInfo();
        ci.setClassId(classId);
        saveClassInfo.delete(ci);
        return "delete OK!";
    }

    @Autowired
    ClassAndStudentsSave classAndStudentsSave;

    @GetMapping(value = "/findClassByStudent",produces = {"application/json;charset=UTF-8"})
    public List<Object[]> findAllClass(@RequestParam("studentsid") String studentsid){
        List<Object[]> classAndStutentsback = classAndStudentsSave.findByStutentsid(studentsid);
        //System.out.println(classAndStutentsback);
        return classAndStutentsback;
    }



  /*  @RequestMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam("email") String  email, @RequestParam("password") String password)
    {
        System.out.println(email+password);
        System.out.println(userRepository.findByEmail(email));
        User user=userRepository.findByEmail(email);
        System.out.println(user.getEmail()+user.getPassword());
        if(user!=null&&(user.getPassword().equals(password)))
        {
          return true;
        }
        return  false;
    }*/


}
