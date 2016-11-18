package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.WeCalendarDAO;

/**
 * Servlet implementation class AddUserComplete
 */
@WebServlet("/AddUserComplete")
public class AddUserComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		String userMail = request.getParameter("usermail");
		String userPass = request.getParameter("userpass");

		WeCalendarDAO wcDAO = new WeCalendarDAO();
		wcDAO.setUserData(userId, userName, userMail, userPass);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/addFinalCheckResult.jsp");
		rd.forward(request, response);
	}
}