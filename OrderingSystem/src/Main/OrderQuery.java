package Main;

public class OrderQuery extends Query{
	private String foodName;
	private int foodNum;
	public OrderQuery(String line) {
		super(line);
		foodName = target.get(1);
		foodNum = Integer.parseInt(target.get(2));
		time = new TimeUnit(target.get(3));
	}
	
	public String getFoodName() {
		return foodName;
	}
	
	public int getFoodNum() {
		return foodNum;
	}
	
	public int getTime() {
		return time.toMsec();
	}
}
