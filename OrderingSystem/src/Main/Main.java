package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Handler handler = new Handler();
		for(int i=0;i<n;i++) {
			String foodName = scanner.next();
			int rest = scanner.nextInt();
			handler.menuAdd(foodName, rest);
		}
		String line = "";
		while(!(line = scanner.nextLine()).isEmpty()) {
			switch(line.charAt(0)) {
				case '1':
					handler.complete(new BuyQuery(line));
					break;
				case '2':
					handler.complete(new OrderQuery(line));
					break;
				case '3':
					handler.complete(new ArrivalQuery(line));
					break;
				case '4':
					handler.complete(new NoteQuery(line));
					break;
			}
		}
		scanner.close();
	}
	

	static boolean isNum(char n) {
		if( n>='0' && n<='9')return true;
		else return false;
	}
}
