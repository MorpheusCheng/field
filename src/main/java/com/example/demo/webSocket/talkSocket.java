package com.example.demo.webSocket;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2018/4/12.
 */

@ServerEndpoint("/talk/{param}")
@Component
public class talkSocket {
    private static List<Session> sessions = new ArrayList<Session>();
    private static List<String> usernames = new ArrayList<String>();
    private String username;
    private static Map<String, Session> map = new HashMap<String, Session>();

    @OnOpen
    public void open(Session session, @PathParam(value = "param") String param) throws IOException {
        username = param;
        usernames.add(param);
        sessions.add(session);
        map.put(param, session);
        //  String msg = "欢迎" + username + "登陆";
        //  Message message = new Message();
        //  message.setWelcome(msg);
        // message.setUsernames(usernames);
        //  broadcast(sessions, message.toJson());
    }

    public void broadcast(Session session,List<Session> sessions, String msg) throws IOException {
        for (Session session1 : sessions) {
            if(!session1.getId().equals(session.getId()))
            session1.getBasicRemote().sendText(msg);
        }
    }

    /*Gson gson = new Gson();*/

    @OnMessage
    public void message(Session session, String json) throws IOException {
        /*ContentVo vo = gson.fromJson(json, ContentVo.class);*/
        broadcast(session,sessions,json);
        // broadcast(sessions,json);
      /*  if(vo.getType())*/
      /*  Message message = new Message();
        String to = vo.getTo();
        Session session_to = map.get(to);
        message.setContent(this.username, "<font color='red' >私聊：" + vo.getMsg() + "</font>");
        session_to.getBasicRemote().sendText(message.toJson());
        session.getBasicRemote().sendText(message.toJson());*/
    }

    @OnClose
    public void close(Session session) throws IOException {

        sessions.remove(session);
        /* sessions.remove(session);
        usernames.remove(this.username);
        map.remove(this.username);
        Message message = new Message();
        String msg = this.username + "退出聊天室";
        message.setWelcome(msg);
        message.setUsernames(usernames);
        broadcast(this.sessions, message.toJson());*/
    }
}
