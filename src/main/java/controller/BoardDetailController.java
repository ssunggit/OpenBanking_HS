package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.qnaBoard.vo.QnABoardVO;
import service.QnABoardService;

public class BoardDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		
		QnABoardService service = new QnABoardService();
		
		QnABoardVO board = service.detailBoard(no);
		
		request.setAttribute("board", board);
		
		return "/jsp/board/detail.jsp?no="+no;
	}

}
