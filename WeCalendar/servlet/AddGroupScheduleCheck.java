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
 * Servlet implementation class AddGroupScheduleCheck
 */
@WebServlet("/AddGroupScheduleCheck")
public class AddGroupScheduleCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ScheduleBeans sb = new ScheduleBeans();

		sb.setDate(request.getParameter("date"));
		sb.setStartTime(request.getParameter("starttime"));
		sb.setEndTime(request.getParameter("endtime"));
		sb.setAttribute(request.getParameter("attribute"));
		sb.setPlace(request.getParameter("place"));
		sb.setTitle(request.getParameter("title"));
		sb.setContent(request.getParameter("content"));
		sb.setAuthority(request.getParameter("authority"));
		sb.setCreateGroup(request.getParameter("creategroup"));
		sb.setCreateUser(request.getParameter("createuser"));

		request.setAttribute("plandata", sb);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/addGroupScheduleFinalCheck.jsp");
		rd.forward(request, response);
	}
}