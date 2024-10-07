import java.util.Scanner;

public class Bai2_6 {

    static int spt;
    static Scanner sc;

    //nhập sinh viên
    public static void Nhap(SinhVien[] SV) {
        for (int i = 0; i < spt; i++) {
            System.out.println("Nhap sinh vien thu " + (i + 1) + " ");
            SV[i] = new SinhVien();
            SV[i].NhapSV();
        }
    }

    //xuất sinh viên
    public static void Xuat(SinhVien[] SV) {
        System.out.println("\nDanh sach sinh vien:\n");
        for (int i = 0; i < spt; i++) {
            SV[i].XuatSV();
        }
    }

    //sắp xếp sinh viên theo dtb
    public static void Xep(SinhVien[] SV) {
        SinhVien tg = new SinhVien();
        for (int i = 0; i < spt - 1; i++) {
            for (int j = i + 1; j < spt; j++) {
                if (SV[i].DTB < SV[j].DTB) {
                    tg = SV[i];
                    SV[i] = SV[j];
                    SV[j] = tg;
                }
            }
        }
        System.out.println("\nDanh sach sinh vien sau khi sap xep theo DTB:\n");
        Xuat(SV);
    } 
    
    //tìm kiếm sinh viên theo msv
    public static void Tim(SinhVien[] SV) {
        System.out.println("Nhap msv can tim: ");
        String ma = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < spt; i++) {
            if (SV[i].MSV.equals(ma)) {
                System.out.println("\nThong tin sinh vien voi ma " + ma + ":");
                SV[i].XuatSV();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien voi ma " + ma);
        }
    }

    //thêm sinh viên
    public static SinhVien[] Them(SinhVien[] SV) {
        spt++;
        SinhVien[] SVmoi = new SinhVien[spt]; 
        for (int i = 0; i < spt - 1; i++) {
            SVmoi[i] = SV[i];
        }
        System.out.println("Nhap thong tin sinh vien moi:");
        SVmoi[spt - 1] = new SinhVien();
        SVmoi[spt - 1].NhapSV();
        return SVmoi; 
    }

    //xóa sinh viên
    public static SinhVien[] Xoa(SinhVien[] SV) {
        System.out.println("Nhap ma sinh vien can xoa: ");
        String ma = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < spt; i++) {
            if (SV[i].MSV.equals(ma)) {
                found = true;
                for (int j = i; j < spt - 1; j++) {
                    SV[j] = SV[j + 1];
                }
                spt--; 
                break; 
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien voi ma " + ma);
        } else {
            System.out.println("Da xoa sinh vien voi ma " + ma);
        }
        return SV;
    }
    

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Nhap so luong sinh vien:");
        spt = sc.nextInt();
        sc.nextLine();  
        SinhVien[] SV = new SinhVien[spt];
        Nhap(SV);
        Xuat(SV);
        Xep(SV);
        Tim(SV);
        SV = Them(SV);
        System.out.println("Danh sach moi:\n");
        Xuat(SV);
        System.out.println("\nDanh sach moi:\n");
        SV = Xoa(SV);
        Xuat(SV);
    }
}

