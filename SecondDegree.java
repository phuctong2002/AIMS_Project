
import java.util.Scanner;
import java.lang.Math;
public class SecondDegree {
	public static void main( String[] args) {
		Scanner sc = new Scanner( System.in);
		double a, b,c;
		System.out.print("Nhap 3 so a b c : ");
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		double delta = b*b - 4*a*c;
		if( delta < 0) {
			System.out.println("Phuong trinh da cho vo nghiem");
			System.exit(0);
		}
		if( delta == 0) {
			System.out.println("Phuong trinh co nghiem kep :  " + -b/(2*a));
			System.exit(0);
		}
		System.out.println("Nghiem thu nhat : " + -(b + Math.sqrt(delta))/(2*a));
		System.out.println("Nghiem thu hai : " + -(b - Math.sqrt(delta))/(2*a));
		sc.close();
	}
}
