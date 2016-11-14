package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GroupBeans;
import model.LoginUserBeans;
import model.WeCalendarDAO;

/**
 * Servlet implementation class GroupLoginCheck
 */
@WebServlet("/GroupLoginCheck")
public class GroupLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		WeCalendarDAO wcDAO = new WeCalendarDAO();
		HttpSession session = request.getSession();
		LoginUserBeans lUB = (LoginUserBeans)session.getAttribute("lub");
		String errorMsg = "";

		//	データ受け取り
		String loginUserId = lUB.getUserId();
		String groupLoginId = request.getParameter("grouploginid");
		String groupLoginPass = request.getParameter("grouploginpass");

		//	エラーチェック
		if(wcDAO.getGroupId(groupLoginId) == false){
			errorMsg += "入力したグループIDは存在しません。<br>";
		}else if(wcDAO.getGroupMember(loginUserId,groupLoginId)==false){
			errorMsg += "入力したグループのメンバーではありません。";
		}else if(!wcDAO.getGroupPass(groupLoginId).equals(groupLoginPass)){
			errorMsg += "パスワードの確認がとれません。<br>";
		}
		if(errorMsg.length() > 0){
			errorMsg += "<br><a href=\"/WeCalendar/groupLogin.jsp\" class=\"btn btn-primary btn-sm\">戻る</a>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);

		//	エラーでない場合ログイン処理
		}else{
			GroupBeans gB = (GroupBeans)wcDAO.getGroupData(groupLoginId);
			session.setAttribute("groupdata", gB);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/groupLoginCompleteResult.jsp");
			rd.forward(request, response);
		}
	}
}
