import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String line = "";
		while(!(line = scanner.nextLine()).isEmpty()) {
			TimeUnit tu = new TimeUnit(line);
			ArrayList<Integer> time = tu.parseInt();
			for(int i=0;i<time.size();i++) {
				System.out.println("time["+i+"] = "+ time.get(i));
			}
			int msec = tu.toMsec();
			System.out.println("msec = "+ msec);
		}
		scanner.close();
	}

}
