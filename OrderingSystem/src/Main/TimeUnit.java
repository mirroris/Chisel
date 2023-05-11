package Main;
import java.util.ArrayList;

public class TimeUnit {
	private String line;
	private int index;
	private final int UNIT = 60;
	ArrayList<Integer> timeSlice;
	
	public TimeUnit(String str) {
		index = 0;
		line = str;
		ArrayList<Integer> timeSlice = new ArrayList<Integer>();
		while(index<line.length()) {
			timeSlice.add(nextStep()); 
		}
		
		index = 0;
	}
	
	public int nextStep() {
		int res = 0;
		while(index<line.length() && !Main.isNum(line.charAt(index))) index++;
		while(index<line.length() && Main.isNum(line.charAt(index))) {
			res = res*10 + (line.charAt(index)-'0');
			index++;
		}
		return res;
	}
	
	public ArrayList<Integer> getTimeSlice() {
		return timeSlice;
	}
	
	public int toMsec() {	
		ArrayList<Integer> sub = getTimeSlice();
		int res = 0;
		int hourUnit = UNIT*UNIT;
		for(int x: sub) {
			res += x*hourUnit;
			hourUnit/=UNIT;
		}
		return res;
	}
	
	public void procTime(TimeUnit addTime) {
		ArrayList<Integer> tar = getTimeSlice();
		ArrayList<Integer> sub = addTime.getTimeSlice();
		int c = 0;
		for(int i=tar.size()-1;i>=0;i--) {
			int x = sub.get(i) + c;
			if(x>=UNIT) {
				tar.add(0, x%UNIT);
				c++;
			}else tar.add(0, x);
		}
		return; 
	}
}
