package nganhang;

import java.util.Scanner;

public abstract class TaiKhoan implements TaiKhoanInterface {
    private String STK; 
    private String chuTK; 
    private String MK; 
    protected double soDu = 0; 
    protected Scanner sc = new Scanner(System.in);
    protected TransactionLog transactionLog;

    public TaiKhoan(String STK, String chuTK, String MK, double soDu) {
        this.STK = STK;
        this.chuTK = chuTK;
        this.MK = MK;
        this.soDu = soDu;
        this.transactionLog = new TransactionLog();
    }

    public TaiKhoan() {
        this.transactionLog = new TransactionLog();
    }

    public String getSTK() {
        return STK;
    }

    public String getChuTK() {
        return chuTK;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSTK(String STK) {
        this.STK = STK;
    }

    public void setChuTK(String chuTK) {
        this.chuTK = chuTK;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    protected boolean xacThuc() {
        System.out.print("Nhap mat khau: ");
        String mk = sc.nextLine();
        return this.MK.equals(mk);
    }

    @Override
    public void guiTien() {
        if (!xacThuc()) {
            System.out.println("Mat khau sai. Khong the thuc hien chuc nang nay.");
            return;
        }
        System.out.print("Nhap so tien muon gui: ");
        double tienGui = sc.nextDouble();
        sc.nextLine();  // Tieu thu newline
        if (tienGui < 0) {
            System.out.println("So tien khong hop le");
        } else {
            this.soDu += tienGui;
            System.out.println("Gui tien thanh cong.");
            transactionLog.addTransaction(new Transaction(this.STK, "deposit", tienGui)); // Add transaction logging
        }
    }

    public abstract void rutTien();

    @Override
    public void kiemTra() {
        if (!xacThuc()) {
            System.out.println("Mat khau sai. Khong the thuc hien chuc nang nay.");
            return;
        }
        System.out.println("So du hien tai: " + this.soDu);
    }

    @Override
    public void doiMatKhau() {
        if (!xacThuc()) {
            System.out.println("Mat khau sai. Khong the thuc hien chuc nang nay.");
            return;
        }
        System.out.print("Nhap mat khau moi: ");
        String mkMoi = sc.nextLine();
        this.MK = mkMoi;
        System.out.println("Doi mat khau thanh cong!");
    }
}
