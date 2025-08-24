#include<stdio.h>
#include<string.h>
#include<ctype.h>
void xoa_ki_tu(char str[], unsigned int vt){
   if(vt>=0&&vt<strlen(str)){
       for(unsigned int i=vt; i<strlen(str); i++){
           str[i]=str[i+1];
       }
   }
   else     return;
}
int main(){
    char st1[100], st2[100];
    int n, m;
    fgets(st1, sizeof(st1), stdin);
    scanf("%d", &n);
    getchar();
    fgets(st2, sizeof(st2), stdin);
    scanf("%d", &m);
    xoa_ki_tu(st1, n);
    printf("%s", st1);
    xoa_ki_tu(st2, m);
    printf("%s", st2);
}
