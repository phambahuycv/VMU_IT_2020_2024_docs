#include <stdio.h>
#include <stdlib.h>
unsigned long long modexp(int a, long long x,unsigned long long n){
	unsigned long long r =1;
	while(x>0){
		if(x%2==1)
		r=(r*a)%n;
		a=(a*a)%n;
		x/=2;
	}
	return r;
}


int main(){
	int a[100],i,test=true;
	unsigned long long r, n=100000000001;
	for(i=0;i<100;i++){
		a[i]=(rand()%1000)+100;
		r=modexp(a[i],(n-1)/2,n);
		if(r!=1&&r!=n-1){
			printf("n khong la so nguyen to.\n");
			test=false;
			break;
		}
	}
	if(test==true)
	printf("n co the la so nguyen to.\n");
	return 0;
}
