#include <iostream>
using namespace std;

int TgCS (int n) {
    if (n == 0)
    {
        return 0;
    }
    else
    {
        if (n<10)
        {
            return n;
        }
        else
        {
            return n%10 + TgCS(n/10);
        } 
    }  
}

int main () {
    cout <<"nhap n: ";
    int n;
    cin >> n;
    cout <<"Tong cac chu so la: "<<TgCS(n);
}