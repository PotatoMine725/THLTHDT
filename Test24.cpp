#include <iostream>
using namespace std;

int Tong(int n) {
    if (n == 1) {
        return 1;
    }
    else{
        if (n % 2 == 0) {
            return -n + Tong(n - 1);
        }
        else {
            return n + Tong(n - 1);
        }
    } 
}

int main() {
    int n;
    cout << "Nhap gia tri n: ";
    cin >> n;
    int ketQua = Tong(n);
    cout << "Tong chuoi: " << ketQua << endl;
    return 0;
}

