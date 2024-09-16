import java.util.Scanner;

public class Test2 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so tien ban dau: ");
        double Goc = scanner.nextDouble();
        System.out.print("\nNhap lai suat hang nam (%): ");
        double i = scanner.nextDouble();
        i = i/100;
        System.out.print("\nNhap so thang gui: ");
        int m = scanner.nextByte();
        double Lai = Goc*i*(m*30.0/365);
        Lai = Math.round(Lai); // làm tròn tiền lãi
        long Lai_int = (long) Lai; // ép kiểu
        double G_cuoi = Goc + Lai;
        long G_cuoi_long = (long) G_cuoi;
        System.out.print("\nSo tien lai la: "+ Lai_int);
        System.out.print("\nTien goc cuoi ky la: "+ G_cuoi_long);
    }
}
