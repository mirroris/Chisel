package track;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
  
  public static void main(String[] args) {
    String[] lines = getStdin();
    Manager manager = new Manager();
    for (int i = 0, l = lines.length; i < l; i++) {
      Parser parser = new Parser(lines[i]);
      Time reqTime = parser.parseTime();
      String command = parser.parseCmd();
      switch(command){
        case "SELL":
          manager.sell(reqTime, parser.parseStr(), parser.parseStr(), parser.parseInt(), parser.parsePrice(), parser.parseTime());
        break;
        case "SELL_CANCEL":
          manager.sellCancel(reqTime, parser.parseStr(), parser.parseStr());
        break;
        case "BID":
          manager.bid(reqTime, parser.parseStr(), parser.parseStr(), parser.parseInt());
        break;
        case "BID_CANCEL":
          manager.bidCancel(reqTime, parser.parseStr(), parser.parseStr());
        break;
      }
    }
    manager.finish();
  }

  private static String[] getStdin() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> lines = new ArrayList<>();
    while (scanner.hasNext()) {
      lines.add(scanner.nextLine());
    }
    return lines.toArray(new String[lines.size()]);
  }

  
  public static boolean isNum(char c) {
	  if(c>='0' && c<='9') return true;
	  else return false;
  }


  public static boolean isLowc(char c){
    if(c>='a' && c<='z')return true;
    else return false;
  }

  
  public static boolean isCapc(char c){
    if(c>='A' && c<='Z')return true;
    else return false;
  }
}