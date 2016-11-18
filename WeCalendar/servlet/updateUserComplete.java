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
 * Servlet implementation class updateUserComplete
 */
@WebServlet("/updateUserComplete")
public class updateUserComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		WeCalendarDAO wcDAO = new WeCalendarDAO();
		HttpSession session = request.getSession();
		LoginUserBeans lUB = (LoginUserBeans) session.getAttribute("lub");

		String newUserId = request.getParameter("userid");
		String newUserName = request.getParameter("username");
		String newUserMail = request.getParameter("usermail");
		String newUserPass = request.getParameter("userpass");

		wcDAO.updateUserData(newUserId, newUserName, newUserMail, newUserPass, lUB.getUserId());

		lUB.setUserId(newUserId);
		lUB.setUserName(newUserName);
		lUB.setUserMail(newUserMail);
		lUB.setUserPass(newUserPass);
		session.setAttribute("lub", lUB);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/updateUserDataCompleteResult.jsp");
		rd.forward(request, response);
	}
}