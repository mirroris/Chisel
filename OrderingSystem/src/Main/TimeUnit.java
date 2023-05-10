package Main;
import java.util.ArrayList;

public class TimeUnit {
	private String line;
	private int index;
	private final int UNIT = 60;
	
	public TimeUnit(String str) {
		index = 0;
		line = str;
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
	
	public ArrayList<Integer> parseInt() {
		int reg = index;
		index = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(index<line.length()) {
			res.add(nextStep()); 
		}
		
		index = reg;
		return res;
	}
	
	public int toMsec() {	
		ArrayList<Integer> sub = parseInt();
		int res = 0;
		int hourUnit = UNIT*UNIT;
		for(int x: sub) {
			res += x*hourUnit;
			hourUnit/=UNIT;
		}
		return res;
	}
	
}
