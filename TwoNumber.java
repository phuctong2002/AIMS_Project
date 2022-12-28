
import java.util.*;
public class TwoNumber {
	public static void main( String[] args) {
		Scanner sc = new Scanner( System.in);
		System.out.print("Enter first number: ");
		double num1 = sc.nextDouble();
		System.out.print("Enter second number: ");
		double num2 = sc.nextDouble();
		double sum = num1 + num2;
		double diff = num1 - num2;
		double product = num1 * num2;
		if( num2 != 0) {
			double quotient = num1 /num2;
			System.out.print("sum : " + sum + " diff: " + diff + " product :" + product + " quotient " + quotient);
		}else {
			System.out.print("sum : " + sum + " diff: " + diff + "product :" + product);
		}
		sc.close();
	}
	
}
