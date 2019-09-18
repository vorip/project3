package com.rt.travel.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rt.travel.chat.dto.FriendDTO;
import com.rt.travel.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSessionTemplate mymy;
	
	@Override
	public void insert(MemberDTO memberDTO) {
		mymy.insert("memberDAO.insert",memberDTO);
	}
	
	@Override
	public MemberDTO select(String inputId) {
		return mymy.selectOne("memberDAO.select",inputId);
	}
	
	@Override
	public int selectCnt(MemberDTO memberDTO) {
		return mymy.selectOne("memberDAO.selectCnt",memberDTO);
	}
	@Override
	public int selectCnt2(MemberDTO memberDTO) {
		return mymy.selectOne("memberDAO.selectCnt2",memberDTO);
	}
	/* (non-Javadoc)
	 * @see com.rt.travel.member.dao.MemberDAO#selectCnt3(java.lang.String)
	 */
	@Override
	public int selectCnt3(String inputId) {
		return mymy.selectOne("memberDAO.selectCnt3",inputId);
	}
	@Override
	public MemberDTO selectId(MemberDTO memberDTO) {
		return mymy.selectOne("memberDAO.selectId",memberDTO);
	}
	@Override
	public MemberDTO selectPw(MemberDTO memberDTO) {
		return mymy.selectOne("memberDAO.selectPw",memberDTO);
	}
	/* (non-Javadoc)
	 * @see com.rt.travel.member.dao.MemberDAO#update(java.lang.String)
	 */
	@Override
	public void update(String id) {
		mymy.update("memberDAO.update",id);
	}
	@Override
	public void updatePw(MemberDTO memberDTO) {
		mymy.update("memberDAO.updatePw",memberDTO);
	}
	@Override
	public void updateAll(MemberDTO memberDTO) {
	      mymy.update("memberDAO.updateAll",memberDTO);
	   }
	/* (non-Javadoc)
	 * @see com.rt.travel.member.dao.MemberDAO#delete(java.lang.String)
	 */
	@Override
	public void delete(String inputId) {
		mymy.delete("memberDAO.delete",inputId);
	}
	
	@Override
	public List<MemberDTO> selectAll(){
		return mymy.selectList("memberDAO.selectAll");
	}
	
	/* (non-Javadoc)
	 * @see com.rt.travel.member.dao.MemberDAO#userAuth(java.lang.String)
	 */
	@Override
	public void userAuth(String email) {
		mymy.update("memberDAO.memberAuth", email);
	}
	
	@Override
	public List<FriendDTO> friendList(String myName){
		return mymy.selectList("memberDAO.friendList",myName);
	}
	@Override
	public void addFriend(FriendDTO friendDTO) {
		mymy.insert("memberDAO.addFriend",friendDTO);
	}
	@Override
	public void deleteFriend(FriendDTO friendDTO) {
		mymy.delete("memberDAO.deleteFriend",friendDTO);
	}
	@Override
	public MemberDTO selectEmail(String id) {
		return mymy.selectOne("memberDAO.selectEmail",id);
	}
	@Override
	public int getIsFriend(FriendDTO friendDTO) {
		return mymy.selectOne("memberDAO.isFriend",friendDTO);
	}
}
