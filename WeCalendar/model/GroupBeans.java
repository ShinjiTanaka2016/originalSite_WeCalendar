package model;
import java.io.Serializable;

public class GroupBeans implements Serializable{
	private String groupId;
	private String groupName;
	private String groupPass;
	private String createUser;
	private String groupMember;

	public GroupBeans(){}

	public GroupBeans(String id,String name,String pass,String createUser){
		setGroupId(id);
		setGroupName(name);
		setGroupPass(pass);
		this.setCreateUser(createUser);
	}

	public String getGroupId() {return groupId;}
	public String getGroupName() {return groupName;}
	public String getGroupPass() {return groupPass;}
	public String getCreateUser() {return createUser;}
	public String getGroupMember() {return groupMember;}

	public void setGroupId(String groupId) {this.groupId = groupId;}
	public void setGroupName(String groupName) {this.groupName = groupName;}
	public void setGroupPass(String groupPass) {this.groupPass = groupPass;}
	public void setCreateUser(String createUser) {this.createUser = createUser;}
	public void setGroupMember(String groupMember) {this.groupMember = groupMember;}
}
