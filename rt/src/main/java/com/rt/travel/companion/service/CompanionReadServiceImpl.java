package com.rt.travel.companion.service;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.course.dao.CourseDAO;
import com.rt.travel.course.dao.TypeADAO;
import com.rt.travel.course.dto.TypeADTO;
import com.rt.travel.member.dao.MemberDAOImpl;
import com.rt.travel.member.dto.MemberDTO;


@Service
public class CompanionReadServiceImpl {

	@Autowired
	TypeADAO typeADAO;
	@Autowired
	MemberDAOImpl memberDAO;
	@Autowired
	CourseDAO courseDAO;
	@Autowired
	ChatDAO chatDAO;
	
	public String companionList() {
		List<TypeADTO> list = typeADAO.typeASelectAll("공개");
		String companionListHtml = "";
		for (int i = 0; i < list.size(); i++) {
			TypeADTO typeADTO = list.get(i);
			MemberDTO memberDTO = memberDAO.select(typeADTO.getId());
			String[] courseStart = courseDAO.placeSelectStart(typeADTO.getNo()).split("[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\\\s]");
			String[] courseEnd = courseDAO.placeSelectEnd(typeADTO.getNo()).split("[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\\\s]");
			
			
			String[] start = typeADTO.getDay_start().split(" ");
			String[] end = typeADTO.getDay_end().split(" ");
			
			companionListHtml += "<tr>\r\n" + 
					"		<td style=\"text-align: center;border-bottom: 1px solid #cbcbcb;\">" 	+ 
					"		<img id='img' src='resources/img/"+memberDTO.getThumb()+"'></td>\r\n" + 
					"		<td style=\"text-align: center;border-top: 1px solid #cbcbcb;\">"+typeADTO.getId()+"</td>\r\n" + 
					"		<td style=\"text-align: center;border-top: 1px solid #cbcbcb;\">"+typeADTO.getCurrent_mem()+"/"+typeADTO.getMax_mem()+"</td>\r\n" + 
					"		<td style=\"text-align: center;border-top: 1px solid #cbcbcb;\">"+courseStart[0]+" "+courseStart[1]+"</td>\r\n" + 
					"		<td style=\"text-align: center;border-top: 1px solid #cbcbcb;\">"+courseEnd[0]+" "+courseEnd[1]+"</td>\r\n" + 
					"		<td style=\"text-align: center;border-top: 1px solid #cbcbcb;\">"+start[0]+"~"+end[0]+"</td>\r\n" + 
					"		<td style=\"text-align: center;border-top: 1px solid #cbcbcb;\"><button class = 'detail' onclick = \"showPlan('"+typeADTO.getNo()+"')\" >자세히보기</button>\r\n" + 
					"	</tr>";
		}
		return companionListHtml;
	}
}
