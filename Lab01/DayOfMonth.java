
import java.util.Scanner;
public class DayOfMonth {
	public static void main(String[] args) {
		int[] tmp1 = {1,3,5,7,8,10,12};
		int[] tmp2 = {4,6,9,11};
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap thang can tim kiem : ");
		int month = sc.nextInt();
		System.out.print("Nhap nam : ");
		int year = sc.nextInt();
		if( month <=0|| month > 12) {
			System.out.print("Khong hop le ");
			System.exit(0);
		}
		if( month == 2) {
			if( year %4 == 0) {
				System.out.println("Thang can tim co 29 ngay");
				System.exit(0);
			}
			System.out.println("Thang can tim co 28 ngay");
			System.exit(0);
		}
		for( int i : tmp1) {
			if( i == month) {
				System.out.println("Thang co 31 ngay");
				System.exit(0);
			}
		}
		for( int i : tmp2) {
			if( i == month) {
				System.out.println("Thang da cho co 30 ngay");
				System.exit(0);
			}
		}
		sc.close();
	}
}
