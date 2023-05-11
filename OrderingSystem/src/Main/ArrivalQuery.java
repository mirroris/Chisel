package Main;

public class ArrivalQuery extends Query{
	String foodName;
	public ArrivalQuery(String line) {
		super(line);
		String foodName = target.get(2);
	}
}
