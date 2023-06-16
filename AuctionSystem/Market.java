package track;

import java.util.HashMap;
import java.util.Map;

public class Market {
	private Map<String, Integer> curPrice;
	private String curOwner;
	private int maxPrice;
	
	public int size() {
		return curPrice.size();
	}
	
	public Market(){
		curPrice = new HashMap<String, Integer>();
		maxPrice = 0;
		curOwner = "";
	}
	
	public int getCurPrice(String usrId) {
		int price = 0;
		if(curPrice.containsKey(usrId)) price = curPrice.get(usrId);
		return price;
	}
	
	public void updatePrice(String usrId, int price) {
		curPrice.put(usrId, price);
		update();
		return;
	}
	
	public void update() {
		for (Map.Entry<String, Integer> entry : curPrice.entrySet()) {
		  if (entry.getValue() > maxPrice) {
		    curOwner = entry.getKey();
		    maxPrice = entry.getValue();
		  }
		}
		return;
	}
	
	public int getMaxPrice() {
		return maxPrice;
	}
	
	public String getCurOwner() {
		return curOwner;
	}
  
	public void cancel(String usrId) {
		curPrice.remove(usrId);
		update();
		return;
	}
	
  
	public boolean contains(String usrId) {
		return curPrice.containsKey(usrId);
	}
}
