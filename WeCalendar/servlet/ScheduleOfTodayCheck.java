package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScheduleOfTodayCheck
 */
@WebServlet("/ScheduleOfTodayCheck")
public class ScheduleOfTodayCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String today = request.getParameter("date");

		System.out.println(today);

		session.setAttribute("today", today);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/todaysPlanDisplay.jsp");
		rd.forward(request, response);
	}

}
