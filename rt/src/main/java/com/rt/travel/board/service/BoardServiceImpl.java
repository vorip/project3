package com.rt.travel.board.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.board.dao.BoardDAO;
import com.rt.travel.board.dto.BoardDTO;
import com.rt.travel.boardcomment.dao.CommentDAO;
import com.rt.travel.boardcomment.dto.CommentDTO;


@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;
	
	@Autowired
	CommentDAO commentDao;
	
	@Override
	public void insert(BoardDTO bDTO) throws Exception {
		bDTO.setWriter("aaaaa");
		boardDao.insert(bDTO);
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		return boardDao.read(bno);
	}
	
	@Override
	public List<CommentDTO> commentList(int bno) throws Exception {
		return commentDao.commentList(bno);
	}

	@Override
	public void update(BoardDTO bDTO) throws Exception {
		boardDao.update(bDTO);
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}
	
	/*
	 * @Override public List<BoardDTO> listAll(String searchOption, String keyword)
	 * throws Exception { return boardDao.listAll(searchOption, keyword); }
	 */
	
	
	 //게시글 전체 목록
	 
	 @Override public List<BoardDTO> listAll(int page) throws Exception {
		 if(page == 0) {
			 page = 1;
		 }
		 
		 return boardDao.listAll(page); 
	}
	 
	 @Override
	 public String board_count_list() throws Exception {
		 
		 int temp = boardDao.board_count()/20;
		 String pageHtml = "<ul style=\"list-style-type: none;\">";
		 if(boardDao.board_count()%20 > 0 || temp == 0) {
			 for (int i = 0; i < temp+1; i++) {
				pageHtml+="<li style=\"float:left;\"><a href = \"list.do?page="+(i+1)+"\">"+(i+1)+"</a></li>";
			}
		 }else {
			 for (int i = 0; i < temp; i++) {
				 pageHtml+="<li style=\"float:left;\"><a href = \"list.do?page="+(i+1)+"\">"+(i+1)+"</a></li>";
			}
		 }
		 return pageHtml+="</ul>";
	 }
	 @Override
	 public String board_count_search() throws Exception {
		 
		 int temp = boardDao.board_count()/20;
		 if(boardDao.board_count()%20 > 0 && temp > 0) {
			 return "";
		 }else {
			 return "";
		 }
	 }
	
	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		long update_time = 0;
		//세션에 저장된 조회시간 검색
		//최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행 x
		if(session.getAttribute("update_time_"+bno) != null) {
			//세션에서 읽어오기
			update_time = (long)session.getAttribute("update_time_"+bno);
		}
		//시스템의 현재시간을 current_time에 저장
		long current_time = System.currentTimeMillis();
		//일정시간이 경과 후 조회수 증 가 처리 24*60*60*1000(24시간)
		//시스템 현재시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간)
		if(current_time - update_time > 5*1000) {
			boardDao.increaseViewcnt(bno);
			//세션에 시간을 저장 : "update_time_"bno는 다른 변수와 중복되지 않게 지정
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public String board_search_title(String searchWord) throws Exception {
		
		List<BoardDTO> list = boardDao.board_search_title(searchWord);

		SimpleDateFormat formatType = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String search_result_html = "";
		BoardDTO dto;
		for (int i = 0; i < list.size(); i++) {
			dto = list.get(i);
			search_result_html +="<tr>\r\n" + 
										"<th scope=\"row\">"+dto.getBno()+"</th>\r\n" + 
										"<td>"+dto.getWriter()+"</td>\r\n" + 
										"<td><a href=\"view.do?bno="+dto.getBno()+"\">"+dto.getTitle()+"</a></td>\r\n" + 
										"<td>"+dto.getViewcnt()+"</td>\r\n" + 
										"<td>"+formatType.format(dto.getRegdate())+"</td>\r\n";
		}
		return search_result_html+="</tr>";
	}

	@Override
	public String board_search_content(String searchWord) throws Exception {
		
		List<BoardDTO> list = boardDao.board_search_content(searchWord);
		
		String search_result_html = "";

		BoardDTO dto;
		for (int i = 0; i < list.size(); i++) {
			dto = list.get(i);
			search_result_html +="<tr>\r\n" + 
										"<th scope=\"row\">"+dto.getBno()+"</th>\r\n" + 
										"<td>"+dto.getWriter()+"</td>\r\n" + 
										"<td><a href=\"view.do?bno="+dto.getBno()+"\">"+dto.getWriter()+"</a></td>\r\n" + 
										"<td>"+dto.getViewcnt()+"</td>\r\n" + 
										"<td><fmt:formatDate value=\""+dto.getRegdate()+"\" pattern=\"yyyy-MM-dd HH:mm\"/></td>\r\n";
		}
		return search_result_html+="</tr>";
	}

	@Override
	public String board_search_writer(String searchWord) throws Exception {
		
		List<BoardDTO> list = boardDao.board_search_writer(searchWord);
		
		String search_result_html = "";

		BoardDTO dto;
		for (int i = 0; i < list.size(); i++) {
			dto = list.get(i);
			search_result_html +="<tr>\r\n" + 
										"<th scope=\"row\">"+dto.getBno()+"</th>\r\n" + 
										"<td>"+dto.getWriter()+"</td>\r\n" + 
										"<td><a href=\"view.do?bno="+dto.getBno()+"\">"+dto.getWriter()+"</a></td>\r\n" + 
										"<td>"+dto.getViewcnt()+"</td>\r\n" + 
										"<td><fmt:formatDate value=\""+dto.getRegdate()+"\" pattern=\"yyyy-MM-dd HH:mm\"/></td>\r\n";
		}
		return search_result_html+="</tr>";
	}

}
