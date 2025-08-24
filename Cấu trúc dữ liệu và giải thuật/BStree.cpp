#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct{
	char hoten[30];
	int sbd;
	float d1, d2, d3;
}Data;

typedef struct tagNode{
	Data infor;
	struct tagNode *left;
	struct tagNode *right;
}Node;
typedef Node* BSTree;

void initBSTree(BSTree *T){
	*T=NULL;
}

void InsertNode(BSTree *T, Data x){
if ((*T)==NULL){
	(*T) = (Node*)malloc(sizeof(Node));
	(*T)->infor=x;
	(*T)->left=NULL;
	(*T)->right=NULL;
	}
	else{
	if((*T)->infor.sbd < x.sbd ) 
		InsertNode(&(*T)->right, x);
	else	
	if((*T)->infor.sbd > x.sbd ) 
		InsertNode(&(*T)->left, x);
	 else return; 
	}
}
 
 void nhap_dl(Data* x){
	printf("nhap SBD: ");
	scanf("%d",&(x->sbd));
	if(x->sbd > 0){
		printf("nhap ho ten: ");
		scanf("%s", x->hoten);
		printf("nhap diem m1: ");
		scanf("%f", &(x->d1));
		printf("nhap diem m2: ");
		scanf("%f", &(x->d2));
		printf("nhap diem m3: ");
		scanf("%f", &(x->d3));
	}
}

 void create_BSTree(BSTree *T){
	Data x;
	initBSTree(T);
	do{
		nhap_dl(&x);
		if(x.sbd!=0)
		  InsertNode(T, x);
	}while((x.sbd!=0));
}

int dk_do(Data x){
	if(x.d1+x.d2+x.d3>=15&& x.d1!=0 &&x.d2!=0 &&x.d3!=0)
		return 1;
	return 0;
}
void in_do(Data x){
	printf("%s, %d, %.2f, %.2f, %.2f\n",x.hoten,x.sbd,x.d1,x.d2,x.d3);
}

void NLR(BSTree T){
		if (T!=NULL){
			 if(dk_do(T->infor))
			in_do(T->infor);
			NLR(T->left);
			NLR(T->right);
		}
}


int main(){
	BSTree cay1;
	initBSTree(&cay1);
	create_BSTree(&cay1);
	NLR(cay1);
}


