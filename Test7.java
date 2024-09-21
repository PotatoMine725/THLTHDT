import java.util.Scanner;

public class Test7 {

    static Scanner sc;

    static int xep (int x, int y, int z) {
        int temp;
        temp = x;
        if (temp >= y && z >=y) {
            temp = y;
        }
        if (temp >=z && y >=z) {
            temp = z ;
        }
        return temp;
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("nhap A: ");
        int a = sc.nextInt();
        System.out.print("\nNhap B: ");
        int b = sc.nextInt();
        System.out.print("\nnhap C: ");
        int c = sc.nextInt();
        System.out.println("So nho nhat la: "+xep(a,b,c));
    }
    
}
