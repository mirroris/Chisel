package Main;

import java.util.Map;
import java.util.HashMap;

public class Handler {
	private Map<String, Integer> menu;
	private Map<String, String> orderWhat;
	private Map<String, Integer> orderWhen;
	
	public Handler(){
		menu = new HashMap<String, Integer>();
		orderWhat = new HashMap<String, String>();
		orderWhen = new HashMap<String, Integer>();
	}

	public void menuAdd(String s, int i) {
		menu.put(s, i);
		return;
	}
	
	public void complete(BuyQuery q) {
		String foodName = q.getFoodName();
		int foodNum = q.getFoodNum();
		String pname = q.getPersonName();
		int time = q.getTime();
		if(menu.get(foodName)==null) System.out.println("not allowed");
		else if(foodNum > menu.get(foodName)) {
			System.out.println("too much");
		}else {
			orderWhen.put(pname, time);
			orderWhat.put(pname, foodName);
			int rest = menu.get(foodName) - foodNum;
			menu.put(foodName, rest);
			System.out.println("OK");
		}
		return;
	}
	
	static void complete(OrderQuery q) {
		
		return;
	}
	
	static void complete(NoteQuery q) {
		return;
	}
	
	static void complete(ArrivalQuery q) {
		return;
	}
}
