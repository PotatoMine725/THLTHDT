package nganhang;

import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class NganHang {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8));

        TaiKhoan taiKhoan = chonLoaiTaiKhoan();

        if (taiKhoan == null) {
            System.out.println("Lua chon khong hop le!");
            sc.close();
            return;
        }

        int choice;
        do {
            hienThiMenu(taiKhoan);
            choice = sc.nextInt();
            sc.nextLine();
            xuLyLuaChon(taiKhoan, choice);
        } while (choice != 0);

        sc.close();
    }

    private static TaiKhoan chonLoaiTaiKhoan() {
        System.out.println("Chon loai tai khoan:");
        System.out.println("1. Tai khoan tiet kiem");
        System.out.println("2. Tai khoan thanh toan");
        System.out.println("3. Tai khoan online");
        System.out.print("Lua chon cua ban: ");
        int loaiTaiKhoan = sc.nextInt();
        sc.nextLine();

        switch (loaiTaiKhoan) {
            case 1:
                return taoTaiKhoanTietKiem();
            case 2:
                return taoTaiKhoanThanhToan();
            case 3:
                return taoTaiKhoanOnline();
            default:
                return null;
        }
    }

    private static TaiKhoan taoTaiKhoanTietKiem() {
        System.out.println("Nhap so tai khoan: ");
        String STK = sc.nextLine();
        System.out.println("Nhap ten chu tai khoan: ");
        String chuTK = sc.nextLine();
        System.out.println("Nhap mat khau: ");
        String MK = sc.nextLine();
        System.out.println("Nhap so du ban dau: ");
        double soDu = sc.nextDouble();
        System.out.println("Nhap lai suat (%): ");
        double laiSuat = sc.nextDouble();
        System.out.println("Nhap thoi han tiet kiem (thang): ");
        int thoiHan = sc.nextInt();
        sc.nextLine();
        return new TaiKhoanTietKiem(STK, chuTK, MK, soDu, laiSuat, thoiHan);
    }

    private static TaiKhoan taoTaiKhoanThanhToan() {
        System.out.println("Nhap so tai khoan: ");
        String STK = sc.nextLine();
        System.out.println("Nhap ten chu tai khoan: ");
        String chuTK = sc.nextLine();
        System.out.println("Nhap mat khau: ");
        String MK = sc.nextLine();
        System.out.println("Nhap so du ban dau: ");
        double soDu = sc.nextDouble();
        System.out.println("Nhap phi dich vu hang thang: ");
        double phiDichVu = sc.nextDouble();
        System.out.println("Nhap han muc thau chi: ");
        double hanMucThauChi = sc.nextDouble();
        sc.nextLine();
        return new TaiKhoanThanhToan(STK, chuTK, MK, soDu, phiDichVu, hanMucThauChi);
    }

    private static TaiKhoan taoTaiKhoanOnline() {
        System.out.println("Nhap so tai khoan: ");
        String STK = sc.nextLine();
        System.out.println("Nhap ten chu tai khoan: ");
        String chuTK = sc.nextLine();
        System.out.println("Nhap mat khau: ");
        String MK = sc.nextLine();
        System.out.println("Nhap so du ban dau: ");
        double soDu = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhap email: ");
        String email = sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        String soDienThoai = sc.nextLine();
        return new TaiKhoanOnline(STK, chuTK, MK, soDu, email, soDienThoai);
    }

    private static void hienThiMenu(TaiKhoan taiKhoan) {
        System.out.println("\nMenu:");
        System.out.println("1. Gui tien");
        System.out.println("2. Rut tien");
        System.out.println("3. Kiem tra so du");
        System.out.println("4. Doi mat khau");
        System.out.println("5. Xem lich su giao dich");

        if (taiKhoan instanceof TaiKhoanTietKiem) {
            System.out.println("6. Tinh lai suat");
        } else if (taiKhoan instanceof TaiKhoanThanhToan) {
            System.out.println("6. Tru phi dich vu");
        } else if (taiKhoan instanceof TaiKhoanOnline) {
            System.out.println("6. Quan ly thong tin tai khoan online");
        }

        System.out.println("0. Thoat");
        System.out.print("Chon chuc nang: ");
    }

    private static void xuLyLuaChon(TaiKhoan taiKhoan, int choice) {
        switch (choice) {
            case 1:
                taiKhoan.guiTien();
                break;
            case 2:
                taiKhoan.rutTien();
                break;
            case 3:
                taiKhoan.kiemTra();
                break;
            case 4:
                taiKhoan.doiMatKhau();
                break;
            case 5:
                taiKhoan.transactionLog.printLog();
                break;
            case 6:
                if (taiKhoan instanceof TaiKhoanTietKiem) {
                    ((TaiKhoanTietKiem) taiKhoan).tinhLaiSuat();
                } else if (taiKhoan instanceof TaiKhoanThanhToan) {
                    ((TaiKhoanThanhToan) taiKhoan).truPhiDichVu();
                } else if (taiKhoan instanceof TaiKhoanOnline) {
                    ((TaiKhoanOnline) taiKhoan).quanLyThongTin();
                }
                break;
            case 0:
                System.out.println("Tam biet!");
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                break;
        }
    }
}
