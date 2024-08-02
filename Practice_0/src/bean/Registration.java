package bean;

public class Registration {
    private String eventId;
    private String userName;

    public Registration() {}
    
    public Registration(String eventId, String userName) {
		this.eventId = eventId;
		this.userName = userName;
	}
    
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
