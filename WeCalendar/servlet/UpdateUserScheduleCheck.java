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
import model.ScheduleBeans;
import model.ScheduleDAO;

/**
 * Servlet implementation class UpdateUserScheduleCheck
 */
@WebServlet("/UpdateUserScheduleCheck")
public class UpdateUserScheduleCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String errorMsg = "";

		LoginUserBeans lUB = (LoginUserBeans)session.getAttribute("lub");
		String loginUserId = lUB.getUserId();

		String id = request.getParameter("planid");
		int planId = Integer.parseInt(id);

		ScheduleDAO sDAO = new ScheduleDAO();
		ScheduleBeans sb = new ScheduleBeans();
		sb = sDAO.getPlanData(planId);
		String createUserId = "";

		if(sb == null){
			errorMsg = "入力したスケジュールID(" +  planId  + ")は存在しません<br><br>"
					+ "<a href=\"/WeCalendar/updateUserSchedule.jsp\" class=\"btn btn-primary btn-sm\">戻る</a>";
			request.setAttribute("msg",errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/schduleError.jsp");
			rd.forward(request, response);
		}else{
			createUserId = sb.getCreateUser();
			if(!loginUserId.equals(createUserId)){
				errorMsg = "入力したスケジュールID(" +  planId  + ")は存在しません";
				request.setAttribute("msg",errorMsg);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/schduleError.jsp");
				rd.forward(request, response);
			}else{
				session.setAttribute("plandata",sb);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/updateUserSchdulecheckResult.jsp");
				rd.forward(request, response);
			}
		}
	}
}