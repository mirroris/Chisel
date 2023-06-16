package track;

public class Hour extends Unit{
	public Hour(int h, Day d) {
		lim = 24;
		time = h;
		pre = d;
	}
	
	@Override
	public int getF() {
		return lim*60;
	}
}