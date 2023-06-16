package track;

public class Unit {
	protected int time;
	protected int lim;
	protected Unit pre;
	
	public void getDecr() {
		if(time==0) {
			pre.getDecr();
			time += lim;
		}
		time--;
  }

	public int getInt() {
		return time;
	}
	
	public int getF() {
		return time;
	}
	
	public void sub(int v) {
		if(time-v<0) {
			pre.getDecr();
			time += lim;
		}
		time -= v;
	}

  public void addOne(){
    if(time+1>lim){
      pre.addOne();
      time = 0;
    }else time++;
  }
  
  public String toStr() {
	  return String.valueOf(time);
  }
}

