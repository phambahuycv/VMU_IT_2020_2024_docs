#include <stdio.h>
#include <string.h>
int main(int argc, char *argv[]) {
	char banRo[127], banMa[127];
	int a=3,b=3,c=2,d=5;
	int i;
	fflush(stdin);
	printf("Nhap ban ro: "); gets(banRo);
	printf("Khoa la ma tran 2x2:\n");
	printf("%d\t%d\n",a,b);
	printf("%d\t%d\n",c,d);	
	for(i=0; i<strlen(banRo); i=i+2){
		banMa[i]=/*banMa[i]+*/(((banRo[i]*a)+(banRo[i+1]*c))%256);
		banMa[i+1]=/*banMa[i+1]+*/(((banRo[i]*b)+(banRo[i+1]*d))%256);
	}
	banMa[strlen(banRo)] = 0; 
	printf("Ban ma: %s",banMa );
	
    //det= a*d-b*c;
	// do det=9 -> 9*57 mod 256 =1
	int det_dao=57;
	int a_dao=(d*det_dao)%256;
	int b_dao=(((-c)+256)*det_dao)%256;
	int c_dao=(((-b)+256)*det_dao)%256;
	int d_dao=(a*det_dao)%256;
	/*
	int a_dao=d;
	int b_dao=(256-b);
	int c_dao=(256-c);
	int d_dao=a;
	*/
	printf("\nKhoa dao cua matran 2x2 tren la:\n");
	printf("%d\t%d\n",a_dao,b_dao);
	printf("%d\t%d\n",c_dao,d_dao);
	
	for(i=0; i<strlen(banMa); i=i+2){
		banRo[i]=/*banRo[i]+*/(((banMa[i]*a_dao)+(banMa[i+1]*c_dao))%256);
		banRo[i+1]=/*banRo[i+1]+*/(((banMa[i]*b_dao)+(banMa[i+1]*d_dao))%256);
	}		
	banRo[strlen(banMa)] = 0; 
	printf("Giai ma, ban ro: %s\n", banRo);
	return 0;
}
