import java.util.Scanner;

public class Test8 {
    static Scanner sc;
    static int a, b, c; 

    static void nhap() {
        System.out.print("Nhap do dai canh a: ");
        a = sc.nextInt();
        System.out.print("\nNhap do dai canh b: ");
        b = sc.nextInt();
        System.out.print("\nNhap do dai canh c: ");
        c = sc.nextInt();
    }

    static void xet() {
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Khong hop le");
        } else if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Khong phai tam giac");
        } else {
            if (a == b && b == c) {
                System.out.println("Tam giac deu");
            } else if (a == b || a == c || b == c) {
                System.out.println("Tam giac can");
            } else {
                System.out.println("Tam giac scalene");
            }
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        nhap();
        xet();
    }
}
