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
 * Servlet implementation class DeleteUserScheduleComplete
 */
@WebServlet("/DeleteUserScheduleComplete")
public class DeleteUserScheduleComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String deleteId = request.getParameter("deleteid");
		int id = Integer.parseInt(deleteId);

		WeCalendarDAO wcDAO = new WeCalendarDAO();
		wcDAO.deleteSchedule(id);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/deleteUserScheduleCompleteResult.jsp");
		rd.forward(request, response);
	}

}
