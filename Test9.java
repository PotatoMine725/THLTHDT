import java.util.Scanner;
public class Test9 {

    static Scanner sc;

    static void tinh (char c, int a, int b) {
        switch (c) {
            case '+':
                System.out.println("a+b= "+ (a+b));
                break;
            case '-':
                System.out.println("a-b= "+ (a-b));
                break;
            case '*':
                System.out.println("a*b= "+ (a*b));
                break;
            case '/':
                System.out.println("a/b= "+ (a+b));
                break;
            default:
                System.out.println("Nhap lai");
                break;
        }
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Moi nhap phep tinh: ");
        char pt = sc.next().charAt(0);
        System.out.print("\nNhap 2 so can tinh: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        tinh(pt,x,y);
    }
}
