

import java.util.Scanner;

public class Matrix {
	public static void main(String[] args) {
		int m,n;
		int a[][] = new int[100][100];
		int b[][] = new int[100][100];
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Kich thuoc cua ma tran: ");
		m = sc.nextInt();
		n = sc.nextInt();
		System.out.println("Nhap thong so cua ma tran thuc nhat:");
		for( int i = 0; i < m; ++i) {
			for( int j = 0; j < n; ++j) {
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println("Nhap thong so cua ma tran thuc hai:");
		for( int i = 0; i < m; ++i) {
			for( int j = 0; j < n; ++j) {
				b[i][j] = sc.nextInt();
			}
		}
		System.out.println("Tong hai ma tran");
		for( int i = 0; i < m; ++i) {
			for( int j = 0; j < n; ++j) {
				System.out.print( (a[i][j] + b[i][j]) + " ");
			}
			System.out.println("");
		}
		
		
		sc.close();
	}
}
