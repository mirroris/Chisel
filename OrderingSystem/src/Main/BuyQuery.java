package Main;

public class BuyQuery extends Query{
	private TimeUnit begin;
	int num;
	
	public BuyQuery(String str) {
		super(str);
		begin = new TimeUnit(target.get(2));
		num = Integer.parseInt(target.get(3));
	}	
	
	public int getTime() {
		return begin.toMsec();
	}
	
	public int getNum() {
		return num;
	}
	
	public String getPersonName() {
		return personName;
	}
}
