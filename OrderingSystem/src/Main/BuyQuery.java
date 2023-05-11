package Main;

public class BuyQuery extends Query{
	int foodNum;
	String foodName;
	String personName;
	
	public BuyQuery(String str) {
		super(str);
		personName = target.get(1);
		foodName = target.get(2);
		foodNum = Integer.parseInt(target.get(3));
		time = new TimeUnit(target.get(4));
	}	
	
	public int getTime() {
		return time.toMsec();
	}
	
	public String getFoodName() {
		return foodName;
	}
	
	public int getFoodNum() {
		return foodNum;
	}
	
	public String getPersonName() {
		return personName;
	}
}
