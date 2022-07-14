package controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.account.vo.AccountVO;
import service.AccountService;

public class accountOpendProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 계좌번호 : 은행코드 + 10자리 난수
		Random r = new Random();
		int num = r.nextInt(899999999) + 100000001;
		
		// 003 : HS_BANK의 은행코드
		// 계좌번호 : 은행코드 + 10자리 난수
		String accountNumber = "003" + Integer.toString(num);
		
		request.setCharacterEncoding("utf-8");
		
		String accountPW = request.getParameter("accountPW");
		int balance = Integer.parseInt(request.getParameter("balance"));
		String accountAlias = request.getParameter("accountAlias");
		
		AccountVO accountVO = new AccountVO();
		
		accountVO.setAccountNumber(accountNumber);
		accountVO.setAccountPW(accountPW);
		accountVO.setBalance(balance);
		accountVO.setAccountAlias(accountAlias);
		accountVO.setBankCode("003");

		AccountService service = new AccountService();
		
		service.addAccount(accountVO);
		
		return "redirect:/";
	}

}
