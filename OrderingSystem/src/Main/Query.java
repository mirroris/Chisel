package Main;
import java.util.ArrayList;

public class Query {
	protected int id;
	protected ArrayList<String> target;
	public Query(String str){
		parseOrder(str);
		target = new ArrayList<String>();
		id = Integer.parseInt(target.get(0));
	}
	
	ArrayList<String> parseOrder(String str) {
		int i = 0;
		int id = 0;
		int n = str.length();
		String elem = null;
		ArrayList<String> res = new ArrayList<>();
		while(i<n && Main.isNum(str.charAt(i))) {
			while(i<n && str.charAt(i)==' ') i++;
			while(i<n && str.charAt(i)!=' ') elem+=str.charAt(i);
			res.add(elem);
		}
		return res;
	}
	
	int getId() {
		return id;
	}
}
