package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDAO {
	Connection con;
	static final String DATABASE_URL = "jdbc:mysql://localhost/wecalendar";
	static final String DATABASE_USER = "root";
	static final String DATABASE_PASWORD = "utsystem2016";

	public GroupDAO(){
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

	//	グループメンバ確認///////////////////////////////////////////////
	public boolean getGroupMember(String id,String member){
		connect();
		String allMember = "";
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM groupdata WHERE group_id=?");
			statement.setString(1,id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				allMember += rs.getString("group_membar");
				rs.close();
				statement.close();
			}else{
				rs.close();
				statement.close();
				return false;
			}
			rs.close();
			statement.close();
			if(allMember.contains(member)){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("グループメンバーチェックエラー");
		}
		return false;
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
	public void addGroupData(String id,String name,String pass,String createUser,String member){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("INSERT INTO groupdata VALUES(?,?,?,?,?)");
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, pass);
			statement.setString(4, member);;
			statement.setString(5, createUser);
			int r = statement.executeUpdate();
			statement.close();
			System.out.println("グループ登録完了");
		} catch (SQLException e) {
			System.out.println("グループ登録エラー");
		}
	}

	//	グループ情報変更///////////////////////////////////////////////
	public void updateGroupData(String id,String newId,String newName,String newPass){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("UPDATE groupdata SET group_id=?,group_name=?,group_pass=? WHERE group_id=?");
			statement.setString(1, newId);
			statement.setString(2, newName);
			statement.setString(3, newPass);
			statement.setString(4, id);
			int r = statement.executeUpdate();
			statement.close();
			System.out.println("グループ更新完了");
		} catch (SQLException e) {
			System.out.println("グループ更新エラー");
		}
	}

	//	グループ情報削除///////////////////////////////////////////////
	public void deleteGroupData(String id){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("DELETE FROM groupdata WHERE group_id=?");
			statement.setString(1, id);
			int r = statement.executeUpdate();
			statement.close();
			System.out.println("グループ削除完了");
		} catch (SQLException e) {
			System.out.println("グループ削除エラー");
		}
	}

	//	グループメンバー追加///////////////////////////////////////////////
	public void updateGroupMember(String id,String member){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("UPDATE groupdata SET group_membar=CONCAT(group_membar,?) WHERE group_id=?");
			System.out.println(id);
			System.out.println(member);
			statement.setString(1, member);
			statement.setString(2, id);
			int r = statement.executeUpdate();
			statement.close();
			System.out.println("グループメンバ更新完了");
		} catch (SQLException e) {
			System.out.println("グループメンバ更新エラー");
		}
	}

	//	グループメンバー削除///////////////////////////////////////////////
	public void deleteGroupMember(String id,String member){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("UPDATE groupdata SET group_member = REPLACE(groupmember, '/?/', '/') WHERE group_id=?");
			statement.setString(1, member);
			statement.setString(2, id);
			int r = statement.executeUpdate();
			statement.close();
			System.out.println("グループメンバー削除完了");
		} catch (SQLException e) {
			System.out.println("グループメンバー削除エラー");
		}
	}

}
