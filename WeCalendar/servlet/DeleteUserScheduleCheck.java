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
import model.WeCalendarDAO;

/**
 * Servlet implementation class DeleteUserScheduleCheck
 */
@WebServlet("/DeleteUserScheduleCheck")
public class DeleteUserScheduleCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String errorMsg = "";

		LoginUserBeans lUB = (LoginUserBeans)session.getAttribute("lub");
		String loginUserId = lUB.getUserId();

		String id = request.getParameter("deleteid");
		int planId = Integer.parseInt(id);

		WeCalendarDAO wcDAO = new WeCalendarDAO();
		ScheduleBeans sb = new ScheduleBeans();
		sb = wcDAO.getPlanData(planId);
		String createUserId = "";

		//	エラーチェック
		if(sb == null){
			errorMsg += "入力したユーザスケジュールID(" +  planId  + ")は存在しません<br><br>"
					 + "<a href=\"/WeCalendar/deleteUserSchedule.jsp\" class=\"btn btn-primary btn-sm\">戻る</a>";
			request.setAttribute("msg",errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		}else{
			createUserId = sb.getCreateUser();
			if(!loginUserId.equals(createUserId) || sb.getCreateGroup() != null){
				errorMsg = "入力したユーザスケジュールID(" +  planId  + ")は存在しません<br><br>"
						 + "<a href=\"/WeCalendar/deleteUserSchedule.jsp\" class=\"btn btn-primary btn-sm\">戻る</a>";
				request.setAttribute("msg",errorMsg);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/error.jsp");
				rd.forward(request, response);

			}else{	//	エラー無しの場合確認画面へ
				session.setAttribute("plandata",sb);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deleteUserSchdulecheckResult.jsp");
				rd.forward(request, response);
			}
		}
	}

}
