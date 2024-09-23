#include <iostream>
using namespace std;

int GT (int n) {
    if (n<0)
    {
        cout <<"nhap lai";
    }
    else
    {
        if (n==0 || n==1)
        {
            return 1;
        }
        else
        {
            n = n*GT(n-1);
        }
    }
    return n;
}

int main () {
    int x;
    cout <<"Nhap gia  tri cua x: ";
    cin >> x;
    cout <<"Giai thua cua x la:"<< GT(x);
}
