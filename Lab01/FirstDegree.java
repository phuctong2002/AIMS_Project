

import java.util.Scanner;

public class FirstDegree {
	public static void main( String[] args) {
		double a, b;
		Scanner sc = new Scanner( System.in);
		System.out.print("Nhap so a ( khac 0) : ");
		a = sc.nextDouble();
		if( a == 0) {
			System.out.println("Loi so a = 0");
			System.exit(0);
		}
		System.out.print("Nhap so b :");
		b = sc.nextDouble();
		System.out.println("Nguyen cua phuong tinh ax + b = 0 la : " + -b/a);		
		sc.close();
	}
}
