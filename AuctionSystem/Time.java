package track;

import java.util.ArrayList;

public class Time {
	private int[] setTime = {0, 0, 0, 0, 0};
  private String year;
  private String month;
  private String date;
  private String hour;
  private String minute;
	
	public Time(int y, int mon, int d, int h, int min) {
		setTime[0] = y;
		setTime[1] = mon;
		setTime[2] = d;
		setTime[3] = h;
		setTime[4] = min;
    String.valueOf(y);
    year = String.valueOf(y);
    month = stringBuild(mon);
    date = stringBuild(d);
    hour = stringBuild(h);
    minute = stringBuild(min);
	}	

  public String stringBuild(int i){
	  String s;
    if(i<10) s = "0" + String.valueOf(i);
    else s = String.valueOf(i);
    return s;
  }

  public boolean isEarlierthan(Time t){
    int []obj = t.getTimeArray();
    for(int i=0;i<5;i++){
      if(setTime[i]<obj[i]){
        return true;
      }else if(setTime[i] > obj[i]){
        return false;
      }
    }
    return true;
  }

  public int[] getTimeArray(){
    return setTime;
  }

  public String toFormat(){
    return year + "-" + month + "-" + date + "T" + hour + ":" + minute;
  }
}