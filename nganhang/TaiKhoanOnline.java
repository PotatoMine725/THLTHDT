package nganhang;

public class TaiKhoanOnline extends TaiKhoan {
    private String email; 
    private String soDienThoai; 
    private TaiKhoanThanhToan taiKhoanThanhToan;
    private TaiKhoanTietKiem taiKhoanTietKiem;

    public TaiKhoanOnline(String STK, String chuTK, String MK, double soDu, String email, String soDienThoai) {
        super(STK, chuTK, MK, soDu);
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.taiKhoanThanhToan = new TaiKhoanThanhToan(STK, chuTK, MK, soDu, 0, 0); 
        this.taiKhoanTietKiem = new TaiKhoanTietKiem(STK, chuTK, MK, soDu, 0, 0); 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public void rutTien() {
        System.out.println("Chon loai tai khoan de rut tien:");
        System.out.println("1. Tai khoan thanh toan");
        System.out.println("2. Tai khoan tiet kiem");
        int choice = sc.nextInt();
        sc.nextLine(); // Tiêu thụ newline
        if (choice == 1) {
            taiKhoanThanhToan.rutTien();
            transactionLog.addTransaction(new Transaction(this.getSTK(), "withdrawal from checking", taiKhoanThanhToan.getSoDu())); // Add transaction logging
        } else if (choice == 2) {
            taiKhoanTietKiem.rutTien();
            transactionLog.addTransaction(new Transaction(this.getSTK(), "withdrawal from savings", taiKhoanTietKiem.getSoDu())); // Add transaction logging
        } else {
            System.out.println("Lua chon khong hop le.");
        }
    }

    @Override
    public void guiTien() {
        System.out.println("Chon loai tai khoan de gui tien:");
        System.out.println("1. Tai khoan thanh toan");
        System.out.println("2. Tai khoan tiet kiem");
        int choice = sc.nextInt();
        sc.nextLine(); // Tiêu thụ newline
        if (choice == 1) {
            taiKhoanThanhToan.guiTien();
            transactionLog.addTransaction(new Transaction(this.getSTK(), "deposit to checking", taiKhoanThanhToan.getSoDu())); // Add transaction logging
        } else if (choice == 2) {
            taiKhoanTietKiem.guiTien();
            transactionLog.addTransaction(new Transaction(this.getSTK(), "deposit to savings", taiKhoanTietKiem.getSoDu())); // Add transaction logging
        } else {
            System.out.println("Lua chon khong hop le.");
        }
    }

    @Override
    public void kiemTra() {
        System.out.println("Chon loai tai khoan để kiem tra:");
        System.out.println("1. Tai khoan thanh toan");
        System.out.println("2. Tai khoan tiet kiem");
        int choice = sc.nextInt();
        sc.nextLine(); 
        if (choice == 1) {
            taiKhoanThanhToan.kiemTra(); 
        } else if (choice == 2) {
            taiKhoanTietKiem.kiemTra();
        } else {
            System.out.println("Lua chon khong hop le.");
        }
    }

    @Override
    public void doiMatKhau() {
        super.doiMatKhau(); 
    }
    
    @Override
    public void quanLyThongTin() {
        if (!xacThuc()) {
            System.out.println("Mat khau sai. Khong thể thuc hien chuc nang nay.");
            return;
        }
        System.out.println("Cap nhat thong tin tài khoan:");
        System.out.print("Nhap email moi (hien tai: " + email + "): ");
        String emailMoi = sc.nextLine();
        this.setEmail(emailMoi);

        System.out.print("Nhap so dien thoai moi (hien tai: " + soDienThoai + "): ");
        String soDienThoaiMoi = sc.nextLine();
        this.setSoDienThoai(soDienThoaiMoi);

        System.out.println("Thong tin tai khoan duoc cap nhat thanh cong.");
    }
}
