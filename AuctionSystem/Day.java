package track;

public class Day extends Unit{
  public Day(int d, Month m) {
		lim = m.getLim();
		time = d;
		pre = m;
	}
	
	@Override
	public int getF() {
		return time*24*60;
	}
}