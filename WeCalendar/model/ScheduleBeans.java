package model;
import java.io.Serializable;

public class ScheduleBeans implements Serializable {

	private int planId;
	private String date;
	private String time;
	private String attribute;
	private String place;
	private String title;
	private String content;
	private String authority;
	private String createGroup;
	private String createUser;

	public ScheduleBeans(){}

	public int getPlanId() {return planId;}
	public String getDate() {return date;}
	public String getTime() {return time;}
	public String getAttribute() {return attribute;}
	public String getPlace() {return place;}
	public String getTitle() {return title;}
	public String getContent() {return content;}
	public String getAuthority() {return authority;}
	public String getCreateGroup() {return createGroup;}
	public String getCreateUser() {return createUser;}

	public void setPlanId(int planId) {this.planId = planId;}
	public void setDate(String date) {this.date = date;}
	public void setTime(String time) {this.time = time;}
	public void setAttribute(String attribute) {this.attribute = attribute;}
	public void setPlace(String place) {this.place = place;}
	public void setTitle(String title) {this.title = title;}
	public void setContent(String content) {this.content = content;}
	public void setAuthority(String authority) {this.authority = authority;}
	public void setCreateGroup(String createGroup) {this.createGroup = createGroup;}
	public void setCreateUser(String createUser) {this.createUser = createUser;}
}
