#include <stdio.h>
#include <string.h>


int main(int argc, char *argv[]) {
	char banRo[127], banMa[127];
	char key[10];
	fflush(stdin);
	printf("Nhap ban ro: "); gets(banRo);
	printf("Nhap khoa: "); gets(key);
	
	for(int i=0,key_L=strlen(key); i<strlen(banRo); i++)
		banMa[i] = ((banRo[i] + key[i%key_L]) % 256);
	banMa[strlen(banRo)] = 0; 
	printf("Ban ma: %s\n", banMa);
	
	
	for(int i=0,key_L=strlen(key); i<strlen(banMa); i++)
		banRo[i] = ((banMa[i] - key[i%key_L]) % 256);
	banRo[strlen(banMa)] = 0; 
	printf("Giai ma, ban ro: %s\n", banRo);
	return 0;
}
