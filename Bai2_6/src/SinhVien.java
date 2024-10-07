import java.util.Scanner;

public class SinhVien {

    String MSV;
    String NamSinh;
    String Ten;
    double DTB;
    Scanner sc;

    public void NhapSV() {
        sc = new Scanner(System.in);
        System.out.println("Nhap msv: ");
        MSV = sc.nextLine();
        System.out.println("Nhap ten sinh vien:");
        Ten = sc.nextLine();
        System.out.println("Nhap ngay sinh: ");
        NamSinh = sc.nextLine();
        System.out.println("Nhao diem trung binh: ");
        DTB = sc.nextDouble();
    }

    public void XuatSV() {
        System.out.println("\nTen: "+ Ten);
        System.out.println("MSV: "+ MSV);
        System.out.println("Nam sinh: "+NamSinh);
        System.out.println("Diemm tb: "+DTB+"\n");
    }

    public SinhVien (){
        
    }

}
