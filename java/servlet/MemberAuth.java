package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.*;

public class MemberAuth extends HttpServlet {
	MemberDAO dao;

	@Override
	public void init() throws ServletException {
		// application 내장 객체 얻기
		ServletContext application = this.getServletContext();

		// web.xml에서 DB 연결 정보 얻기
		String driver = application.getInitParameter("OracleDriver");
		String connectUrl = application.getInitParameter("OracleURL");
		String oId = application.getInitParameter("OracleId");
		String oPass = application.getInitParameter("OraclePwd");

		// DAO 생성
		dao = new MemberDAO(driver, connectUrl, oId, oPass);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admin_id = this.getInitParameter("admin_id");

		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		MemberDTO memberDTO = dao.getMemberDTO(id, pass);

		String memberName = memberDTO.getName();
		if (memberName != null) {
			req.setAttribute("authMessage", memberName + "회원님 안녕하세요.");
		} else {
			if (admin_id.equals(id)) {
				req.setAttribute("authMessage", admin_id + "는 최고 관리자입니다.");
			} else {
				req.setAttribute("authMessage", "귀하는 회원이 아닙니다.");
			}
		}
		req.getRequestDispatcher("/JSP_Example_Code/ch13/MemberAuth.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		dao.close();
	}
}
