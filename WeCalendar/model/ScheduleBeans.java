package model;
import java.io.Serializable;

public class ScheduleBeans implements Serializable {

	private int planId;
	private String date;
	private String startTime;
	private String endTime;
	private String attribute;
	private String place;
	private String title;
	private String content;
	private String authority;
	private String createGroup;
	private String createUser;

	public ScheduleBeans(){}
	public ScheduleBeans(int id,String data,String startTime,String endTime,String attribute,String place,
			String title,String content,String authority,String createGroup,String createUser){
		this.planId = id;
		this.date = data;
		this.startTime = startTime;
		this.endTime = endTime;
		this.attribute = attribute;
		this.place = place;
		this.title = title;
		this.content = content;
		this.authority = authority;
		this.createGroup = createGroup;
		this.createUser = createUser;
	}

	public int getPlanId() {return planId;}
	public String getDate() {return date;}
	public String getStartTime() {return startTime;}
	public String getEndTime() {return endTime;}
	public String getAttribute() {return attribute;}
	public String getPlace() {return place;}
	public String getTitle() {return title;}
	public String getContent() {return content;}
	public String getAuthority() {return authority;}
	public String getCreateGroup() {return createGroup;}
	public String getCreateUser() {return createUser;}

	public void setPlanId(int planId) {this.planId = planId;}
	public void setDate(String date) {this.date = date;}
	public void setStartTime(String startTime) {this.startTime = startTime;}
	public void setEndTime(String endTime) {this.endTime = endTime;}
	public void setAttribute(String attribute) {this.attribute = attribute;}
	public void setPlace(String place) {this.place = place;}
	public void setTitle(String title) {this.title = title;}
	public void setContent(String content) {this.content = content;}
	public void setAuthority(String authority) {this.authority = authority;}
	public void setCreateGroup(String createGroup) {this.createGroup = createGroup;}
	public void setCreateUser(String createUser) {this.createUser = createUser;}
}
