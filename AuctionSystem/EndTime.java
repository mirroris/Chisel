package track;

public class EndTime {
	private Time endTime;
	private String itemId;
	
	public EndTime(String id, Time t) {
		itemId = id;
		endTime = t;
	}
	
	public Time getTime() {
		return endTime;
	}
	
	public String getId() {
		return itemId;
	}
}
