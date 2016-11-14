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

		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endtime");
		String errorMsg ="";

		//	エラーチェック
		if(startTime.length()==0 && endTime.length()>0){
			errorMsg += "終了時間のみの入力はできません。<br>";
		}else if(endTime.length() > 0 && startTime.compareTo(endTime)>=0){
			errorMsg += "開始時間と終了時間の設定が異常です<br>";
		}
		if(errorMsg.length() > 0){
			errorMsg += "<br><a href=\"/addUserSchedule.jsp\" class=\"btn btn-primary btn-sm\">戻る</a><br>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		}

		ScheduleBeans sb = new ScheduleBeans();

		sb.setDate(request.getParameter("date"));
		sb.setStartTime(request.getParameter("starttime"));
		sb.setEndTime(request.getParameter("endtime"));
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
