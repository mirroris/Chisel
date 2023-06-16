package track;

public class Month extends Unit{
  public Month(int m, Year y) {
		lim = 12;
		time = m;
		pre = y;
	}
	
  public int getLim(){
    int []dates = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    return dates[time];
  } 

	@Override
	public int getF() {
    int []dates = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int sum = 0;
    for(int i=1;i<time;i++) sum+=dates[i];
		return sum*24*60;
	}
}