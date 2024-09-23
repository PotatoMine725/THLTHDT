import java.util.Scanner;

public class Test10 {
    static Scanner sc;

    static int cal (int n) {
        int S = 0;
        for (int i = 1; i <= n; i++) {
            S = S + i;
        }
        return S;
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Nhap N: ");
        int N = sc.nextInt();
        System.out.print("\nTong cac so tu 1 toi n la: "+cal(N));
    }
}
