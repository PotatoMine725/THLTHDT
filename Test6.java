import java.util.Scanner;

public class Test6 {
    static int[] M;
    static int N;
    static Scanner sc;

    static void Nhap() {
        for (int i = 0; i < N; i++) {
            System.out.print("M[" + i + "] = ");
            M[i] = sc.nextInt();
        }
    }

    static void Xuat() {
        for (int i = 0; i < N; i++) {
            System.out.println("M[" + i + "] = " + M[i]);
        }
    }

    static int Tim(int X) {
        int pos = -1; // Initialize with an invalid position
        boolean found = false;
        for (int i = 0; i < N && !found; i++) {
            if (M[i] == X) {
                found = true;
                pos = i;
            }
        }
        if (found) {
            System.out.println("Tim thay");
        } else {
            System.out.println("Khong tim thay");
        }
        return pos;
    }

    static void Xoa(int X) {
        int K = Tim(X);   
            for (int j = K; j < N - 1; j++) {
                M[j] = M[j + 1];
            }
            M[N - 1] = 0;
            N--;
    }

    static void SapXep() {
        for (int i = 0; i<N; i++) {
            for (int j = 0; j < N-1; j++) {
                if (M[j] > M[j+1]) {
                    int temp = M[j];
                    M[j] = M[j+1];
                    M[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu mang: ");
        N = sc.nextInt();
        M = new int[N];
        Nhap();
        Xuat();
        Tim(3);
        Xoa(4);
        Xuat();
        SapXep();
        Xuat();
        sc.close(); 
    }
}
