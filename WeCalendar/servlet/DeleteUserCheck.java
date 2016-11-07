package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginUserBeans;
import model.WeCalendarDAO;

/**
 * Servlet implementation class DeleteUserCheck
 */
@WebServlet("/DeleteUserCheck")
public class DeleteUserCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		LoginUserBeans lUB = (LoginUserBeans) session.getAttribute("lub");
		String errorMsg = "";

		String id = lUB.getUserId();
		String pass = lUB.getUserPass();

		String DeletePass = request.getParameter("deletepass");

		if(!DeletePass.equals(pass)){
			errorMsg += "パスワードが違います。<br>";
			request.setAttribute("errormsg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/deletePassError.jsp");
			rd.forward(request, response);
		}else{
			WeCalendarDAO wcDAO = new WeCalendarDAO();
			wcDAO.deleteUserData(id);
			session.invalidate();

			String Msg = "IDを削除しました。";
			request.setAttribute("msg",Msg );

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/logoutComplete.jsp");
			rd.forward(request, response);
		}


	}

}
