package track;

public class Minute extends Unit{
	public Minute(int m, Hour h) {
		lim = 60;
		time = m;
		pre = h;
	}
	
	@Override
	public int getF() {
		return time;
	}
}
