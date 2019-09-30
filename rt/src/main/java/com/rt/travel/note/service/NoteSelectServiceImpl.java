package com.rt.travel.note.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.note.dao.NoteDAO;
import com.rt.travel.note.dto.NoteDTO;

@Service
public class NoteSelectServiceImpl implements NoteSelectService {
   
   List<NoteDTO> noteList;
   NoteDTO noteDTO;
   String noteListHtml;
   String other;
   int chatRoomNum;
   String member;
   
   @Autowired
   NoteDAO noteDAO;
   
   @Override
   public String noteSelectAll(String me){
      noteList = noteDAO.noteSelectAll(me);
      noteListHtml = "<div id = 'noteList'>"+
            "         <div id = 'noteList1'>" + 
            "            <img id = 'minimiNoteList' onclick='minimiNoteList();'src = 'resources/img/minimi.png'>" + 
            "            <h3 style=\"margin-left: 15px;\">쪽지목록</h3>" + 
            "         </div>"+
            "         <div id = 'noteContents'>";
      for(int i=0;i<noteList.size();i++) {
         noteDTO = noteList.get(i);
         if(noteDTO.getNoteType()=='O')
         noteListHtml+= "<div class = 'eachNote'>" + 
               "         <span class = 'sender'>"+noteDTO.getOther()+"</span><br>" + 
               "         <span class = 'noteContent'>"+noteDTO.getContent()+"</span><br>" + 
               "         <span class= 'chatT'>"+noteDTO.getSendTime()+"</span><br>" + 
               "         <button style = 'margin-left : 10px;' onclick=\"sendNoteDiv('"+noteDTO.getOther()+"');\">답장</button>"
                     + "<button onclick=\"deleteNote('"+noteDTO.getNoteNum()+"','');\">삭제</button>" +
               "      </div>" + 
               "      <hr>";
         else {
            if(noteDTO.getApplyType()=='f')
            noteListHtml+= "<div class = 'eachNote'>" + 
                  "         <span class = 'sender'>"+noteDTO.getOther()+"</span><br>" + 
                  "         <span class = 'noteContent'>"+noteDTO.getContent()+"</span><br>" + 
                  "         <span class = 'chatT'>"+noteDTO.getSendTime()+"</span><br>" + 
                  "         <button style='margin-left : 10px;' onclick = \"acceptFriend('"+noteDTO.getOther()+"','"+noteDTO.getMe()+"','"+noteDTO.getNoteNum()+"');\">수락</button><button onclick=\"rejectFriend('"+noteDTO.getOther()+"','"+noteDTO.getNoteNum()+"');\">거절</button>" + 
                  "      </div>" + 
                  "      <hr>";
            else {
               member = noteDTO.getOther().split("<>")[0];
               chatRoomNum = Integer.parseInt(noteDTO.getOther().split("<>")[1]);
               noteListHtml+= "<div class = 'eachNote'>" + 
                     "         <span class = 'sender'>"+noteDTO.getOther()+"</span><br>" + 
                     "         <span class = 'noteContent'>"+noteDTO.getContent()+"</span><br>" + 
                     "         <span class = 'chatT'>"+noteDTO.getSendTime()+"</span><br>" + 
                     "         <button style='margin-left : 10px;' onclick = \"acceptCompanion('"+member+"','"+noteDTO.getNoteNum()+"','"+chatRoomNum+"');\">수락</button><button onclick=\"rejectCompanion('"+member+"','"+noteDTO.getNoteNum()+"');\">거절</button>" + 
                     "      </div>" + 
                     "      <hr>";
            }
         }
      }
      noteListHtml += "</div></div>";
      return noteListHtml;
   }
   
}