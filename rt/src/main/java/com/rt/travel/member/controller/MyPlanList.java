package com.rt.travel.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.course.dao.TypeADAO;
import com.rt.travel.course.dto.TypeADTO;

@Service
public class MyPlanList {

	@Autowired
	TypeADAO typeADAO;
	
	public String myPlan(String id) {
		List<TypeADTO> list = typeADAO.selectPlan(id);
		String myPlanHtml="";
		for (int i = 0; i < list.size(); i++) {
			TypeADTO typeADTO = list.get(i);
			
			String[] start = typeADTO.getDay_start().split(" ");
			String[] end = typeADTO.getDay_end().split(" ");
			
			myPlanHtml += "<tr>\r\n" + 
					"		<td style=\"text-align: center;\">"+typeADTO.getTitle()+"</td>\r\n" + 
					"		<td style=\"text-align: center;\">"+typeADTO.getTravel_day()+"</td>\r\n" + 
					"		<td style=\"text-align: center;\">"+typeADTO.getTravel_type()+"</td>\r\n" + 
					"		<td style=\"text-align: center;\">"+typeADTO.getTravel_theme()+"</td>\r\n" + 
					"		<td style=\"text-align: center;\">"+typeADTO.getChoice_public()+"</td>\r\n" + 
					"		<td style=\"text-align: center;\">"+typeADTO.getTravel_intro()+"</td>\r\n" + 
					"		<td style=\"text-align: center;\">"+start[0]+"~"+end[0]+"</td>\r\n" + 
					"		<td style=\"text-align: center;\"><button class = 'detail' onclick = \"location.href='showindex.do?no="+typeADTO.getNo()+"'\" >자세히보기</button>\r\n" + 
					"	</tr>";
			
		}
		
		return myPlanHtml;
	}
}
