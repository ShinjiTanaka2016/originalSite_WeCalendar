package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ScheduleBeans;
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
		String startTime = request.getParameter("starttime");
		if(startTime.length()==0){startTime = null;}
		String endTime = request.getParameter("endtime");
		if(endTime.length()==0){endTime = null;}
		String attribute = request.getParameter("attribute");
		String place = request.getParameter("place");
		if(place.length()==0){place = null;}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if(content.length()==0){content = null;}
		String authority = request.getParameter("authority");
		String createGroup = null;
		String createUser = request.getParameter("createuser");

		WeCalendarDAO wcDAO = new WeCalendarDAO();
		wcDAO.setScedule(date, startTime, endTime, attribute, place, title, content,
				authority, createGroup, createUser);
		ScheduleBeans sb =
				new ScheduleBeans(0,date,startTime,endTime,attribute,place,title,content,
								  authority,createGroup,createUser);
		HttpSession session = request.getSession();
		session.setAttribute("plandata",sb);
		RequestDispatcher rd = request.getRequestDispatcher
				("/WEB-INF/jsp/addUserScheduleFinalCheckResult.jsp");
		rd.forward(request, response);
	}
}
