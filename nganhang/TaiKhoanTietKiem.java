package nganhang;

public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat; // Lai suat
    private int thoiHan; // Thoi han

    public TaiKhoanTietKiem(String STK, String chuTK, String MK, double soDu, double laiSuat, int thoiHan) {
        super(STK, chuTK, MK, soDu);
        this.laiSuat = laiSuat;
        this.thoiHan = thoiHan;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    public void tinhLaiSuat() {
        if (!xacThuc()) {
            System.out.println("Mat khau sai. Khong the thuc hien chuc nang nay.");
            return;
        }
        double tienLai = soDu * (laiSuat / 100);
        soDu += tienLai;
        System.out.println("Lai suat da duoc cong vao tai khoan. So du moi la: " + soDu);
        transactionLog.addTransaction(new Transaction(this.getSTK(), "interest", tienLai)); // Add transaction logging
    }

    @Override
    public void rutTien() {
        if (!xacThuc()) {
            System.out.println("Mat khau sai. Khong the thuc hien chuc nang nay.");
            return;
        }
        System.out.print("Nhap so tien muon rut: ");
        double tienRut = sc.nextDouble();
        sc.nextLine();  // Tieu thu newline
        if (tienRut > soDu) {
            System.out.println("So tien rut vuot qua so du hien co.");
        } else {
            soDu -= tienRut;
            System.out.println("Rut tien thanh cong. So du moi la: " + soDu);
            transactionLog.addTransaction(new Transaction(this.getSTK(), "withdrawal", tienRut)); // Add transaction logging
        }
    }

    @Override
    public void quanLyThongTin() {
    }
}
