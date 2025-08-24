#include <stdio.h>
#include <string.h>
int main(int argc, char *argv[]) {
	char banRo[127], banMa[127];
	char key;
	int i;
	fflush(stdin);
	printf("Nhap ban ro: "); gets(banRo);
//Khoa
	key = 3;
	for(i=0; i<strlen(banRo); i++)
		banMa[i] = (banRo[i] + key) % 256;
	banMa[strlen(banRo)] = 0; //ket thuc xau
	printf("Ban ma: %s\n", banMa);
	for(i=0; i<strlen(banMa); i++)
		banRo[i] = (banMa[i] - key) % 256;
	banRo[strlen(banMa)] = 0; //ket thuc xau
	printf("Giai ma, ban ro: %s\n", banRo);
	return 0;
}
