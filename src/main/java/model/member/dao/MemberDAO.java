package model.member.dao;
/*
 * t_member 테이블에 대한 CRUD 메소드
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import model.member.vo.MemberVO;

public class MemberDAO {

	public void join(MemberVO member) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO MEMBER(ID, PASSWORD,NAME, BIRTH, TEL, EMAIL, ADDRESS) ");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				int loc = 1;
				pstmt.setString(loc++, member.getId());
				pstmt.setString(loc++, member.getPassword());
				pstmt.setString(loc++, member.getName());
				pstmt.setString(loc++, member.getBirth());
				pstmt.setString(loc++, member.getTel());
				pstmt.setString(loc++, member.getEmail());
				pstmt.setString(loc++, member.getAddress());
				
				pstmt.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	public MemberVO login(String id, String password) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append(" from member ");
		sql.append(" where id = ? and password = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				
				ResultSet rs = pstmt.executeQuery();
				
				// id 가 기본키이기 때문에 나올 수 있는 레코드가 0~1개
				if(rs.next()) {
					MemberVO loginVO = new MemberVO();
					loginVO.setId(rs.getString("id"));
					loginVO.setPassword(rs.getString("password"));
					loginVO.setName(rs.getString("name"));
					loginVO.setBirth(rs.getString("birth"));
					loginVO.setTel(rs.getString("tel"));
					loginVO.setEmail(rs.getString("email"));
					loginVO.setAddress(rs.getString("address"));
					loginVO.setRegDate(rs.getString("reg_date"));					
					loginVO.setType(rs.getString("type"));
					
					return loginVO;
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			// 로그인 실패할 경우 null 리턴
			return null;
		
	}
	
	

}
