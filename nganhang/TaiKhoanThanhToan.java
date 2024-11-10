package nganhang;

import java.util.Scanner;

public class TaiKhoanThanhToan extends TaiKhoan {
    private double phiDichVu; 
    private double hanMucThauChi; 
    private static Scanner sc = new Scanner(System.in);

    public TaiKhoanThanhToan(String STK, String chuTK, String MK, double soDu, double phiDichVu, double hanMucThauChi) {
        super(STK, chuTK, MK, soDu);
        this.phiDichVu = phiDichVu;
        this.hanMucThauChi = hanMucThauChi;
    }

    private double nhapHanMucThauChi() {
        System.out.print("Nhap han muc thau chi: ");
        return sc.nextDouble();
    }

    public double getPhiDichVu() {
        return phiDichVu;
    }

    public void setPhiDichVu(double phiDichVu) {
        this.phiDichVu = phiDichVu;
    }

    public double getHanMucThauChi() {
        return hanMucThauChi;
    }

    public void setHanMucThauChi(double hanMucThauChi) {
        this.hanMucThauChi = hanMucThauChi;
    }

    @Override
    public void rutTien() {
        if (!xacThuc()) {
            System.out.println("Mat khau sai. Khong the thuc hien chuc nang nay.");
            return;
        }

        hanMucThauChi = nhapHanMucThauChi();  // Nhập hạn mức thấu chi từ bàn phím

        System.out.print("Nhap so tien muon rut: ");
        double tienRut = sc.nextDouble();
        sc.nextLine();  // Tiêu thụ newline

        if (tienRut > soDu + hanMucThauChi) {
            System.out.println("So tien rut vuot qua han muc thau chi.");
        } else {
            soDu -= tienRut;
            System.out.println("Rut tien thanh cong. So du moi la: " + soDu);
            transactionLog.addTransaction(new Transaction(this.getSTK(), "withdrawal", tienRut)); // Add transaction logging
        }
    }

    public void truPhiDichVu() {
        if (!xacThuc()) {
            System.out.println("Mat khau sai. Khong the thuc hien chuc nang nay.");
            return;
        }
        if (soDu >= phiDichVu) {
            soDu -= phiDichVu;
            System.out.println("Phi dich vu da duoc tru. So du moi la: " + soDu);
            transactionLog.addTransaction(new Transaction(this.getSTK(), "service fee", phiDichVu)); // Add transaction logging
        } else {
            System.out.println("So du khong du de tru phi dich vu.");
        }
    }

    @Override
    public void quanLyThongTin() {
    }
}
