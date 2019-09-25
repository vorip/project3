package com.rt.travel.board.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.rt.travel.board.dao.BoardDAO;
import com.rt.travel.board.dto.BoardDTO;


@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;
	
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
	public void update(BoardDTO bDTO) throws Exception {
		boardDao.update(bDTO);
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}
	
	//게시글 전체 목록
	@Override
	public List<BoardDTO> listAll() throws Exception {
		return boardDao.listAll();
	}

	/*
	 * @Override public int countArticle(String searchOption, String keyword) throws
	 * Exception { return boardDao.countArticle(searchOption, keyword); }
	 */
	
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


}
