package service;

import model.account.dao.AccountDAO;
import model.account.vo.AccountVO;

public class AccountService {
	
	private AccountDAO accountDao;
	
	public AccountService() {
		accountDao = new AccountDAO();
	}

	public void addAccount(AccountVO accountVO) {
		accountDao.addAccount(accountVO);
		
	}
	

}
