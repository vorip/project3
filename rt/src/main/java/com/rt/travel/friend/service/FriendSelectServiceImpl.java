package com.rt.travel.friend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.friend.dto.FriendDTO;
import com.rt.travel.member.dao.MemberDAOImpl;
import com.rt.travel.member.dto.MemberDTO;

@Service
public class FriendSelectServiceImpl implements FriendSelectService {

   MemberDTO memberDTO;
   FriendDTO friendDTO;
   String friendName;
   private String friendInfoName;
   
   @Autowired
   MemberDAOImpl memberDAO;
   
   @Override
   public String searchFriendResult(String id,String name) {
      memberDTO = memberDAO.select(id);
      friendDTO = new FriendDTO();
      friendDTO.setMyName(name);
      if(memberDTO!=null) {
         friendName = memberDTO.getName()+"_"+memberDTO.getId();
         friendDTO.setFriendName(friendName);
         if(memberDAO.getIsFriend(friendDTO)==0&&!name.equals(friendName))
               return searchResult(memberDTO,"<button onclick = \"addFriendButton('"+name+"','"+(friendName)+"');\" type = \"button\" id = \"addFriendButton\">친구추가</button>");
         else
            return searchResult(memberDTO,"<span class = \'addFriendText3\'>이미 친구입니다</span>");
      }else {
         return "<span class = \"addFriendText\">"+id+"</span><br>" + 
               "<span class = \"addFriendText\">님을 찾을 수 없습니다.</span><br>" + 
               "<span class = \"addFriendText2\">입력하신 ID는 등록된 회원이 아닙니다.</span>"+
               "<button type = \"button\" onclick = \'exitAddFriend();\' id =\"exitAddFriendButton\">나가기</button>";
      }
   }
   @Override
   public String searchResult(MemberDTO memberDTO,String isFriend) {
      //고칠거
      return "<img id =\"friendPicture\" src = \"resources/img/thumb.jpg\"><br>" + 
            "<span id = \"resultFriendName\">"+memberDTO.getName()+"_"+memberDTO.getId()+"</span><br>" + 
            isFriend;
   }
   @Override
   public String friendInfo(String friendName,String name) {
      return friendInfoHtml(memberDAO.select(friendName.split("_")[1]),name); 
   }
   @Override
   public String friendInfoHtml(MemberDTO memberDTO,String name) {
      friendInfoName = memberDTO.getName()+"_"+memberDTO.getId();
      if(!friendInfoName.equals(name))
         return "<div class = 'friendInfo' id = 'friendInfo'>" + 
               "<img id = 'minimiInfo' src = 'resources/img/minimi.png' onclick = 'minimiInfo();'>" +
               "<div align='center'><h3>친구정보</h3></div>" +
               "<div align = 'center' class = 'friendThumb'><img src = 'resources/img/thumb.jpg'></div>" + 
               "<div align = 'center' class = 'friendNameDiv'><span class = 'friendName'>"+friendInfoName+"</span></div>" + 
               "<div align = 'center' class = 'friendEmailDiv'><span class = 'friendEmail'>"+memberDTO.getEmail()+"</span><br></div>" + 
               "<div align='center' class = 'friendInfoBtn'>" + 
                  "<button class = 'sendNoteBtn' onclick=\"sendNoteDiv('"+friendInfoName+"');\">쪽지보내기</button>" + 
                  "<button class = 'deleteFriendBtn' onclick=\"deleteFriend('"+friendInfoName+"');\">친구삭제</button>" + 
               "</div>" + 
            "</div>";
      else
         return "<div class = 'friendInfo' id='friendInfo'>" + 
         "<img id = 'minimiInfo' src = 'resources/img/minimi.png' onclick = 'minimiInfo();'>" +
         "<div align='center'><h3>친구정보</h3></div>" + 
         "<div align = 'center' class = 'friendThumb'><img src = 'resources/img/thumb.jpg'></div>" + 
         "<div align = 'center' class = 'friendNameDiv'><span class = 'friendName'>"+friendInfoName+"</span></div>" + 
         "<div align = 'center' class = 'friendEmailDiv'><span class = 'friendEmail'>"+memberDTO.getEmail()+"</span><br></div>" + 
         "<div align='center' class = 'friendInfoBtn'>" + 
         "<button class = 'sendNoteBtn' onclick=\"sendNoteDiv('"+friendInfoName+"');\" disabled = 'disabled'>쪽지보내기</button>" + 
         "<button class = 'deleteFriendBtn' onclick=\"deleteFriend('"+friendInfoName+"');\" disabled = 'disabled'>친구삭제</button>" + 
         "</div>" + 
         "</div>";
   }
}