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
 * Servlet implementation class UpDateUserScheduleFinalCheck
 */
@WebServlet("/UpDateUserScheduleFinalCheck")
public class UpDateUserScheduleFinalCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String errorMsg = "";

		HttpSession session = request.getSession();
		ScheduleBeans sb = (ScheduleBeans) session.getAttribute("plandata");

		if(sb.getDate().length()==0){
			errorMsg = "日付が入力されていません";
		}
		if(sb.getTitle().length()==0){
			errorMsg = "タイトルが入力されていません";
		}

		if(errorMsg.length()>0){
			request.setAttribute("Msg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/schduleError.jsp");
			rd.forward(request, response);
		}else{
			String planId = request.getParameter("id");
			int id = Integer.parseInt(planId);
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
			wcDAO.updateScedule(id, date, time, attribute, place, title, content,
								authority, createGroup, createUser);

			sb = wcDAO.getPlanData(id);
			session.setAttribute("plandata",sb);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/updateUserScheduleComplete.jsp");
			rd.forward(request, response);
		}
	}
}
