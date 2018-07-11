package com.example.demo.webSocket;

/**
 * Created by hello on 2018/4/11.
 */

import java.util.List;
import com.google.gson.Gson;


/**
 * Created by hello on 2018/4/11.
 */
public class Message {
    private String welcome;
    private List<String> usernames;
    private String content;
    private static Gson gson=new Gson();
   /* public static SimpleDateFormat simpleDateFormat=new SimpleDateFormat
            ("HH:mm:ss yyyy-MM-dd ");*/
    public List<String> getUsernames() {
        return usernames;
    }

    public String getContent() {
        return content;
    }

    public static Gson getGson() {
        return gson;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContent( String name,String msg) {
        this.content = name+":  "+msg+"<br/>";
    }

    public static void setGson(Gson gson) {
        Message.gson = gson;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String toJson(){
        return gson.toJson(this);
    }
}

