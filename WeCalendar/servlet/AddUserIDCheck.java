package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.WeCalendarDAO;
import model.addUserBeans;

/**
 * Servlet implementation class AddUserIDCheck
 */
@WebServlet("/AddUserIDCheck")
public class AddUserIDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		String userMail = request.getParameter("usermail");
		String userPass01 = request.getParameter("userpass01");
		String userPass02 = request.getParameter("userpass02");

		String errorMsg = "";

		if(		userId.length() == 0 		||	userName.length() == 0		|| userMail.length() == 0
		   || 	userPass01.length() == 0	|| userPass02.length() == 0 ){
			errorMsg += "入力されていない項目があります。<br>";
		}
		if(userId.length() < 8 || 12 < userId.length()){
			errorMsg += "ユーザIDが指定の範囲外です(8～12,半角英数)<br>";
		}
		if(userPass01.length() < 8 || 12 < userPass01.length()){
			errorMsg += "ユーザパスが指定の範囲外です(8～12文字,半角英数)<br>";
		}
		if(!(userPass01.equals(userPass02)) || userPass01.length() == 0){
			errorMsg += "ユーザパスの確認が取れません<br>";
		}

		if(errorMsg.length() > 0){
			request.setAttribute("errormsg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/addIdError.jsp");
			rd.forward(request, response);


		}else{

			WeCalendarDAO wcDAO = new WeCalendarDAO();
			if(wcDAO.getUserId(userId) == true){
				errorMsg += "入力したＩＤはすでに使われています<br>";
			}
			if(wcDAO.getUserMail(userMail) == true){
				errorMsg += "入力したアドレスはすでに使われています<br>";
			}

			if(errorMsg.length() > 0){
				request.setAttribute("errormsg", errorMsg);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/addIdError.jsp");
				rd.forward(request, response);
			}else{
				addUserBeans aUB = new addUserBeans();
				aUB.setUserId(userId);
				aUB.setUserMail(userMail);
				aUB.setUserName(userName);
				aUB.setUserPass(userPass01);
				request.setAttribute("aub", aUB);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/addFinalCheck.jsp");
				rd.forward(request, response);
			}
		}
	}
}