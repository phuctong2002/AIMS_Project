

import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tmp[] = new int[100];
		Scanner sc = new Scanner( System.in);
		System.out.print("Nhap so phan tu cua day: ");
		int n = sc.nextInt();
		int sum = 0;
		for( int i = 0; i < n; ++i) {
			System.out.print("Nhap phan tu so " + (i + 1) + " : ");
			tmp[i] = sc.nextInt();
			sum += tmp[i];
		}
		for( int i = 0; i < n; ++i) {
			for( int j = n -1; j > i; --j ) {
				if( tmp[j] < tmp[j -1]) {
					int a = tmp[j];
					tmp[j] = tmp[j -1];
					tmp[j - 1] = a;
				}
			}
		}
		for(int i = 0; i < n; ++i) {
			System.out.println(tmp[i]);
		}
		System.out.print("Sum : " + sum + ", avg: " + 1.0*sum/n);
		sc.close();
	}

}
