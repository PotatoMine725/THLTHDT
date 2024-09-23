#include <iostream>
using namespace std;

int Tong (int n) {
    if (n == 1)
    {
        return 1;
    }
    else
    {
        if (n%2 == 0)
        {
            return  -n + Tong(n-1);
        }
        else
        {
            return  n + Tong(n-1);
        }
    }
}

int main () {
    cout <<"Nhap x ";
    int x;
    cin >> x;
    cout <<"Tong day so la:"<<Tong(x); 
}
