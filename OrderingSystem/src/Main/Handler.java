package Main;

import java.util.Map;
import java.util.HashMap;

public class Handler {
	private Map<String, Integer> menu;
	private Map<String, String> orderWhat;
	private Map<String, Integer> orderWhen;
	
	Handler(){
		menu = new HashMap<String, Integer>();
	}

	public void menuAdd(String s, int i) {
		menu.put(s, i);
		return;
	}
	
	static void complete(BuyQuery q) {
		int num = q.getNum();
		String pname = q.getPersonName();
		int time = q.getTime();
		
	}
	
	static void complete(OrderQuery q) {
		
	}
	
	static void complete(NoteQuery q) {
		
	}
	
	static void complete(ArrivalQuery q) {
		
	}
}
