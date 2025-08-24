#include<stdio.h>
#include<string.h>
void Dem(char s[])
{
	unsigned int i;
	unsigned dem[256];
    for(i=32;i<126;i++)
    {
    	dem[i]=0;
	}
	for(i=0;i<strlen(s);i++)
	{
		dem[(unsigned int)s[i]]++;
	}	
	for(i=32;i<126;i++){
	if(dem[i]!=0){
	printf("%c: %d\n" , (char)i , dem[i]); 
}
}
}




int main()
{
	char s[100];
	fgets(s,sizeof(s),stdin);
	Dem(s);
}
