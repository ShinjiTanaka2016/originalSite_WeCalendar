package model;
import java.io.Serializable;

public class LoginUserBeans implements Serializable{
	private String userId;
	private String userName;
	private String userMail;
	private String userPass;
	private String usersGroup;

	public LoginUserBeans(){}

	public String getUserId() {return userId;}
	public String getUserName() {return userName;}
	public String getUserMail() {return userMail;}
	public String getUserPass() {return userPass;}
	public String getUsersGroup() {return usersGroup;}

	public void setUserId(String userId) {this.userId = userId;}
	public void setUserName(String userName) {this.userName = userName;}
	public void setUserMail(String userMail) {this.userMail = userMail;}
	public void setUserPass(String userPass) {this.userPass = userPass;}
	public void setUsersGroup(String usersGroup) {this.usersGroup = usersGroup;}
}
