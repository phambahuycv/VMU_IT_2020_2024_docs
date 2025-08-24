#include<stdio.h>
long long modexp(int a, int x, long long n){
	long long r = 1;
	while(x>0){
		if(x%2==1)
		r=(r*a)%n;
		a=(a*a)%n;
		x/=2;
			}
			return r;
}

int main(){
	int a = 501, x = 1023;
	int n =1234567890;
	long long r = modexp(a,x,n);
	printf("%d luy thua %d dong du %d = %d\n", a, x , n, r);
	return 0;
}
