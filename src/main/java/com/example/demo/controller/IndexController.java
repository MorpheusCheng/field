package com.example.demo.controller;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionOperator;
import com.example.demo.servletUploadify.ResourceList;
import com.example.demo.servletUploadify.resourceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;


/**
 * Created by hello on 2018/3/14.
 */
@Controller
public class IndexController {

    @GetMapping("/signup")
    public String signup() {
        return "/signup";
    }

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @GetMapping("/setclass")
    public String setClass(Model model){
        model.addAttribute("classList");
        return "/SetClass";
    }

    @Autowired
    QuestionOperator questionOperator;


    @RequestMapping(value = {"/", "/talk"}, method = RequestMethod.GET)
    public String get(Model model) {
        List<Question> list = questionOperator.findAll();
        model.addAttribute("questionList", list);
        return "/talk";
    }

    @GetMapping("/ask")
    public String askGet(Model model) {
        List<Question> list = questionOperator.findAll();
        model.addAttribute("questionList", list);
        return "/ask_question";
    }

    @Autowired
    resourceListRepository resourceListRepository;


    @GetMapping("/resource")
    public String getResource(Model model){
        List<ResourceList> lists=resourceListRepository.findAll();
        model.addAttribute("resourceList",lists);
        return "/resource";
    }

  /*  @GetMapping("/uploadify")
    public void uploadify(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, FileUploadException {
        Map map = new HashMap();
        request.setCharacterEncoding("utf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        String path = request.getRealPath("/file");
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024 * 1024*1024);
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
        for (FileItem item : list) {
            String name = item.getName() ;
            System.out.println("获得的名字："+name);
            String fileSuffix  = name.substring(name.lastIndexOf(".")+1,name.length());
            //file的后缀
            String oldName = name.replaceAll("." + fileSuffix,"");
            String fileName = String.valueOf(new Date().getTime());//生成唯一的文件标识
            String newName = fileName + "." + fileSuffix;
            OutputStream out = new FileOutputStream(new File(path,newName));
            InputStream in = item.getInputStream() ;
            in.close();
            out.close();
        }
    }*/
}
