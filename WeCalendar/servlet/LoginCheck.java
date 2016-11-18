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
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("loginuserid");
		String userPass = request.getParameter("loginuserpass");

		String errorMsg = "";

		WeCalendarDAO wcDAO = new WeCalendarDAO();
		if(wcDAO.loginUserCheck(userId, userPass) == true){

		}else{
			errorMsg += "ユーザ確認が取れません";
		}

		if(errorMsg.length() > 0){
			request.setAttribute("errormsg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp");
			rd.forward(request, response);
		}else{

			LoginUserBeans lUB = new LoginUserBeans();
			lUB.setUserId(wcDAO.getLoginUserId(userId));
			lUB.setUserName(wcDAO.getLoginUserName(userId));
			lUB.setUserMail(wcDAO.getLoginUserMail(userId));
			lUB.setUserPass(wcDAO.getLoginUserPass(userId));

			GroupBeans gB = new GroupBeans();;

			gB.setGroupId("0");
			gB.setGroupName("0");
			gB.setGroupPass("0");
			gB.setAdministrator("0");

			HttpSession session = request.getSession();
			session.setAttribute("lub", lUB);
			session.setAttribute("groupdata", gB);
			RequestDispatcher rd = request.getRequestDispatcher("/myPage.jsp");
			rd.forward(request, response);
		}
	}
}