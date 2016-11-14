package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeCalendarDAO {
	Connection con;
	static final String DATABASE_URL = "jdbc:mysql://localhost/wecalendar";
	static final String DATABASE_USER = "root";
	static final String DATABASE_PASWORD = "utsystem2016";

	public WeCalendarDAO(){
		connect();
	}

	//	データベース接続///////////////////////////////////////////////////
	protected boolean connect(){
		String msg = "";
		try{
			if(con != null){
				if(con.getWarnings() == null){
					return true;
				}
				disconnect();
			}
			try{
				Class.forName("com.mysql.jdbc.Driver");
				msg = "ドライバのロードに成功しました";
			}catch(ClassNotFoundException e){
				msg = "ドライバのロードに失敗しました";
			}

			con = DriverManager.getConnection(DATABASE_URL,DATABASE_USER,DATABASE_PASWORD);
			if(con.getWarnings() == null){
				return true;
			}
			disconnect();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	protected void disconnect(){
		if(con != null){
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			con = null;
		}
	}

	//	ユーザＩＤチェック/////////////////////////////////////////////////
	public boolean getUserId(String userId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM userdata WHERE user_id = ?");
			statement.setString(1, userId);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				rs.close();
				statement.close();
				return true;
			}else{
				rs.close();
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("ユーザＩＤチェックエラー");
		}
		return false;
	}

	//	ユーザメールチェック///////////////////////////////////////////////
	public boolean getUserMail(String sUMail){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM userdata WHERE user_mail = ?");
			statement.setString(1, sUMail);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				rs.close();
				statement.close();
				return true;
			}else{
				rs.close();
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("ユーザメールチェックエラー");
		}
		return false;
	}


	//	ユーザ登録/////////////////////////////////////////////////////////
	public void setUserData(String userId,String userName,
							String userMail,String userPass){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("INSERT INTO userdata VALUES(?,?,?,?)");
			statement.setString(1, userId);
			statement.setString(2, userName);
			statement.setString(3, userMail);
			statement.setString(4, userPass);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("ユーザ登録エラー");
		}
	}

	//	ユーザログインチェック/////////////////////////////////////////////
	public boolean loginUserCheck(String userId,String userPass){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM userdata WHERE user_id=? AND user_pass=? ");
			statement.setString(1, userId);
			statement.setString(2, userPass);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				rs.close();
				statement.close();
				return true;
			}else{
				rs.close();
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("ログインエラー");
		}
		return false;
	}


	//	ログインユーザ情報取り出し/////////////////////////////////////
	public String getLoginUserId(String id){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT user_id FROM userdata WHERE user_id = ? ");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				id = rs.getString("user_id");
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("id取得エラー");
		}
		return id;
	}
	public String getLoginUserName(String id){
		String name = "";
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT user_name FROM userdata WHERE user_id = ?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				name = rs.getString("user_name");
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("name取得エラー");
		}
		return name;
	}
	public String getLoginUserMail(String id){
		String mail = "";
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT user_mail FROM userdata WHERE user_id = ?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				mail = rs.getString("user_mail");
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("mail取得エラー");
		}
		return mail;
	}
	public String getLoginUserPass(String id){
		String pass = "";
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT user_pass FROM userdata WHERE user_id = ?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				pass = rs.getString("user_pass");
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("pass取得エラー");
		}
		return pass;
	}


	//	ユーザ情報更新/////////////////////////////////////////////////////
	public void updateUserData(String newUserId,String newUserName,
			String newUserMail,String newUserPass,String nowUserId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("UPDATE userdata SET user_id=?,user_name=?,"
							+ "user_mail=?,user_pass=? WHERE user_id=?");
			statement.setString(1, newUserId);
			statement.setString(2, newUserName);
			statement.setString(3, newUserMail);
			statement.setString(4, newUserPass);
			statement.setString(5, nowUserId);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("更新エラー");
		}
	}

	//	ユーザ情報削除/////////////////////////////////////////////////////
	public void deleteUserData(String userId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM userdata WHERE user_id=?");
			statement.setString(1, userId);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("削除エラー");
		}
	}

	//	スケジュール登録///////////////////////////////////////////////////
	public void setScedule(	String date,String startTime,String endTime,String attribute,
							String place,String title,String content,String authority,
							String createGroup,String createUser){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
				("INSERT INTO plandata(plan_day,start_time,end_time,plan_attribute,plan_place,plan_title,"
						+ "plan_content,view_authority,create_group_id,create_user_id)"
						+ " VALUES(?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, date);
			statement.setString(2, startTime);
			statement.setString(3, endTime);
			statement.setString(4, attribute);
			statement.setString(5, place);
			statement.setString(6, title);
			statement.setString(7, content);
			statement.setString(8, authority);
			statement.setString(9, createGroup);
			statement.setString(10, createUser);

			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("スケジュール登録エラー");
		}
	}

	//	スケジュール更新///////////////////////////////////////////////////
	public void updateScedule(int id,String date,String startTime,String endTime,String attribute,String place,
			String title,String content,String authority,String createGroup,String createUser){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
				("UPDATE plandata SET plan_day=?,start_time=?,end_time=?,plan_attribute=?,"
						+ "plan_place=?,plan_title=?,plan_content=?,view_authority=?,"
						+ "create_group_id=?,create_user_id=? WHERE plan_id=?");
			statement.setString(1, date);
			statement.setString(2, startTime);
			statement.setString(3, endTime);
			statement.setString(4, attribute);
			statement.setString(5, place);
			statement.setString(6, title);
			statement.setString(7, content);
			statement.setString(8, authority);
			statement.setString(9, createGroup);
			statement.setString(10, createUser);
			statement.setInt(11, id);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("スケジュール更新エラー");
		}
	}

	//	スケジュール削除///////////////////////////////////////////////////
	public void deleteSchedule(int id){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM plandata WHERE plan_id=?");
			statement.setInt(1, id);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("スケジュール削除エラー");
		}
	}


	//	ユーザスケジュール一括削除///////////////////////////////////////////////////
	public void deleteUserSchedule(String userid){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("DELETE FROM plandata WHERE create_user_id=? AND view_authority='個人'");
			statement.setString(1, userid);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("スケジュール削除エラー");
		}
	}


	//	グループスケジュール一括削除///////////////////////////////////////////////////
	public void deleteGroupSchedule(String groupid){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("DELETE FROM plandata WHERE create_group_id=?");
			statement.setString(1, groupid);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("スケジュール削除エラー");
		}
	}

	//	スケジュール情報取得///////////////////////////////////////////////
	public ScheduleBeans getPlanData(int id){
		connect();
		ScheduleBeans sb = new ScheduleBeans();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM plandata WHERE plan_id=? ");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				sb.setPlanId(rs.getInt("plan_id"));
				sb.setDate(rs.getString("plan_day"));
				sb.setStartTime(rs.getString("start_time"));
				sb.setEndTime(rs.getString("end_time"));
				sb.setAttribute(rs.getString("plan_attribute"));
				sb.setPlace(rs.getString("plan_place"));
				sb.setTitle(rs.getString("plan_title"));
				sb.setContent(rs.getString("plan_content"));
				sb.setAuthority(rs.getString("view_authority"));
				sb.setCreateGroup(rs.getString("create_group_id"));
				sb.setCreateUser(rs.getString("create_user_id"));
			}else{
				return null;
			}
			rs.close();
			statement.close();
			return sb;
		} catch (SQLException e) {
			System.out.println("schedule取得エラー");
		}
		return null;
	}

	//	グループID取得///////////////////////////////////////////////
	public boolean getGroupId(String id){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM groupdata WHERE group_id = ?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				rs.close();
				statement.close();
				return true;
			}else{
				rs.close();
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("ユーザＩＤチェックエラー");
		}
		return false;
	}

	//	グループpass取得///////////////////////////////////////////////
	public String getGroupPass(String id){
		String pass = "";
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM groupdata WHERE group_id = ?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				pass = rs.getString("group_pass");
				rs.close();
				statement.close();
			}else{
				rs.close();
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("ユーザＩＤチェックエラー");
		}
		return pass;
	}

	//	グループ情報取得///////////////////////////////////////////////
	public GroupBeans getGroupData(String id){
			connect();
			GroupBeans gB = new GroupBeans();
			try {
				PreparedStatement statement = con.prepareStatement
						("SELECT * FROM groupdata WHERE group_id=? ");
				statement.setString(1, id);
				ResultSet rs = statement.executeQuery();
				if(rs.next()){
					gB.setGroupId(rs.getString("group_id"));
					gB.setGroupName(rs.getString("group_name"));
					gB.setGroupPass(rs.getString("group_pass"));
					gB.setAdministrator(rs.getString("group_administrator"));
				}else{
					return null;
				}
				rs.close();
				statement.close();
				return gB;
			} catch (SQLException e) {
				System.out.println("group情報取得エラー");
			}
			return null;
		}

	//	グループ管理者ID取得///////////////////////////////////////////////
	public String getGroupAdministrator(String id){
			connect();
			String groupAdministrator = "";
			try {
				PreparedStatement statement = con.prepareStatement
						("SELECT * FROM groupdata WHERE group_id=? ");
				statement.setString(1, id);
				ResultSet rs = statement.executeQuery();
				if(rs.next()){
					groupAdministrator = rs.getString("group_administrator");
				}else{
					return "";
				}
				rs.close();
				statement.close();
				return groupAdministrator;
			} catch (SQLException e) {
				System.out.println("group情報取得エラー");
			}
			return "";
		}



	//	グループ情報登録///////////////////////////////////////////////
	public void addGroupData(String id,String name,String pass,String administrator){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("INSERT INTO groupdata VALUES(?,?,?,?)");
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, pass);
			statement.setString(4, administrator);;
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("グループ登録エラー");
		}
	}

	//	グループ情報変更///////////////////////////////////////////////
	public void updateGroupData(String nowId,String newId,String newName,String newPass){
		connect();
		try {
			PreparedStatement statement01 = con.prepareStatement
					("UPDATE groupdata SET group_id=?,group_name=?,group_pass=? WHERE group_id=?");
			statement01.setString(1,newId);
			statement01.setString(2,newName);
			statement01.setString(3,newPass);
			statement01.setString(4,nowId);
			statement01.executeUpdate();
			statement01.close();
			System.out.println("グループ更新完了");
		} catch (SQLException e) {
			System.out.println("グループ更新エラー");
		}
	}

	//	グループ情報削除///////////////////////////////////////////////
	public void deleteGroupData(String groupId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("DELETE FROM groupdata WHERE group_id=?");
			statement.setString(1, groupId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("グループ削除エラー");
		}
		try {
			PreparedStatement statement = con.prepareStatement
					("DELETE FROM affiliationgroup WHERE group_id=?");
			statement.setString(1, groupId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("所属グループ削除エラー");
		}
	}

	//	作成グループ情報一括削除///////////////////////////////////////////////
	public void deleteCreateGroupData(String userId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("DELETE FROM groupdata WHERE group_administrator=?");
			statement.setString(1, userId);
			int r = statement.executeUpdate();
			statement.close();
			System.out.println("グループ削除完了");
		} catch (SQLException e) {
			System.out.println("グループ削除エラー");
		}
	}

	//	グループメンバ取得///////////////////////////////////////////////
	public boolean getGroupMember(String userId,String groupId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM affiliationgroup WHERE user_id = ? AND group_id=?");
			statement.setString(1, userId);
			statement.setString(2, groupId);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				rs.close();
				statement.close();
				return true;
			}else{
				rs.close();
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("グループメンバ取得エラー");
		}
		return false;
	}

	//	グループメンバー表示///////////////////////////////////////////////
	public String displayGroupMember(String groupId){
		String member = "";
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM affiliationgroup WHERE group_id=? ORDER BY user_id");
			statement.setString(1, groupId);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){ member += rs.getString("user_id") + "<br>";}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("グループメンバ取得エラー");
		}
		return member;
	}


	//	グループメンバー追加///////////////////////////////////////////////
	public void addGroupMember(String memberId,String groupId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("INSERT INTO affiliationgroup VALUES(?,?)");
			statement.setString(1, memberId);
			statement.setString(2, groupId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("グループメンバ追加エラー");
		}
	}


	//	グループメンバー情報更新（グループID変更時）/////////////////////////////
	public void updateGroupMember(String nowId,String newId){
		try {
			PreparedStatement statement01 = con.prepareStatement
					("UPDATE affiliationgroup SET group_id=? WHERE group_id=?");
			statement01.setString(1,newId);
			statement01.setString(2,nowId);
			statement01.executeUpdate();
			statement01.close();
			System.out.println("所属グループ更新完了");
		} catch (SQLException e) {
			System.out.println("所属グループ更新エラー");
		}
	}

	//	グループメンバー削除///////////////////////////////////////////////
	public void deleteGroupMember(String memberId,String groupId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("DELETE FROM affiliationgroup WHERE user_id=? AND group_id=?");
			statement.setString(1, memberId);
			statement.setString(2, groupId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("グループメンバー削除エラー");
		}
	}

	//	グループ全メンバー一括削除（グループID削除時）///////////////////////////////
	public void deleteGroupAllMember(String groupId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("DELETE FROM affiliationgroup WHERE group_id=?");
			statement.setString(1, groupId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("グループメンバー削除エラー");
		}
	}

	//	作成全グループ全メンバー一括削除(ユーザID削除時)/////////////////////////////
	public void deleteCreateAllGroupAllMember(String userId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM groupdata WHERE group_administrator=?");
			statement.setString(1, userId);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){deleteGroupAllMember(rs.getString("group_id"));}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("作成全グループ全メンバー削除エラー");
		}
	}


}
