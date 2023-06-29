package model2.mvcboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSP_Example_Code/ch14/view.do")
public class ViewController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MVCBoardDAO dao = new MVCBoardDAO();
		String idx = req.getParameter("idx");
		dao.updateVisitCount(idx);
		MVCBoardDTO dto = dao.selectView(idx);
		dao.close();

		dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));

		// 게시물 저장 후 뷰로 포워드
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/JSP_Example_Code/ch14/View.jsp").forward(req, resp);
	}
}
