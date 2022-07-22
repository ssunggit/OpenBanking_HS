package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.qnaBoard.vo.QnABoardVO;
import service.QnABoardService;

public class boardListProcessController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QnABoardService service = new QnABoardService();
		
		List<QnABoardVO> boardList = service.boardList();
		
		request.setAttribute("boardList", boardList);
		
		return "/jsp/board/list.jsp";
	}

}
