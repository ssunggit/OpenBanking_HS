package model.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.ac.kopo.util.ConnectionFactory;
import model.account.vo.AccountVO;

public class AccountDAO {

	public void addAccount(AccountVO accountVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Account(account_number, account_pw, account_alias, balance, bankcode) ");
		sql.append(" VALUES(?, ?, ?, ?, ?) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				int loc = 1;
				pstmt.setString(loc++, accountVO.getAccountNumber());
				pstmt.setString(loc++, accountVO.getAccountPW());
				pstmt.setString(loc++, accountVO.getAccountAlias());
				pstmt.setInt(loc++, accountVO.getBalance());
				pstmt.setString(loc++, accountVO.getBankCode());
				
				pstmt.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}

}
