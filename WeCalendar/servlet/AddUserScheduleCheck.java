package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScheduleBeans;

/**
 * Servlet implementation class AddUserScheduleCheck
 */
@WebServlet("/AddUserScheduleCheck")
public class AddUserScheduleCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ScheduleBeans sb = new ScheduleBeans();

		sb.setDate(request.getParameter("date"));
		sb.setTime(request.getParameter("time"));
		sb.setAttribute(request.getParameter("attribute"));
		sb.setPlace(request.getParameter("place"));
		sb.setTitle(request.getParameter("title"));
		sb.setContent(request.getParameter("content"));
		sb.setAuthority(request.getParameter("authority"));
		sb.setCreateUser(request.getParameter("createuser"));

		request.setAttribute("schedule", sb);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/addUserScheduleFinalCheck.jsp");
		rd.forward(request, response);
	}
}
