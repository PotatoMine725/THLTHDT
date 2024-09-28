#include <stdio.h>
#include <math.h>
main(){
    int i,n,count;
    printf("nhap n");
    scanf("%d",&n);
    if(n<2)
        printf("%d khong phai la so nguyen to",n);
    else{
        count = 0;
        for(i=2;i<=sqrt(n);i++)
            if(n%i==0)
                count++;
        if(count!=0)
            printf("%d khong phai so nguyen to",n);
        else 
            printf("%d la so nguyen to",n);
    }
}