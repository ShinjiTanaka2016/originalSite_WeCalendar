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
import model.ScheduleDAO;

/**
 * Servlet implementation class TodayScheduleCheck
 */
@WebServlet("/TodayScheduleCheck")
public class TodayScheduleCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 受け取ったスケジュールIDを元にデータを取得
		 * */
		request.setCharacterEncoding("UTF-8");
		String planId = request.getParameter("planid");
		int id = Integer.parseInt(planId);

		ScheduleBeans sb = new ScheduleBeans();
		ScheduleDAO aDAO = new ScheduleDAO();
		sb = aDAO.getPlanData(id);

		HttpSession session = request.getSession();
		session.setAttribute("plandata", sb);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/TodayScheduleResult.jsp");
		rd.forward(request, response);
	}
}