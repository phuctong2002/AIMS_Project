

import java.util.Scanner;

public class SystemFirstDegree {
	public static void main( String[] args) {
		double a11, a12, b1, b2, a21, a22;
		Scanner sc = new Scanner( System.in);
		System.out.print("a11 : ");
		a11 = sc.nextDouble();
		System.out.print( "a12 : ");
		a12 = sc.nextDouble();
		System.out.print( "b1 : ");
		b1 = sc.nextDouble();
		System.out.print("a21 : ");
		a21 = sc.nextDouble();
		System.out.print( "a22 : ");
		a22 = sc.nextDouble();
		System.out.print( "b1 : ");
		b2 = sc.nextDouble();
		double d = a11*a22 - a21*a12;
		double dx = b1*a22 - b2*a12;
		double dy = a11*b2 - a21*b1;
		if( d == 0 && dx == 0 && dy == 0) {
			System.out.println("He co vo so nghiem");
			System.exit(0);
		}
		if( d == 0 &&( dx == 0 || dy == 0 )) {
			System.out.println("He vo so nghiem");
			System.exit(0);
		}
		if( d != 0) {
			System.out.println("x : " + dx/d + "  y : " + dy/d);
		}
		sc.close();
	}
}
