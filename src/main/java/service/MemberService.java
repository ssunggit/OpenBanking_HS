package service;

import model.member.dao.MemberDAO;
import model.member.vo.MemberVO;

public class MemberService {

	private MemberDAO memberDao;

	public MemberService() {
		memberDao= new MemberDAO();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 회원가입
	 */
	public void join(MemberVO member) {
		
		memberDao.join(member);
		
	}
	
	/**
	 * 로그인
	 * @param id
	 * @param password
	 * @return
	 */
	public MemberVO login(String id, String password) {
		
		MemberVO loginVO = memberDao.login(id, password);
				
		return loginVO;
	}
	
}
