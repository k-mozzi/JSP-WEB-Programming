package servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSP_Example_Code/ch13/LifeCycle.do")
public class LifeCycle extends HttpServlet {

	@PostConstruct
	public void myPostConstruct() {
		System.out.println("call myPostConstruct()");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("call init()");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("call service()");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("call doGet()");
		req.getRequestDispatcher("/JSP_Example_Code/ch13/LifeCycle.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("call doPost()");
		req.getRequestDispatcher("/JSP_Example_Code/ch13/LifeCycle.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("call destroy()");
	}

	@PreDestroy
	public void myPreDestroy() {
		System.out.println("call myPreDestroy()");
	}
}
