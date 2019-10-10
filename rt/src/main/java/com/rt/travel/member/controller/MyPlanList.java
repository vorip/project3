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
		String myPlanHtml = "";
		for (int i = 0; i < list.size(); i++) {
			TypeADTO typeADTO = list.get(i);

			String[] start = typeADTO.getDay_start().split(" ");
			String[] end = typeADTO.getDay_end().split(" ");

			myPlanHtml += "<tr>\r\n" + "		<td style=\"text-align: center;  border-top: 1px solid #cbcbcb; padding-top: 5px;padding-bottom: 5px;\">" + typeADTO.getTitle() + "</td>\r\n"
					+ "		<td style=\"text-align: center;  border-top: 1px solid #cbcbcb; padding-top: 5px;padding-bottom: 5px;\">" + typeADTO.getTravel_type() + "</td>\r\n"
					+ "		<td style=\"text-align: center;  border-top: 1px solid #cbcbcb; padding-top: 5px;padding-bottom: 5px;\">" + typeADTO.getTravel_theme() + "</td>\r\n"
					+ "		<td style=\"text-align: center;  border-top: 1px solid #cbcbcb; padding-top: 5px;padding-bottom: 5px;\">" + typeADTO.getChoice_public() + "</td>\r\n"
					+ "		<td style=\"text-align: center;  border-top: 1px solid #cbcbcb; padding-top: 5px;padding-bottom: 5px;\">" + typeADTO.getTravel_intro() + "</td>\r\n"
					+ "		<td style=\"text-align: center;  border-top: 1px solid #cbcbcb; padding-top: 5px;padding-bottom: 5px;\">" + start[0] + "~" + end[0] + "</td>\r\n"
					+ "		<td style=\"text-align: center;  border-top: 1px solid #cbcbcb; padding-top: 5px;padding-bottom: 5px;\"><button class = 'detail' onclick = \"location.href='showindex.do?no="+typeADTO.getNo() + "'\""  
					+"style=\"display: inline-block;	line-height: normal; white-space: nowrap; vertical-align: middle;text-align: center;"
					+ "	cursor: pointer;box-sizing: border-box; background-color: #1f8dd6;"
					+ "	color: white;\" >자세히보기</button>" + "	</tr>";
		}

		return myPlanHtml;
	}
}
