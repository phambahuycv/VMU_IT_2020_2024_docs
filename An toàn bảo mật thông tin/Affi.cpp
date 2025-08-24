#include <stdio.h>
#include <string.h>
int main(int argc, char *argv[]) {
	char banRo[127], banMa[127];
	int i;
	fflush(stdin);
	printf("Nhap ban ro: "); gets(banRo);
	int a= 3, b= 6;
	for(i=0; i<strlen(banRo); i++)
		banMa[i]=( ( (a * banRo[i]) + b) % 256);
	banMa[strlen(banRo)] = 0;
	printf("Ban ma: %s\n", banMa);	
	int a_inv = 0;
    int flag = 0;
    for (int j = 0; j < 256; j++)
    {
        flag = (a * j) % 256;
        if (flag == 1)
        {
            a_inv = j;
        }
    }    
	for(i=0; i<strlen(banMa); i++)
		banRo[i]=( ( a_inv * (banMa[i] - b) ) % 256 );
	banRo[strlen(banMa)] = 0;
	printf("Giai ma, ban ro: %s\n", banRo);
	return 0;
}
