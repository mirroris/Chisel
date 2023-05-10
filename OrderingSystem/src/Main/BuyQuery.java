package Main;

public class BuyQuery extends Query{
	private TimeUnit begin;
	int foodNum;
	String foodName;
	String personName;
	
	public BuyQuery(String str) {
		super(str);
		personName = target.get(1);
		foodName = target.get(2);
		foodNum = Integer.parseInt(target.get(3));
		begin = new TimeUnit(target.get(4));
	}	
	
	public int getTime() {
		return begin.toMsec();
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
