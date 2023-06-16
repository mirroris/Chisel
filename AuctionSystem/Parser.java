package track;
import track.App;

public class Parser {
  private String line = null;
  private int index = 0;
  private int len = 0;
  public Parser(String s){
    index = 0; 
    line = s;
    len = line.length();
  }

  public int parseInt(){
    int res = 0;
    while(index<len && !App.isNum(line.charAt(index))) index++;
    while(index<len && App.isNum(line.charAt(index))) {
      res = res*10 + (line.charAt(index)-'0');
      index++;
    }
    return res;
  }

  public int parsePrice(){
    int res = 0;
    while(index<len && !(App.isNum(line.charAt(index)) || line.charAt(index)=='-')) index++;
    if(line.charAt(index)=='-') index++;
    while(index<len && App.isNum(line.charAt(index))) {
      res = res*10 + (line.charAt(index)-'0');
      index++;
    }
    return res;
  } 


  public String parseStr(){
    String res = "";
    while(index<len && !App.isLowc(line.charAt(index))) index++;
    while(index<len && App.isLowc(line.charAt(index))) {
      res += line.charAt(index);
      index++;
    }
    return res;
  }

  public String parseCmd(){
    String res = "";
    while(index<len && !(App.isCapc(line.charAt(index)) || line.charAt(index)=='_')) index++;
    while(index<len && (App.isCapc(line.charAt(index)) || line.charAt(index)=='_')) {
      res += line.charAt(index);
      index++;
    }
    return res;
  }



  public Time parseTime(){
    return new Time(parseInt(), parseInt(), parseInt(), parseInt(), parseInt());
  }
}  