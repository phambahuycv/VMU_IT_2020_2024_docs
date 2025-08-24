#include <stdio.h>
#include <string.h>
int main() {
char pw[30];
int count=0;
do{
fflush(stdin);
scanf("%s",pw);
if(strcmp(pw,"123456a@B")!=0 && count<5)
{
   count++;
    }
    }while(count<5 && strcmp(pw,"123456a@B")!=0);
    if(count<5)
    printf("Dang nhap thanh cong, %d",count+1);
    else
    printf("Tai khoan bi khoa, %d",count);
    return 0;
    }
