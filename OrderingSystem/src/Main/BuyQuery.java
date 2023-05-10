package Main;

public class BuyQuery extends Query{
	private TimeUnit begin;
	int num;
	
	public BuyQuery(String str) {
		super(str);
		begin = new TimeUnit(target.get(1));
		num = Integer.parseInt(target.get(2));
	}	
	
}
