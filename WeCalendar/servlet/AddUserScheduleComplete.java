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
 * Servlet implementation class AddUserScheduleComplete
 */
@WebServlet("/AddUserScheduleComplete")
public class AddUserScheduleComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String attribute = request.getParameter("attribute");
		String place = request.getParameter("place");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String authority = request.getParameter("authority");
		String createGroup = null;
		String createUser = request.getParameter("createuser");

		WeCalendarDAO wcDAO = new WeCalendarDAO();
		wcDAO.setScedule(date, time, attribute, place, title, content,
				authority, createGroup, createUser);

		RequestDispatcher rd = request.getRequestDispatcher
				("/WEB-INF/jsp/addUserScheduleFinalCheckResult.jsp");
		rd.forward(request, response);
	}
}
