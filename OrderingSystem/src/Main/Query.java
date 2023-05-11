package Main;
import java.util.ArrayList;

public class Query {
	protected int id;
	protected ArrayList<String> target;
	protected TimeUnit time;
	
	public Query(String str){
		parseOrder(str);
		target = new ArrayList<String>();
		id = Integer.parseInt(target.get(0));
		
		int i = 0;
		int n = str.length();
		String elem = null;
		ArrayList<String> target = new ArrayList<>();
		while(i<n && Main.isNum(str.charAt(i))) {
			while(i<n && str.charAt(i)==' ') i++;
			while(i<n && str.charAt(i)!=' ') elem+=str.charAt(i);
			target.add(elem);
		}
	}
	
	ArrayList<String> getTarget() {
		return target;
	}
	
	int getId() {
		return id;
	}
}
