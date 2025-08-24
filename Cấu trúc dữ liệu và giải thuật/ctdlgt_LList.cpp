#include <stdio.h>
#include <stdlib.h>
#include <string.h>
    typedef struct    {
    	char hoten[30];
    	int masv;
    	float d1,d2,d3;
    }Data;
    typedef struct tagNode
    {
    	Data infor;
    	struct tagNode *link;
    }Node;
    typedef struct    {
    	Node *pHead;  Node *pTail;
    	int spt;
    }LList;

void InitList(LList *L)
    {
    	L->pHead = NULL;
    	L->pTail = NULL;
    	L->spt = 0;
    }
int emptyList(LList L){
    return (L.spt == 0); 
}

void insert_Head(LList *L, Data x)
    {
    	Node *pp;
    	pp = (Node*) malloc(sizeof(Node));
    	pp->infor = x;
    	pp->link = NULL;
    	if(emptyList(*L)){
    			L->pHead = pp;
    			L->pTail = pp;
    		}  	
else {
    		pp->link = L->pHead;
    		L->pHead = pp;
    		}
    	L->spt++;
    }
    
void del_Head (LList *L) {
	Node *pp;
	if( emptyList(*L) ) return;
	else { 
	pp = L->pHead;
	L->pHead = pp->link;
	free(pp);
	L->spt--;
	if(L->pHead==NULL) L->pTail=NULL;
	}
}
void nhapdl(Data* x){
	printf("nhap ma: ");
	scanf("%d",&(x->masv));
	if(x->masv > 0){
		printf("nhap ten: ");
		scanf("%s", x->hoten);
		printf("nhap diem m1: ");
		scanf("%f", &(x->d1));
		printf("nhap diem m2: ");
		scanf("%f", &(x->d2));
		printf("nhap diem m3: ");
		scanf("%f", &(x->d3));
	}
}
void tao_ds(LList*L){
	InitList(L);
	Data x;
	do{
		nhapdl(&x);
		if(x.masv >0)
		insert_Head(L,x);
	}
	while (x.masv >0);
}
void indl(Data x){
	printf("%s, %d, %.2f, %.2f, %.2f\n",x.hoten,x.masv,x.d1,x.d2,x.d3);
}
void duyet_ds(LList L){
	Node*pp=L.pHead;
	while(pp!=NULL){
		indl(pp->infor);
		pp=pp->link;
	}
}
int main(){
	LList ds1;
	InitList(&ds1);
	tao_ds(&ds1);
	duyet_ds(ds1);
}
