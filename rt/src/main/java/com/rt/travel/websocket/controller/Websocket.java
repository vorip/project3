package com.rt.travel.websocket.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ServerEndpoint("/websocket")
public class Websocket {
   private List<Session> sessionList;
//   private static final Logger LOGGER = LoggerFactory.getLogger(Websocket.class);
   private static final Map<String, List<Session>> ROOMLIST = new HashMap<String, List<Session>>();
   private static String[] roomNums;
   private String[] msgArr;
   
   public Websocket() {
   }
   // 웹소켓 객체가 생성 되고 onopen호출 시 자동으로 session생성하는거같음. 생성된 session정보를 파라미터로 받아서 list에
   // 추가.

   @RequestMapping("roomNumsSetting")
   public String roomCreate(String roomNums,HttpSession session) {
      if (!"".equals(roomNums.trim()))
         this.roomNums = roomNums.trim().split(",");
      return "ajax/ajaxResult";
   }

   @OnOpen
   public void open(Session session) {
      for (int i = 0; i < roomNums.length; i++) {
         if (ROOMLIST.containsKey(this.roomNums[i])) {
            ROOMLIST.get(this.roomNums[i]).add(session);
            // 콘솔창에 INFO : ~나오게하는거
         } else {
            sessionList = new ArrayList<Session>();
            sessionList.add(session);
            ROOMLIST.put(this.roomNums[i], sessionList);
            // 콘솔창에 INFO : ~나오게하는거
         }
      }
   }

   // onmessage : 메세지 전달받았을 때 동작. session은 보낸사람.
   @OnMessage
   public void msg(String msg, Session session) {
      sendAllSessionToMessage(session, msg);
   }

   // 세션리스트에 있는 사람들한테 메세지 다 보내려고 호출되는 메소드. 나빼고보내려고 파라미터에 내 session정보받아옴
   private void sendAllSessionToMessage(Session me, String msg) {
      try {
         msgArr = msg.split("\\{\\}");
         sessionList = ROOMLIST.get(msgArr[2]);
         for (Session session : sessionList) {
            if (!me.getId().equals(session.getId())) {
               session.getBasicRemote().sendText(msg);
            }
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

   @OnClose
   public void close(Session session) {
      if(ROOMLIST.size()>0)
         for (String key : ROOMLIST.keySet()) {
            if (ROOMLIST.get(key).contains(session)) {
               ROOMLIST.get(key).remove(session);
            }
         }
   }

   @OnError
   public void error(Throwable t) {
      t.printStackTrace();
   }

}