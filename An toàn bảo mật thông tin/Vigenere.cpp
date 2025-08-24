#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>

#define  MAXSIZE 100

void inputText(char *textStr){  
    char ch='a';     
    int i=0;      
    while (ch!=0xD){  
        ch=getch();  
        if (ch==0x8 && i>0 ) --i,printf("\b \b");     
        if (ch>='A'&&ch<='Z') ch=tolower(ch);
        if (i>=MAXSIZE) continue;
        if (  !( (ch>='a'&&ch<='z') ||  ch==' ') ) continue; 
        textStr[i++]=ch;
        printf("%c",ch);
    }
    textStr[i]=NULL;              
    printf("\n");
}
void inputPass(char *passStr){
    char ch='a';
    int i=0;
    while (ch!=0xD){
        ch=getch();
        if (ch==0x8 && i>0 ) --i,printf("\b \b");
        if (ch>='a'&&ch<='z') ch=toupper(ch);
        if (i>=MAXSIZE) continue;
        if (!(ch>='A'&&ch<='Z')) continue; 
        passStr[i++]=ch;
        printf("%c",ch);
    }
    passStr[i]=NULL;    
    printf("\n");
}
void inputCode(char *passStr){
    char ch='a';
    int i=0;
    while (ch!=0xD){
        ch=getch();
        if (ch==0x8 && i>0 ) --i,printf("\b \b");
        if (ch>='a'&&ch<='z') ch=toupper(ch);
        if (i>=MAXSIZE) continue;
        if (  !( (ch>='A'&&ch<='Z') ||  ch==' ') ) continue;
        passStr[i++]=ch;
        printf("%c",ch);
    }
    passStr[i]=NULL;    
    printf("\n");
}
//encode method
char charVigenereAt(char lowerTextCol,char upperTextRow){
    if (upperTextRow>='a'&&upperTextRow<='z') upperTextRow=toupper(upperTextRow);
    if (lowerTextCol>='A'&&lowerTextCol<='Z') lowerTextCol=tolower(lowerTextCol);
    if (upperTextRow==NULL) return lowerTextCol;
    if (!(lowerTextCol>='a'&&lowerTextCol<='z'&&upperTextRow>='A'&&upperTextRow<='Z')) return ' ';
    return (upperTextRow-'A'+lowerTextCol-'a')%26+'A';
}  

char* enCode(char *textStr,char *passStr,char *resultStr)
{
    int i,n=strlen(textStr),m=strlen(passStr);
    if (m==0) m=1;  // for safe, with null string, this function not throw a exception
    for (i=0;i<n;i++)
        resultStr[i]=charVigenereAt(textStr[i],passStr[i%m]);
    resultStr[i]=NULL;
    return resultStr;
}


//decode method
char textWithVigenereChar(char vigenereChar,char upperTextRow)
{
    if (upperTextRow>='a'&&upperTextRow<='z') upperTextRow=toupper(upperTextRow);
    if (vigenereChar>='a'&&vigenereChar<='z') vigenereChar=toupper(vigenereChar);
    if (upperTextRow==NULL) return vigenereChar;
    if (!(vigenereChar>='A'&&vigenereChar<='Z'&&upperTextRow>='A'&&upperTextRow<='Z')) return ' ';
    return (26-(upperTextRow-'A') + (vigenereChar-'A'))%26+'a';
}


char* deCode(char *codeStr,char *passStr,char *resultStr)
{
    int i,n=strlen(codeStr),m=strlen(passStr);
    if (m==0) m=1;
    for (i=0;i<n;i++)
        resultStr[i]=textWithVigenereChar(codeStr[i],passStr[i%m]);
    resultStr[i]=NULL;
    return resultStr;
}

 char source[MAXSIZE],pass[MAXSIZE],result[MAXSIZE],ch='a';
int main(int argc, char *argv[]) {
	printf("Nhap ban ro       : ");
    inputText(source);
    printf("Nhap khoa         : ");
    inputPass(pass);
    printf("Ban ma            : %s",enCode(source,pass,result));
    ch='a';
    printf("\n");
    printf("Ban ro, tu giai ma: %s",deCode(enCode(source,pass,result),pass,result));
    ch='a';
	return 0;
}
