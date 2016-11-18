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
import model.WeCalendarDAO;

/**
 * Servlet implementation class AddGroupMenberCheck
 */
@WebServlet("/AddGroupMenberCheck")
public class AddGroupMenberCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String errorMsg = "";
		WeCalendarDAO wcDAO = new WeCalendarDAO();

		//	グループデータ受け取り
		String groupId = request.getParameter("groupid");
		String groupName = request.getParameter("groupname");
		String groupPass = request.getParameter("grouppass");
		String administrator = request.getParameter("createuser");

		//	メンバーデータ受け取り
		String member1 = request.getParameter("member1");
		String member2 = request.getParameter("member2");
		String member3 = request.getParameter("member3");
		String member4 = request.getParameter("member4");
		String member5 = request.getParameter("member5");
		String member6 = request.getParameter("member6");

		//	ユーザIDチェック
		if(member1.length()>0 && wcDAO.getUserId(member1)==false)
			{ errorMsg += member1 +"<br>";member1 = "";}
		if(member2.length()>0 && wcDAO.getUserId(member2)==false)
			{ errorMsg += member2 +"<br>";member2 = "";}
		if(member3.length()>0 && wcDAO.getUserId(member3)==false)
			{ errorMsg += member3 +"<br>";member3 = "";}
		if(member4.length()>0 && wcDAO.getUserId(member4)==false)
			{ errorMsg += member4 +"<br>";member4 = "";}
		if(member5.length()>0 && wcDAO.getUserId(member5)==false)
			{ errorMsg += member5 +"<br>";member5 = "";}
		if(member6.length()>0 && wcDAO.getUserId(member6)==false)
			{ errorMsg += member6 +"<br>";member6 = "";}
		if(errorMsg.length()>0){
			errorMsg += "<br>上記ユーザIDは存在しません。登録をキャンセルしました。<br>";
		}

		//	グループテーブル作成
		wcDAO.addGroupData(groupId, groupName, groupPass, administrator);

		//	所属グループテーブル作成
		if(wcDAO.getGroupMember(administrator, groupId)==false){
			wcDAO.addGroupMember(administrator, groupId);
		}


		if(member1.length()>0 && wcDAO.getGroupMember(member1, groupId)==false){
			wcDAO.addGroupMember(member1, groupId);
			}
		if(member2.length()>0 && wcDAO.getGroupMember(member2, groupId)==false){
			wcDAO.addGroupMember(member2, groupId);
			}
		if(member3.length()>0 && wcDAO.getGroupMember(member3, groupId)==false){
			wcDAO.addGroupMember(member3, groupId);
			}
		if(member4.length()>0 && wcDAO.getGroupMember(member4, groupId)==false){
			wcDAO.addGroupMember(member4, groupId);
			}
		if(member5.length()>0 && wcDAO.getGroupMember(member5, groupId)==false){
			wcDAO.addGroupMember(member5, groupId);
		}
		if(member6.length()>0 && wcDAO.getGroupMember(member6, groupId)==false){
			wcDAO.addGroupMember(member6, groupId);
		}

		//	グループログイン処理
		HttpSession session = request.getSession();
		GroupBeans gb = new GroupBeans();
		gb.setGroupId(groupId);
		gb.setGroupName(groupName);
		gb.setGroupPass(groupPass);
		gb.setAdministrator(administrator);
		session.setAttribute("groupdata", gb);

		request.setAttribute("msg", errorMsg);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/addGroupCompleteResult.jsp");
		rd.forward(request, response);
	}
}