package model;
import java.io.Serializable;

public class GroupBeans implements Serializable{
	private String groupId;
	private String groupName;
	private String groupPass;
	private String administrator;

	public GroupBeans(){}

	public GroupBeans(String id,String name,String pass,String administrator){
		setGroupId(id);
		setGroupName(name);
		setGroupPass(pass);
		setAdministrator(administrator);
	}

	public String getGroupId() {return groupId;}
	public String getGroupName() {return groupName;}
	public String getGroupPass() {return groupPass;}
	public String getAdministrator() {return administrator;}

	public void setGroupId(String groupId) {this.groupId = groupId;}
	public void setGroupName(String groupName) {this.groupName = groupName;}
	public void setGroupPass(String groupPass) {this.groupPass = groupPass;}
	public void setAdministrator(String administrator) {this.administrator = administrator;}
}
